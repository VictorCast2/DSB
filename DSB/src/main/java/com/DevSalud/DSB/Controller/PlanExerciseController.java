package com.DevSalud.DSB.Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.DevSalud.DSB.Model.UserModel;
import com.DevSalud.DSB.Service.UserServices;
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

        // Filtra los planes según la enfermedad y la clasificación de salud
        Map<String, List<List<String>>> exercisePlans = filterPlans(disease, healthClassification);
        model.addAttribute("exercisePlans", exercisePlans);

        return "/Health_Plans/Exercises/PlanesEjercicio"; // Vista donde se mostrarán los ejercicios
    }

    private Map<String, List<List<String>>> filterPlans(String disease, String healthClassification) {
        Map<String, List<List<String>>> filteredPlans = new HashMap<>();
        Map<String, List<List<String>>> allPlans = loadPlansFromJson();

        // Filtrar planes según la enfermedad y clasificación de salud
        if (allPlans.isEmpty()) {
            return filteredPlans; // Retorna un mapa vacío si no hay planes
        }

        switch (disease) {
            case "Hipertensos":
                filterHypertensivePlans(healthClassification, filteredPlans, allPlans);
                break;
            case "Diabetico Tipo I":
                filterDiabetesType1Plans(healthClassification, filteredPlans, allPlans);
                break;
            case "Diabetico Tipo II":
            case "Diabético Tipo II":
                filterDiabetesType2Plans(healthClassification, filteredPlans, allPlans);
                break;
            default:
                // Manejar otros casos si es necesario
                break;
        }

        return filteredPlans;
    }

    private void filterHypertensivePlans(String healthClassification, Map<String, List<List<String>>> filteredPlans, Map<String, List<List<String>>> allPlans) {
        switch (healthClassification) {
            case "Bajo Peso":
                filteredPlans.put("hipertensosBajoDePeso", allPlans.get("hipertensosBajoDePeso"));
                break;
            case "Sobre Peso":
                filteredPlans.put("hipertensosSobrePeso", allPlans.get("hipertensosSobrePeso"));
                break;
            default:
                // Manejar otros casos si es necesario
                break;
        }
    }

    private void filterDiabetesType1Plans(String healthClassification, Map<String, List<List<String>>> filteredPlans, Map<String, List<List<String>>> allPlans) {
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
                // Manejar otros casos si es necesario
                break;
        }
    }

    private void filterDiabetesType2Plans(String healthClassification, Map<String, List<List<String>>> filteredPlans, Map<String, List<List<String>>> allPlans) {
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
                // Manejar otros casos si es necesario
                break;
        }
    }

    private Map<String, List<List<String>>> loadPlansFromJson() {
        Gson gson = new Gson();
        try {
            Resource resource = new ClassPathResource("static/Json/PlanExercice.json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            Type type = new TypeToken<Map<String, List<List<String>>>>() {
            }.getType();
            return gson.fromJson(reader, type);
        } catch (Exception e) {
            e.printStackTrace();
            return new HashMap<>(); // Retorna un mapa vacío en caso de error
        }
    }

}
