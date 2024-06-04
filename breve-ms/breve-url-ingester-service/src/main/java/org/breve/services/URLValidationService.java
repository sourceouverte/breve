package org.breve.services;

import org.breve.controllers.InvalidUrlException;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

@Service
public class URLValidationService {
    public void validateUrl(String url) throws InvalidUrlException, URISyntaxException {
        try {
            new URL(url);
        } catch (MalformedURLException e) {
            throw new InvalidUrlException("The provided URL is not valid: " + url);
        }
    }
}