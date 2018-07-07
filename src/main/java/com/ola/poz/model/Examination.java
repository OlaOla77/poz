package com.ola.poz.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "examinations")
public class Examination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 255)
    @Column(unique = true, nullable = false)
    private String name;

    @Min(0)
    private Double price;

}
