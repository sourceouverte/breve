package org.breve.services;

import org.breve.dtos.IngestionInputDto;
import org.breve.models.URL;
import org.breve.repositories.URLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@Service
public class IngestionService {

    private final URLRepository urlRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(IngestionService.class);

    @Autowired
    public IngestionService(URLRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public URL saveURL(IngestionInputDto inputDto) {
        URL url = new URL();
        url.setLongUrl(inputDto.getLongUrl());
        url.setCustomCode(inputDto.getCustomCode());
        url.setDescription(inputDto.getDescription());
        return urlRepository.save(url);
    }

    public URL updateURL(IngestionInputDto inputDto) {
        URL url = urlRepository.findOneByCustomCode(inputDto.getCustomCode()).orElse(null);
        if (url != null) {
            url.setLongUrl(inputDto.getLongUrl());
            urlRepository.save(url);
        }
        return url;
    }

    public Optional<URL> getURLByCustomCode(String customCode) {
        LOGGER.info("Fetching URL with customCode: {}", customCode);
        Optional<URL> url = urlRepository.findOneByCustomCode(customCode);
        LOGGER.info("URL fetched from MongoDB: {}", url);
        return url;
    }
}