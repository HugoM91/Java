package com.example.repositories;

import com.example.entity.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    List<Consulta> findByidConsulta(String idConsulta);

    List<Consulta> findByidUtente(String idUtente);

    List<Consulta> findByidFuncionario(String idFuncionario);

    List<Consulta> findByestado(String estado);

    List<Consulta> findByobservacoes(String observacoes);

    List<Consulta> findBydata(String data);

    Consulta findConsultaByIdUtente_Nif(String nif);

    List<Consulta> findAllByIdUtente_Nome(String nome);

    List<Consulta> findAllByEstadoEquals(String estado);

    //List<Consulta> findAllByIdUtenteAndByIdMedico(String idUtente, String idMedico);

    long countAllByEstadoEquals(String estado);

    List<Consulta> findAllByEstadoEqualsAndIdUtente_NomeEquals(String estado, String nome);

    List<Consulta> findConsultasByVaga_Disponibilidade_Medico_Nome(String nome);

    List<Consulta> findAllByIdConsulta(long idConsulta);

    List<Consulta> findAllByVaga_Id(Long id);

    Long countAllByIdUtente_Nome(String nomeUtente);

    Long countAllByEstadoAndIdUtente_Nome(String estado, String nomeUtente);

    List<Consulta> findConsultasByVaga_Disponibilidade_Medico_NomeAndIdUtente_IdUtente(String nomeMedico, Long idUtente);

    List<Consulta> findAllByIdUtente_IdUtente(Long idUtente);
}