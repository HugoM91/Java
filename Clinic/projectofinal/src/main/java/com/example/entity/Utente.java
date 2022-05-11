package com.example.entity;


import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Component
public class Utente {

    @Id
    @GeneratedValue
    @Column(name = "idUtente")
    private Long idUtente;
    //@GeneratedValue(strategy=GenerationType.SEQUENCE, generator=”pessoa_sequence”)
    //@SequenceGenerator(name=”pessoa_sequence”, sequenceName=”pes_seq”)

    @Column(name = "nome")
    private String nome;

    @Column(name = "dataNascimento")
    private Date dataNascimento;

    @Column(name = "genero")
    private String genero;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "telemovel")
    private String telemovel;

    @Column(name = "morada")
    private String morada;

    @Column(name = "andar")
    private String andar;

    @Column(name = "distrito")
    private String distrito;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "codigoPostal")
    private String codigoPostal;

    @Column(name = "localidade")
    private String localidade;

    @Column(name = "nif")
    private String nif;

    @Column(name = "sns")
    private String sns;

    @Column(name = "seguro")
    private String seguro;

    @Column(name = "idPrivilegio")
    private Long idPrivilegio;

    @Column(name = "observacoes")
    private String observacoes;

    @OneToMany
    private List<Consulta> consulta;

    public Long getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(Long idUtente) {
        this.idUtente = idUtente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelemovel() {
        return telemovel;
    }

    public void setTelemovel(String telemovel) {
        this.telemovel = telemovel;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getSns() {
        return sns;
    }

    public void setSns(String sns) {
        this.sns = sns;
    }

    public String getSeguro() {
        return seguro;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

    public Long getIdPrivilegio() {
        return idPrivilegio;
    }

    public void setIdPrivilegio(Long idPrivilegio) {
        this.idPrivilegio = idPrivilegio;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public List<Consulta> getConsulta() {
        return consulta;
    }

    public void setConsulta(List<Consulta> consulta) {
        this.consulta = consulta;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "idUtente=" + idUtente +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", genero='" + genero + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", telefone='" + telefone + '\'' +
                ", telemovel='" + telemovel + '\'' +
                ", morada='" + morada + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                ", localidade='" + localidade + '\'' +
                ", nif='" + nif + '\'' +
                ", sns='" + sns + '\'' +
                ", seguro='" + seguro + '\'' +
                ", idPrivilegio=" + idPrivilegio +
                ", observacoes='" + observacoes + '\'' +
                '}';
    }
}
