package com.DevSalud.DSB.Model;

import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "PlanAliment")
public class PlanAlimentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NonNull
    private String Day;
    private String Breakfast;
    private String Lunch;
    private String Dinner;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime CurrentDate;

    @ManyToOne
    @JoinColumn(name = "UsersId", referencedColumnName = "Id")
    private UserModel user;
    
}