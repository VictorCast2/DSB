package com.DevSalud.DSB.Controller;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.DevSalud.DSB.Model.*;
import com.DevSalud.DSB.Service.*;
import com.fasterxml.jackson.databind.*;
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
        private ResourceLoader resourceLoader;

        @GetMapping("/RegistroAlimento")
        public String formularioRegistroAlimento(Model model) {
                model.addAttribute("alimentLog", new AlimentLogModel());
                model.addAttribute("allCategoriaFood", loadFoodCategories("Comida"));
                model.addAttribute("allCategoriaAliments", loadFoodCategories("CategoriaAlimentos"));
                model.addAttribute("allNameAliments", loadAliments());
                return "/Food/FormularioRegistroAlimento";
        }

        @PostMapping("/RegistroAlimento")
        public String createAlimentLog(HttpSession session, Model model,
                        @ModelAttribute AlimentLogModel alimentLog) {
                Long userId = (Long) session.getAttribute("UsuarioId");
                if (userId != null) {
                        UserModel user = userService.getUserById(userId);
                        if (user != null) {
                                alimentLog.setUser(user);
                                alimentLogService.saveAlimentLog(alimentLog);
                                return "redirect:/Api/Users/Food/Home";
                        }
                }
                model.addAttribute("error", "Usuario no encontrado.");
                return "redirect:/Api/Users/Login";
        }

        private List<String> loadFoodCategories(String categoryKey) {
                Resource resource = resourceLoader.getResource("classpath:/static/Json/Alimentos.json");
                try (InputStream inputStream = resource.getInputStream()) {
                        ObjectMapper mapper = new ObjectMapper();
                        JsonNode root = mapper.readTree(inputStream);
                        JsonNode categoriesNode = root.path(categoryKey);
                        return StreamSupport.stream(categoriesNode.spliterator(), false)
                                        .map(JsonNode::asText)
                                        .collect(Collectors.toList());
                } catch (IOException e) {
                        throw new RuntimeException("Error al cargar categorías de alimentos: " + e.getMessage());
                }
        }

        private Map<String, List<String>> loadAliments() {
                Resource resource = resourceLoader.getResource("classpath:/static/Json/Alimentos.json");
                try (InputStream inputStream = resource.getInputStream()) {
                        ObjectMapper mapper = new ObjectMapper();
                        JsonNode root = mapper.readTree(inputStream);
                        JsonNode alimentsNode = root.path("Alimentos");
                        Map<String, List<String>> aliments = new HashMap<>();
                        alimentsNode.fields().forEachRemaining(entry -> {
                                List<String> items = StreamSupport.stream(entry.getValue().spliterator(), false)
                                                .map(JsonNode::asText)
                                                .collect(Collectors.toList());
                                aliments.put(entry.getKey(), items);
                        });
                        return aliments;
                } catch (IOException e) {
                        throw new RuntimeException("Error al cargar alimentos: " + e.getMessage());
                }
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