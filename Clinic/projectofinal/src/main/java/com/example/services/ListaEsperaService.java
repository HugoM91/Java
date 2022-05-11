package com.example.services;

import com.example.entity.ListaEspera;

import java.util.List;

public interface ListaEsperaService {

    void createListaEspera(ListaEspera listaEspera);

    List<ListaEspera> getAllListaEspera();

    List<ListaEspera> getAllListaEsperaByNomeMedico(String nomeMedico);

    void deleteListaEspera(ListaEspera listaEspera);

    ListaEspera getListaEsperaById(Long id);

    long countAllListaEspera();

    long countAllListaEsperaByMedico(String nomeMedico);

    ListaEspera getNext(String nomeMedico);
}
