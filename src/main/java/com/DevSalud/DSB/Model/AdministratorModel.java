package com.DevSalud.DSB.Model;

import com.DevSalud.DSB.Model.Dao.PersonModel;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Administrator")
public class AdministratorModel extends PersonModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
}