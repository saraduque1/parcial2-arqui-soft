package com.arquisoft.Parcial2.controller;

import com.arquisoft.Parcial2.domain.DTO.MateriaDTO;
import com.arquisoft.Parcial2.domain.model.Nota;
import com.arquisoft.Parcial2.services.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("v1/notas/")
public class NotasController {
    private final NotaService notaService;

    @Autowired
    public NotasController(NotaService notaService) {
        this.notaService = notaService;
    }

    @GetMapping("estudiante/{cedula}")
    public ResponseEntity<List<MateriaDTO>> getNotasByEstudianteCedula(@PathVariable String cedula) {
        List<Nota> notas = notaService.findAllByEstudianteCedula(cedula);

        Set<String> materiaSet = notas.stream()
                .map(nota -> nota.getMateria().getCodigoMateria())
                .collect(Collectors.toSet());
        List<MateriaDTO> materias = new ArrayList<>();


        materiaSet.forEach(materia -> {
            List<Integer> notasValue = notas.stream()
                    .filter(nota -> nota.getMateria().getCodigoMateria().equals(materia))
                    .map(Nota::getNota)
                    .toList();
            materias.add(
                    MateriaDTO.builder()
                            .codigoMateria(materia)
                            .notas(notasValue)
                            .build());
        });

        return ResponseEntity.ok(materias);
    }
}
