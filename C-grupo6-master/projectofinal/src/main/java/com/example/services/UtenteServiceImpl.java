package com.example.services;

import com.example.entity.Utente;
import com.example.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteServiceImpl implements UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    @Override
    public List<Utente> getAllUtentes() {
        return utenteRepository.findAll();
    }

    @Override
    public Utente getUtenteById(Long id) {
        return utenteRepository.findById(id).orElse(null);
        //return utenteRepository.getOne(id);
    }

    @Override
    public Utente getUtenteByNome(String nome) {
        return utenteRepository.findByNome(nome);
    }

    @Override
    public void createUtente(Utente utente) {
        utenteRepository.save(utente);
    }

    @Override
    public void updateUtente(Long id, Utente utente) {
        utenteRepository.save(utente);
    }

    @Override
    public void deleteUtente(Utente utente) {

        utenteRepository.deleteById(utente.getIdUtente());
    }

    @Override
    public long countAllUtentes() {
        return utenteRepository.count();
    }

    @Override
    public void updateUtente(Utente utente) {
        utenteRepository.save(utente);
    }

}