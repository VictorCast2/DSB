package com.DevSalud.DSB.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DevSalud.DSB.Model.ExerciseLogModel;
import com.DevSalud.DSB.Repository.ExerciseLogRepository;

@Service
public class PlanExerciseService {

    @Autowired
    private ExerciseLogRepository exerciseLogRepository;

    public List<ExerciseLogModel> getAllExercise() {
        return exerciseLogRepository.findAll();
    }

    public ExerciseLogModel getExerciseById(Long id) {
        return exerciseLogRepository.findById(id).orElse(null);
    }

    public ExerciseLogModel saveExercise(ExerciseLogModel exerciseLog) {
        return exerciseLogRepository.save(exerciseLog);
    }

    public void deleteExercise(Long id) {
        exerciseLogRepository.deleteById(id);
    }

}
