package com.example.repositories;

import com.example.entity.Calendario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalendarioRepository extends JpaRepository<Calendario, Long> {
    List<Calendario> findBydata(String data);

    List<Calendario> findByhora(String hora);

    List<Calendario> findByidMedico(String idMedico);

    List<Calendario> findByidConsulta(String idConsulta);

    List<Calendario> findByidUtente(String idUtente);
}