package com.arquisoft.Parcial2.repositories;

import com.arquisoft.Parcial2.domain.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteDAO extends JpaRepository<Estudiante, String> {
}
