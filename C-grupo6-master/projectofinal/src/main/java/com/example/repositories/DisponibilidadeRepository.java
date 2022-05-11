package com.example.repositories;

import com.example.entity.Disponibilidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisponibilidadeRepository extends JpaRepository<Disponibilidade, Long> {

    List<Disponibilidade> getAllByMedico_IdMedico(Long id);

    List<Disponibilidade> findAllByMedico_IdMedico(Long medico_idMedico);
}
