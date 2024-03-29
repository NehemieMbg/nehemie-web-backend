package org.hyperskill.exceptionhandlingspringboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

// Custom Exception
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class FlightNotFoundException extends RuntimeException {
    
    public FlightNotFoundException(String message) {
        super(message);
    }
    
    @ExceptionHandler(FlightNotFoundException.class)
    public ResponseEntity<CustomErrorMessage> handleFlightNotFound(
            FlightNotFoundException e,  WebRequest request) {
        
        CustomErrorMessage body = new CustomErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now(),
                e.getMessage(),
                request.getDescription(false)
        );

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
