package com.DevSalud.DSB.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.DevSalud.DSB.Model.PlanExerciseModel;

@Repository
public interface PlanExerciseRepository extends JpaRepository<PlanExerciseModel, Long> {
}