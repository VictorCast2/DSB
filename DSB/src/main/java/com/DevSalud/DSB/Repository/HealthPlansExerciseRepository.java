package com.DevSalud.DSB.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.DevSalud.DSB.Model.PlanExercisesModel;

@Repository
public interface HealthPlansExerciseRepository extends JpaRepository<PlanExercisesModel, Long> {
}