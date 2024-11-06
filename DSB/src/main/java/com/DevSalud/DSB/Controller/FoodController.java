package com.DevSalud.DSB.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/Api/Users/Food")
public class FoodController {

    @GetMapping("/RegistroAlimento")
    public String formularioRegistroAlimento() {
        return "/Food/FormularioRegistroAlimento";
    }

    @GetMapping("/Home")
    public String homeRegistroAlimento() {
        return "/Food/HomeRegistroAlimento";
    }

    @GetMapping("/EditarAlimento")
    public String formularioEditarAlimento() {
        return "/Food/FormularioEditarAlimento";
    }

    @GetMapping("/TablaAlimento")
    public String TablaRegistroAlimento() {
        return "/Food/TablaRegistroAlimento";
    }

}