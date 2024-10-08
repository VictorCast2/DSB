package com.DevSalud.DSB.Model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "StatusHealth")
public class StatusHealthModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;

    @Basic
    @NonNull
<<<<<<< HEAD
    public String HealthClassification;
=======
    public String HealthClassification;;
>>>>>>> parent of dc284d4 (commit al main)
    public float BodyMass;

    @ManyToOne
    @JoinColumn(name = "UsersId", nullable = false)
    private UserModel User;
}