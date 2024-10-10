package com.DevSalud.DSB.Model.Dao;

import jakarta.persistence.Basic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonModel {
    @Basic
    @NonNull
    private String Name;
    private String username;
    private String Password;
}