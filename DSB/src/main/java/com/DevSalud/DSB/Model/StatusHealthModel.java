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
    public String HealthClassification;
    public float BodyMass;

    @ManyToOne
    @JoinColumn(name = "UsersId", referencedColumnName = "Id")
    private UserModel User;

}