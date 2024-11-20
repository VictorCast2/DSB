package com.DevSalud.DSB.Controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.DevSalud.DSB.Model.UserModel;
import com.DevSalud.DSB.Service.*;
import com.google.gson.*;
import jakarta.servlet.http.HttpSession;
import lombok.Data;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.*;

@Data
@Controller
@RequestMapping(path = "/Api/Users")
public class UserController {

    @Autowired
    private UserServices userService;

    @Autowired
    private HealthServices healthService;

    @Autowired
    private ResourceLoader resourceLoader;

    /**
     * Muestra la página de registro.
     */
    @GetMapping("/Registro")
    public String showRegistration(Model model) {
        try {
            // Cargar el archivo JSON desde la carpeta resources
            Resource resource = resourceLoader.getResource("classpath:/static/Json/Registro.json");
            String content = new String(Files.readAllBytes(resource.getFile().toPath()));
            // Parsear el JSON usando Gson
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(content, JsonObject.class);
            // Extraer los valores de los arrays "Sexo" y "Enfermedad"
            JsonArray sexoArray = jsonObject.getAsJsonArray("Sexo");
            JsonArray enfermedadArray = jsonObject.getAsJsonArray("Enfermedad");
            // Convertir las opciones a listas simples de cadenas sin comillas
            List<String> sexoOptions = new ArrayList<>();
            List<String> enfermedadOptions = new ArrayList<>();
            // Llenar las listas con los valores del JSON
            for (JsonElement sexo : sexoArray) {
                sexoOptions.add(sexo.getAsString()); // Obtener el valor como cadena
            }
            for (JsonElement enfermedad : enfermedadArray) {
                enfermedadOptions.add(enfermedad.getAsString()); // Obtener el valor como cadena
            }
            // Pasar las opciones al modelo
            model.addAttribute("sexoOptions", sexoOptions);
            model.addAttribute("enfermedadOptions", enfermedadOptions);
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("jsonData", "Error leyendo el archivo JSON: " + e.getMessage());
        }
        // Agregar el modelo para el registro de usuario
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
    public String registerUser(@ModelAttribute("Users") UserModel Users, RedirectAttributes redirect, BindingResult result, Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("UsuarioId");
        if (userId == null) {
            if (result.hasErrors()) {
                return "/Api/Users/Registro";
            }
            // Verificar si el usuario ha aceptado los términos y condiciones
            if (!Users.isTermsAccepted()) {
                model.addAttribute("Error", "Debes aceptar los términos y condiciones.");
                return "/Api/Users/Registro";
            }
            // Verificar la edad del usuario
            LocalDate DateOfBirth = Users.getDateBirthday();
            Integer calculatedAge = userService.calculateAge(DateOfBirth);
            Double masaCorporal = healthService.calculateIMC(Users.getWeight(), Users.getHeight());
            System.out.println("Calculated Age: " + calculatedAge); // Imprime la edad calculada
            if (calculatedAge == null || calculatedAge <= 16) {
                model.addAttribute("Error", "La fecha de nacimiento no es válida.");
                return "/Api/Users/Registro";
            }
            // Asignar los valores calculados a las propiedades del usuario
            Users.setAge(calculatedAge);
            Users.setBodyMass(masaCorporal);
            Users.setHealthClassification(healthService.classifyIMC(masaCorporal));
            // Encriptar la contraseña antes de guardar
            String hashedPassword = BCrypt.hashpw(Users.getPassword(), BCrypt.gensalt()); // Encriptar la contraseña
            Users.setPassword(hashedPassword); // Guardar la contraseña encriptada
            // Guardar el usuario con la contraseña encriptada
            userService.saveOrUpdateUser(Users);
            // Agregar un mensaje de éxito y redirigir al usuario
            redirect.addFlashAttribute("msgExito", "El Usuario ha sido agregado con éxito");
            session.setAttribute("UsuarioId", null);
            return "redirect:/"; // Redirige a la página principal
        } else {
            return "redirect:/DSBConection"; // Si el usuario ya está logueado, redirigir a otra página
        }
    }

    /**
     * Muestra la página de olvido de contraseña.
     * 
     * @param model Modelo para la vista.
     * @return La vista de olvido de contraseña.
     */
    @GetMapping("/OlvidoContrasenna")
    public String OlvidoContrasenna(Model model) {
        return "Users/OlvidoContraseña";
    }

    /**
     * 
     * @param username
     * @param newPassword
     * @param confirmPassword
     * @param model
     * @param session
     * @return
     */
    @PostMapping("/OlvidoContrasenna")
    public String manejarOlvidoContrasenna(@RequestParam("username") String username,
            @RequestParam("newPassword") String newPassword, @RequestParam("confirmPassword") String confirmPassword,
            Model model, HttpSession session) {
        // Verificar que el nuevo password y confirmación coinciden
        if (!newPassword.equals(confirmPassword)) {
            model.addAttribute("error", "Las contraseñas no coinciden.");
            return "Users/OlvidoContraseña"; // Volver al formulario
        }

        // Obtener el usuario por nombre de usuario
        UserModel user = userService.findByUserOrEmail(username);
        if (user != null) {
            // Encriptar la nueva contraseña antes de guardarla
            String EncryptPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt());
            userService.resetPassword(user.getId(), EncryptPassword);
            model.addAttribute("message", "Contraseña cambiada con éxito.");
            session.setAttribute("UsuarioId", null);
            return "redirect:/";
        } else {
            model.addAttribute("error", "Usuario no encontrado.");
            return "Users/OlvidoContraseña"; // Volver al formulario
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
            Model model, HttpSession session) {
        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "Las contraseñas no coinciden.");
            return "Users/EliminarUsuario"; // Regresa a la vista si hay error
        }

