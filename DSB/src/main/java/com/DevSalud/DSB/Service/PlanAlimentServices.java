package com.DevSalud.DSB.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.DevSalud.DSB.Repository.PlanAlimentRepository;
import lombok.Data;

@Data
@Service
public class PlanAlimentServices {

    @Autowired
    private PlanAlimentRepository planAlimentRepository;

}