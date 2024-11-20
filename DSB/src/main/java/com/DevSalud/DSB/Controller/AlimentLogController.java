package com.DevSalud.DSB.Controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.DevSalud.DSB.Model.*;
import com.DevSalud.DSB.Repository.AlimentLogRepository;
import com.DevSalud.DSB.Service.*;
import jakarta.servlet.http.HttpSession;
import lombok.Data;

@Data
@Controller
@RequestMapping(path = "/Api/Users/Food")
public class AlimentLogController {

    @Autowired
    private UserServices userService;

    @Autowired
    private AlimentLogServices alimentLogService;

    @Autowired
    private AlimentLogRepository alimentLogRepository;

    @ModelAttribute("allCategoriaFood")
    public List<String> comidas() {
        return getComidas();
    }

    @ModelAttribute("allCategoriaAliments")
    public List<String> categoriaComida() {
        return getCategorias();
    }

    @ModelAttribute("allNameAliments")
    public Map<String, List<String>> nombresComidas() {
        return getComidasPorCategoria();
    }

    private List<String> getComidas() {
        return Arrays.asList(
                "Desayuno", "Almuerzo", "Cena");
    }

    private List<String> getCategorias() {
        return Arrays.asList(
                "Proteinas", "Frutas", "Verduras", "Granos",
                "Productos Lacteos", "Azucares", "Grasas Saturadas",
                "Harinas", "Carbohidratos");
    }

    private Map<String, List<String>> getComidasPorCategoria() {
        Map<String, List<String>> comidas = new HashMap<>();
        comidas.put("Proteinas", Arrays.asList(
                "Pollo", "Carnes Rojas", "Huevo", "Camarones",
                "Albondigas", "Pechuga", "Chicharron", "Empanadas",
                "Tacos", "Pescado", "Queso", "Cerdo",
                "Salchicha", "Jamon", "Mortadela", "Panceta",
                "Chorizo", "Butifarra", "Yogur", "Leche"));
        comidas.put("Frutas", Arrays.asList(
                "Piña", "Arándanos", "Uvas", "Manzanas",
                "Peras", "Mango", "Fresas", "Sandía",
                "Naranjas", "Plátanos", "Kiwi", "Melocotones", "Guayaba"));
        comidas.put("Verduras", Arrays.asList(
                "Cebolla", "Tomate", "Pimentón", "Espinaca",
                "Cilantro", "Ajo", "Berenjena", "Zanahorias",
                "Lechuga", "Repollo", "Maíz", "Ñame", "Papa",
                "Yuca", "Patata", "Plátano Verde", "Plátano Amarillo"));
        comidas.put("Productos Lacteos", Arrays.asList(
                "Leche Condensada", "Leche Entera", "Leche Descremada",
                "Leche Deslactosada", "Queso Con Sal", "Queso Sin Sal",
                "Mantequilla Con Sal", "Mantequilla Sin Sal",
                "Yogur Natural", "Suero", "Crema De Leche"));
        comidas.put("Azucares", Arrays.asList(
                "Panela", "Jugo De Naranja Con Azucar",
                "Jugo De Piña Con Azucar", "Jugo De Mango Con Azucar",
                "Jugo De Guanábana Con Azucar", "Jugo De Mora Con Azucar",
                "Jugo De Maracuyá Con Azucar", "Jugo De Lulo Con Azucar",
                "Jugo De Tomate De Árbol Con Azúcar", "Jugos Mixtos",
                "Chocolate Caliente", "Pan Dulce", "Bollos Dulces",
                "Yogur Con Azucar", "Café Con Azucar", "Té Con Azucar"));
        comidas.put("Grasas Saturadas", Arrays.asList(
                "Arepas Fritas", "Empanadas Fritas", "Churros",
                "Chicharrón", "Patacón", "Huevo Frito",
                "Chorizo Frito", "Buñuelos", "Carimañolas",
                "Bollos Fritos", "Morcilla Frita", "Papas Fritas",
                "Queso Frito", "Tajaditas", "Salchichón Frito"));
        comidas.put("Harinas", Arrays.asList(
                "Arroz", "Arepas", "Buñuelos", "Pan De Queso",
                "Torta De Maíz", "Torta De Choclo", "Pandebono De Queso",
                "Pan De Sal", "Pan Integral", "Pan De Leche",
                "Pan Blanco", "Empanadas", "Tostadas",
                "Pancakes", "Waffles"));
        comidas.put("Granos", Arrays.asList(
                "Avena", "Pasta", "Yuca",
                "Mazamorra", "Arvejas", "Lentejas",
                "Tostadas de trigo integral", "Yogur con avena y frutos secos",
                "Leche con avena", "Smoothie de frutas y avena", "Cereal integral con leche o frutas"));
        comidas.put("Carbohidratos", Arrays.asList(
                "Pasta", "Pan", "Harinas",
                "Tubérculos", "Maíz", "Galletas",
                "Cereal", "Frutas secas"));
        return comidas;
    }

