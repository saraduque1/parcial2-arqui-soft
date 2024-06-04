package com.arquisoft.Parcial2.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Table(name = "estudiante")
public class Estudiante {
    @Id
    @Column(name = "student_id")
    private String cedula;

    @Column(name = "nombre")
    private String nombre;


}
