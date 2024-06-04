package com.arquisoft.Parcial2.services.Impl;

import com.arquisoft.Parcial2.domain.model.Nota;
import com.arquisoft.Parcial2.repositories.NotaDAO;
import com.arquisoft.Parcial2.services.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaServiceImpl implements NotaService {
    private final NotaDAO notaDAO;

    @Autowired
    public NotaServiceImpl(NotaDAO notaDAO) {
        this.notaDAO = notaDAO;
    }

    @Override
    public List<Nota> findAllByEstudianteCedula(String cedula) {
        return notaDAO.findAllByEstudianteCedula(cedula);
    }

    @Override
    public void saveNotas(List<Nota> notas) {
        notaDAO.saveAll(notas);
    }
}
