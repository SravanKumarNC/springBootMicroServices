package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data

@Table(name = "case_service")
public class CaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    private int age;
    private String address;
    private String description;
    @Column(nullable = false, unique = true)
    private long phone;
    private String department;
    private String role;
    private int yearOfExperience;

}
