package com.DevSalud.DSB.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.DevSalud.DSB.Model.MenuOfTheDayModel;

@Repository
public interface MenuOfTheDayRepository extends JpaRepository<MenuOfTheDayModel, Long> {
}