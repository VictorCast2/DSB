package com.DevSalud.DSB.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import ch.qos.logback.core.model.Model;


@Controller
@RequestMapping(path = "/Api/Users/Exercises")
public class ExercisesController {

    @GetMapping("/RegistroEjercicio")
    public String formularioRegistroEjercicio() {
        return "/Exercises/FormularioRegistroEjercicio";
    }

    @GetMapping("/h")
    public String homeRegistroEjercicio(Model model) {
        return "/Exercises/HomeRegistroEjercicio";
    }

}