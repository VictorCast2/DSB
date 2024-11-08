package com.DevSalud.DSB.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DevSalud.DSB.Model.ExerciseLogModel;
import com.DevSalud.DSB.Repository.ExerciseLogRepository;

@Service
public class ExerciseLogServices {

    @Autowired
    private ExerciseLogRepository exerciseLogRepository;

    public void saveExerciseLog(ExerciseLogModel exerciseLog) {
        exerciseLogRepository.save(exerciseLog);
    }

}