package com.DevSalud.DSB.Service;

import java.io.File;
import java.net.URL;
import java.nio.file.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.DevSalud.DSB.Model.PlanExercisesModel;
import com.DevSalud.DSB.Repository.HealthPlansExerciseRepository;

@Service
public class HealthPlansExerciseService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private HealthPlansExerciseRepository planEjercicioRepository;

    // Método para obtener los planes de ejercicio desde la base de datos
    @SuppressWarnings("deprecation")
    public List<PlanExercisesModel> obtenerPlanesEjercicio(String disease, String healthClassification) {
        // Consulta SQL para obtener los planes de ejercicio filtrados por enfermedad y
        // clasificación de salud
        String sql = "SELECT * FROM plans_exercises WHERE Disease = ? AND HealthClassification = ?";

        // Ejecutar la consulta y mapear el resultado a objetos de tipo
        // PlanExercisesModel
        return jdbcTemplate.query(sql, new Object[] { disease, healthClassification }, (rs, rowNum) -> {
            // Crear un nuevo objeto PlanExercisesModel y asignar los valores de la consulta
            PlanExercisesModel plan = new PlanExercisesModel();
            plan.setDay(rs.getString("Day"));
            plan.setExerciseName(rs.getString("ExerciseName"));
            plan.setExerciseType(rs.getString("ExerciseType"));
            plan.setExerciseIntensity(rs.getString("ExerciseIntensity"));
            plan.setDisease(rs.getString("Disease"));
            plan.setHealthClassification(rs.getString("HealthClassification"));
            return plan;
        });
    }

    // Método para ejecutar el script SQL
    public void ejecutarPlanEjercicio() {
        try {
            // Obtener el recurso como URL
            URL resource = getClass().getClassLoader().getResource("HealthPlansExercises.sql");
            
            if (resource == null) {
                throw new IllegalArgumentException("Archivo no encontrado: HealthPlansExercises.sql");
            }
    
            // Convertir la URL a un archivo y leerlo
            File file = new File(resource.toURI());
            String sql = new String(Files.readAllBytes(file.toPath()));
    
            // Ejecutar las consultas
            List<String> queries = List.of(sql.split(";"));
            for (String query : queries) {
                if (!query.trim().isEmpty()) {
                    jdbcTemplate.execute(query.trim());
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // Manejo adecuado de errores, usa un logger en producción
        }
    }

    // Obtener planes de ejercicio por enfermedad y clasificación de salud
    public List<PlanExercisesModel> obtenerPlanesEjercicios(String disease, String healthClassification) {
        return planEjercicioRepository.findAll().stream()
                .filter(plan -> plan.getDisease().equals(disease)
                        && plan.getHealthClassification().equals(healthClassification))
                .toList(); // Devuelve una lista filtrada
    }

    // Método para obtener todos los planes
    public List<PlanExercisesModel> obtenerTodosLosPlanes() {
        return planEjercicioRepository.findAll();
    }

}