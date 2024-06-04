package com.arquisoft.Parcial2.repositories;

import com.arquisoft.Parcial2.domain.model.Materia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MateriaDAO extends JpaRepository<Materia, String> {
}
