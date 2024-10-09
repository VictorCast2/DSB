package com.DevSalud.DSB.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaginaPrincipalController {

    @GetMapping({ "DSB", " " })
    public String paginaPrincipal() {
        return "indexPaginaPrincipal";
    }

}
