package com.DevSalud.DSB.Model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
@Entity
@Table(name = "Users") // Nombre de la tabla en MySQL
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Basic
    private String FirstName;
    private String LastName;
    private String Sex;
    private String User;
    private String Password;
    private Double Weight;
    private Double Height;
    private String Disease;

}