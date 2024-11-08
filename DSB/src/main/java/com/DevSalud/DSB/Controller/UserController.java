package com.DevSalud.DSB.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.DevSalud.DSB.Exception.NoDataFoundException;
import com.DevSalud.DSB.Model.UserModel;
import com.DevSalud.DSB.Service.UserServices;
import jakarta.servlet.http.HttpSession;
import lombok.Data;
import java.time.LocalDate;

@Data
@Controller
@RequestMapping(path = "/Api/Users")
public class UserController {

    // Variable Global de guardado del Usuario Id
    public Long UsuarioId;

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
     * 
     */
    @PostMapping("/Registro")
    public String registerUser(@ModelAttribute("Users") UserModel Users,
            RedirectAttributes redirect,
            BindingResult result,
            Model model,
            HttpSession session) {
        if (result.hasErrors()) {
            return "/Api/Users/Registro";
        }
        if (!Users.isTermsAccepted()) {
            model.addAttribute("Error", "Debes aceptar los términos y condiciones.");
            return "/Api/Users/Registro";
        }
        LocalDate DateOfBirth = Users.getDateBirthday();
        Integer calculatedAge = userService.calculateAge(DateOfBirth);
        System.out.println("Calculated Age: " + calculatedAge); // Imprime la edad calculada
        if (calculatedAge == null || calculatedAge < 0) {
            model.addAttribute("Error", "La fecha de nacimiento no es válida.");
            return "/Users/Registro";
        }
        Users.setAge(calculatedAge); // Calcula y asigna la edad

        userService.saveOrUpdateUser(Users); // Guarda el usuario con la edad calculada
        redirect.addFlashAttribute("msgExito", "El Usuario ha sido agregado con éxito");

        return "redirect:/DSBConection"; // Redirecciona a la página principal
    }

    /**
     * Muestra la página de olvido de contraseña.
     * 
     * @param model Modelo para la vista.
     * @return La vista de olvido de contraseña.
     */
    @GetMapping("/OlvidoContrasenna")
    public String OlvidoContrasenna(Model model) {
        model.addAttribute("error", null);
        model.addAttribute("message", null);
        return "Users/OlvidoContraseña"; // Asegúrate que la ruta es correcta
    }

    /**
     * 
     * @param username
     * @param newPassword
     * @param confirmPassword
     * @param model
     * @return
     */
    @PostMapping("/OlvidoContrasenna")
    public String manejarOlvidoContrasenna(@RequestParam("username") String username,
            @RequestParam("newPassword") String newPassword, @RequestParam("confirmPassword") String confirmPassword,
            Model model) {
        // Verificar que el nuevo password y confirmación coinciden
        if (!newPassword.equals(confirmPassword)) {
            model.addAttribute("error", "Las contraseñas no coinciden.");
            return "Users/OlvidoContraseña"; // Volver al formulario
        }
        // Obtener el usuario por nombre de usuario
        UserModel user = userService.findByUserOrEmail(username);
        if (user != null) {
            userService.resetPassword(user.getId(), newPassword); // Cambiar la contraseña
            model.addAttribute("message", "Contraseña cambiada con éxito.");
            return "redirect:/DSBSinConection";
        } else {
            model.addAttribute("error", "Usuario no encontrado.");
            return "/Api/Users/OlvidoContrasenna"; // Volver al formulario
        }
    }

    /**
     * Muestra la página de eliminación de usuario.
     * 
     * @return La vista de eliminación de usuario.
     */
    @GetMapping("/EliminarUsuario")
    public String mostrarEliminarUsuario(Model model) {
        model.addAttribute("user", new UserModel());
        return "Users/EliminarUsuario";
    }

    @PostMapping("/EliminarUsuario")
    public String manejarEliminarUsuario(@RequestParam("username") String username,
            @RequestParam("password") String password, @RequestParam("confirmPassword") String confirmPassword,
            Model model) {
        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "Las contraseñas no coinciden.");
            return "/Api/Users/EliminarUsuario"; // Regresa a la vista si hay error
        }
        UserModel user = userService.findByUserOrEmail(username);
        if (user != null && user.getPassword().equals(password)) {
            userService.deleteUserById(user.getId()); // Elimina el usuario
            return "redirect:/DSBSinConection";
        } else {
            model.addAttribute("error", "Usuario no encontrado o contraseña incorrecta.");
            return "/Api/Users/EliminarUsuario"; // Regresa a la vista si hay error
        }
    }

    /**
     * 
     * @param model
     * @return
     */
    @GetMapping("/Login")
    public String loginForm(Model model) {
        model.addAttribute("Users", new UserModel());
        return "Users/Login";
    }

    /**
     * 
     * @param UserOrEmail
     * @param Password
     * @param model
     * @return
     */
    @PostMapping("/Login")
    public String login(@RequestParam("UserOrEmail") String UserOrEmail,
            @RequestParam("Password") String Password,
            Model model, HttpSession session) {
        UserModel user = userService.findByUserOrEmail(UserOrEmail);
        if (user != null && user.getPassword().equals(Password)) {
            session.setAttribute("UsuarioId", user.getId()); // Almacena el ID del usuario en la sesión
            return "redirect:/DSBConection"; // Redirecciona a la página principal
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
        userService.saveOrUpdateUser(Users);
        redirect.addFlashAttribute("msgExito", "El Usuario ha sido actualizado con éxito");
        return "redirect:/Api/Users/Lista";
    }

}