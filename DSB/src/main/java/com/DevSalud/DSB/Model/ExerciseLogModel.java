package com.DevSalud.DSB.Model;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
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
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDate StrartDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDate FinalDate;
    public String ExerciseIntensity;

    @ManyToOne
    @JoinColumn(name = "UsersId", referencedColumnName = "Id")
    private UserModel User;

}