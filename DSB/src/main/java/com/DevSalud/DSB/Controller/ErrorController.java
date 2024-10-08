package com.DevSalud.DSB.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    @GetMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        String ErrorPage = "Error";

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
            switch (statusCode) {
                case 404:
                    ErrorPage = "Error/404";
                    break;
                case 500:
                    ErrorPage = "Error/500";
                    break;
                case 403:
                    ErrorPage = "Error/403";
                    break;
                case 400:
                    ErrorPage = "Error/400";
                    break;
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