package com.example.services;

import com.example.entity.ListaEspera;
import com.example.repositories.ListaEsperaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaEsperaServiceImpl implements ListaEsperaService {

    @Autowired
    private ListaEsperaRepository listaEsperaRepository;

    @Override
    public void createListaEspera(ListaEspera listaEspera) {
        listaEsperaRepository.save(listaEspera);
    }

    @Override
    public List<ListaEspera> getAllListaEspera() {
        return listaEsperaRepository.findAll();
    }

    @Override
    public List<ListaEspera> getAllListaEsperaByNomeMedico(String nomeMedico) {
        return listaEsperaRepository.findAllByConsulta_Vaga_Disponibilidade_Medico_Nome(nomeMedico);
    }

    @Override
    public void deleteListaEspera(ListaEspera listaEspera) {
        listaEsperaRepository.deleteById(listaEspera.getIdSenha());
    }

    @Override
    public ListaEspera getListaEsperaById(Long id) {
        return listaEsperaRepository.findById(id).orElse(null);
    }

    @Override
    public long countAllListaEspera() {
        return listaEsperaRepository.count();
    }

    @Override
    public long countAllListaEsperaByMedico(String nomeMedico) {
        return listaEsperaRepository.countListaEsperaByConsulta_Vaga_Disponibilidade_Medico_Nome(nomeMedico);
    }

    @Override
    public ListaEspera getNext(String nomeMedico) {

        return getAllListaEsperaByNomeMedico(nomeMedico).get(0);
    }
}
