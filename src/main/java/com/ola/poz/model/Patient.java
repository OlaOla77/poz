package com.ola.poz.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 255)
    @Column(nullable = false)
    private String name;

    @Size(max = 255)
    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private Long pesel;

    private Long contact;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;

}
