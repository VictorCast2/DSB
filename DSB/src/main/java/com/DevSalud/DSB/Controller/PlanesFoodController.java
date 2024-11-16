package com.DevSalud.DSB.Controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.DevSalud.DSB.Model.UserModel;
import com.DevSalud.DSB.Service.UserServices;
import jakarta.servlet.http.HttpSession;
import lombok.Data;

@Data
@Controller
@RequestMapping("/Api/Users/Food")
public class PlanesFoodController {

    @Autowired
    private UserServices userService;

    @GetMapping("/PlanAlimentos")
    public String listAlimetos(Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("UsuarioId");
        if (userId != null) {
            UserModel user = userService.getUserById(userId);
            if (user != null) {
                String disease = user.getDisease();
                String healthClassification = user.getHealthClassification();

                // Filtra los planes alimenticios según la enfermedad y la clasificación de salud
                Map<String, List<List<String>>> foodPlans = filterPlansByDiseaseAndHealthClassification(disease,
                        healthClassification);
                model.addAttribute("FoodPlans", foodPlans); // Pasa los planes filtrados a la vista
                return "/Health_Plans/Food/PlanesAlimenticios"; // Vista donde se mostrarán los planes
            }
        }
        model.addAttribute("error", "Usuario no encontrado.");
        return "redirect:/Api/Users/Login"; // Redirige a login si el usuario no se encuentra
    }

    private Map<String, List<List<String>>> filterPlansByDiseaseAndHealthClassification(String disease,
            String healthClassification) {
        Map<String, List<List<String>>> allPlans = PlanesMap();
        Map<String, List<List<String>>> filteredPlans = new HashMap<>();

        // Filtra según la enfermedad y el IMC del usuario
        if ("Hipertensos".equals(disease)) {
            if ("Bajo Peso".equals(healthClassification)) {
                filteredPlans.put("hipertensosBajoDePeso", allPlans.get("hipertensosBajoDePeso"));
            } else if ("Sobre Peso".equals(healthClassification)) {
                filteredPlans.put("hipertensosSobrePeso", allPlans.get("hipertensosSobrePeso"));
            }
        }
        // Puedes agregar más condiciones para otras enfermedades (Diabetes, etc.) de
        // manera similar

        return filteredPlans;
    }

