package com.example.entity;


import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Facturacao {

    @Id
    @GeneratedValue
    Long idInterno;

    @Column(name = "id_facturacao")
    private String idFacturacao;

    @Column(name = "url")
    private String url;

    @Column(name = "id_consulta")
    private Long idConsulta;

    public Long getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Long idConsulta) {
        this.idConsulta = idConsulta;
    }

    public String getIdFacturacao() {
        return idFacturacao;
    }

    public void setIdFacturacao(String idFacturacao) {
        this.idFacturacao = idFacturacao;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getIdInterno() {
        return idInterno;
    }

    public void setIdInterno(Long idInterno) {
        this.idInterno = idInterno;
    }
}
