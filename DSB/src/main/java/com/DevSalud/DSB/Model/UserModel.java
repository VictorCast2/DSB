package com.DevSalud.DSB.Model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Basic
    @NonNull
    private String Name;
    private String Sex;
    private Integer Age;
    private String username;
    private String EmailAddress;
    private String Password;
    private Double Weight;
    private Double Height;
    private String Disease;

    // Campo transitorio para el checkbox de términos y condiciones
    @Transient
    private boolean termsAccepted;
}