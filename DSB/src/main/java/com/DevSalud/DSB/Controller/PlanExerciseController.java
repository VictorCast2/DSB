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
import org.springframework.web.bind.annotation.PathVariable;
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
                "Lunes - Hombro - Elevaciones Frontales Con Bandas Elásticas Con Giro De Pie - Baja"
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

    @GetMapping("/EditarPlanEjercicio/{id}")
    public String editExercise(@PathVariable Long id, Model model) {
        ExerciseLogModel exerciseLog = exerciseLogServices.getExerciseLogById(id);
        model.addAttribute("exerciseLog", exerciseLog);
        return "editarEjercicio"; // Devuelve la vista de edición de ejercicio
    }

    @GetMapping("/EliminarPlanEjercicio/{id}")
    public String deleteExercise(@PathVariable Long id) {
        exerciseLogServices.DeleteExerciseLog(id);
        return "redirect:/Api/Users/Exercises/ListaEjercicio"; // Redirige a la lista de ejercicios después de eliminar
    }
}
