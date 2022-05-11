package com.example.services;

import com.example.entity.Utente;


import java.util.List;

public interface UtenteService {

    List<Utente> getAllUtentes();

    Utente getUtenteById(Long id);

    Utente getUtenteByNome(String nome);

    void createUtente(Utente utente);

    void updateUtente(Long id, Utente utente);

    void deleteUtente(Utente utente);

    long countAllUtentes();

    void updateUtente(Utente utente);
}
