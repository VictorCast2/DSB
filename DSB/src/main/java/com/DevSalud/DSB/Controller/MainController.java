package com.DevSalud.DSB.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.DevSalud.DSB.Model.*;
import com.DevSalud.DSB.Service.*;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

    @Autowired
    private ContactUsServices contactUsServices;

    @Autowired
    private UserServices userService;

    /**
     * Maneja las solicitudes GET para las rutas raíz (" "), "/", y
     * "/DSBSinConection".
     * 
     * @return La vista "Index".
     */
    @GetMapping({ " ", "/", "/DSBSinConection" })
    public String Index(HttpSession session) {
        session.setAttribute("UsuarioId", null);
        return "Index";
    }

    /**
     * Maneja las solicitudes GET para la ruta "/DSBConection".
     *
     * @return La vista "IndexPaginaPrincipal".
     */
    @GetMapping("/DSBConection")
    public String IndexPaginaPrincipal(Model model) {
        model.addAttribute("contact", new ContactUsModel());
        return "IndexPaginaPrincipal";
    }

    @PostMapping("/DSBConection")
    public String IndexPost(@ModelAttribute("contact") ContactUsModel contactUsModel, Model model,
            HttpSession session) {
        Long userId = (Long) session.getAttribute("UsuarioId");
        if (userId != null) {
            UserModel user = userService.getUserById(userId);
            contactUsModel.setUser(user);
            contactUsServices.saveContact(contactUsModel);
            return "redirect:/DSBConection";
        } else {
            return "redirect:/";
        }
    }

}