package com.DevSalud.DSB.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    /**
     * Maneja los errores y redirige a la página de error adecuada según el código
     * de estado HTTP.
     * 
     * @param request La solicitud HTTP que contiene la información del error.
     * @return El nombre de la vista de error correspondiente según el código de
     *         estado HTTP.
     *         Si no se encuentra un código específico, se redirige a la página de
     *         error general.
     */
    @GetMapping("/Error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        String errorPage = "Error/Index"; // Página por defecto para errores no especificados
        if (status != null) {
            // Determina la página de error según el código de estado HTTP
            Integer statusCode = Integer.valueOf(status.toString());
            switch (statusCode) {
                case 404:
                    errorPage = "Error/404"; // Página para error 404 (No encontrado)
                    break;
                case 500:
                    errorPage = "Error/500"; // Página para error 500 (Error interno del servidor)
                    break;
                case 403:
                    errorPage = "Error/403"; // Página para error 403 (Prohibido)
                    break;
                case 400:
                    errorPage = "Error/400"; // Página para error 400 (Solicitud incorrecta)
                    break;
                default:
                    errorPage = "Error/Index"; // Página por defecto para otros errores
                    break;
            }
        }
        return errorPage; // Devuelve la página de error correspondiente
    }

    /**
     * Constructor del controlador de errores.
     * Este constructor es llamado cuando se crea una instancia del controlador de
     * errores.
     */
    public ErrorController() {
        super();
    }

    /**
     * Retorna la ruta de la página de error.
     * 
     * @return La ruta de la página de error, que generalmente es "/Error".
     */
    public String getErrorPath() {
        return "/error";
    }

}