package com.DevSalud.DSB.Model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Basic
    @NonNull
    private String Name;
    private String Sex;
    private Integer Age;
    @Column(name = "EmailAddress", nullable = false, unique = true)
    private String EmailAddress;
    private String User;
    private String Password;
    private Double Weight;
    private Double Height;
    private String Disease;

    // Campo transitorio para el checkbox de términos y condiciones
    @Transient
    private boolean termsAccepted;

}