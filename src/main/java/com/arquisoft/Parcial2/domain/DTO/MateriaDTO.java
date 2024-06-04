package com.arquisoft.Parcial2.domain.DTO;

import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class MateriaDTO {
    private String codigoMateria;
    private List<Integer> notas;
}
