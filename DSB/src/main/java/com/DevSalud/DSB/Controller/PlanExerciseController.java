package com.DevSalud.DSB.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.DevSalud.DSB.Service.UserServices;
import lombok.Data;

@Data
@Controller
@RequestMapping("/Api/Users/Exercises")
public class PlanExerciseController{

        @Autowired
        private UserServices userService;
        
}