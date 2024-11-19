package com.DevSalud.DSB.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PlanAlimentController {

    @GetMapping("/TablaPlanesAlimenticios")
    public String recomendarPlanesAlimenticios(){
        return "PlanesAlimenticios";
    }


}