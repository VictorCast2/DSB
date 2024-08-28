package com.DevSalud.DSB.Repository;

import com.DevSalud.DSB.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    // Métodos adicionales personalizados si es necesario
}