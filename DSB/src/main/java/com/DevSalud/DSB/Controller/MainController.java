package com.DevSalud.DSB.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    /**
     * Maneja las solicitudes GET para las rutas raíz (" "), "/", y "/DSBSinConection".
     *
     * @return La vista "Index".
     */
    @GetMapping({ " ", "/", "/DSBSinConection" })
    public String Index() {
        return "Index";
    }

    /**
     * Maneja las solicitudes GET para la ruta "/DSBConection".
     *
     * @return La vista "IndexPaginaPrincipal".
     */
    @GetMapping("/DSBConection")
    public String IndexPaginaPrincipal() {
        return "IndexPaginaPrincipal";
    }

}