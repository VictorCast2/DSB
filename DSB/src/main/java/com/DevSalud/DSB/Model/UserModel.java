package com.DevSalud.DSB.Model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

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
    private LocalDate DateBirthday;
    private String user;
    private String emailAddress;
    private String Password;
    private Double Weight;
    private Double Height;
    private String Disease;

    @Transient
    private boolean termsAccepted;

}