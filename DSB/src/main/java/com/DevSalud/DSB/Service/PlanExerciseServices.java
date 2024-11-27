package com.DevSalud.DSB.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.DevSalud.DSB.Model.ExerciseLogModel;
import com.DevSalud.DSB.Repository.ExerciseLogRepository;
import com.DevSalud.DSB.Repository.PlanExerciseRepository;
import lombok.Data;

@Data
@Service
public class PlanExerciseServices {

    @Autowired
    private PlanExerciseRepository planExerciseRepository;

    @Autowired
    private ExerciseLogRepository exerciseLogRepository;

    /**
     * Verifica si el paciente ha realizado algún ejercicio no autorizado.
     * 
     * @param userId El ID del usuario.
     * @return true si el paciente ha realizado algún ejercicio no autorizado, false
     *         en caso contrario.
     */
    public boolean hasUnauthorizedExercises(Long userId, String Disease) {
        List<String> unauthorizedExercises;
        if (Disease == "Hipertension") {
            unauthorizedExercises = List.of("Aerobicos", "Fuerza", "Fortalecimiento"); // Lista de ejercicios 
        } else{
            unauthorizedExercises = List.of(""); // Todos los ejercicios son buenos para los diabeticos
        }
        List<ExerciseLogModel> exerciseLogs = exerciseLogRepository.findByUserId(userId);
        return exerciseLogs.stream().anyMatch(exerciseLog -> unauthorizedExercises.contains(exerciseLog.getExerciseName()));
    }

}