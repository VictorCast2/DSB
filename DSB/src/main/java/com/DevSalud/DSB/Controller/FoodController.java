package com.DevSalud.DSB.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/Api/Users/Food")
public class FoodController {

    @ModelAttribute("allCategoriaDesayuno")
    public List<String> categoriaDelDesayuno() {
        return Arrays.asList(
            "Proteinas", "Frutas", "Verduras", "Granos", 
            "Productos Lacteos", "Azucares", "Grasas Saturadas", 
            "Harinas", "Carbohidratos"
        );
    }

    @ModelAttribute("allCategoriaAlmuerzo")
    public List<String> categoriaDelAlmuerzo() {
        return Arrays.asList(
            "Proteinas", "Verduras", "Granos", "Productos Lacteos", 
            "Azucares", "Grasas Saturadas", "Harinas", "Carbohidratos"
        );
    }

    @ModelAttribute("allCategoriaCena")
    public List<String> categoriaDeLaCena() {
        return Arrays.asList(
            "Proteinas", "Frutas", "Verduras", "Granos", 
            "Productos Lacteos", "Azucares", "Grasas Saturadas", 
            "Harinas", "Carbohidratos"
        );
    }

    @GetMapping("/RegistroAlimento")
    public String formularioRegistroAlimento() {
        return "/Food/FormularioRegistroAlimento";
    }

    @GetMapping("/Home")
    public String homeRegistroAlimento() {
        return "/Food/HomeRegistroAlimento";
    }

    @GetMapping("/EditarAlimento")
    public String formularioEditarAlimento() {
        return "/Food/FormularioEditarAlimento";
    }

    @GetMapping("/TablaAlimento")
    public String TablaRegistroAlimento() {
        return "/Food/TablaRegistroAlimento";
    }

}