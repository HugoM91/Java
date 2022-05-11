package com.example.entity;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalTime;
import java.util.List;
import java.util.Queue;

@Entity
@Component
public class ListaEspera {

    @Id
    @GeneratedValue
    @Column(name = "idSenha")
    private Long idSenha;
    //@GeneratedValue(strategy=GenerationType.SEQUENCE, generator=”pessoa_sequence”)
    //@SequenceGenerator(name=”pessoa_sequence”, sequenceName=”pes_seq”)

    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime timestamp;

    @OneToOne
    private Consulta consulta;

    public Long getIdSenha() {
        return idSenha;
    }

    public void setIdSenha(Long idSenha) {
        this.idSenha = idSenha;
    }

    public LocalTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalTime timestamp) {
        this.timestamp = timestamp;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }


}
