package com.DevSalud.DSB.Controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.DevSalud.DSB.Model.ExerciseLogModel;
import com.DevSalud.DSB.Service.ExerciseLogServices;

@Controller
@RequestMapping("/Api/Users/Exercises")
public class PlanExerciseController {

    @Autowired
    private ExerciseLogServices exerciseLogServices;

    @ModelAttribute("allNamePlanes")
    public Map<String, List<String>> PlanesMap() {
        Map<String, List<String>> planMap = new HashMap<>();

        planMap.put("hipertensosBajoDePeso", Arrays.asList(
                "Lunes - Aerobicos - Saltos De Cuerda - Moderada",
                "Lunes - Aerobicos - Saltos De Tijera- Moderada",
                "Lunes - Aerobicos - Caminata Rápida - Baja",
                "Lunes - Aerobicos - bicicleta Estática - Alta",
                "Lunes - Pierna - Sentadillas Sin Peso O Con Una Silla - Moderada",
                "Lunes - Pierna - Sentadillas Con Salto - Baja",
                "Lunes - Pierna - Elevaciones De Talones Con Elevación De Cadera - Moderada",
                "Lunes - Hombro - Elevaciones Laterales Con Bandas Elásticas - Moderada",
                "Lunes - Hombro - Elevaciones Frontales Con Bandas Elásticas Y Giro - Alta",
                "Lunes - Hombro - Elevaciones Frontales Con Bandas Elásticas Con Giro De Pie - Baja",
                //
                "Martes - Espalda - Flexiones Inclinadas - Baja",
                "Martes - Espalda - Escaladores De Montaña - Moderada",
                "Martes - Espalda - Remo Con Bandas Elásticas - Alta",
                "Martes - Triceps - Fondos En Silla - Moderada",
                "Martes - Triceps - Fondos En El Suelo - Baja",
                "Martes - Triceps - Fondos De Tríceps Con Elevación De Pierna- Moderada",
                "Martes - Equilibrio - Levantamiento de una pierna - Alta",
                "Martes - Equilibrio - Equilibrio En T - Alta",
                "Martes - Equilibrio - Equilibrio En Talones - Alta",
                //
                "Miercoles - Pecho - Flexiones De Brazo - Baja",
                "Miercoles - Pecho - Flexiones Con Brazos Abiertos - Baja",
                "Miercoles - Pecho - Flexiones Inclinadas - Alta",
                "Miercoles - Biceps - Curl De Bíceps Con Bandas Elásticas - Moderada",
                "Miercoles - Biceps - Curl De Bíceps Con Bandas Elásticas Alternado - Moderada",
                "Miercoles - Biceps - Curl De Bíceps Con Bandas Elásticas Cruzadas - Moderada",
                "Miercoles - Antebrazo - Curl De Muñeca Con Bandas Elásticas - Moderada",
                "Miercoles - Antebrazo - Extensión De Muñeca Con Bandas Elásticas - Moderada",
                "Miercoles - Antebrazo - Extensión De Muñeca Con Bandas Elásticas Y Giro De Torso - Moderada",
                //
                "Jueves - Abdominales - Abdominales Tradicionales - Moderada",
                "Jueves - Abdominales - Abdominales Tipo Bicicleta - Moderada",
                "Jueves - Abdominales - Abdominales Con Piernas Elevadas - Moderada",
                "Jueves - Pantorrilla - Elevaciones De Talón - Moderada",
                "Jueves - Pantorrilla - Elevaciones De Talón Con Una Pierna - Baja",
                "Jueves - Pantorrilla - Elevaciones De Talón En Escalón - Moderada",
                "Jueves - Flexibilidad - Estiramiento De Cuádriceps - Alta",
                "Jueves - Flexibilidad - Estiramiento De Pantorrillas - Alta",
                "Jueves - Flexibilidad - Estiramiento De Cadera - Alta",
                //
                "Viernes - Fuerza - Flexiones De Brazo (Push-Ups) - Baja",
                "Viernes - Fuerza - Flexiones Inclinadas - Baja",
                "Viernes - Fuerza - Fondos De Tríceps En Silla - Baja",
                "Viernes - Resistencia - Saltos De Tijera - Moderada",
                "Viernes - Resistencia - Sentadillas Con Salto - Baja",
                "Viernes - Resistencia - Flexiones Declinadas - Baja",
                "Viernes - Aerobico - Rodillas Al Pecho - Alta",
                "Viernes - Aerobico - Skipping - Alta",
                "Viernes - Aerobico - Salto De Estrella - Alta"
        ));
        return planMap;
    }

    public String home() {
        return "home"; // Devuelve la vista de inicio
    }

    @GetMapping("/PlanEjercicio")
    public String listExercises(Model model) {
        List<ExerciseLogModel> exerciseLogs = exerciseLogServices.getAllExerciseLogs();
        model.addAttribute("exerciseLogs", exerciseLogs);
        return "listaEjercicio"; // Devuelve la vista de lista de ejercicios
    }

}
