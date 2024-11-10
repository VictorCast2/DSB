package com.DevSalud.DSB.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.DevSalud.DSB.Model.ExerciseLogModel;

@Repository
public interface ExerciseLogRepository extends JpaRepository<ExerciseLogModel, Long> {

    @Query("SELECT e FROM ExerciseLogModel e WHERE e.user.id = :userId")
    List<ExerciseLogModel> findByUserId(Long userId);
}

}
