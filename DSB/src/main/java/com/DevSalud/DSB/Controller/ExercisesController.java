package com.DevSalud.DSB.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;
import ch.qos.logback.core.model.Model;


@Controller
@RequestMapping(path = "/Api/Users/Exercises")
public class ExercisesController {

    // Método que devuelve la lista de tipos de ejercicios
    @ModelAttribute("allTipEjercicios")
    public List<String> tiposDeEjercicios() {
        return Arrays.asList("Aerobico", "Anaerobicos", "Fuerza", "Resistencia", "Pecho", "Pierna", "Hombro", "Espalda", "Biceps", "Triceps", "Abdominales", "Antebrazo", "Pantorrilla", "Equilibrio", "Fortalecimiento", "Flexibilidad");
    }

    // Mapa con ejercicios asociados a cada tipo
    @ModelAttribute("ejerciciosPorTipo")
    public Map<String, List<String>> ejerciciosPorTipo() {
        Map<String, List<String>> ejerciciosPorTipo = new HashMap<>();

        ejerciciosPorTipo.put("Fuerza", Arrays.asList("Deadlifts", "Bench Press", "Squats"));
        ejerciciosPorTipo.put("Aerobico", Arrays.asList("Correr", "Nadar", "Bicicleta"));
        ejerciciosPorTipo.put("Pecho", Arrays.asList("Flexiones", "Press de banca"));
        // Agregar más tipos y ejercicios aquí según sea necesario

        return ejerciciosPorTipo;
    }

    @GetMapping("/RegistroEjercicio")
    public String formularioRegistroEjercicio(Model model) {
        return "Exercises/FormularioRegistroEjercicio";
    }

    @GetMapping("/home")
    public String homeRegistroEjercicio(Model model) {
        return "/Exercises/HomeRegistroEjercicio";
    }

}