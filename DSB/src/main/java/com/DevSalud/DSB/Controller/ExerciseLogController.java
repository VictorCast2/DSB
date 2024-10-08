package com.DevSalud.DSB.Controller;

import com.DevSalud.DSB.Model.ExerciseLogModel;
import com.DevSalud.DSB.Service.ExerciseLogServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/Api/ExerciseLog")
public class ExerciseLogController {
    @Autowired
    private ExerciseLogServices exerciseLogService;

    /**
     * Endpoint para obtener todos los registros de ejercicios.
     * @return Lista de registros de ejercicios.
     */
    @GetMapping
    public List<ExerciseLogModel> getAllExerciseLogs() {
        return exerciseLogService.getAllExerciseLogs();
    }

    /**
     * Endpoint para obtener un registro de ejercicio por ID.
     * @param id Identificador del registro de ejercicio.
     * @return Registro de ejercicio.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ExerciseLogModel> getExerciseLogById(@PathVariable Long id) {
        return exerciseLogService.getExerciseLogById(id)
                .map(exerciseLog -> ResponseEntity.ok().body(exerciseLog))
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Endpoint para crear un nuevo registro de ejercicio.
     * @param exerciseLogModel Registro de ejercicio a crear.
     * @return Registro de ejercicio creado.
     */
    @PostMapping
    public ExerciseLogModel createExerciseLog(@RequestBody ExerciseLogModel exerciseLogModel) {
        return exerciseLogService.saveExerciseLog(exerciseLogModel);
    }

    /**
     * Endpoint para actualizar un registro de ejercicio existente.
     * @param id Identificador del registro de ejercicio.
     * @param exerciseLogModel Registro de ejercicio actualizado.
     * @return Registro de ejercicio actualizado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ExerciseLogModel> updateExerciseLog(@PathVariable Long id, @RequestBody ExerciseLogModel exerciseLogModel) {
        return ResponseEntity.ok(exerciseLogService.updateExerciseLog(id, exerciseLogModel));
    }

    /**
     * Endpoint para eliminar un registro de ejercicio por ID.
     * @param id Identificador del registro de ejercicio.
     * @return Respuesta de éxito o fallo.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExerciseLog(@PathVariable Long id) {
        exerciseLogService.deleteExerciseLog(id);
        return ResponseEntity.noContent().build();
    }

}