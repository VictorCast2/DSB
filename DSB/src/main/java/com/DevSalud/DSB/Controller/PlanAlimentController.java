package com.DevSalud.DSB.Controller;

import com.DevSalud.DSB.Model.UserModel;
import com.DevSalud.DSB.Service.UserServices;
import com.google.gson.*;
import jakarta.servlet.http.HttpSession;
import lombok.Data;

import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Data
@Controller
@RequestMapping("/Api/Users/Food")
public class PlanAlimentController {

    @Autowired
    private UserServices userService;

    @Autowired
    private ResourceLoader resourceLoader;

    @GetMapping("/PlanAlimentos")
    public String listAlimetos(Model model, HttpSession session) {
        try {
            Long userId = (Long) session.getAttribute("UsuarioId");
            if (userId != null) {
                UserModel user = userService.getUserById(userId);
                if (user != null) {
                    // Recargar el archivo JSON desde la carpeta resources
                    Resource resource = resourceLoader.getResource("classpath:/static/Json/PlanesAlimenticios.json");
                    String content = new String(Files.readAllBytes(resource.getFile().toPath()));
                    // Parsear el JSON usando Gson
                    Gson gson = new Gson();
                    JsonObject jsonObject = gson.fromJson(content, JsonObject.class);

                    Map<String, List<Map<String, String>>> Retorno = new HashMap<>();
                    switch (user.getDisease()) {
                        case "Hipertension" -> {
                            switch (user.getHealthClassification()) {
                                case "Bajo Peso" -> {
                                    Retorno = extractAlimentsMap(jsonObject.getAsJsonArray("hipertensosBajoDePeso"));
                                    break;
                                }
                                case "Peso Normal" -> {
                                    Retorno = null;
                                    break;
                                }
                                case "Sobre Peso" -> {
                                    Retorno = extractAlimentsMap(jsonObject.getAsJsonArray("hipertensosSobrePeso"));
                                    break;
                                }
                                case "Obesidad Tipo I" -> {
                                    Retorno = extractAlimentsMap(
                                            jsonObject.getAsJsonArray("hipertensosObesidadTipo1y2"));
                                    break;
                                }
                                case "Obesidad Tipo II" -> {
                                    Retorno = extractAlimentsMap(
                                            jsonObject.getAsJsonArray("hipertensosObesidadTipo1y2"));
                                    break;
                                }
                                case "Obesidad Tipo III" -> {
                                    Retorno = extractAlimentsMap(
                                            jsonObject.getAsJsonArray("hipertensosObesidadTipo3y4"));
                                    break;
                                }
                                case "Obesidad Tipo IV" -> {
                                    Retorno = extractAlimentsMap(jsonObject.getAsJsonArray("hipertensosObesidadTipo3y4"));
                                    break;
                                }
                            }
                        }
                        case "Diabetes Tipo 1" -> {
                            switch (user.getHealthClassification()) {
                                case "Bajo Peso" -> {
                                    Retorno = extractAlimentsMap(jsonObject.getAsJsonArray("diabetesTipo1BajoDePeso"));
                                    break;
                                }
                                case "Peso Normal" -> {
                                    Retorno = null;
                                    break;
                                }
                                case "Sobre Peso" -> {
                                    Retorno = extractAlimentsMap(jsonObject.getAsJsonArray("diabetesTipo1SobrePeso"));
                                    break;
                                }
                                case "Obesidad Tipo I" -> {
                                    Retorno = extractAlimentsMap(jsonObject.getAsJsonArray("diabetesTipo1ObesidadTipo1y2"));
                                    break;
                                }
                                case "Obesidad Tipo II" -> {
                                    Retorno = extractAlimentsMap(
                                            jsonObject.getAsJsonArray("diabetesTipo1ObesidadTipo1y2"));
                                    break;
                                }
                                case "Obesidad Tipo III" -> {
                                    Retorno = extractAlimentsMap(
                                            jsonObject.getAsJsonArray("diabetesTipo1ObesidadTipo3y4"));
                                    break;
                                }
                                case "Obesidad Tipo IV" -> {
                                    Retorno = extractAlimentsMap(
                                            jsonObject.getAsJsonArray("diabetesTipo1ObesidadTipo3y4"));
                                    break;
                                }
                            }
                        }
                        case "Diabetes Tipo 2" -> {
                            switch (user.getHealthClassification()) {
                                case "Bajo Peso" -> {
                                    Retorno = extractAlimentsMap(jsonObject.getAsJsonArray("diabetesTipo2BajoDePeso"));
                                    break;
                                }
                                case "Peso Normal" -> {
                                    Retorno = null;
                                    break;
                                }
                                case "Sobre Peso" -> {
                                    Retorno = extractAlimentsMap(jsonObject.getAsJsonArray("diabetesTipo2SobrePeso"));
                                    break;
                                }
                                case "Obesidad Tipo I" -> {
                                    Retorno = extractAlimentsMap(
                                            jsonObject.getAsJsonArray("diabetesTipo2ObesidadTipo1y2"));
                                    break;
                                }
                                case "Obesidad Tipo II" -> {
                                    Retorno = extractAlimentsMap(
                                            jsonObject.getAsJsonArray("diabetesTipo2ObesidadTipo1y2"));
                                    break;
                                }
                                case "Obesidad Tipo III" -> {
                                    Retorno = extractAlimentsMap(
                                            jsonObject.getAsJsonArray("diabetesTipo2ObesiadaTipo3y4"));
                                    break;
                                }
                                case "Obesidad Tipo IV" -> {
                                    Retorno = extractAlimentsMap(
                                            jsonObject.getAsJsonArray("diabetesTipo2ObesiadaTipo3y4"));
                                    break;
                                }
                            }
                        }
                    }
                    model.addAttribute("FoodPlans", Retorno);
                } else {
                    model.addAttribute("error", "Usuario no encontrado.");
                    return "redirect:/Api/Users/Login";
                }
            }
        } catch (IOException | JsonSyntaxException e) {
            e.printStackTrace();
            model.addAttribute("jsonData", "Error leyendo el archivo JSON: " + e.getMessage());
        }
        return "/Health_Plans/Food/PlanesAlimenticios";
    }

    private Map<String, List<Map<String, String>>> extractAlimentsMap(JsonArray alimentosJson) {
        Map<String, List<Map<String, String>>> alimentsMap = new HashMap<>();
        for (JsonElement element : alimentosJson) {
            JsonObject dayObject = element.getAsJsonObject();
            String day = dayObject.get("dia").getAsString();
            Map<String, String> mealMap = new HashMap<>();
            mealMap.put("desayuno", dayObject.get("desayuno").getAsString());
            mealMap.put("almuerzo", dayObject.get("almuerzo").getAsString());
            mealMap.put("cena", dayObject.get("cena").getAsString());
            if (!alimentsMap.containsKey(day)) {
                alimentsMap.put(day, new ArrayList<>());
            }
            alimentsMap.get(day).add(mealMap);
        }
        return alimentsMap;
    }

}