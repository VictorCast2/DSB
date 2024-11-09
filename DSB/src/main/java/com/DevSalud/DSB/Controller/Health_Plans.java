package com.DevSalud.DSB.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping(path = "/Api/Users/Health_Plans")
public class Health_Plans {
    
    @GetMapping("/PlanEjercicio")
    public String mostrarPlanEjercicio() {
        return "/Health_Plans/Exercises/PlanesEjercicio";
    }

    @GetMapping("/PlanAlimenticio")
    public String mostrarPlanAlimenticio() {
        return "/Health_Plans/Food/PlanesAlimenticios";
    }
    
}