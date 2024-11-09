package com.DevSalud.DSB.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.DevSalud.DSB.Model.AlimentLogModel;
import com.DevSalud.DSB.Repository.AlimentLogRepository;

@Service
public class AlimentLogServices {

    @Autowired
    private AlimentLogRepository alimentLogRepository;

    public void saveAlimentLog(AlimentLogModel alimentLog) {
        alimentLogRepository.save(alimentLog);
    }

}
