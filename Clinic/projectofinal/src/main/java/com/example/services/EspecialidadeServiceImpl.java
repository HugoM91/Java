package com.example.services;

import com.example.entity.Especialidade;
import com.example.entity.Funcionario;
import com.example.repositories.EspecialidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadeServiceImpl implements EspecialidadeService {

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    @Override
    public List<Especialidade> getAllEspecialidade() {
        return especialidadeRepository.findAll();
    }

    @Override
    public void createEspecialidade(Especialidade especialidade) {
        especialidadeRepository.save(especialidade);
    }

    @Override
    public void deleteEspecialidade(Long id) {
        especialidadeRepository.deleteById(id);
    }
}