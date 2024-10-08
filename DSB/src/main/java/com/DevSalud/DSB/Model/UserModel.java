package com.DevSalud.DSB.Model;

import com.DevSalud.DSB.Model.Dao.PersonModel;
import jakarta.persistence.*;
<<<<<<< HEAD
import lombok.*;

import java.util.Date;
=======
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
>>>>>>> testPaginaPrincipal

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
<<<<<<< HEAD
<<<<<<< HEAD
    private Integer Age;
    @Column(name = "EmailAddress",  nullable = false, unique = true)
    private String EmailAddress;
    private String User;
    private String Password;
=======
    private Date BirthDate;
    private Integer Age = CalcularEdad(BirthDate);
    private String emailAddress;
>>>>>>> 1476cc1eec84222d1dd9b995941450bf6e99f071
=======
    private Date BirthDate;
    private Integer Age;
    private String emailAddress;
>>>>>>> parent of dc284d4 (commit al main)
    private Double Weight;
    private Double Height;
    private String Disease;

    // Campo transitorio para el checkbox de términos y condiciones
    @Transient
    private boolean termsAccepted;

}