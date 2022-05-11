package com.example.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@Component
public class Calendario {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "data")
    String data;
    @Column(name = "hora")
    String hora;
    @Column(name = "idConsulta")
    String idConsulta;
    @OneToMany
    List<Medico> idMedico;
    @Column(name = "idMedico")
    String idMedico2;
    @Column(name = "idUtente")
    String idUtente;
    @Column(name = "ano")
    String ano;
    @Column(name = "mes")
    String mes;
    @Column(name = "dia")
    String dia;

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(String idConsulta) {
        this.idConsulta = idConsulta;
    }

    public List<Medico> getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(List<Medico> idMedico) {
        this.idMedico = idMedico;
    }

    public String getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(String idUtente) {
        this.idUtente = idUtente;
    }

    public String getIdMedico2() {
        return idMedico2;
    }

    public void setIdMedico2(String idMedico2) {
        this.idMedico2 = idMedico2;
    }
}
