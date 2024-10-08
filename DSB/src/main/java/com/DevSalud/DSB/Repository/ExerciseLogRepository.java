package com.DevSalud.DSB.Repository;

import com.DevSalud.DSB.Model.ExerciseLogModel;
import com.DevSalud.DSB.Model.StatusHealthModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseLogRepository extends JpaRepository<ExerciseLogModel, Long> {
}