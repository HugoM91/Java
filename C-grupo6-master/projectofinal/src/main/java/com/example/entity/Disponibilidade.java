package com.example.entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

@Entity
public class Disponibilidade {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    private List<Vaga> vagas;

    @ManyToOne
    private Medico medico;

    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime inicioTurno;

    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime fimTurno;

    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime inicioIntervalo;

    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime fimIntervalo;

    @Column
    private DayOfWeek diaSemana;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Vaga> getVagas() {
        return vagas;
    }

    public void setVagas(List<Vaga> vagas) {
        this.vagas = vagas;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public LocalTime getInicioTurno() {
        return inicioTurno;
    }

    public void setInicioTurno(LocalTime inicioTurno) {
        this.inicioTurno = inicioTurno;
    }

    public LocalTime getFimTurno() {
        return fimTurno;
    }

    public void setFimTurno(LocalTime fimTurno) {
        this.fimTurno = fimTurno;
    }

    public LocalTime getInicioIntervalo() {
        return inicioIntervalo;
    }

    public void setInicioIntervalo(LocalTime inicioIntervalo) {
        this.inicioIntervalo = inicioIntervalo;
    }

    public LocalTime getFimIntervalo() {
        return fimIntervalo;
    }

    public void setFimIntervalo(LocalTime fimIntervalo) {
        this.fimIntervalo = fimIntervalo;
    }

    public DayOfWeek getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(DayOfWeek diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getDiaSemanaPt() {
        return getDiaSemana().getDisplayName(TextStyle.FULL, Locale.forLanguageTag("pt"));
    }
}
