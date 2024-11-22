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

    /**
     * Maneja el formulario de contacto en la página principal.
     * Recibe los datos del formulario y los guarda en la base de datos si el
     * usuario está autenticado.
     * Si el usuario no está autenticado, lo redirige a la página de inicio.
     * 
     * @param contactUsModel El modelo que contiene los datos del formulario de
     *                       contacto.
     * @param model          El modelo utilizado para pasar los datos a la vista.
     * @param session        La sesión HTTP para obtener el ID del usuario.
     * @return Redirige a la misma página o a la página de inicio dependiendo del
     *         estado de la sesión.
     */
    @PostMapping("/DSBConection")
    public String IndexPaginaPrincipal(@ModelAttribute("contact") ContactUsModel contactUsModel, Model model,
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