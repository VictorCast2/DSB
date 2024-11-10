package com.DevSalud.DSB.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.DevSalud.DSB.Model.ExerciseLogModel;
import com.DevSalud.DSB.Repository.ExerciseLogRepository;
import lombok.Data;

@Data
@Service
public class ExerciseLogServices {

    @Autowired
    private ExerciseLogRepository exerciseLogRepository;

    public void saveExerciseLog(ExerciseLogModel exerciseLog) {
        exerciseLogRepository.save(exerciseLog);
    }

    public List<ExerciseLogModel> getAllExerciseLogs() {
        return exerciseLogRepository.findAll();
    }

    public ExerciseLogModel UpdateExerciseLog(Long id, ExerciseLogModel updatedExerciseLog) {
        Optional<ExerciseLogModel> existingExerciseLog = exerciseLogRepository.findById(id);
        if (existingExerciseLog.isPresent()) {
            ExerciseLogModel exerciseLog = existingExerciseLog.get();
            exerciseLog.setExerciseName(updatedExerciseLog.getExerciseName());
            exerciseLog.setExerciseType(updatedExerciseLog.getExerciseType());
            exerciseLog.setStrartDate(updatedExerciseLog.getStrartDate());
            exerciseLog.setFinalDate(updatedExerciseLog.getFinalDate());
            exerciseLog.setExerciseIntensity(updatedExerciseLog.getExerciseIntensity());
            return exerciseLogRepository.save(exerciseLog);
        } else {
            return null;
        }
    }

    public ExerciseLogModel getExerciseLogById(Long id) {
        return exerciseLogRepository.findById(id).orElse(null);
    }

    public void DeleteExerciseLog(Long id) {
        exerciseLogRepository.deleteById(id);
    }

}