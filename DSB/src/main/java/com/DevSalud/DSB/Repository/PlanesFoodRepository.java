package com.DevSalud.DSB.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DevSalud.DSB.Model.PlanesFoodModel;

@Repository
public interface PlanesFoodRepository extends JpaRepository <PlanesFoodModel,Long> {

}
