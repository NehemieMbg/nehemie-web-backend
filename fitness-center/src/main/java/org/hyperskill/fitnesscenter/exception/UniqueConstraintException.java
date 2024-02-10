package org.hyperskill.fitnesscenter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class UniqueConstraintException extends RuntimeException {
    public UniqueConstraintException(String message) {
        super(message);
    }
}
