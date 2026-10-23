package org.example._5_interceptors_demo_1.exceptions;

public class TokenNotFoundException extends RuntimeException{

    public TokenNotFoundException(String message) {
        super(message);
    }
}
