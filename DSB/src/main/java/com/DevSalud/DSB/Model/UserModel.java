package com.DevSalud.DSB.Model;

import com.DevSalud.DSB.Model.Dao.PersonModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class UserModel extends PersonModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Basic
    @NonNull
    private String Sex;
    private Date BirthDate;
    private Integer Age;
    private String emailAddress;
    private Double Weight;
    private Double Height;
    private String Disease;

    // Campo transitorio para el checkbox de términos y condiciones
    @Transient
    private boolean termsAccepted;
}