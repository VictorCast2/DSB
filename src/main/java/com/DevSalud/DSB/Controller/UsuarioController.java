package com.DevSalud.DSB.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.DevSalud.DSB.Model.UsuarioModel;
import com.DevSalud.DSB.Services.UsuarioServices;

@RequestMapping(path =  "/api/Users")
@Controller
public class UsuarioController {

    @Autowired
    private UsuarioServices  usuarioServices;

    //*Metodo que retornara el html registro */
    @GetMapping("/regitroUsuario")
    public String  regitroUsuario(Model model){
        model.addAttribute("usuario", new UsuarioModel());
        return "Registro";
    }

    //*Metodo que guarda a un usuario */
    @PostMapping("/guardarUsuario")
    public String guardarUsuario(UsuarioModel usuariomodel){
        usuarioServices.guardarUsuarios(usuariomodel);
        return  "redirect:/api/Users/regitroUsuario";

    }



}
