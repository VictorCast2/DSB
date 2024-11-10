package com.DevSalud.DSB.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DevSalud.DSB.Model.ExerciseLogModel;

@Repository
public interface PlanExerciseRepository extends JpaRepository<ExerciseLogModel, Long> {

}
