package com.scholorship.demo.model;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;

@Entity
@Table(name = "signup")
@Data

public class Signup{
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "Signup_id")
    private Integer Signup_id;



    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "confirm_password")
    private String confirm_password;


}