package com.DevSalud.DSB.Model.Dao;

import jakarta.persistence.Basic;
import lombok.*;

import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonModel {
    @Basic
    @NonNull
    private String Name;
    private String username;
    private String Password;

    public static final Calendar birth = Calendar.getInstance();

    /**
     * Metodo para calcular la edad actual de una persona
     */
    public static Integer CalcularEdad(Date BirthDate) {
        birth.setTime(BirthDate);
        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
        if (today.get(Calendar.DAY_OF_YEAR) < birth.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }
        return age;
    }


}