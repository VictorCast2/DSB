package com.DevSalud.DSB.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DevSalud.DSB.Repository.ExerciseLogRepository;

@Service
public class ExerciseLogService {

    @Autowired
    private ExerciseLogRepository exerciseLogRepository;

}