package com.DevSalud.DSB.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.DevSalud.DSB.Exception.NoDataFoundException;
import com.DevSalud.DSB.Model.UserModel;
import com.DevSalud.DSB.Service.UserServices;

@Controller
@RequestMapping(path = "/Api/Users")
public class UserController {

    @Autowired
    private UserServices userService;

    /**
     * Muestra la página de registro.
     * 
     * @return La vista de registro.
     */
    @GetMapping("/Registro")
    public String showRegistrationForm(Model model) {
        model.addAttribute("Users", new UserModel());
        return "/Users/Registro";
    }

    /**
     * Procesa el registro de un usuario.
     * 
     * @param model El modelo para la vista.
     * @return La vista de redirección.
     */
    @PostMapping("/Registro")
    public String registerUser(@ModelAttribute("Users") UserModel Users, RedirectAttributes redirect,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/Users/Registro";
        }
        if (!Users.isTermsAccepted()) {
            model.addAttribute("Error", "Debes aceptar los términos y condiciones.");
            return "/Users/Registro";
        }
        userService.saveOrUpdateUsers(Users);
        redirect.addFlashAttribute("msgExito", "El Usuario ha sido agregado con éxito");
        return "redirect:/";
    }

    /**
     * Muestra la página de olvido de contraseña.
     * 
     * @return La vista de olvido de contraseña.
     */
    @GetMapping("/OlvidoContraseña")
    public String OlvidoContraseña() {
        return "/Users/OlvidoContraseña";
    }

    /**
     * Muestra la página de eliminación de contraseña.
     * 
     * @return La vista de eliminación de contraseña.
     */
    @GetMapping("/EliminarContraseña")
    public String EliminarContraseña() {
        return "/Users/EliminarContraseña";
    }

    /**
     * Muestra la página para escribir una nueva contraseña.
     * 
     * @return La vista para escribir una nueva contraseña.
     */
    @GetMapping("/EscribaContraseña")
    public String EscribaContraseña() {
        return "/Users/EscribaContraseña";
    }

    @GetMapping("/Login")
    public String Login(Model model) {
        model.addAttribute("Users", new UserModel());
        return "Users/Login";
    }

    @PostMapping("/Api/Users/Login")
    public String login(@RequestParam String usernameOrEmail, @RequestParam String password, Model model) {
        UserModel user = userService.findByUserOrEmail(usernameOrEmail);
        if (user != null && user.getPassword().equals(password)) {
            return "/User/InicioSeccion";
        } else {
            model.addAttribute("error", "Credenciales incorrectas");
            return "Users/Login"; // Regresa a la vista de login si las credenciales son incorrectas
        }
    }

    /**
     * Muestra la lista de usuarios.
     * 
     * @param modelo El modelo para la vista.
     * @return La vista de lista de usuarios.
     */
    @GetMapping("/Lista")
    public String ListaUsuarios(Model modelo) {
        try {
            modelo.addAttribute("Usuarios", userService.getAllUsers());
        } catch (NoDataFoundException e) {
            modelo.addAttribute("Error", e.getMessage());
        }
        return "/Users/Lista";
    }

    /**
     * Muestra la página de edición de un usuario.
     * 
     * @param id     El ID del usuario.
     * @param modelo El modelo para la vista.
     * @return La vista de edición de usuario.
     */
    @GetMapping("/Editar/{id}")
    public String EditarUsuario(@PathVariable Long id, Model modelo) {
        try {
            UserModel usuario = userService.getUserById(id);
            modelo.addAttribute("Usuario", usuario);
            return "/Users/Editar";
        } catch (NoDataFoundException e) {
            return "redirect:/Api/Users/Lista";
        }
    }

    /**
     * Actualiza un usuario.
     * 
     * @param Users         El modelo de usuario.
     * @param bindingResult Resultado de la validación.
     * @param redirect      Atributos de redirección.
     * @param modelo        El modelo para la vista.
     * @return La vista de redirección.
     */
    @PostMapping("/Actualizar")
    public String ActualizarUsuario(@Validated @ModelAttribute("Usuario") UserModel Users, BindingResult bindingResult,
            RedirectAttributes redirect, Model modelo) {
        if (bindingResult.hasErrors()) {
            modelo.addAttribute("Usuario", Users);
            return "Editar";
        }
        userService.saveOrUpdateUsers(Users);
        redirect.addFlashAttribute("msgExito", "El Usuario ha sido actualizado con éxito");
        return "redirect:/Api/Users/Lista";
    }

    /**
     * Elimina un usuario por su ID.
     * 
     * @param id       El ID del usuario.
     * @param redirect Atributos de redirección.
     * @return La vista de redirección.
     */
    @GetMapping("/Eliminar/{id}")
    public String EliminarUsuario(@PathVariable Long id, RedirectAttributes redirect) {
        try {
            userService.deleteUserById(id);
            redirect.addFlashAttribute("msgExito", "El Usuario ha sido eliminado con éxito");
        } catch (NoDataFoundException e) {
            redirect.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/Api/Users/Lista";
    }

}