        UserModel user = userService.findByUserOrEmail(username);
        if (user != null && BCrypt.checkpw(password, user.getPassword())) {
            userService.deleteUserById(user.getId()); // Elimina el usuario
            session.setAttribute("UsuarioId", null);
            return "redirect:/";
        } else {
            model.addAttribute("error", "Usuario no encontrado o contraseña incorrecta.");
            return "Users/EliminarUsuario"; // Regresa a la vista si hay error
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
     * Método para manejar el login con bcrypt.
     * 
     * @param UserOrEmail Correo electrónico o nombre de usuario.
     * @param Password    Contraseña ingresada.
     * @param model       Modelo para pasar datos a la vista.
     * @param session     Sesión del usuario.
     * @return Redirección a la página principal si las credenciales son correctas,
     *         o el formulario de login si no lo son.
     */
    @PostMapping("/Login")
    public String login(@RequestParam("UserOrEmail") String UserOrEmail,
            @RequestParam("Password") String Password,
            Model model, HttpSession session) {

        // Encuentra el usuario por correo electrónico o nombre de usuario
        UserModel user = userService.findByUserOrEmail(UserOrEmail);

        // Si el usuario existe, comparamos las contraseñas usando bcrypt
        if (user != null) {
            // Compara la contraseña ingresada con la contraseña encriptada almacenada
            if (BCrypt.checkpw(Password, user.getPassword())) {
                session.setAttribute("UsuarioId", user.getId()); // Almacena el ID del usuario en la sesión
                return "redirect:/DSBConection"; // Redirige a la página principal
            }
        }
        // Si las credenciales son incorrectas, muestra un mensaje de error
        model.addAttribute("error", "Credenciales incorrectas");
        return "Users/Login"; // Regresa a la vista de login si las credenciales son incorrectas
    }


    @GetMapping("/Editar")
    public String editarUsuario(Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("UsuarioId");
        if (userId != null) {
            UserModel usuario = userService.getUserById(userId);
            model.addAttribute("Users", usuario);

            // Agregar las opciones para enfermedades crónicas y sexo desde el JSON
            try {
                Resource resource = resourceLoader.getResource("classpath:/static/Json/Registro.json");
                String content = new String(Files.readAllBytes(resource.getFile().toPath()));
                Gson gson = new Gson();
                JsonObject jsonObject = gson.fromJson(content, JsonObject.class);
                JsonArray sexoArray = jsonObject.getAsJsonArray("Sexo");
                JsonArray enfermedadArray = jsonObject.getAsJsonArray("Enfermedad");

                List<String> sexoOptions = new ArrayList<>();
                List<String> enfermedadOptions = new ArrayList<>();

                for (JsonElement sexo : sexoArray) {
                    sexoOptions.add(sexo.getAsString());
                }
                for (JsonElement enfermedad : enfermedadArray) {
                    enfermedadOptions.add(enfermedad.getAsString());
                }

                model.addAttribute("sexoOptions", sexoOptions);
                model.addAttribute("enfermedadOptions", enfermedadOptions);
            } catch (IOException e) {
                e.printStackTrace();
                model.addAttribute("jsonData", "Error leyendo el archivo JSON: " + e.getMessage());
            }

            return "/Users/Editar";
        } else {
            return "Users/Login";
        }
    }

    @PostMapping("/Editar")
    public String actualizarUsuario(@Validated @ModelAttribute("Users") UserModel Users, BindingResult bindingResult,
                                    RedirectAttributes redirect, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("Users", Users);
            return "Users/Editar";
        }
        userService.saveOrUpdateUser(Users);
        redirect.addFlashAttribute("msgExito", "El usuario ha sido actualizado con éxito");
        return "redirect:/DSBConection";
    }

}