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

                    Map<String, List<String>> Retorno = new HashMap<>();

                    switch (user.getDisease()){
                        case "Hipertension" ->{
                            switch (user.getHealthClassification()) {
                                case "Bajo Peso" ->{
                                    Retorno = extractAlimentsMap(jsonObject.getAsJsonObject("hipertensosBajoDePeso"));
                                    break;
                                }
                                case "Peso Normal" ->{   
                                    Retorno = null;                             
                                    break;
                                }
                                case "Sobre Peso" ->{
                                    Retorno = extractAlimentsMap(jsonObject.getAsJsonObject("hipertensosSobrePeso"));
                                    break;
                                }
                                case "Obesidad Tipo I" ->{
                                    Retorno = extractAlimentsMap(jsonObject.getAsJsonObject("hipertensosObesidadTipo1y2"));
                                    break;
                                }
                                case "Obesidad Tipo II" ->{
                                    Retorno = extractAlimentsMap(jsonObject.getAsJsonObject("hipertensosObesidadTipo1y2"));
                                    break;
                                }
                                case "Obesidad Tipo III" ->{
                                    Retorno = extractAlimentsMap(jsonObject.getAsJsonObject("hipertensosObesidadTipo3y4"));
                                    break;
                                }
                                case "Obesidad Tipo IV" ->{
                                    Retorno = extractAlimentsMap(jsonObject.getAsJsonObject("hipertensosObesidadTipo3y4"));
                                    break;
                                }
                            }
                        }
                        case "Diabetes Tipo 1" ->{
                            switch (user.getHealthClassification()) {
                                case "Bajo Peso" ->{
                                    Retorno = extractAlimentsMap(jsonObject.getAsJsonObject("diabetesTipo1BajoDePeso"));
                                    break;
                                }
                                case "Peso Normal" ->{   
                                    Retorno = null;                             
                                    break;
                                }
                                case "Sobre Peso" ->{
                                    Retorno = extractAlimentsMap(jsonObject.getAsJsonObject("diabetesTipo1SobrePeso"));
                                    break;
                                }
                                case "Obesidad Tipo I" ->{
                                    Retorno = extractAlimentsMap(jsonObject.getAsJsonObject("diabetesTipo1ObesidadTipo1y2"));
                                    break;
                                }
                                case "Obesidad Tipo II" ->{
                                    Retorno = extractAlimentsMap(jsonObject.getAsJsonObject("diabetesTipo1ObesidadTipo1y2"));
                                    break;
                                }
                                case "Obesidad Tipo III" ->{
                                    Retorno = extractAlimentsMap(jsonObject.getAsJsonObject("diabetesTipo1ObesidadTipo3y4"));
                                    break;
                                }
                                case "Obesidad Tipo IV" ->{
                                    Retorno = extractAlimentsMap(jsonObject.getAsJsonObject("diabetesTipo1ObesidadTipo3y4"));
                                    break;
                                }
                            }
                        }
                        case "Diabetes Tipo 2" ->{
                            switch (user.getHealthClassification()) {
                                case "Bajo Peso" ->{
                                    Retorno = extractAlimentsMap(jsonObject.getAsJsonObject("diabetesTipo2BajoDePeso"));
                                    break;
                                }
                                case "Peso Normal" ->{   
                                    Retorno = null;                             
                                    break;
                                }
                                case "Sobre Peso" ->{
                                    Retorno = extractAlimentsMap(jsonObject.getAsJsonObject("diabetesTipo2SobrePeso"));
                                    break;
                                }
                                case "Obesidad Tipo I" ->{
                                    Retorno = extractAlimentsMap(jsonObject.getAsJsonObject("diabetesTipo2ObesidadTipo1y2"));
                                    break;
                                }
                                case "Obesidad Tipo II" ->{
                                    Retorno = extractAlimentsMap(jsonObject.getAsJsonObject("diabetesTipo2ObesidadTipo1y2"));
                                    break;
                                }
                                case "Obesidad Tipo III" ->{
                                    Retorno = extractAlimentsMap(jsonObject.getAsJsonObject("diabetesTipo2ObesiadaTipo3y4"));
                                    break;
                                }
                                case "Obesidad Tipo IV" ->{
                                    Retorno = extractAlimentsMap(jsonObject.getAsJsonObject("diabetesTipo2ObesiadaTipo3y4"));
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

    private Map<String, List<String>> extractAlimentsMap(JsonObject alimentosJson) {
        Map<String, List<String>> AlimentsMap = new HashMap<>();
        for (Map.Entry<String, JsonElement> entry : alimentosJson.entrySet()) {
            List<String> alimentosList = new ArrayList<>();
            JsonArray jsonArray = entry.getValue().getAsJsonArray();
            for (JsonElement element : jsonArray) {
                alimentosList.add(element.getAsString());
            }
            AlimentsMap.put(entry.getKey(), alimentosList);
        }
        return AlimentsMap;
    }

}