package com.DevSalud.DSB.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
            throw new RuntimeException("Error al guardar el registro de alimento: " + e.getMessage());
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
                throw new RuntimeException("Error al actualizar el registro de alimento: " + e.getMessage());
            }
        } else {
            throw new RuntimeException("El registro de alimento no existe.");
        }
    }

    /**
     * Elimina un registro de alimentación por su ID.
     * @param id El ID del registro de alimentación a eliminar.
     */
    public void deleteAlimentLog(Long id) {
        try {
            alimentLogRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el registro de alimento: " + e.getMessage());
        }
    }

    /**
     * Obtiene los registros de alimentos de un usuario por su ID.
     * @param userId El ID del usuario.
     * @return Una lista de registros de alimentos.
     */
    public List<AlimentLogModel> getFoodLogsByUserId(Long userId) {
        return alimentLogRepository.findByUserId(userId);
    }

    // Método para obtener el alimento por su ID
    public AlimentLogModel getAlimentLogById(Long id) {
        Optional<AlimentLogModel> alimentLog = alimentLogRepository.findById(id);
        return alimentLog.orElse(null);  // Si no se encuentra el alimento, retorna null
    }
    
}