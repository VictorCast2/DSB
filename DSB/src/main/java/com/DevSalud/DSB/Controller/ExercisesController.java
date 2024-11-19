package com.DevSalud.DSB.Controller;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.DevSalud.DSB.Model.*;
import com.DevSalud.DSB.Service.*;
import com.google.gson.*;
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

    @GetMapping("/RegistrarYEditarEjercicio")
    public String showExercise(Model model) {
        ExerciseLogModel exerciseLog = new ExerciseLogModel(); // Crear un nuevo objeto vacío para el formulario
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
            model.addAttribute("exerciseLog", exerciseLog); // Agregar el nuevo ejercicio al modelo

        } catch (IOException | JsonSyntaxException e) {
            e.printStackTrace();
            model.addAttribute("jsonData", "Error leyendo el archivo JSON: " + e.getMessage());
        }
        return "Exercises/FormularioRegistroEjercicio"; // Vista para registrar el nuevo ejercicio
    }

    @GetMapping("/RegistrarYEditarEjercicio/{id}")
    public String EditsExercise(@PathVariable Long id, Model model) {
        ExerciseLogModel exerciseLog = new ExerciseLogModel();
        try {
            // Obtener el ejercicio desde el servicio por ID
            exerciseLog = exerciseLogService.getExerciseLogById(id);
            if (exerciseLog == null) {
                model.addAttribute("error", "Ejercicio no encontrado.");
                return "redirect:/Api/Users/Exercises/TablaEjercicio"; // Redirigir si no se encuentra el ejercicio
            }

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
            model.addAttribute("exerciseLog", exerciseLog); // Agregar el ejercicio al modelo

        } catch (IOException | JsonSyntaxException e) {
            e.printStackTrace();
            model.addAttribute("jsonData", "Error leyendo el archivo JSON: " + e.getMessage());
        }
        return "Exercises/FormularioRegistroEjercicio"; // Vista para editar el ejercicio
    }

    @PostMapping("/RegistrarYEditarEjercicio")
    public String saveOrUpdateExercise(@ModelAttribute("exerciseLog") ExerciseLogModel exerciseLog, Model model,
            HttpSession session) {
        try {
            Long userId = (Long) session.getAttribute("UsuarioId");

            // Si el ejercicio tiene un ID, significa que se está actualizando
            if (exerciseLog.getId() != null) {
                // Verificar si el ejercicio existe en la base de datos
                ExerciseLogModel existingExercise = exerciseLogService.getExerciseLogById(exerciseLog.getId());
                if (existingExercise != null) {
                    // Si existe, actualizar el ejercicio
                    exerciseLogService.UpdateExerciseLog(exerciseLog);
                    model.addAttribute("success", "Ejercicio actualizado exitosamente.");
                } else {
                    model.addAttribute("error", "El ejercicio no existe para actualizar.");
                }
            } else {
                // Si el ejercicio no tiene ID, es un nuevo registro
                UserModel user = userService.getUserById(userId);
                exerciseLog.setUser(user);
                // Eliminar el ejercicio anterior si es necesario antes de registrar el nuevo
                if (exerciseLog.getId() != null) {
                    exerciseLogService.DeleteExerciseLog(exerciseLog.getId());
                }
                // Registrar un nuevo ejercicio
                exerciseLogService.saveExerciseLog(exerciseLog);
                model.addAttribute("success", "Ejercicio registrado exitosamente.");
            }
            // Recargar el archivo JSON desde la carpeta resources
            Resource resource = resourceLoader.getResource("classpath:/static/Json/Ejercicio.json");
            String content = new String(Files.readAllBytes(resource.getFile().toPath()));
            // Parsear el JSON usando Gson
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(content, JsonObject.class);
            // Extraer las opciones
            List<String> intensidadOptions = extractJsonArray(jsonObject, "IntensidadEjercicio");
            List<String> tiposEjerciciosOptions = extractJsonArray(jsonObject, "TiposEjercicios");
            Map<String, List<String>> ejerciciosMap = extractEjerciciosMap(jsonObject.getAsJsonObject("Ejercicios"));
            // Pasar las opciones al modelo
            model.addAttribute("intensidadOptions", intensidadOptions);
            model.addAttribute("tiposEjerciciosOptions", tiposEjerciciosOptions);
            model.addAttribute("ejerciciosMap", ejerciciosMap);
            model.addAttribute("exerciseLog", exerciseLog); // Asegurarse de pasar el objeto actualizado al modelo

        } catch (IOException | JsonSyntaxException e) {
            e.printStackTrace();
            model.addAttribute("jsonData", "Error leyendo el archivo JSON: " + e.getMessage());
        }
        return "Exercises/FormularioRegistroEjercicio"; // Vista de registro/edición
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

    @GetMapping("/TablaEjercicio")
    public String tableExercise(Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("UsuarioId");
        if (userId != null) {
            // Aquí obtenemos los ejercicios del usuario desde el servicio.
            List<ExerciseLogModel> exerciseLogs = exerciseLogService.getExerciseLogsByUserId(userId);
            model.addAttribute("exerciseLogs", exerciseLogs);
            return "Exercises/TablaRegistroEjercicio";
        } else {
            model.addAttribute("error", "Usuario no encontrado.");
            return "redirect:/Api/Users/Login";
        }
    }

    @GetMapping("/EliminarEjercicio/{id}")
    public String deleteExercise(@PathVariable Long id) {
        exerciseLogService.DeleteExerciseLog(id); // Llama al servicio para eliminar el ejercicio por ID
        return "redirect:/Api/Users/Exercises/TablaEjercicio"; // Redirige a la lista de ejercicios después de eliminar
    }

    @GetMapping("/Home")
    public String homeRegistroEjercicio() {
        return "/Exercises/HomeRegistroEjercicio";
    }

}