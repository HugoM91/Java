package com.example.services;

import com.example.entity.Funcionario;
import com.example.entity.Medico;

import java.util.List;

public interface FuncionarioService {

    List<Funcionario> getAllFuncionario();

    Funcionario getFuncionarioById(Long id);

    Funcionario getFuncionarioByNome(String nome);

    void createFuncionario(Funcionario funcionario);

    void updateFuncionario(Funcionario funcionario);

    void deleteFuncionario(Funcionario funcionario);

    long countAllFuncionarios();
}
