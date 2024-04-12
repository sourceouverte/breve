package org.breve.controllers;

import org.breve.dtos.IngestionInputDto;
import org.breve.models.URL;
import org.breve.services.IngestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController("ingester")
public class IngestionController {

    private final IngestionService ingestionService;

    @Autowired
    public IngestionController(IngestionService ingestionService) {
        this.ingestionService = ingestionService;
    }

    @PostMapping("/urls")
    public URL saveURL(@RequestBody IngestionInputDto inputDto) {
        return ingestionService.saveURL(inputDto);
    }

    @PutMapping("/urls")
    public URL updateURL(@RequestBody IngestionInputDto inputDto) {
        return ingestionService.updateURL(inputDto);
    }

    @GetMapping("/urls/{customCode}")
    public Optional<URL> getURLByCustomCode(@PathVariable String customCode) {
        return ingestionService.getURLByCustomCode(customCode);
    }
}