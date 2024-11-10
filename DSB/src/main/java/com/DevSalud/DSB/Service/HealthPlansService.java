package com.DevSalud.DSB.Service;

import java.nio.file.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class HealthPlansService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Método para ejecutar las queries desde el HealthPlansExercises.sql
    public void ejecutarPlanEjercicio() {
        try {
            // Cargar el archivo SQL desde resources
            String path = getClass().getClassLoader().getResource("HealthPlansExercises.sql").getPath();
            String sql = new String(Files.readAllBytes(Paths.get(path)));

            // Ejecutar el script SQL
            List<String> queries = List.of(sql.split(";")); // Asumimos que cada query está separada por un ";"
            for (String query : queries) {
                if (!query.trim().isEmpty()) {
                    jdbcTemplate.execute(query.trim());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();  // Manejar errores de manera adecuada
        }
    }
    
}