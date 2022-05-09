package com.volvo.codingchallenge.exception;

public class AddressNotFoundException extends RuntimeException{
    public AddressNotFoundException() {
    super();
}

    public AddressNotFoundException(String message) {
        super(message);
    }

    public AddressNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
