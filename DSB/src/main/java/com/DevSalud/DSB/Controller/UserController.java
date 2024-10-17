package com.DevSalud.DSB.Controller;

import com.DevSalud.DSB.Model.UserModel;
import com.DevSalud.DSB.Service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(path = "/Api/Users")
public class UserController {

    @Autowired
    private UserServices userService;

    @GetMapping("/Registro")
    public String registro(Model model) {
        model.addAttribute("Usuario", new UserModel());
        return "/Users/Registro";
    }

    @PostMapping("/Registro")
    public String registrarUser(@Validated @ModelAttribute("Usuario") UserModel user, BindingResult bindingResult, RedirectAttributes redirect, Model model) {
        if (bindingResult.hasErrors() || !user.isTermsAccepted()) {
            model.addAttribute("Usuario", user);
            if (!user.isTermsAccepted()) {
                model.addAttribute("termsError", "Debes aceptar los términos y condiciones.");
            }
            return "/Users/Registro";
        }
        userService.saveUsers(user);
        redirect.addFlashAttribute("msgExito", "El Usuario ha sido agregado con éxito");
        return "redirect:/";
    }

    @GetMapping("/OlvidoContraseña")
    public String OlvidoContraseña() {
        return "/Users/OlvidoContraseña";
    }

    @GetMapping("/EliminarContraseña")
    public String EliminarContraseña() {
        return "/Users/EliminarContraseña";
    }

    @GetMapping("/EscribaContraseña")
    public String EscribaContraseña() {
        return "/Users/EscribaContraseña";
    }

    @GetMapping("/Login")
    public String Login() {
        return "/Users/Login";
    }

    @GetMapping("/Lista")
    public String ListaUsuarios(Model modelo) {
        modelo.addAttribute("Usuarios", userService.getAllUsers());
        return "/Users/Lista";
    }

    @GetMapping("/Editar/{id}")
    public String EditarUsuario(@PathVariable Long id, Model modelo) {
        UserModel usuario = userService.getUserById(id);
        if (usuario != null) {
            modelo.addAttribute("Usuario", usuario);
            return "/Users/Editar";
        } else {
            return "redirect:/Api/Users/Lista";
        }
    }

    @PostMapping("/Actualizar")
    public String ActualizarUsuario(@Validated @ModelAttribute("Usuario") UserModel Users, BindingResult bindingResult, RedirectAttributes redirect, Model modelo) {
        if (bindingResult.hasErrors()) {
            modelo.addAttribute("Usuario", Users);
            return "Editar";
        }
        userService.saveUsers(Users);
        redirect.addFlashAttribute("msgExito", "El Usuario ha sido actualizado con éxito");
        return "redirect:/Api/Users/Lista";
    }

    @GetMapping("/Eliminar/{id}")
    public String EliminarUsuario(@PathVariable Long id, RedirectAttributes redirect) {
        userService.deleteUserById(id);
        redirect.addFlashAttribute("msgExito", "El Usuario ha sido eliminado con éxito");
        return "redirect:/Api/Users/Lista";
    }

}