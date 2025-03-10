package com.DevSalud.DSB.Controller;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.DevSalud.DSB.Model.UserModel;
import com.DevSalud.DSB.Service.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jakarta.servlet.http.HttpSession;
import lombok.Data;

@Data
@Controller
@RequestMapping("/Api/Users/Exercises")
public class PlanExerciseController {

    @Autowired
    private UserServices userService;
    
    @Autowired
    private PlanExerciseServices PlanExerciseServices;

    @GetMapping("/PlanEjercicio")
    public String listExercises(Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("UsuarioId");

        if (userId == null) {
            model.addAttribute("error", "Usuario no encontrado.");
            return "redirect:/Api/Users/Login"; // Redirige a login si el usuario no se encuentra
        }

        UserModel user = userService.getUserById(userId);
        if (user == null) {
            model.addAttribute("error", "Usuario no encontrado.");
            return "redirect:/Api/Users/Login"; // Redirige a login si el usuario no se encuentra
        }

        String disease = user.getDisease();
        String healthClassification = user.getHealthClassification();

        // Verifica si el usuario ha realizado ejercicios no autorizados
        if (PlanExerciseServices.hasUnauthorizedExercises(userId, disease)) {
            System.out.println("El paciente ha realizado ejercicios no autorizados.");
            model.addAttribute("error", "El paciente ha realizado ejercicios no autorizados.");
            return "error"; // Vista de error
        }

        // Filtra los planes según la enfermedad y la clasificación de salud
        Map<String, List<List<String>>> exercisePlans = filterPlans(disease, healthClassification);
        model.addAttribute("exercisePlans", exercisePlans);
        return "/Health_Plans/Exercises/PlanesEjercicio"; // Vista donde se mostrarán los ejercicios
    }

    /**
     * Filtra los planes de ejercicio basados en la enfermedad y la clasificación de
     * salud del usuario.
     * 
     * @param disease              La enfermedad del usuario.
     * @param healthClassification La clasificación de salud del usuario.
     * @return Un mapa de planes de ejercicio filtrados.
     */
    private Map<String, List<List<String>>> filterPlans(String disease, String healthClassification) {
        Map<String, List<List<String>>> filteredPlans = new HashMap<>();
        Map<String, List<List<String>>> allPlans = loadPlansFromJson();

        // Filtrar planes según la enfermedad y clasificación de salud
        if (allPlans.isEmpty()) {
            return filteredPlans; // Retorna un mapa vacío si no hay planes
        }

        switch (disease) {
            case "Hipertension":
                filterHypertensivePlans(healthClassification, filteredPlans, allPlans);
                break;
            case "Diabetes Tipo 1":
                filterDiabetesType1Plans(healthClassification, filteredPlans, allPlans);
                break;
            case "Diabetes Tipo 2":
                filterDiabetesType2Plans(healthClassification, filteredPlans, allPlans);
                break;
            default:
                break;
        }

        return filteredPlans;
    }

    /**
     * Filtra los planes para usuarios hipertensos según su clasificación de salud.
     * 
     * @param healthClassification La clasificación de salud del usuario.
     * @param filteredPlans        El mapa de planes filtrados.
     * @param allPlans             El mapa de todos los planes de ejercicio.
     */
    private void filterHypertensivePlans(String healthClassification, Map<String, List<List<String>>> filteredPlans,
            Map<String, List<List<String>>> allPlans) {
        switch (healthClassification) {
            case "Bajo Peso":
                filteredPlans.put("hipertensosBajoDePeso", allPlans.get("hipertensosBajoDePeso"));
                break;
            case "Sobre Peso":
                filteredPlans.put("hipertensosSobrePeso", allPlans.get("hipertensosSobrePeso"));
                break;
            case "Obesidad Tipo I":
            case "Obesidad Tipo II":
                filteredPlans.put("hipertensosObesidadTipo1y2", allPlans.get("hipertensosObesidadTipo1y2"));
                break;
            case "Obesidad Tipo III":
            case "Obesidad Tipo IV":
                filteredPlans.put("hipertensosObesidadTipo3y4", allPlans.get("hipertensosObesidadTipo3y4"));
                break;
            default:
                break;
        }
    }