    @GetMapping("/RegistroYEditarAlimento")
    public String formularioRegistroAlimento(Model model) {
        model.addAttribute("alimentLog", new AlimentLogModel());
        return "/Food/FormularioRegistroAlimento";
    }

    @PostMapping("/RegistroYEditarAlimento")
    public String createOrUpdateAlimentLog(HttpSession session, Model model,
            @ModelAttribute AlimentLogModel alimentLog) {
        Long userId = (Long) session.getAttribute("UsuarioId");
        if (userId != null) {
            UserModel user = userService.getUserById(userId);
            if (user != null) {
                alimentLog.setUser(user);
                if (alimentLog.getId() != null) {
                    // Si el ID no es nulo, estamos actualizando
                    alimentLogService.updateAlimentLog(alimentLog);
                } else {
                    // Si el ID es nulo, estamos creando
                    alimentLogService.saveAlimentLog(alimentLog);
                }
                return "redirect:/Api/Users/Food/TablaAlimento";
            }
        }
        model.addAttribute("error", "Usuario no encontrado.");
        return "redirect:/Api/Users/Login";
    }

    @GetMapping("/Home")
    public String homeRegistroAlimento() {
        return "/Food/HomeRegistroAlimento";
    }

    @GetMapping("/EliminarAlimento/{id}")
    public String eliminarAlimento(@PathVariable Long id, Model model) {
        AlimentLogModel alimentLog = alimentLogService.getAlimentLogById(id);
        if (alimentLog != null) {
            alimentLogService.deleteAlimentLog(id); // Método en el servicio para eliminar
            return "redirect:/Api/Users/Food/TablaAlimento"; // Redirige a la tabla después de eliminar
        } else {
            model.addAttribute("error", "Alimento no encontrado.");
            return "redirect:/Api/Users/Food/TablaAlimento"; // Redirige si no se encuentra el alimento
        }
    }

    @GetMapping("/EditarAlimento/{id}")
    public String editarAlimento(@PathVariable Long id, Model model) {
        AlimentLogModel alimentLog = alimentLogService.getAlimentLogById(id);
        if (alimentLog != null) {
            model.addAttribute("alimentLog", alimentLog);
            return "/Food/FormularioRegistroAlimento"; // La vista para editar
        } else {
            model.addAttribute("error", "Alimento no encontrado.");
            return "redirect:/Api/Users/Food/TablaAlimento"; // Redirige si no se encuentra el alimento
        }
    }

    @GetMapping("/TablaAlimento")
    public String tableFoodLog(Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("UsuarioId");
        if (userId != null) {
            List<AlimentLogModel> foodLogs = alimentLogRepository.findAll();
            model.addAttribute("foodLogs", foodLogs);
            return "Food/TablaRegistroAlimento";
             // Asegúrate que esta sea la ruta correcta de tu template HTML
        } else {
            model.addAttribute("error", "Usuario no encontrado.");
            return "redirect:/Api/Users/Login";
        }
    }

}