    @ModelAttribute("allNamePlanes")
    public Map<String, List<List<String>>> PlanesMap() {
        Map<String, List<List<String>>> planMap = new HashMap<>();

        // Planes para hipertensos con IMC bajo de peso
        List<List<String>> hipertensosBajoDePeso = new ArrayList<>();
        hipertensosBajoDePeso.add(Arrays.asList("Lunes",
                "1 Arepa Mediana,1 Pocillo De Cafe De Leche, 1 Tajada De Queso Bajo En Sal",
                "3 Unidades Pequenas De Papa Criolla,1 Porcion De Pechuga Asada,1 Porcion De Ensalada",
                "1 Porcion De Tortilla De Habichuela, 1 Porcion De Bollo Limpio"));

        hipertensosBajoDePeso.add(Arrays.asList("Martes",
                "1 Unidad Mediana De Papa Cocida (Dividida En 4 Sin Cascara), 1 Huevo Cocido",
                "1 Pocillo De Arrroz De Cerdo Bistec (Tomate y Cebolla), 1 Porcion De Ensalada",
                "1 Porcion De Huevo Con Espinaca, 1 Arepa Asada"));

        hipertensosBajoDePeso.add(Arrays.asList("Miércoles",
                "1 Porcion De Tortilla, 1 Unidad De Papa Mediana, Cebolla Blanca y 1 Huevo Batido",
                "1 Pedazo De Ahuyama, 1 Porcion De Pollo Asado, 1 Porcion De Vegetales",
                "1 Porcion De Pollo Hilachado, 2 Torrejas De Pan Integral"));

        hipertensosBajoDePeso.add(Arrays.asList("Jueves",
                "1 Platano Amarillo, 2 Claras De Huevos Con Tomate y Cebolla, 1 Pocillo De Cafe Con Leche",
                "1 Porcion De Filete De Pescado, 1 Porcion De Ensalada y Un Pocillo De Arroz",
                "1 Arepa Mediana Rellena De Pollo Hilachado Con Vegetales"));

        hipertensosBajoDePeso.add(Arrays.asList("Viernes",
                "1 Trozo Mediano De Yuca, 1 Torreja De Queso",
                "1 Plato Mediano De Sopas De Cohete Con Verduras y Papas y Ñame",
                "1 Porcion De Boronia (1/2 De Platano Amarillo), (1/2 Berenjenas), (1/2 Tomate), (1/2 Cebolla)"));

        hipertensosBajoDePeso.add(Arrays.asList("Sábado",
                "1 Arepa Mediana, 1 Pocillo De Cafe De Leche, 1 Tajada De Queso Bajo En Sal",
                "3 Unidades Pequenas De Papa Criolla, 1 Porcion De Pechuga Asada, 1 Porcion De Ensalada",
                "1 Porcion De Tortilla De Habichuela, 1 Porcion De Bollo Limpio"));

        hipertensosBajoDePeso.add(Arrays.asList("Domingo",
                "1 Unidad Mediana De Papa Cocida (Dividida En 4 Sin Cascara), 1 Huevo Cocido",
                "1 Pocillo De Arrroz De Cerdo Bistec (Tomate y Cebolla), 1 Porcion De Ensalada",
                "1 Porcion De Huevo Con Espinaca, 1 Arepa Asada"));

        planMap.put("hipertensosBajoDePeso", hipertensosBajoDePeso);

        // Planes para hipertensos con IMC sobrepeso
        List<List<String>> hipertensosSobrePeso = new ArrayList<>();
        hipertensosSobrePeso.add(Arrays.asList("Lunes",
                "1 Banano, Arepa De Maíz, Huevo Revuelto, Avena",
                "Ensalada De Tomate, Lechuga Y Arvejas, Filete De Pescado, Aceite De Oliva",
                "Uvas Con Pan Integral Con Ajo Y Aceite De Oliva, Agua De Avena"));

        hipertensosSobrePeso.add(Arrays.asList("Martes",
                "1 Mango, Papa Criolla, Queso Bajo En Sal Y Leche De Almendras",
                "Ensalada De Tomate, Papas Cocidas, Pechugas En Cuadros, Aceite De Oliva",
                "Sándwich De Pollo, Fruta, Té De Menta"));

        hipertensosSobrePeso.add(Arrays.asList("Miércoles",
                "Papaya Con Banano, Pan Integral, Guiso Con Pollo Y Avena",
                "Ensalada De Lechuga Crespa, Arroz De Ají, Pescado Al Vapor, Aceite De Oliva",
                "Tostadas Integrales, Zumo De Uvas"));

        hipertensosSobrePeso.add(Arrays.asList("Jueves",
                "Avena Cocida Con Frutas Frescas (Plátano, Papaya, Arándanos) Y Un Puñado De Nueces",
                "Ensalada De Zanahorias Con Puré De Papa, Crema De Lentejas, Aceite De Oliva",
                "Sándwich De Atún, Agua De Avena"));

        hipertensosSobrePeso.add(Arrays.asList("Viernes",
                "1 Mango, Bollo De Maíz, Huevo Revuelto, Leche De Almendras",
                "Ensalada De Atún, Vegetales Y Garbanzos, Aceite De Oliva",
                "Manzana Y Pan Integral Con Tahini"));

        hipertensosSobrePeso.add(Arrays.asList("Sábado",
                "Arándanos, Arepa De Maíz Con Queso Bajo En Sal, Avena",
                "Ensalada De Brócoli Y Pastas Con Verduras, Pavo Horneado, Aceite De Oliva",
                "1/2 Taza De Arroz Con Pollo, 1 Rebanada De Pan Tostado Con Ajo"));

        hipertensosSobrePeso.add(Arrays.asList("Domingo",
                "Avena Cocida Con Frutas Frescas (Plátano, Mango, Arándanos) Y Un Puñado De Nueces",
                "Ensalada De Espinacas Con Tomate, Pepino Y Aguacate Con Salmón Al Horno, Aceite De Oliva",
                "Té De Menta, 2 Rebanadas De Pan Integral Tostado, Ajo Y Aceite De Oliva"));

        planMap.put("hipertensosSobrePeso", hipertensosSobrePeso);

        return planMap;
    }

}