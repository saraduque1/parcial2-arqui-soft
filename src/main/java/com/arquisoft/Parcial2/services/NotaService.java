package com.arquisoft.Parcial2.services;


import com.arquisoft.Parcial2.domain.model.Nota;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NotaService {
    List<Nota> findAllByEstudianteCedula(String cedula);
    void saveNotas(List<Nota> notas);
}
