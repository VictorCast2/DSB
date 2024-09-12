package com.Developper.DSB.Controller;

import com.Developper.DSB.Service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/Users")
public class UserController {

    @Autowired
    private UserServices userService;

    @GetMapping("/Registro")
    public String registro() {
        return "Registro";
    }

    @GetMapping("/OlvidoContraseña")
    public String olvidoContraseña() {
        return "OlvidoContraseña";
    }

    @GetMapping("/EliminarContraseña")
    public String eliminarContraseña() {
        return "EliminarContraseña";
    }

    @GetMapping("/EscribaContraseña")
    public String escribaContraseña() {
        return "EscribaContraseña";
    }

    @GetMapping("/Login")
    public String login() {
        return "Login";
    }
}