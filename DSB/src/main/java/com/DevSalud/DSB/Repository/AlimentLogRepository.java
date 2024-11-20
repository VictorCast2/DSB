package com.DevSalud.DSB.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.DevSalud.DSB.Model.AlimentLogModel;

@Repository
public interface AlimentLogRepository extends JpaRepository<AlimentLogModel, Long> {
    List<AlimentLogModel> findByUserId(Long userId);
}