package com.DevSalud.DSB.Model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "AlimentLog")
public class AlimentLogModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;

    @Basic
    @NonNull
    private String CategoryFood;
    private String Food;

    @ManyToOne
    @JoinColumn(name = "MenuOfTheDayModel", referencedColumnName = "Id")
    private MenuOfTheDayModel menuOfTheDayModel;

    @ManyToOne
    @JoinColumn(name = "UsersId", referencedColumnName = "Id")
    private UserModel User;

}