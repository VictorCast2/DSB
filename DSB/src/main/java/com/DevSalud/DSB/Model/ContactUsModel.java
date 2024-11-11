package com.DevSalud.DSB.Model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ContactUsModel")
public class ContactUsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;

    @Basic
    @NonNull
    private String Name;
    private String Email;
    private String Subject;
    private String Message;

    @ManyToOne
    @JoinColumn(name = "UsersId", referencedColumnName = "Id")
    private UserModel user;

}