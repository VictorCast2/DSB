package com.DevSalud.DSB.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.DevSalud.DSB.Exception.ValidateServiceException;
import com.DevSalud.DSB.Model.ContactUsModel;
import com.DevSalud.DSB.Repository.ContactUsRepository;
import lombok.Data;

@Data
@Service
public class ContactUsServices {
    @Autowired
    private ContactUsRepository contactUsRepository;

    /**
 * Guarda un nuevo contacto en la base de datos.
 * 
 * Este método recibe un objeto `ContactUsModel`, que contiene la información
 * del contacto,
 * y lo guarda en la base de datos usando el repositorio `contactUsRepository`.
 * 
 * @param contactUsModel El objeto que contiene la información del contacto a
 *                       guardar.
 */
public void saveContact(ContactUsModel contactUsModel) {
    try {
        contactUsRepository.save(contactUsModel);
    } catch (Exception e) {
        throw new ValidateServiceException("Error al guardar el contacto: " + e.getMessage(), e);
    }
}

}