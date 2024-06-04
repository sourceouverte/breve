package org.breve.controllers;

public class CodeAlreadyExistsException extends  RuntimeException {
    public CodeAlreadyExistsException(String message) {
        super(message);
    }
}
