package com.DevSalud.DSB.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.*;

@Controller
@RequestMapping(path = "/Api/Users/Exercises")
public class ExercisesController {

    @ModelAttribute("allTipEjercicios")
    public List<String> tiposDeEjercicios() {
        return Arrays.asList("Aerobico", "Anaerobicos", "Fuerza", "Resistencia", "Pecho", "Pierna", "Hombro", "Espalda", "Biceps", "Triceps", "Abdominales", "Antebrazo", "Pantorrilla", "Equilibrio", "Fortalecimiento", "Flexibilidad");
    }

    @ModelAttribute("allNameEjercicios")
    public Map<String, List<String>> nombreDeLosEjercicios() {
        Map<String, List<String>> ejercicios = new HashMap<>();
        ejercicios.put("Aerobico", Arrays.asList("Flexiones De Brazo (Push-ups)", "Flexiones De Diamante", "Flexiones Declinadas"));
        ejercicios.put("Anaerobicos", Arrays.asList("Saltos De Tijera", "Burpees", "Escaladores De Montaña"));
        ejercicios.put("Pecho", Arrays.asList("Flexiones De Brazo", "Flexiones De Diamante", "Flexiones Inclinadas"));
        ejercicios.put("Pierna", Arrays.asList("Sentadillas", "Sentadillas Con Salto", "Sentadillas De Sumo"));
        ejercicios.put("Hombro", Arrays.asList("Flexiones De Pica", "Flexiones Hindúes", "Flexiones Declinadas"));
        ejercicios.put("Triceps", Arrays.asList("Fondos En Silla", "Fondos Entre Dos Sillas", "Fondos En El Suelo"));
        ejercicios.put("Biceps", Arrays.asList("Flexiones Con Agarre Estrecho", "Flexiones De Diamante", "Flexiones Escalonadas"));
        ejercicios.put("Espalda", Arrays.asList("Flexiones Hindúes", "Flexiones Con Pica", "Flexiones Arqueras"));
        ejercicios.put("Abdominales", Arrays.asList("Abdominales Tradicionales", "Abdominales Tipo Bicicleta", "Abdominales Con Piernas Elevadas"));
        ejercicios.put("Pantorrilla", Arrays.asList("Elevaciones De Talón", "Elevaciones De Talón Con Una Pierna", "Elevaciones De Talón En Escalón"));
        ejercicios.put("Antebrazo", Arrays.asList("Flexiones Con Manos Invertidas", "Flexiones Con Agarre Estrecho", "Flexiones De Diamante"));
        ejercicios.put("Flexibilidad", Arrays.asList("Estiramiento De Cuádriceps", "Estiramiento De Isquiotibiales", "Estiramiento De Pantorrillas"));
        ejercicios.put("Equilibrio", Arrays.asList("Equilibrio A Una Pierna", "Equilibrio A Una Pierna Con Ojo Cerrado", "Equilibrio En Puntillas"));
        ejercicios.put("Fortalecimiento", Arrays.asList("Flexiones De Brazo (Push-Ups)", "Flexiones De Diamante", "Flexiones Arqueras (Archer Push-Ups)"));
        ejercicios.put("Fuerza", Arrays.asList("Flexiones De Brazo (Push-Ups)", "Flexiones De Diamante", "Flexiones Inclinadas"));
        ejercicios.put("Resistencia", Arrays.asList("Saltos De Tijera (Jumping Jacks)", "Burpees", "Escaladores De Montaña (Mountain Climbers)"));
        return ejercicios;
    }

    @GetMapping("/RegistroEjercicio")
    public String formularioRegistroEjercicio() {
        return "Exercises/FormularioRegistroEjercicio";
    }

    @GetMapping("/Home")
    public String homeRegistroEjercicio() {
        return "Exercises/HomeRegistroEjercicio";
    }

}