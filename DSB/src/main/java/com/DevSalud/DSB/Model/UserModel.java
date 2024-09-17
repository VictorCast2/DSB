package com.DevSalud.DSB.Model;

import jakarta.persistence.*;
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
    private String FirstName;
    private String LastName;
    private String Sex;
    private String EmailAddress;
    private String User;
    private String Password;
    private Double Weight;
    private Double Height;
    private String Disease;
}