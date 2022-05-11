package com.example.repositories;


import com.example.entity.Calendario;
import com.example.entity.Consulta;
import com.example.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    Funcionario findByNome(String nome);
/*


    List<Consulta> findByidFuncionario(String idFuncionario);

    List<Consulta> findByemail(String email);
    List<Consulta> findBytelemovel(String telemovel);
    List<Consulta> findByidPrivilegio(String idPrivilegio);

*/
}
