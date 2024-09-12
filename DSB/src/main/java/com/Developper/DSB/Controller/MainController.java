package com.Developper.DSB.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping({" ","DSB"})
    public String index() {
        return "Index";
    }

    @GetMapping("Nosotros")
    public String nosotros() {
        return "Nosotros";
    }

    @GetMapping("OficinaVirtual")
    public String oficinaVirtual() {
        return "OficinaVirtual";
    }

    @GetMapping("Contactos")
    public String contactos() {
        return "Contactos";
    }
}