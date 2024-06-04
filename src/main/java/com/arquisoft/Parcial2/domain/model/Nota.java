package com.arquisoft.Parcial2.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Table(name = "nota")
public class Nota {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name =  "nota_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cedula" , nullable = false)
    private Estudiante estudiante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_materia" , nullable = false)
    private Materia materia;

    @Column(name = "nota", nullable = false)
    private Integer nota;
}
