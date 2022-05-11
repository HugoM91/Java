package com.example.repositories;


import com.example.entity.Consulta;
import com.example.entity.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EspecialidadeRepository extends JpaRepository<Especialidade, Long> {
    /*
    List<Especialidade> findByidEspecialidade(String idEspecialidade);
    List<Especialidade> findBytipo(String tipo);
    */
}
