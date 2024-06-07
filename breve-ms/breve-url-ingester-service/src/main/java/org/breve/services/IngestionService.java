package org.breve.services;

import org.breve.controllers.CodeAlreadyExistsException;
import org.breve.controllers.InvalidUrlException;
import org.breve.dtos.IngestionInputDto;
import org.breve.models.URLS;
import org.breve.repositories.ShortURLRepository;
import org.breve.repositories.URLRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Optional;

@Service
public class IngestionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IngestionService.class);
    private final URLRepository urlRepository;
    private final ShortURLRepository shortURLRepository;
    private URLShorteningService urlShorteningService;

    @Autowired
    public IngestionService(URLRepository urlRepository, ShortURLRepository shortURLRepository
    ) {
        this.urlRepository = urlRepository;
        this.shortURLRepository = shortURLRepository;
    }

    public URLS saveURL(IngestionInputDto inputDto) {
        URLS url = new URLS();
        url.setLongUrl(inputDto.getLongUrl());
        url.setCustomCode(inputDto.getCustomCode());
        url.setDescription(inputDto.getDescription());
        return urlRepository.save(url);
    }

    public URLS updateURL(IngestionInputDto inputDto) {
        URLS url = urlRepository.findOneByCustomCode(inputDto.getCustomCode()).orElse(null);
        if (url != null) {
            url.setLongUrl(inputDto.getLongUrl());
            urlRepository.save(url);
        }
        return url;
    }

    public Optional<URLS> getURLByCustomCode(String customCode) {
        LOGGER.info("Fetching URL with customCode: {}", customCode);
        Optional<URLS> url = urlRepository.findOneByCustomCode(customCode);
        LOGGER.info("URL fetched from MongoDB: {}", url);
        return url;
    }

    public void ingestUrl(IngestionInputDto inputDto) throws IOException, InvalidUrlException, URISyntaxException {
        URLS url = new URLS();
        url.setLongUrl(inputDto.getLongUrl());
        url.setShortUrl(URLShorteningService.shortenURL(inputDto.getLongUrl()));
        url.setCustomCode(URLShorteningService.shortenURL(inputDto.getLongUrl()));
        String customCode = url.getCustomCode();
        if (customCode != null) {
            List<URLS> urls = shortURLRepository.findOneByCustomCode(customCode);
            if (!urls.isEmpty()) {
                throw new CodeAlreadyExistsException("Custom Code already exists: ");
            } else {
                URL urlObj = new URL(inputDto.getLongUrl());
                HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
                connection.setInstanceFollowRedirects(false); // Only check initial URL
                connection.setRequestMethod("HEAD");
                connection.connect();
                int responseCode = connection.getResponseCode();
                System.out.println("response code" + responseCode);
                url.setCustomCode(URLShorteningService.shortenURL(inputDto.getLongUrl()));
                url.setDescription(inputDto.getDescription());
                urlRepository.save(url);
            }
        }
    }
}
