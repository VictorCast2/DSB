package com.DevSalud.DSB.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.DevSalud.DSB.Model.UserModel;
import com.DevSalud.DSB.Service.HealthService;

@Controller
@RequestMapping("/Api/Users/Health/")
public class HealthController {

    @Autowired
    private final HealthService healthService;

    public HealthController(HealthService healthService) {
        this.healthService = healthService;
    }

    @GetMapping("/healthUsers")
    public List<UserModel> getAllUsers() {
        return healthService.getAllUsers();
    }

}