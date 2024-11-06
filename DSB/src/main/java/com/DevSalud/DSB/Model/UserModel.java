package com.DevSalud.DSB.Model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
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
    private String user;
    private String emailAddress;
    private String Password;
    private Double Weight;
    private Double Height;
    private String Disease;
    private Double MasaCorporal;
    private String ClasificacionSalud;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate DateBirthday;
    
    @Transient
    private boolean termsAccepted;
}