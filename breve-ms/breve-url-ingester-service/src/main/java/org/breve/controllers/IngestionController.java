package org.breve.controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.breve.dtos.IngestionInputDto;
import org.breve.models.URLS;
import org.breve.services.IngestionService;
import org.breve.services.URLValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController("ingester")
public class IngestionController {

    private final IngestionService ingestionService;
    private final URLValidationService urlValidationService;

    @Autowired
    public IngestionController(IngestionService ingestionService, URLValidationService urlValidationService) throws InvalidUrlException {
        this.ingestionService = ingestionService;
        this.urlValidationService = urlValidationService;
    }

    @PostMapping("/urls")
    public URLS saveURL(@RequestBody IngestionInputDto inputDto) {
        return ingestionService.saveURL(inputDto);
    }

    @PutMapping("/urls")
    public URLS updateURL(@RequestBody IngestionInputDto inputDto) {
        return ingestionService.updateURL(inputDto);
    }

    @PostMapping("/ingest")
    public ResponseEntity<SuccessResponse> ingest(@RequestBody IngestionInputDto inputDto) throws InvalidUrlException, IOException, URISyntaxException {
        try {
            ingestionService.ingestUrl(inputDto);
            SuccessResponse successResponse = new SuccessResponse("success", "URL is valid");
            return new ResponseEntity<SuccessResponse>(successResponse, HttpStatus.OK);
        } catch (InvalidUrlException ex) {
            urlValidationService.validateUrl(inputDto.getLongUrl());
        }
        return null;
    }

    @GetMapping("/{customCode}")
    public void redirectToLongUrl(@PathVariable String customCode, HttpServletResponse response) {
        Optional<URLS> longUrl = ingestionService.getURLByCustomCode(customCode);
        String s = longUrl.map(URLS::getLongUrl).orElse(null);
        try {
            response.sendRedirect(s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}