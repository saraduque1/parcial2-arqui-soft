package com.arquisoft.Parcial2.repositories;

import com.arquisoft.Parcial2.domain.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotaDAO extends JpaRepository<Nota, Long> {
    List<Nota> findAllByEstudianteCedula(String cedula);
}
