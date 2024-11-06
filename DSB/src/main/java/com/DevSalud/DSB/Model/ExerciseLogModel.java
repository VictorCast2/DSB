package com.DevSalud.DSB.Model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ExerciseLog")
public class ExerciseLogModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;

    @Basic
    @NonNull
    public String ExerciseName;
    public String ExerciseType;
    public Integer Hours;
    public Integer Minutes;
    public String ExerciseIntensity;

    @ManyToOne
    @JoinColumn(name = "MenuOfTheDayModel", referencedColumnName = "Id")
    private MenuOfTheDayModel menuOfTheDayModel;

    @ManyToOne
    @JoinColumn(name = "UsersId", referencedColumnName = "Id")
    private UserModel User;

}