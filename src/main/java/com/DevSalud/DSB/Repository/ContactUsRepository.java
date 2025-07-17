package com.DevSalud.DSB.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.DevSalud.DSB.Model.ContactUsModel;

@Repository
public interface ContactUsRepository extends JpaRepository<ContactUsModel, Long> {
}