package org.example.bookmyshow.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "user not found")
public class NoUserFound extends RuntimeException{

    public NoUserFound() {
    }

    public NoUserFound(String message) {
        super(message);
    }
}
