package com.DevSalud.DSB.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Anotación que define el código de estado HTTP que será devuelto cuando esta excepción sea lanzada.
// En este caso, se devolverá un estado de error interno del servidor (500 Internal Server Error).
@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class GeneralServiceException extends RuntimeException {
    
    public GeneralServiceException() {
    }

    public GeneralServiceException(String message) {
        super(message);
    }

    public GeneralServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public GeneralServiceException(Throwable cause) {
        super(cause);
    }

    public GeneralServiceException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}