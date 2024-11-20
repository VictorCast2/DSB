package com.DevSalud.DSB.Model;

import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;
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
    private Long Id;

    @NonNull
    private String Foods;
    private String AlimentsCategories;
    private String Aliments;

    @NonNull
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime StrartDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "UsersId", referencedColumnName = "Id", nullable = false)
    private UserModel User;

}
