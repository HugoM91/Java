package com.example.repositories;

import com.example.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

    Medico findByNome(String nome);
/*
    List<Consulta> findByidMedico(String idMedico);
    List<Consulta> findByidEspecialidade(String idEspecialidade);
    List<Consulta> findByidPrivilegio(String idPrivilegio);
    List<Consulta> findBynome(String nome);
    List<Consulta> findByemail(String email);
    List<Consulta> findBycontacto(String contacto);
    List<Consulta> findBycv(String cv);

*/
    Medico getMedicoByNome(String nome);
}
