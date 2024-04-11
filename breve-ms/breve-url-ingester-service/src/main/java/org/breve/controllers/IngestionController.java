package org.breve.controllers;

import org.breve.dtos.IngestionInputDto;
import org.breve.models.URL;
import org.breve.services.IngestionService;
import org.springframework.web.bind.annotation.*;

@RestController("ingester")
public class IngestionController {

    private final IngestionService ingestionService;

    public IngestionController(IngestionService ingestionService) {
        this.ingestionService = ingestionService;
    }

    @PostMapping("/urls")
    public URL saveURL(@RequestBody IngestionInputDto inputDto) {
        return ingestionService.saveURL(inputDto);
    }

    @PutMapping("/urls")
    public URL updateURL(@RequestBody IngestionInputDto inputDto) {
        // Implement the logic to update the URL here
        return null;
    }
}