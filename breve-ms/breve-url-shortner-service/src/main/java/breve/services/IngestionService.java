package breve.services;

import breve.dtos.IngestionInputDto;
import breve.models.URL;
import breve.repositories.URLRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IngestionService {

    private final URLRepository urlRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(IngestionService.class);

    @Autowired
    public IngestionService(URLRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public String getURLByCustomCode(String customCode) {
        LOGGER.info("Fetching URL with customCode: {}", customCode);
        URL url = urlRepository.findByCustomCode(customCode);
        LOGGER.info("URL fetched from MongoDB: {}", url);
        if(url != null){
            return url.getLongUrl();
        } else {
            return null;
        }
    }
}