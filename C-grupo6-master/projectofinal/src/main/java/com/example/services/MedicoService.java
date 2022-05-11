package com.example.services;

import com.example.entity.Medico;

import java.util.List;

public interface MedicoService {

    List<Medico> getAllMedicos();

    Medico getMedicoById(Long id);

    Medico getMedicoByNome(String nome);

    void createMedico(Medico medico);

    void updateMedico(Medico medico);

    void deleteMedico(Medico medico);

    long countAllMedicos();

}
