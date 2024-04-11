package org.breve.services;

import org.breve.dtos.IngestionInputDto;
import org.breve.models.URL;
import org.breve.repositories.URLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngestionService {

    private final URLRepository urlRepository;

    @Autowired
    public IngestionService(URLRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public URL saveURL(IngestionInputDto inputDto) {
        URL url = new URL();
        url.setLongUrl(inputDto.getLongUrl());
        url.setCustomCode(inputDto.getCustomCode());
        return urlRepository.save(url);
    }
}