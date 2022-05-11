package com.example.entity;


import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@Component
public class Especialidade {

    @Id
    @GeneratedValue
    @Column(name = "idEspecialidade")
    private Long idEspecialidade;
    //@GeneratedValue(strategy=GenerationType.SEQUENCE, generator=”pessoa_sequence”)
    //@SequenceGenerator(name=”pessoa_sequence”, sequenceName=”pes_seq”)

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "valor")
    private String value;

    @OneToMany
    private List<Medico> medicos;

    public Long getIdEspecialidade() {
        return idEspecialidade;
    }

    public void setIdEspecialidade(Long idEspecialidade) {
        this.idEspecialidade = idEspecialidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }
}
