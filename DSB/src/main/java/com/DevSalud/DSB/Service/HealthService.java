package com.DevSalud.DSB.Service;

import java.lang.Math;
import org.springframework.stereotype.Service;

@Service
public class HealthService {

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
            throw new IllegalArgumentException("El IMC no puede ser nulo");
        }
        if (IMC < 18.5) {
            return "Bajo Peso";
        } else if (IMC <= 24.9) {
            return "Peso Normal";
        } else if (IMC <= 29.9) {
            return "Sobrepeso";
        } else if (IMC <= 34.9) {
            return "Obesidad Tipo 1";
        } else if (IMC <= 39.9) {
            return "Obesidad Tipo 2";
        } else if (IMC <= 49.9) {
            return "Obesidad Tipo 3";
        } else {
            return "Obesidad Tipo 4";
        }
    }

}