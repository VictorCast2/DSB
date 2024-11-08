package com.DevSalud.DSB.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DevSalud.DSB.Model.UserModel;
import com.DevSalud.DSB.Repository.HealthRepository;

@Service
public class HealthService {

    @Autowired
    private final HealthRepository healthRepository;

    public HealthService(HealthRepository healthRepository) {
        this.healthRepository = healthRepository;
    }

    public List<UserModel> getAllUsers() {
        return healthRepository.findAll();
    }

}
