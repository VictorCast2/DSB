package com.DevSalud.DSB.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.DevSalud.DSB.Model.ContactUsModel;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

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

}