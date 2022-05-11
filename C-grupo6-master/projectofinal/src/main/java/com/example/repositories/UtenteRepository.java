package com.example.repositories;


import com.example.entity.Calendario;
import com.example.entity.Consulta;
import com.example.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {

    Utente findByNome(String nome);

/*
    List<Utente> findByidUtente(String idUtente);
    List<Utente> findBynome(String nome);
    List<Utente> findBydata_nascimento(String data_nascimento);
    List<Utente> findByemail(String email);
    List<Utente> findBytelemovel(String telemovel);
    List<Utente> findBymorada(String morada);
    List<Utente> findBynif(String nif);
    List<Utente> findBysns(String sns);
    List<Utente> findByseguro(String seguro);
    List<Utente> findByidPrivilegio(String idPrivilegio);
    List<Utente> findByobservacoes(String observacoes);
*/

}
