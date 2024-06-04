package com.arquisoft.Parcial2.domain.DTO;

import org.springframework.hateoas.RepresentationModel;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class MateriaDTO extends RepresentationModel<MateriaDTO> {
    private String codigoMateria;
    private List<Integer> notas;
}
