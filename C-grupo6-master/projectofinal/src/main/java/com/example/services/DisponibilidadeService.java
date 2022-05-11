package com.example.services;

import com.example.entity.Disponibilidade;
import com.example.entity.Medico;

import java.util.List;

public interface DisponibilidadeService {

    List<Disponibilidade> getAllDisponibilidade();

    List<Disponibilidade> getAllDisponibilidadeByMedico(Long idMedico);

    Disponibilidade createDisponibilidade(Disponibilidade disponibilidade);

    Disponibilidade updateDisponibilidade(Disponibilidade disponibilidade);

    void deleteAllByMedico(Medico medico);
}
