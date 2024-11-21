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
                    // Extraer las opciones
                    Map<String, List<String>> hipertensosBajoDePeso = extractAlimentsMap(jsonObject.getAsJsonObject("hipertensosBajoDePeso"));
                    Map<String, List<String>> hipertensosSobrePeso = extractAlimentsMap(jsonObject.getAsJsonObject("hipertensosSobrePeso"));
                    Map<String, List<String>> hipertensosObesidadTipo1y2 = extractAlimentsMap(jsonObject.getAsJsonObject("hipertensosObesidadTipo1y2"));
                    Map<String, List<String>> hipertensosObesidadTipo3y4 = extractAlimentsMap(jsonObject.getAsJsonObject("hipertensosObesidadTipo3y4"));
                    Map<String, List<String>> diabetesTipo1BajoDePeso = extractAlimentsMap(jsonObject.getAsJsonObject("diabetesTipo1BajoDePeso"));
                    Map<String, List<String>> diabetesTipo1SobrePeso = extractAlimentsMap(jsonObject.getAsJsonObject("diabetesTipo1SobrePeso"));
                    Map<String, List<String>> diabetesTipo1ObesidadTipo1y2 = extractAlimentsMap(jsonObject.getAsJsonObject("diabetesTipo1ObesidadTipo1y2"));
                    Map<String, List<String>> diabetesTipo1ObesidadTipo3y4 = extractAlimentsMap(jsonObject.getAsJsonObject("diabetesTipo1ObesidadTipo3y4"));
                    Map<String, List<String>> diabetesTipo2BajoDePeso = extractAlimentsMap(jsonObject.getAsJsonObject("diabetesTipo2BajoDePeso"));
                    Map<String, List<String>> diabetesTipo2SobrePeso = extractAlimentsMap(jsonObject.getAsJsonObject("diabetesTipo2SobrePeso"));
                    Map<String, List<String>> diabetesTipo2ObesidadTipo1y2 = extractAlimentsMap(jsonObject.getAsJsonObject("diabetesTipo2ObesidadTipo1y2"));
                    Map<String, List<String>> diabetesTipo2ObesiadaTipo3y4 = extractAlimentsMap(jsonObject.getAsJsonObject("diabetesTipo2ObesiadaTipo3y4"));

                    model.addAttribute("FoodPlans", hipertensosBajoDePeso);
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