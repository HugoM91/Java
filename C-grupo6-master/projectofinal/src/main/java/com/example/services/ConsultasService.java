package com.example.services;

import com.example.entity.Consulta;
import com.example.entity.Funcionario;
import com.example.entity.Procura;
import com.example.entity.Utente;

import java.time.LocalTime;
import java.util.List;


public interface ConsultasService {

    List<Consulta> getConsultas();

    Consulta getConsultaById(Long id);

    List<Consulta> getConsultaByNome(String nome);

    void createConsulta(Consulta consulta);

    void updateConsulta(Consulta consulta);

    void deleteConsulta(Long id);

    Consulta getConsultaByNif(String nif);

    long atrasoConsulta(LocalTime horaAtual);

    long atrasoConsultaMedico(LocalTime horaAtual, String nomeMedico);

    List<Consulta> getConsultasByEstadoAndUtente(String estado, String nome);

    List<Consulta> getConsultasByMedico(String nome);

    List<Consulta> getConsultasById(long idConsulta);

    void updateConsultasByIdVaga(long idVaga);

    Long countAllConsultaByNomeUtente(String nomeUtente);

    Long countAllConsultasByEstadoAndUtente(String estado, String nomeUtente);

    List<Consulta> getConsultaByMedicoAndIdUtente(String nomeMedico, Long idUtente);

    List<Consulta> getConsultasByIdUtente(Long idUtente);
}

