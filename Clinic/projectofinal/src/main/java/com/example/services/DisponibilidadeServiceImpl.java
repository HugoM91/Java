package com.example.services;

import com.example.entity.Disponibilidade;
import com.example.entity.Medico;
import com.example.entity.Vaga;
import com.example.repositories.DisponibilidadeRepository;
import com.example.repositories.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DisponibilidadeServiceImpl implements DisponibilidadeService {

    @Autowired
    private DisponibilidadeRepository disponibilidadeRepository;

    @Autowired
    private VagaService vagaService;

    @Override
    public List<Disponibilidade> getAllDisponibilidade() {
        return disponibilidadeRepository.findAll();
    }

    @Override
    public List<Disponibilidade> getAllDisponibilidadeByMedico(Long idMedico) {
        return disponibilidadeRepository.getAllByMedico_IdMedico(idMedico);
    }

    @Override
    public Disponibilidade createDisponibilidade(Disponibilidade disponibilidade) {
        return disponibilidadeRepository.save(disponibilidade);
    }

    @Override
    public Disponibilidade updateDisponibilidade(Disponibilidade disponibilidade) {
        return disponibilidadeRepository.save(disponibilidade);
    }

    @Override
    public void deleteAllByMedico(Medico medico) {
        for (Disponibilidade disponibilidade: disponibilidadeRepository.getAllByMedico_IdMedico(medico.getIdMedico())) {
            vagaService.deleteAllVagasByIdDisponibilidade(disponibilidade.getId());
            disponibilidadeRepository.deleteById(disponibilidade.getId());
        }
    }


}
