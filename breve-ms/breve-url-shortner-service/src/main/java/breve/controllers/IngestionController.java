package breve.controllers;

import breve.dtos.IngestionInputDto;
import breve.models.URL;
import breve.services.IngestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@RestController("ingester")
public class IngestionController {

    private final IngestionService ingestionService;

    @Autowired
    public IngestionController(IngestionService ingestionService) {
        this.ingestionService = ingestionService;
    }

    @GetMapping("/urls/{customCode}")
    public RedirectView redirectToLongUrl(@PathVariable String customCode) {
        String redirectValue = ingestionService.getURLByCustomCode(customCode);
        if(redirectValue != null){
            return new RedirectView(redirectValue);
        } else {
            return new RedirectView();
        }
    }
}