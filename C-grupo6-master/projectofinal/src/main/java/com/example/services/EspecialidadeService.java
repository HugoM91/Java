package com.example.services;

import com.example.entity.Especialidade;
import com.example.entity.Funcionario;

import java.util.List;


public interface EspecialidadeService {

    List<Especialidade> getAllEspecialidade();

    void createEspecialidade(Especialidade especialidade);

    void deleteEspecialidade(Long id);

}

