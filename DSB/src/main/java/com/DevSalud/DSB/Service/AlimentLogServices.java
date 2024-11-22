package com.DevSalud.DSB.Service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.DevSalud.DSB.Exception.*;
import com.DevSalud.DSB.Model.AlimentLogModel;
import com.DevSalud.DSB.Repository.AlimentLogRepository;
import lombok.Data;

@Data
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
            throw new GeneralServiceException("Error al guardar el registro de alimento: " + e.getMessage(), e);
        }
    }

    /**
     * Actualiza un registro de alimentación existente.
     * @param alimentLog El registro de alimentación a actualizar.
     * @return El registro de alimentación actualizado.
     */
    public AlimentLogModel updateAlimentLog(AlimentLogModel alimentLog) {
        if (alimentLogRepository.existsById(alimentLog.getId())) {
            try {
                return alimentLogRepository.save(alimentLog);
            } catch (Exception e) {
                throw new GeneralServiceException("Error al actualizar el registro de alimento: " + e.getMessage(), e);
            }
        } else {
            throw new NoDataFoundException("El registro de alimento no existe.");
        }
    }

    /**
     * Elimina un registro de alimentación por su ID.
     * @param id El ID del registro de alimentación a eliminar.
     */
    public void deleteAlimentLog(Long id) {
        try {
            if (alimentLogRepository.existsById(id)) {
                alimentLogRepository.deleteById(id);
            } else {
                throw new NoDataFoundException("El registro de alimento no existe.");
            }
        } catch (Exception e) {
            throw new GeneralServiceException("Error al eliminar el registro de alimento: " + e.getMessage(), e);
        }
    }

    /**
     * Obtiene los registros de alimentos de un usuario por su ID.
     * @param userId El ID del usuario.
     * @return Una lista de registros de alimentos.
     */
    public List<AlimentLogModel> getFoodLogsByUserId(Long userId) {
        try {
            List<AlimentLogModel> logs = alimentLogRepository.findByUserId(userId);
            if (logs.isEmpty()) {
                throw new NoDataFoundException("No se encontraron registros de alimentos para el usuario con ID: " + userId);
            }
            return logs;
        } catch (Exception e) {
            throw new GeneralServiceException("Error al obtener los registros de alimentos: " + e.getMessage(), e);
        }
    }

    // Método para obtener el alimento por su ID
    public AlimentLogModel getAlimentLogById(Long id) {
        try {
            Optional<AlimentLogModel> alimentLog = alimentLogRepository.findById(id);
            return alimentLog.orElseThrow(() -> new NoDataFoundException("No se encontró el registro de alimento con ID: " + id));
        } catch (Exception e) {
            throw new GeneralServiceException("Error al obtener el registro de alimento: " + e.getMessage(), e);
        }
    }
    
}