package com.DevSalud.DSB.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DevSalud.DSB.Model.StatusHealthModel;
import com.DevSalud.DSB.Repository.StatusHealthRepository;

@Service
public class StatusHealthServices {

    @Autowired
    private StatusHealthRepository statusHealthRepository;

    /**
     * Obtiene todas las entradas de StatusHealth.
     *
     * @return una lista de todas las entradas de StatusHealth.
     */
    public List<StatusHealthModel> getAllStatusHealth() {
        return statusHealthRepository.findAll();
    }

    /**
     * Obtiene una entrada de StatusHealth por su ID.
     *
     * @param id el ID de la entrada de StatusHealth.
     * @return un Optional que contiene la entrada de StatusHealth si existe, o
     *         vacío si no.
     */
    public Optional<StatusHealthModel> getStatusHealthById(Long id) {
        return statusHealthRepository.findById(id);
    }

    /**
     * Guarda o actualiza una entrada de StatusHealth.
     *
     * @param statusHealthModel el modelo de StatusHealth a guardar o actualizar.
     * @return el modelo de StatusHealth guardado o actualizado.
     */
    public StatusHealthModel saveOrUpdateStatusHealth(StatusHealthModel statusHealthModel) {
        return statusHealthRepository.save(statusHealthModel);
    }

    /**
     * Elimina una entrada de StatusHealth por su ID.
     *
     * @param id el ID de la entrada de StatusHealth a eliminar.
     */
    public void deleteStatusHealth(Long id) {
        statusHealthRepository.deleteById(id);
    }

}