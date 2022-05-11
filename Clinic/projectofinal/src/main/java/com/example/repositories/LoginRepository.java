package com.example.repositories;


import com.example.entity.Calendario;
import com.example.entity.Consulta;
import com.example.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {

    List<Consulta> findByid(String id);

    List<Consulta> findByusername(String username);

    List<Consulta> findBypassword(String password);

    List<Consulta> findByusertype(String usertype);


}
