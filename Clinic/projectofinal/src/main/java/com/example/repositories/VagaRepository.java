package com.example.repositories;

import com.example.entity.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Long> {

    List<Vaga> findAllByDisponivelTrue();

    List<Vaga> findVagasByDisponibilidade_Medico_IdMedicoAndDisponibilidade_DiaSemana(Long disponibilidade_medico_idMedico, DayOfWeek disponibilidade_diaSemana);

    List<Vaga> findByDisponivelTrueAndDataAndDisponibilidade_Medico_IdMedicoOrderByHoraInicio(LocalDate data, Long disponibilidade_medico_idMedico);

    List<Vaga> findByDisponivelTrueAndDataAndDisponibilidade_Medico_Especialidade_IdEspecialidadeOrderByHoraInicio(LocalDate data, Long disponibilidade_medico_especialidade_idEspecialidade);

    List<Vaga> getAllByDisponibilidade_Id(Long disponibilidadeId);

    List<Vaga> findVagasByDisponibilidade_Medico_nome(String username);


}
