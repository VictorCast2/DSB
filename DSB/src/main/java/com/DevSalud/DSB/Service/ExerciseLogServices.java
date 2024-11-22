package com.DevSalud.DSB.Service;

import java.util.*;
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

    /**
     * Guarda un nuevo registro de ejercicio en la base de datos.
     * 
     * Este método recibe un objeto `ExerciseLogModel` que contiene la información
     * del registro
     * de ejercicio y lo guarda en la base de datos usando el repositorio
     * `exerciseLogRepository`.
     * 
     * @param exerciseLog El objeto que contiene la información del registro de
     *                    ejercicio a guardar.
     */
    public void saveExerciseLog(ExerciseLogModel exerciseLog) {
        exerciseLogRepository.save(exerciseLog);
    }

    /**
     * Obtiene todos los registros de ejercicio almacenados en la base de datos.
     * 
     * Este método devuelve una lista de todos los registros de ejercicio
     * existentes.
     * 
     * @return Una lista de todos los registros de ejercicio.
     */
    public List<ExerciseLogModel> getAllExerciseLogs() {
        return exerciseLogRepository.findAll();
    }

    /**
     * Actualiza un registro de ejercicio existente en la base de datos.
     * 
     * Este método recibe un objeto `ExerciseLogModel` con los datos actualizados y
     * los aplica a un registro de ejercicio existente en la base de datos.
     * Si el registro existe, se actualiza y guarda de nuevo.
     * 
     * @param updatedExerciseLog El objeto que contiene los nuevos datos del
     *                           registro de ejercicio.
     * @return El registro de ejercicio actualizado, o null si no se encuentra el
     *         registro.
     */
    public ExerciseLogModel UpdateExerciseLog(ExerciseLogModel updatedExerciseLog) {
        Optional<ExerciseLogModel> existingExerciseLog = exerciseLogRepository.findById(updatedExerciseLog.getId());
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

    /**
     * Obtiene un registro de ejercicio por su ID.
     * 
     * Este método busca un registro de ejercicio en la base de datos utilizando su
     * ID
     * y lo retorna si se encuentra. Si no se encuentra, retorna null.
     * 
     * @param id El ID del registro de ejercicio que se desea obtener.
     * @return El registro de ejercicio encontrado, o null si no se encuentra.
     */
    public ExerciseLogModel getExerciseLogById(Long id) {
        return exerciseLogRepository.findById(id).orElse(null);
    }

    /**
     * Elimina un registro de ejercicio de la base de datos.
     * 
     * Este método elimina un registro de ejercicio utilizando su ID.
     * 
     * @param id El ID del registro de ejercicio a eliminar.
     */
    public void DeleteExerciseLog(Long id) {
        exerciseLogRepository.deleteById(id);
    }

    /**
     * Obtiene todos los registros de ejercicio de un usuario específico.
     * 
     * Este método busca y retorna todos los registros de ejercicio asociados a un
     * usuario específico utilizando el ID del usuario.
     * 
     * @param userId El ID del usuario cuyos registros de ejercicio se desean
     *               obtener.
     * @return Una lista de los registros de ejercicio del usuario.
     */
    public List<ExerciseLogModel> getExerciseLogsByUserId(Long userId) {
        return exerciseLogRepository.findByUserId(userId);
    }

}