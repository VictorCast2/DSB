package com.Developper.DSB.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String FirstName;
    private String LastName;
    private String Sex;
    private String User;
    private String Password;
    private Double Weight;
    private Double Height;
    private String Disease;
}