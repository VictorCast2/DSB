package com.DevSalud.DSB.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaginaPrincipalController {
    @GetMapping({"DSB", "/", " "})
    public String Index() {
        return "Index";
    }

    @GetMapping("/Nosotros")
    public String Nosotros() {
        return "Nosotros";
    }

    @GetMapping("/OficinaVirtual")
    public String OficinaVirtual() {
        return "OficinaVirtual";
    }

    @GetMapping("/Contactos")
    public String Contactos() {
        return "Contactos";
    }
}