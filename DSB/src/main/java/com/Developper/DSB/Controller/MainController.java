package com.Developper.DSB.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping({" ","DSB"})
    public String index() {
        return "Index";
    }

    @GetMapping({"Nosotros"})
    public String Nosotros() {
        return "Nosotros";
    }

    @GetMapping({"OficinaVirtual"})
    public String OficinaVirtual() {
        return "OficinaVirtual";
    }

    @GetMapping({"Conctatos"})
    public String Conctatos() {
        return "Conctatos";
    }
    @GetMapping({"sss"})
    public String Conctatos() {
        return "sss";
    }

}