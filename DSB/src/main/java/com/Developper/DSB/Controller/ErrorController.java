package com.Developper.DSB.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    @GetMapping("/error")
    public String handleError(HttpServletRequest request) {
        // Recibe la solicitud HTTP (HttpServletRequest)
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        // Obtiene el código de estado del error
        String ErrorPage = "Error";
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                ErrorPage = "Error/404";
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                ErrorPage = "Error/500";
            } else if (statusCode == HttpStatus.FORBIDDEN.value()) {
                ErrorPage = "Error/403";
            } else if (statusCode == HttpStatus.BAD_REQUEST.value()) {
                ErrorPage = "Error/400";
            }
        }
        return ErrorPage;
    }

    // Constructor del controlador de errores
    public ErrorController() {
        super();
    }

    // Método que retorna la ruta de error
    public String getErrorPath() {
        return "/error";
    }
}