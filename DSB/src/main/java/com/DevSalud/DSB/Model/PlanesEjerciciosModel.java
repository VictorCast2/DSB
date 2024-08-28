package com.DevSalud.DSB.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "PlanesEjercicios") // Nombre de la tabla en MySQL
public class PlanesEjerciciosModel {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String TypeExercise;
    private String NameExercise;
    private String ExerciseIntensity;
    private Integer Day = LocalDate.now().getDayOfMonth();

}