    /**
     * Filtra los planes para usuarios con diabetes tipo 1 según su clasificación de
     * salud.
     * 
     * @param healthClassification La clasificación de salud del usuario.
     * @param filteredPlans        El mapa de planes filtrados.
     * @param allPlans             El mapa de todos los planes de ejercicio.
     */
    private void filterDiabetesType1Plans(String healthClassification, Map<String, List<List<String>>> filteredPlans,
            Map<String, List<List<String>>> allPlans) {
        switch (healthClassification) {
            case "Bajo Peso":
                filteredPlans.put("diabetesTipo1BajoPeso", allPlans.get("diabetesTipo1BajoPeso"));
                break;
            case "Sobre Peso":
                filteredPlans.put("diabetesTipo1SobrePeso", allPlans.get("diabetesTipo1SobrePeso"));
                break;
            case "Obesidad Tipo I":
            case "Obesidad Tipo II":
                filteredPlans.put("diabetesTipo1ObesidadTipoIYII", allPlans.get("diabetesTipo1ObesidadTipoIYII"));
                break;
            case "Obesidad Tipo III":
            case "Obesidad Tipo IV":
                filteredPlans.put("diabetesTipo1ObesidadTipoIIIYIV", allPlans.get("diabetesTipo1ObesidadTipoIIIYIV"));
                break;
            default:
                break;
        }
    }

    /**
     * Filtra los planes para usuarios con diabetes tipo 2 según su clasificación de
     * salud.
     * 
     * @param healthClassification La clasificación de salud del usuario.
     * @param filteredPlans        El mapa de planes filtrados.
     * @param allPlans             El mapa de todos los planes de ejercicio.
     */
    private void filterDiabetesType2Plans(String healthClassification, Map<String, List<List<String>>> filteredPlans,
            Map<String, List<List<String>>> allPlans) {
        switch (healthClassification) {
            case "Bajo Peso":
                filteredPlans.put("diabetesTipo2BajoPeso", allPlans.get("diabetesTipo2BajoPeso"));
                break;
            case "Sobre Peso":
                filteredPlans.put("diabetesTipo2SobrePeso", allPlans.get("diabetesTipo2SobrePeso"));
                break;
            case "Obesidad Tipo I":
            case "Obesidad Tipo II":
                filteredPlans.put("diabetesTipo2ObesidadTipoIYII", allPlans.get("diabetesTipo2ObesidadTipoIYII"));
                break;
            case "Obesidad Tipo III":
            case "Obesidad Tipo IV":
                filteredPlans.put("diabetesTipo2ObesidadTipoIIIYIV", allPlans.get("diabetesTipo2ObesidadTipoIIIYIV"));
                break;
            default:
                break;
        }
    }

    /**
     * Carga los planes de ejercicio desde un archivo JSON.
     * 
     * @return Un mapa que contiene todos los planes de ejercicio cargados desde el
     *         archivo JSON.
     */
    private Map<String, List<List<String>>> loadPlansFromJson() {
        Gson gson = new Gson();
        try {
            Resource resource = new ClassPathResource("static/Json/PlanExercise.json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            Type type = new TypeToken<Collection<Map<String, List<List<String>>>>>() {
            }.getType();
            Collection<Map<String, List<List<String>>>> plans = gson.fromJson(reader, type);
            Map<String, List<List<String>>> allPlans = new HashMap<>();
            for (Map<String, List<List<String>>> plan : plans) {
                allPlans.putAll(plan);
            }
            return allPlans;
        } catch (Exception e) {
            e.printStackTrace();
            return new HashMap<>(); // Retorna un mapa vacío en caso de error
        }
    }

}