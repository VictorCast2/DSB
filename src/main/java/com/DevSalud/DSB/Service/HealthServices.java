package com.DevSalud.DSB.Service;

import java.util.List;
import java.lang.Math;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.DevSalud.DSB.Exception.*;
import com.DevSalud.DSB.Model.UserModel;
import com.DevSalud.DSB.Repository.HealthRepository;
import lombok.Data;

@Data
@Service
public class HealthServices {

    @Autowired
    private final HealthRepository healthRepository;

    /**
     * Obtiene todos los usuarios de la base de datos.
     * 
     * Este método devuelve una lista de todos los usuarios almacenados en la base
     * de datos.
     * 
     * @return Una lista con todos los usuarios.
     */
    public List<UserModel> getAllUsers() {
        try {
            return healthRepository.findAll();
        } catch (Exception e) {
            throw new GeneralServiceException("Error al obtener todos los usuarios: " + e.getMessage(), e);
        }
    }

    /**
     * Calcula el IMC.
     *
     * @param Weight El peso.
     * @param Height La altura.
     * @return El IMC calculado.
     */
    public Double calculateIMC(Double Weight, Double Height) {
        if (Weight == null || Height == null || Height == 0) {
            throw new IllegalArgumentException("Peso y altura no pueden ser nulos o cero");
        }
        return (Weight / (Math.pow(Height, 2)));
    }

    /**
     * Clasifica el IMC según las categorías estándar.
     *
     * @param imc El IMC.
     * @return La clasificación de salud.
     */
    public String classifyIMC(Double IMC) {
        if (IMC == null) {
            throw new ValidateServiceException("El IMC no puede ser nulo");
        }
        try {
            if (IMC < 18.5) {
                return "Bajo Peso";
            } else if (IMC <= 24.9) {
                return "Peso Normal";
            } else if (IMC <= 29.9) {
                return "Sobre Peso";
            } else if (IMC <= 34.9) {
                return "Obesidad Tipo I";
            } else if (IMC <= 39.9) {
                return "Obesidad Tipo II";
            } else if (IMC <= 49.9) {
                return "Obesidad Tipo III";
            } else {
                return "Obesidad Tipo IV";
            }
        } catch (Exception e) {
            throw new GeneralServiceException("Error al clasificar el IMC: " + e.getMessage(), e);
        }
    }

}