package com.DevSalud.DSB.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.DevSalud.DSB.Model.PlanAlimentModel;

@Repository
public interface PlanAlimentRepository extends JpaRepository<PlanAlimentModel, Long> {
}