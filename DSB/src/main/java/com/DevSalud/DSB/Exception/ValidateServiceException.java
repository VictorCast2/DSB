package com.DevSalud.DSB.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Anotación que define el código de estado HTTP que será devuelto cuando esta excepción sea lanzada.
// En este caso, se devolverá un estado de solicitud incorrecta (400 Bad Request).
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ValidateServiceException extends RuntimeException {

    public ValidateServiceException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ValidateServiceException(Throwable cause) {
        super(cause);
    }

    public ValidateServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidateServiceException(String message) {
        super(message);
    }

    public ValidateServiceException() {
    }
    
}