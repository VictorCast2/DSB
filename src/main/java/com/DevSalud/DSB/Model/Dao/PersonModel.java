package com.DevSalud.DSB.Model.Dao;

import jakarta.persistence.Basic;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonModel {
    @Basic
    @NonNull
    private String Name;
    private String userName;
    private String emailAddress;
    private String Password;
}