package com.DevSalud.DSB.Model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MenuOfTheDay")
public class MenuOfTheDayModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;

    @Basic
    @NonNull
    private String CategoryFoodBreakFast;
    private String BreakFast;
    private String CategoryFoodLunch;
    private String Lunch;
    private String CategoryFoodDinner;
    private String Dinner;

    @ManyToOne
    @JoinColumn(name = "UsersId", referencedColumnName = "Id")
    private UserModel User;
}