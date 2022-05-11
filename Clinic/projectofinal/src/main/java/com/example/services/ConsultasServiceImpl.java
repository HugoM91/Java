package com.example.services;

import java.sql.*;


import com.example.entity.Consulta;
import com.example.entity.Procura;
import com.example.repositories.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class ConsultasServiceImpl implements ConsultasService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Override
    public List<Consulta> getConsultas() {
        return consultaRepository.findAll();
    }

    @Override
    public long atrasoConsulta(LocalTime horaAtual) {

        List<Consulta> atrasados = new ArrayList<Consulta>();

        for (Consulta consulta : getConsultas()) {
            if (consulta.getEstado().equals("Marcada") && consulta.getHora().isBefore(horaAtual)) {
                atrasados.add(consulta);

            }
        }
        return atrasados.size();
    }

    @Override
    public long atrasoConsultaMedico(LocalTime horaAtual, String nomeMedico) {

        List<Consulta> atrasados = new ArrayList<Consulta>();

        for (Consulta consulta : getConsultas()) {
            if (consulta.getEstado().equals("Marcada") && consulta.getHora().isBefore(horaAtual)
                    && consulta.getVaga().getDisponibilidade().getMedico().getNome().equals(nomeMedico)) {
                atrasados.add(consulta);

            }
        }
        return atrasados.size();
    }

    @Override
    public List<Consulta> getConsultasByEstadoAndUtente(String estado, String nome) {
        return consultaRepository.findAllByEstadoEqualsAndIdUtente_NomeEquals(estado, nome);
    }

    @Override
    public List<Consulta> getConsultasByMedico(String nome) {
        return consultaRepository.findConsultasByVaga_Disponibilidade_Medico_Nome(nome);
    }

    @Override
    public List<Consulta> getConsultasById(long idConsulta) {
        return consultaRepository.findAllByIdConsulta(idConsulta);
    }

    @Override
    public void updateConsultasByIdVaga(long idVaga) {
        for (Consulta consulta: consultaRepository.findAllByVaga_Id(idVaga)) {
            consulta.setVaga(null);
            consulta.setEstado("Cancelada");
            consultaRepository.save(consulta);
        }
    }

    @Override
    public Long countAllConsultaByNomeUtente(String nomeUtente) {
        return consultaRepository.countAllByIdUtente_Nome(nomeUtente);
    }

    @Override
    public Long countAllConsultasByEstadoAndUtente(String estado, String nomeUtente) {
        return consultaRepository.countAllByEstadoAndIdUtente_Nome(estado, nomeUtente);
    }

    @Override
    public List<Consulta> getConsultaByMedicoAndIdUtente(String nomeMedico, Long idUtente) {
        return consultaRepository.findConsultasByVaga_Disponibilidade_Medico_NomeAndIdUtente_IdUtente(nomeMedico, idUtente);
    }

    @Override
    public List<Consulta> getConsultasByIdUtente(Long idUtente) {
        return consultaRepository.findAllByIdUtente_IdUtente(idUtente);
    }

    @Override
    public Consulta getConsultaById(Long id) {
        return consultaRepository.getOne(id);
    }

    @Override
    public List<Consulta> getConsultaByNome(String nome) {
        return consultaRepository.findAllByIdUtente_Nome(nome);
    }

    @Override
    public void createConsulta(Consulta consulta) {
        this.consultaRepository.save(consulta);
    }

    @Override
    public void updateConsulta(Consulta consulta) {
        consultaRepository.save(consulta);
    }

    @Override
    public void deleteConsulta(Long id) {
        consultaRepository.deleteById(id);
    }

    @Override
    public Consulta getConsultaByNif(String nif) {
        return consultaRepository.findConsultaByIdUtente_Nif(nif);
    }

}