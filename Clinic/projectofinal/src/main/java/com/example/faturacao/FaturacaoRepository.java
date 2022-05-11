package com.example.faturacao;

import com.example.entity.Facturacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FaturacaoRepository extends JpaRepository<Facturacao, String> {

    List<Facturacao> findAllByIdConsulta(long idConsulta);

}
