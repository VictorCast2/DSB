package com.DevSalud.DSB.Controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping(path = "/Api/Users/Exercises")
public class ExercisesController {

    @ModelAttribute("allTipEjercicios")
    public List<String> tiposDeEjercicios() {
        return Arrays.asList("Aerobico", "Anaerobicos", "Fuerza", "Resistencia", "Pecho", "Pierna", "Hombro", 
                "Espalda", "Biceps", "Triceps", "Abdominales", "Antebrazo", "Pantorrilla", 
                "Equilibrio", "Fortalecimiento", "Flexibilidad"
        );
    }

    @ModelAttribute("allNameEjercicios")
    public Map<String, List<String>> nombreDeLosEjercicios() {
        Map<String, List<String>> ejercicios = new HashMap<>();
        ejercicios.put("Aerobico", Arrays.asList("Flexiones De Brazo (Push-ups)", "Flexiones De Diamante", "Burpees", "Running"));
        ejercicios.put("Anaerobicos", Arrays.asList("Sprints", "Jump Rope", "High-Intensity Interval Training (HIIT)"));
        ejercicios.put("Fuerza", Arrays.asList("Deadlifts", "Bench Press", "Squats"));
        return ejercicios;
    }

    @GetMapping("/RegistroEjercicio")
    public String formularioRegistroEjercicio() {
        return "/Exercises/FormularioRegistroEjercicio";
    }

    @GetMapping("/Home")
    public String homeRegistroEjercicio(Model model) {
        return "/Exercises/HomeRegistroEjercicio";
    }
}