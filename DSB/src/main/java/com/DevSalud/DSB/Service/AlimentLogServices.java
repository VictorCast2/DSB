package com.DevSalud.DSB.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DevSalud.DSB.Model.AlimentLogModel;
import com.DevSalud.DSB.Repository.AlimentLogRepository;

@Service
public class AlimentLogServices {

    @Autowired
    private AlimentLogRepository alimentLogRepository;

    /**
     * Guarda un nuevo registro de alimentación.
     * @param alimentLog El registro de alimentación a guardar.
     * @return El registro de alimentación guardado con su ID generado.
     */
    public AlimentLogModel saveAlimentLog(AlimentLogModel alimentLog) {
        try {
            return alimentLogRepository.save(alimentLog);
        } catch (Exception e) {
            // Manejo de errores, puedes personalizar el manejo
            throw new RuntimeException("Error al guardar el registro de alimento: " + e.getMessage());
        }
    }

}