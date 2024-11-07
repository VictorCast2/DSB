package com.DevSalud.DSB.Controller;

import java.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @ModelAttribute("allNameComidaDesayuno")
    public Map<String, List<String>> nombreDeLasComida() {
        Map<String, List<String>> comida = new HashMap<>();

        comida.put("Proteinas", Arrays.asList(
                "Pollo", "Carnes Rojas", "Huevo",
                "Camarones", "Albondigas", "Pechuga",
                "Chicharron", "Empanadas", "Tacos", "Carne",
                "Pescado", "Queso", "Cerdo", "Pechuga", "Salchicha",
                "Jamon", "Mortadela", "Panceta", "Chorizo", "Butifarra",
                "Yogur", "Leche", "Barras de merienda", "Avena"));

        comida.put("Frutas", Arrays.asList(
                "Piña", "Arándanos", "Uvas",
                "Manzanas", "Peras", "Mango",
                "Fresas", "Sandía", "Naranjas",
                "Plátanos", "Kiwi", "Melocotones", "Guayaba"));

        comida.put("Verduras", Arrays.asList(
                "Cebolla", "Tomate", "Pimentón",
                "Espinaca", "Cilantro", "Ajo",
                "Berenjena", "Zanahorias", "Lechuga",
                "Repollo", "Maíz", "Ñame",
                "Papa", "Yuca", "Patata", "Plátano Verde", "Plátano Amarillo"));

        comida.put("Lacteos", Arrays.asList(
                "Leche Condensada", "Leche Entera", "Leche Descremada",
                "Leche Deslactosada", "Queso Con Sal", "Queso Sin Sal",
                "Mantequilla Con Sal", "Mantequilla Sin Sal",
                "Yogur Natural", "Suero", "Crema De Leche", "Jugo De Milo", "Jugo De Chocolisto"));

        comida.put("Azucares", Arrays.asList(
                "Panela", "Barras de merienda", "Jugo De Milo",
                "Jugo De Chocolisto", "Chicha de arroz",
                "Jugo De Naranja Con Azucar", "Jugo De Piña Con Azucar",
                "Jugo De Mango Con Azucar", "Jugo De Guanábana Con Azucar",
                "Jugo De Mora Con Azucar", "Jugo De Maracuyá Con Azucar",
                "Jugo De Lulo Con Azucar", "Jugo De Tomate De Árbol Con Azúcar",
                "Jugos Mixtos (combinaciones de frutas)", "Chocolate Caliente", "Pan Dulce", "Bollos Dulces",
                "Yogur Con Azucar", "Café Con Azucar", "Té Con Azucar"));

        comida.put("Grasas Saturadas", Arrays.asList(
                "Arepas Fritas", "Empanadas Fritas", "Churros",
                "Chicharrón", "Patacón", "Huevo Frito",
                "Chorizo Frito", "Buñuelos", "Carimañolas",
                "Bollos Fritos", "Morcilla Frita", "Papas Fritas",
                "Queso Frito", "Tajaditas", "Salchichón Frito"));

        comida.put("Harinas", Arrays.asList(
                "Arroz", "Arepas", "Buñuelos", "Pan De Queso",
                "Torta De Maíz", "Torta De Choclo", "Pandebono De Queso",
                "Pan De Sal", "Pan Integral", "Pan De Leche",
                "Pan Blanco", "Empanadas", "Papa",
                "Tostadas", "Pancakes", "Waffles"));

        comida.put("Granos", Arrays.asList(
                "Avena", "Arepas", "Arroz", "Pasta",
                "Yuca", "Mazamorra", "Arvejas", "Lentejas",
                "Tostadas de trigo integral", "Yogur con avena y frutos secos",
                "Leche con avena", "Smoothie de frutas y avena",
                "Cereal integral con leche o frutas"));

        return comida;
    }

    @ModelAttribute("allNameComidaAlmuerzo")
    public Map<String, List<String>> nombreDeLasComidaAlmuerzo() {
        Map<String, List<String>> comida = new HashMap<>();

        comida.put("Proteinas", Arrays.asList(
                "Pollo", "Carnes Rojas", "Huevo", "Camarones",
                "Albondigas", "Pechuga", "Chicharron", "Empanadas",
                "Tacos", "Carnes", "Pescado", "Queso",
                "Cerdo", "Salchicha", "Jamon", "Mortadela",
                "Panceta", "Chorizo", "Butifarra", "Yogur",
                "Leche", "Barras de Merienda", "Pato",
                "Pavo", "Conejo", "Pulpo", "Cangrejo",
                "Calamar", "Codillo"));

        comida.put("Verduras", Arrays.asList(
                "Cebolla", "Tomate", "Pepino", "Remolacha",
                "Cebollin", "Berenjena", "Pimenton", "Espinaca",
                "Cilantro", "Ajo", "Zanahorias", "Lechuga",
                "Repollo", "Maiz", "Ñame", "Papa",
                "Yuca", "Patata", "Plátano Verde", "Plátano Amarillo"));

        comida.put("Granos", Arrays.asList(
                "Lenteja", "Frijoles", "Garbanzo", "Alvejas",
                "Guisante", "Arroz"));

        comida.put("Lacteos", Arrays.asList(
                "Leche Entera", "Leche Descremada", "Leche Deslactosada",
                "Queso Con Sal", "Queso Sin Sal", "Jugo De Milo", "Suero"));

        comida.put("Azucares", Arrays.asList(
                "Panela", "Barras de merienda", "Jugo De Milo",
                "Jugo De Chocolisto", "Chicha de arroz",
                "Jugo De Naranja Con Azúcar", "Jugo De Piña Con Azúcar",
                "Jugo De Mango Con Azúcar", "Jugo De Guanábana Con Azúcar",
                "Jugo De Mora Con Azúcar", "Jugo De Maracuyá Con Azúcar",
                "Jugo De Lulo Con Azúcar", "Jugo De Tomate De Árbol Con Azúcar",
                "Jugos Mixtos (combinaciones de frutas)", "Chocolate Caliente", "Pan Dulce", "Bollos Dulces",
                "Yogur Con Azúcar", "Café Con Azúcar", "Helado",
                "Postre 3 leches", "Dulces o candies", "Té Con Azúcar"));

        comida.put("Grasas Saturadas", Arrays.asList(
                "Arepas Fritas", "Empanadas Fritas", "Churros",
                "Chicharrón", "Tajaditas", "Patacón",
                "Pollo Frito", "Pescado Frito", "Pechuga Frita",
                "Carne Frita", "Cerdo Frito", "Pavo Frito",
                "Pato Frito", "Pulpo Frito", "Conejo Frito",
                "Huevo Frito", "Chorizo Frito", "Buñuelos",
                "Carimañolas", "Bollos Fritos", "Morcilla Frita",
                "Papas Fritas", "Queso Frito", "Salchichón Frito",
                "Comida Rápida"));

        comida.put("Harinas", Arrays.asList(
                "Arepas", "Arroz", "Buñuelos", "Pan De Queso",
                "Pan De Sal", "Pan Integral", "Pan De Leche",
                "Pan Blanco", "Lasaña", "Pandebono",
                "Pan de Yuca", "Carimañolas", "Churros",
                "Espaguetis", "Empanadas"));

        comida.put("Cabohidratos", Arrays.asList(
                "Avena", "Arepas", "Arroz", "Pasta",
                "Yuca", "Mazamorra", "Arvejas", "Lentejas",
                "Sopas", "Tostadas de trigo integral",
                "Yogur con avena y frutos secos", "Leche con avena",
                "Smoothie de frutas y avena", "Cereal integral con leche o frutas"));

        return comida;
    }

    @ModelAttribute("allNameComidaCena")
    public Map<String, List<String>> nombreDeLasComidaCena() {
        Map<String, List<String>> comida = new HashMap<>();

        comida.put("Proteinas", Arrays.asList(
                "Pollo", "Carnes Rojas", "Huevo", "Camarones",
                "Albóndigas", "Pechuga", "Chicharrón", "Empanadas",
                "Tacos", "Carnes", "Pescado", "Queso",
                "Cerdo", "Salchicha", "Jamon", "Mortadela",
                "Panceta", "Chorizo", "Butifarra", "Yogur",
                "Leche", "Barras de Merienda", "Pato",
                "Pavo", "Conejo", "Pulpo", "Cangrejo",
                "Calamar", "Codillo"));

        comida.put("Verduras", Arrays.asList(
                "Cebolla", "Tomate", "Pepino", "Remolacha",
                "Cebollín", "Berenjena", "Pimentón", "Espinaca",
                "Cilantro", "Ajo", "Zanahorias", "Lechuga",
                "Repollo", "Maíz", "Ñame", "Papa",
                "Yuca", "Patata", "Plátano Verde", "Plátano Amarillo"));

        comida.put("Granos", Arrays.asList(
                "Lenteja", "Frijoles", "Garbanzo", "Alverjas",
                "Guisante", "Arroz"));

        comida.put("Lacteos", Arrays.asList(
                "Leche Entera", "Leche Descremada", "Leche Deslactosada",
                "Queso Con Sal", "Queso Sin Sal", "Jugo De Milo", "Suero"));

        comida.put("Azucares", Arrays.asList(
                "Panela", "Barras de merienda", "Jugo De Milo",
                "Jugo De Chocolisto", "Chicha de arroz",
                "Jugo De Naranja Con Azúcar", "Jugo De Piña Con Azúcar",
                "Jugo De Mango Con Azúcar", "Jugo De Guanábana Con Azúcar",
                "Jugo De Mora Con Azúcar", "Jugo De Maracuyá Con Azúcar",
                "Jugo De Lulo Con Azúcar", "Jugo De Tomate De Árbol Con Azúcar",
                "Jugos Mixtos (combinaciones de frutas) Con Azúcar",
                "Chocolate Caliente", "Pan Dulce", "Bollos Dulces",
                "Yogur Con Azúcar", "Café Con Azúcar", "Helado",
                "Postre 3 leches", "Dulces o candies", "Té Con Azúcar"));

        comida.put("Grasas Saturadas", Arrays.asList(
                "Arepas Fritas", "Empanadas Fritas", "Churros",
                "Chicharrón", "Tajaditas", "Patacón",
                "Pollo Frito", "Pescado Frito", "Pechuga Frita",
                "Carne Frita", "Cerdo Frito", "Pavo Frito",
                "Pato Frito", "Pulpo Frito", "Conejo Frito",
                "Huevo Frito", "Chorizo Frito", "Buñuelos",
                "Carimañolas", "Bollos Fritos", "Morcilla Frita",
                "Papas Fritas", "Queso Frito", "Salchichón Frito",
                "Comida Rápida"));

        comida.put("Harinas", Arrays.asList(
                "Arepas", "Arroz", "Buñuelos", "Pan De Queso",
                "Pan De Sal", "Pan Integral", "Pan De Leche",
                "Pan Blanco", "Lasaña", "Pandebono",
                "Pan de Yuca", "Carimañolas", "Churros",
                "Espaguetis", "Empanadas"));

        comida.put("Frutas", Arrays.asList(
                "Piña", "Arándanos", "Uvas", "Manzanas",
                "Peras", "Mango", "Fresas", "Sandía",
                "Naranjas", "Plátanos", "Kiwi",
                "Melocotones", "Guayaba"));

        comida.put("Carbohidratos", Arrays.asList(
                "Avena", "Arepas", "Arroz", "Pasta",
                "Yuca", "Mazamorra", "Arvejas", "Lentejas",
                "Sopas", "Tostadas de trigo integral",
                "Yogur con avena y frutos secos", "Leche con avena",
                "Smoothie de frutas y avena",
                "Cereal integral con leche o frutas"));

        return comida;
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