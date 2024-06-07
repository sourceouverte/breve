package org.breve.controllers;

public class InvalidUrlException extends Throwable {
    public InvalidUrlException(String message) {
        super(message);
    }
}
