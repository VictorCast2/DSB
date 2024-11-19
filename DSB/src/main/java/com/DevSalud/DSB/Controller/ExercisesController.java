package com.DevSalud.DSB.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.DevSalud.DSB.Model.ExerciseLogModel;
import com.DevSalud.DSB.Model.UserModel;
import com.DevSalud.DSB.Service.ExerciseLogServices;
import com.DevSalud.DSB.Service.UserServices;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/Api/Users/Exercises")
public class ExercisesController {

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private UserServices userService;

    @Autowired
    private ExerciseLogServices exerciseLogService;

    @GetMapping("/RegistroEjercicio")
    public String showExerciseForm(Model model) {
        try {
            // Cargar el archivo JSON desde la carpeta resources
            Resource resource = resourceLoader.getResource("classpath:/static/Json/Ejercicio.json");
            String content = new String(Files.readAllBytes(resource.getFile().toPath()));

            // Parsear el JSON usando Gson
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(content, JsonObject.class);

            // Extraer los valores de los arrays "IntensidadEjercicio" y "TiposEjercicios"
            List<String> intensidadOptions = extractJsonArray(jsonObject, "IntensidadEjercicio");
            List<String> tiposEjerciciosOptions = extractJsonArray(jsonObject, "TiposEjercicios");

            // Extraer los ejercicios agrupados por tipo
            Map<String, List<String>> ejerciciosMap = extractEjerciciosMap(jsonObject.getAsJsonObject("Ejercicios"));

            // Pasar las opciones al modelo
            model.addAttribute("intensidadOptions", intensidadOptions);
            model.addAttribute("tiposEjerciciosOptions", tiposEjerciciosOptions);
            model.addAttribute("ejerciciosMap", ejerciciosMap);
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("jsonData", "Error leyendo el archivo JSON: " + e.getMessage());
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            model.addAttribute("jsonData", "Error procesando el JSON: " + e.getMessage());
        }
        // Agregar el modelo para el registro de ejercicio
        model.addAttribute("exerciseLog", new ExerciseLogModel());
        return "Exercises/FormularioRegistroEjercicio";
    }

    private List<String> extractJsonArray(JsonObject jsonObject, String arrayName) {
        List<String> list = new ArrayList<>();
        JsonArray jsonArray = jsonObject.getAsJsonArray(arrayName);
        for (JsonElement element : jsonArray) {
            list.add(element.getAsString());
        }
        return list;
    }

    private Map<String, List<String>> extractEjerciciosMap(JsonObject ejerciciosJson) {
        Map<String, List<String>> ejerciciosMap = new HashMap<>();
        for (Map.Entry<String, JsonElement> entry : ejerciciosJson.entrySet()) {
            List<String> ejerciciosList = new ArrayList<>();
            JsonArray jsonArray = entry.getValue().getAsJsonArray();
            for (JsonElement element : jsonArray) {
                ejerciciosList.add(element.getAsString());
            }
            ejerciciosMap.put(entry.getKey(), ejerciciosList);
        }
        return ejerciciosMap;
    }

    @PostMapping("/RegistroEjercicio")
    public String registerExercise(@ModelAttribute("exerciseLog") ExerciseLogModel exerciseLog, Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("UsuarioId");
        if (userId != null) {
            UserModel user = userService.getUserById(userId);
            exerciseLog.setUser(user);
            exerciseLogService.saveExerciseLog(exerciseLog);
            model.addAttribute("message", "Registro exitoso");
            System.out.println("Fecha de inicio: " + exerciseLog.getStrartDate());
            System.out.println("Fecha final: " + exerciseLog.getFinalDate());
            return "redirect:/Api/Users/Exercises/TablaEjercicio";
        } else {
            model.addAttribute("error", "Usuario no encontrado.");
            return "redirect:/Api/Users/Login";
        }
    }

    @GetMapping("/TablaEjercicio")
    public String TablaRegistroEjercicio(Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("UsuarioId");
        if (userId != null) {
            model.addAttribute("exerciseLogs", null);
            return "Exercises/TablaRegistroEjercicio";
        } else {
            model.addAttribute("error", "Usuario no encontrado.");
            return "redirect:/Api/Users/Login";
        }
    }

    @GetMapping("/EditarEjercicio/{id}")
    public String showEditEjercicio(@PathVariable Long id, Model model) {
        // Obtener el ejercicio específico a editar
        ExerciseLogModel exerciseLog = exerciseLogService.getExerciseLogById(id);
        // Agregar atributos al modelo
        model.addAttribute("exerciseLog", exerciseLog);
        return "Exercises/FormularioEditarEjercicio";
    }

    @PostMapping("/EditarEjercicio")
    public String editarEjercicio(@ModelAttribute ExerciseLogModel exerciseLog) {
        exerciseLogService.UpdateExerciseLog(exerciseLog);
        return "redirect:/Api/Users/Exercises/TablaEjercicio"; // Redirige después de la edición
    }

    @GetMapping("/EliminarEjercicio/{id}")
    public String deleteExercise(@PathVariable Long id) {
        exerciseLogService.DeleteExerciseLog(id);
        return "redirect:/Api/Users/Exercises/TablaEjercicio";
    }

    @GetMapping("/Home")
    public String homeRegistroEjercicio() {
        return "/Exercises/HomeRegistroEjercicio";
    }

}
