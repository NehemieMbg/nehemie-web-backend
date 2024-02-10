package org.hyperskill.fitnesscenter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UniqueConstraintException.class)
    public ResponseEntity<CustomErrorMessage>
        handleUniqueConstraintException(UniqueConstraintException ex) {
            CustomErrorMessage errorMessage = new CustomErrorMessage(
                    HttpStatus.BAD_REQUEST.value(),
                    ex.getMessage(),
                    LocalDateTime.now()
            );
            
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}
