package com.DevSalud.DSB.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping({ " ", "/", "/DSBSinConection" })
    public String Index() {
        return "Index";
    }

    @GetMapping("/DSBConection")
    public String IndexPaginaPrincipal() {
        return "IndexPaginaPrincipal";
    }

    @GetMapping("/Noticias")
    public String Noticias() {
        return "Noticias";
    }

    @GetMapping("/Contactos")
    public String Contactos() {
        return "Contactos";
    }

}