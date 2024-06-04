package com.arquisoft.Parcial2.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Table(name = "materia")
public class Materia {
    @Id
    @Column(name = "codigo_materia")
    private String CodigoMateria;

    @Column(name = "creditos")
    private String creditos;

    @Column(name = "nombre_materia")
    private String NombreMateria;
}
