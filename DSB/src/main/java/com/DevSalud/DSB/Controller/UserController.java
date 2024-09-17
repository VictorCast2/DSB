package com.DevSalud.DSB.Controller;

import com.DevSalud.DSB.Service.UserServices;
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
    public String Registro() {
        return "Registro";
    }

    @GetMapping("/OlvidoContraseña")
    public String OlvidoContraseña() {
        return "OlvidoContraseña";
    }

    @GetMapping("/EliminarContraseña")
    public String EliminarContraseña() {
        return "EliminarContraseña";
    }

    @GetMapping("/EscribaContraseña")
    public String EscribaContraseña() {
        return "EscribaContraseña";
    }

    @GetMapping("/Login")
    public String Login() {
        return "Login";
    }

}