package com.example.services;


import com.example.entity.Disponibilidade;
import com.example.entity.Vaga;

import java.time.LocalDate;
import java.util.List;

public interface VagaService {

     List<Vaga> getAllVagasByUsername(String username);

    List<Vaga> getAllVagas();

    List<Vaga> getAllVagasByDisponivel();

    Vaga getVagaById(Long id);

    void createVaga(Vaga vaga);

    void updateVaga(Long id, Vaga vaga);

    public void generateVagas(Disponibilidade disponibilidade, LocalDate dataInicial);

    public List<Vaga> getAllByDisponivelTrueAndDataAndDisponibilidade_Medico_IdMedico(LocalDate data, Long disponibilidade_medico_idMedico);

    public List<Vaga> getAllByDisponivelTrueAndDataAndDisponibilidade_Medico_Especialidade_IdEspecialidade(LocalDate data, Long disponibilidade_medico_especialidade);

    void deleteAllVagasByIdDisponibilidade(Long idDisponibilidade);

    void updateVaga(Vaga vaga);
}
