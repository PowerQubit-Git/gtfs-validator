package tml.centralapi.validatormain.controller;

public class FileNotFoundException extends RuntimeException {
    public FileNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}
