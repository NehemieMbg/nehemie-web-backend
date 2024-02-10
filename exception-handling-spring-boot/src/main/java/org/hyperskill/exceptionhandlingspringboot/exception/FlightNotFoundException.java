package org.hyperskill.exceptionhandlingspringboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Custom Exception
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class FlightNotFoundException extends RuntimeException {
    
    public FlightNotFoundException(String message) {
        super(message);
    }
}
