package com.DevSalud.DSB.Controller;

import java.time.format.DateTimeFormatter;
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

    /**
     * Muestra el estado de salud del usuario.
     * Obtiene el usuario desde la sesión, recupera sus datos, y los pasa a la
     * vista.
     * 
     * @param model   El modelo utilizado para pasar los datos a la vista.
     * @param session La sesión HTTP para obtener el ID del usuario.
     * @return El nombre de la vista que muestra el estado de salud del usuario.
     */
    @GetMapping(" ")
    public String estadoSalud(Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("UsuarioId"); // Obtén el ID del usuario desde la sesión
        System.out.println("Id:" + userId);
        if (userId != null) {
            UserModel usuario = userService.getUserById(userId); // Obtenemos el usuario con el ID
            // Formateamos la fecha de nacimiento del usuario
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String formattedDate = usuario.getDateBirthday().format(formatter);
            // Pasamos el usuario y la fecha formateada a la vista
            model.addAttribute("usuario", usuario);
            model.addAttribute("formattedDate", formattedDate);
        } else {
            model.addAttribute("error", "Usuario no encontrado.");
            return "redirect:/Api/Users/Login"; // Redirige a la página de login si no hay usuario
        }
        return "/Health_Status/EstadoSalud"; // Devolvemos la vista con los datos
    }

}