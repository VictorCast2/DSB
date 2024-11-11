package com.DevSalud.DSB.Model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "PlanExercises")
public class PlanExercisesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Esto indica que el ID se genera automáticamente
    private Long id;

    @Basic
    @NonNull
    private String Day;
    private String ExerciseName;
    private String ExerciseType;
    private String ExerciseIntensity;
    private String Disease;
    private String HealthClassification;
}