package com.ola.poz.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Column(name = "appointment_date")
    private LocalDateTime appointmentDate;

    @ManyToOne()
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToMany
    @JoinTable(
            name = "appointment_examination",
            joinColumns = @JoinColumn(name = "examination_id"),
            inverseJoinColumns = @JoinColumn(name = "appointment_id")
    )
    private List<Examination> examinations;
}
