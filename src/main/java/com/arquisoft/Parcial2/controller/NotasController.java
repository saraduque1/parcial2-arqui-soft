package com.arquisoft.Parcial2.controller;

import com.arquisoft.Parcial2.domain.DTO.MateriaDTO;
import com.arquisoft.Parcial2.domain.model.Estudiante;
import com.arquisoft.Parcial2.domain.model.Materia;
import com.arquisoft.Parcial2.domain.model.Nota;
import com.arquisoft.Parcial2.services.NotaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("v1/notas/")
@Tag(name = "Notas", description = "Gestión de notas de estudiantes")
public class NotasController {
    private final NotaService notaService;

    @Autowired
    public NotasController(NotaService notaService) {
        this.notaService = notaService;
    }

    @Operation(summary = "Obtener notas por cédula del estudiante")
    @GetMapping("estudiante/{cedula}")
    public ResponseEntity<List<EntityModel<MateriaDTO>>> getNotasByEstudianteCedula(@PathVariable String cedula) {
        List<Nota> notas = notaService.findAllByEstudianteCedula(cedula);

        Set<String> materiaSet = notas.stream()
                .map(nota -> nota.getMateria().getCodigoMateria())
                .collect(Collectors.toSet());
        List<EntityModel<MateriaDTO>> materias = new ArrayList<>();

        materiaSet.forEach(materia -> {
            List<Integer> notasValue = notas.stream()
                    .filter(nota -> nota.getMateria().getCodigoMateria().equals(materia))
                    .map(Nota::getNota)
                    .toList();
            MateriaDTO materiaDTO = MateriaDTO.builder()
                    .codigoMateria(materia)
                    .notas(notasValue)
                    .build();
            EntityModel<MateriaDTO> materiaModel = EntityModel.of(materiaDTO);

            materiaModel.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(NotasController.class)
                    .getNotasByEstudianteCedula(cedula)).withRel("estudiante-notas"));
            materiaModel.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(NotasController.class)
                    .saveMateria(cedula, materiaDTO)).withRel("add-nota"));

            materias.add(materiaModel);
        });

        return ResponseEntity.ok(materias);
    }

    @Operation(summary = "Guardar notas para un estudiante")
    @PostMapping("estudiante/{cedula}")
    public ResponseEntity<List<Nota>> saveMateria(@PathVariable String cedula, @RequestBody MateriaDTO materiaDTO) {
        List<Nota> notas = new ArrayList<>();

        materiaDTO.getNotas().forEach(nota -> {
            try {
                Nota nota1 = Nota.builder()
                        .materia(Materia.builder().CodigoMateria(materiaDTO.getCodigoMateria()).build())
                        .estudiante(Estudiante.builder().cedula(cedula).build())
                        .nota(nota).build();
                notas.add(nota1);
            } catch (RuntimeException e) {
                throw new RuntimeException("Materia o Estudiante no existe");
            }
        });

        notaService.saveNotas(notas);
        return ResponseEntity.ok(notas);
    }
}