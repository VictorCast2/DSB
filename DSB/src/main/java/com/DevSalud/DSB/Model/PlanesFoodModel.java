package com.DevSalud.DSB.Model;


import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "PlanesAlimenticios")
public class PlanesFoodModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlan;

    private String dia;
    private String desayuno;
    private String almuerzo;
    private String cena;
}