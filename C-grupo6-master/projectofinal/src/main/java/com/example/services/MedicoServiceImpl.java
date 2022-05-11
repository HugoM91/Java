package com.example.services;

import com.example.entity.Medico;
import com.example.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoServiceImpl implements MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Override
    public List<Medico> getAllMedicos() {
        return medicoRepository.findAll();
    }

    @Override
    public Medico getMedicoById(Long id) {
        return medicoRepository.getOne(id);
    }

    @Override
    public Medico getMedicoByNome(String nome) {
        return medicoRepository.findByNome(nome);
    }

    @Override
    public void createMedico(Medico medico) {
        this.medicoRepository.save(medico);
    }

    @Override
    public void updateMedico(Medico medico) {
        medicoRepository.save(medico);
    }

    @Override
    public void deleteMedico(Medico medico) {
        medicoRepository.deleteById(medico.getIdMedico());
    }

    @Override
    public long countAllMedicos() {
        return medicoRepository.count();
    }
}
