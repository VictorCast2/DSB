package com.DevSalud.DSB.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.DevSalud.DSB.Model.PlanExercisesModel;
import com.DevSalud.DSB.Repository.PlanExerciseRepository;
import lombok.Data;

@Service
@Data
public class PlanExerciseServices {

    @Autowired
    private final PlanExerciseRepository planExerciseRepository;

    // Método para obtener todos los planes de ejercicio
    public List<PlanExercisesModel> getAllPlans() {
        return planExerciseRepository.findAll();
    }

    // Método para guardar un nuevo plan de ejercicio
    public PlanExercisesModel savePlan(PlanExercisesModel plan) {
        return planExerciseRepository.save(plan);
    }

}