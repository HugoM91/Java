package com.example.entity;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Component
public class Consulta {

    @Id
    @GeneratedValue
    @Column(name = "idConsulta")
    private Long idConsulta;

    @Column(name = "idFatura", length= 1_000)
    private String idFatura;

    @OneToOne
    private ListaEspera listaEspera;

    @ManyToOne
    private Utente idUtente;

    @OneToOne
    private Vaga vaga;

    @Column(name = "url")
    private String url;

    @Column(name = "idFuncionario")
    private String idFuncionario;

    @Column(name = "estado")
    private String estado;

    @Column(name = "observacoes", length= 2_000)
    private String observacoes;

    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate data;

    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime hora;

    @Column(name = "valor")
    private String valor;

    public String getIdFatura() {
        return idFatura;
    }

    public void setIdFatura(String idFatura) {
        this.idFatura = idFatura;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Long getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Long idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Utente getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(Utente idUtente) {
        this.idUtente = idUtente;
    }

    public String getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(String idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public ListaEspera getListaEspera() {
        return listaEspera;
    }

    public void setListaEspera(ListaEspera listaEspera) {
        this.listaEspera = listaEspera;
    }
}

