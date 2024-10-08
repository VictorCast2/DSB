package com.DevSalud.DSB.Service;

import com.DevSalud.DSB.Exception.GeneralServiceException;
import com.DevSalud.DSB.Model.ExerciseLogModel;
import com.DevSalud.DSB.Repository.ExerciseLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseLogServices {

    @Autowired
    private ExerciseLogRepository exerciseLogRepository;

    /**
     * Método para obtener todos los registros de ejercicios.
     * @return Lista de registros de ejercicios.
     */
    public List<ExerciseLogModel> getAllExerciseLogs() {
        return exerciseLogRepository.findAll();
    }

    /**
     * Método para obtener un registro de ejercicio por ID.
     * @param id Identificador del registro de ejercicio.
     * @return Registro de ejercicio.
     */
    public Optional<ExerciseLogModel> getExerciseLogById(Long id) {
        return exerciseLogRepository.findById(id);
    }

    /**
     * Método para guardar un nuevo registro de ejercicio.
     * @param exerciseLogModel Registro de ejercicio a guardar.
     * @return Registro de ejercicio guardado.
     */
    public ExerciseLogModel saveExerciseLog(ExerciseLogModel exerciseLogModel) {
        return exerciseLogRepository.save(exerciseLogModel);
    }

    /**
     * Método para actualizar un registro de ejercicio existente.
     * @param id Identificador del registro de ejercicio.
     * @param updatedExerciseLog Registro de ejercicio actualizado.
     * @return Registro de ejercicio actualizado.
     */
    public ExerciseLogModel updateExerciseLog(Long id, ExerciseLogModel updatedExerciseLog) {
        return exerciseLogRepository.findById(id)
                .map(exerciseLog -> {
                    exerciseLog.setExerciseName(updatedExerciseLog.getExerciseName());
                    exerciseLog.setExerciseType(updatedExerciseLog.getExerciseType());
                    exerciseLog.setHours(updatedExerciseLog.getHours());
                    exerciseLog.setMinutes(updatedExerciseLog.getMinutes());
                    exerciseLog.setExerciseIntensity(updatedExerciseLog.getExerciseIntensity());
                    exerciseLog.setUser(updatedExerciseLog.getUser());
                    return exerciseLogRepository.save(exerciseLog);
                }).orElseThrow(() -> new GeneralServiceException("Registro de ejercicio no encontrado con id " + id));
    }

    /**
     * Método para eliminar un registro de ejercicio por ID.
     * @param id Identificador del registro de ejercicio.
     */
    public void deleteExerciseLog(Long id) {
        exerciseLogRepository.deleteById(id);
    }
}