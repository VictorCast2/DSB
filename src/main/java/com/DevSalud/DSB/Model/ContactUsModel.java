package com.DevSalud.DSB.Model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ContactUs")
public class ContactUsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NonNull
    private String NameContactUs;
    private String EmailContactUs;
    private String SubjectContactUs;
    private String MessageContactUs;

    @ManyToOne
    @JoinColumn(name = "UsersId", referencedColumnName = "Id")
    private UserModel user;

}