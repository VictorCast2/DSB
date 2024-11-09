package com.DevSalud.DSB.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.DevSalud.DSB.Model.UserModel;
import com.DevSalud.DSB.Service.*;
import jakarta.servlet.http.HttpSession;
import lombok.Data;

@Data
@Controller
@RequestMapping("/Api/Users/Health")
public class HealthController {

    @Autowired
    private UserServices userService;

    @Autowired
    private final HealthService healthService;

    @GetMapping({" "})
    public String estadoSalud(Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("UsuarioId"); // Obtén el ID del usuario desde la sesión
        System.out.println("Id:" + userId);
        if (userId != null) {
            UserModel usuario = userService.getUserById(userId); // Obtenemos el usuario con el ID
            model.addAttribute("usuario", usuario);
        } else {
            model.addAttribute("error", "Usuario no encontrado.");
            return "redirect:/Api/Users/Login"; // Redirige a la página de login si no hay usuario
        }
        return "/Health_Status/EstadoSalud";
    }

}