package com.example.services;

import com.example.entity.Funcionario;
import com.example.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public List<Funcionario> getAllFuncionario() {
        return funcionarioRepository.findAll();
    }

    @Override
    public Funcionario getFuncionarioById(Long id) {
        return funcionarioRepository.getOne(id);
    }

    @Override
    public Funcionario getFuncionarioByNome(String nome) {
        return funcionarioRepository.findByNome(nome);
    }

    @Override
    public void createFuncionario(Funcionario funcionario) {
        this.funcionarioRepository.save(funcionario);
    }

    @Override
    public void updateFuncionario(Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
    }

    @Override
    public void deleteFuncionario(Funcionario funcionario) {
        funcionarioRepository.deleteById(funcionario.getIdFuncionario());
    }

    @Override
    public long countAllFuncionarios() {
        return funcionarioRepository.count();
    }
}
