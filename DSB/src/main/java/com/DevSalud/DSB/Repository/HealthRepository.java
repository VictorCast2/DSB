package com.DevSalud.DSB.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.DevSalud.DSB.Model.UserModel;

@Repository
public interface HealthRepository extends JpaRepository<UserModel, Long> {
}