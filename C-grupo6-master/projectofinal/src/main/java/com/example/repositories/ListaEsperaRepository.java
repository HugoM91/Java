package com.example.repositories;


import com.example.entity.ListaEspera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListaEsperaRepository extends JpaRepository<ListaEspera, Long> {
/*
    List<Consulta> findByidsenha(String idSenha);
    List<Consulta> findByidConsulta(String idConsulta);
*/

    List<ListaEspera> findAllByConsulta_Vaga_Disponibilidade_Medico_Nome(String nomeMedico);

    List<ListaEspera> findAllByConsulta_Estado(String estado);

    long countListaEsperaByConsulta_Vaga_Disponibilidade_Medico_Nome(String nomeMedico);


}
