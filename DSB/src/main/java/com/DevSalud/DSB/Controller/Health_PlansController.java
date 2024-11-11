package com.DevSalud.DSB.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.DevSalud.DSB.Model.PlanExercisesModel;
import com.DevSalud.DSB.Model.UserModel;
import com.DevSalud.DSB.Service.HealthPlansExerciseService;
import com.DevSalud.DSB.Service.UserServices;
import jakarta.servlet.http.HttpSession;
import lombok.Data;

@Data
@Controller
@RequestMapping(path = "/Api/Users/Health_Plans")
public class Health_PlansController {

    @Autowired
    private UserServices userService;

    @Autowired
    private HealthPlansExerciseService healthPlansExerciseService;

    @GetMapping("/PlanEjercicio")
    public String mostrarPlanEjercicio(Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("UsuarioId");
        if (userId != null) {
            UserModel user = userService.getUserById(userId);
            healthPlansExerciseService.ejecutarPlanEjercicio();
            if (user != null) {
                String disease = user.getDisease();
                String healthClassification = user.getHealthClassification();
                List<PlanExercisesModel> exercisePlans = healthPlansExerciseService.obtenerPlanesEjercicio(disease,
                        healthClassification);
                model.addAttribute("exercisePlans", exercisePlans);
                return "/Health_Plans/Exercises/PlanesEjercicio";
            }
        }
        model.addAttribute("error", "Usuario no encontrado.");
        return "redirect:/Api/Users/Login";
    }

    @GetMapping("/PlanAlimenticio")
    public String mostrarPlanAlimenticio() {
        return "/Health_Plans/Food/PlanesAlimenticios";
    }

    @PostMapping("/PlanAlimenticio")
    public String planAlimenticio() {
        return "/Health_Plans/Food/PlanesAlimenticios";
    }

}