package com.DevSalud.DSB.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping(path = "/Api/Users/Exercises")
public class ExercisesController {

    @GetMapping("/RegistroEjercicio")
    public String formularioRegistroEjercicio() {
        return "/Exercises/FormularioRegistroEjercicio";
    }

    @GetMapping("/home")
    public String homeRegistroEjercicio() {
        return "/Exercises/HomeRegistroEjercicio";
    }


    @GetMapping("/EditarEjercicio")
    public String formularioEditarEjercicio() {
        return "/Exercises/FormularioEditarEjercicio";
    }

    @GetMapping("/TablaRegistroEjercicio")
    public String TablaRegistroEjercicio() {
        return "/Exercises/TablaRegistroEjercicio";
    }
}