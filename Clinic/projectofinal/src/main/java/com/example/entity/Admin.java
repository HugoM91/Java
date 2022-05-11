package com.example.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Component
public class Admin {


    @Id
    @GeneratedValue
    @Column(name = "idAdmin")
    private Long idAdmin;

    @Column(name = "nome")
    private String nome;

    @Column(name = "dataNascimento")
    private Date dataNascimento;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "nif")
    private String nif;

    @Column(name = "sns")
    private String sns;

    @Column(name = "genero")
    private String genero;

    @Column(name = "telemovel")
    private String telemovel;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "codigoPostal")
    private String codigoPostal;

    @Column(name = "localidade")
    private String localidade;

    @Column(name = "idPrivilegio")
    private Long idPrivilegio;

    @Column(name = "fotoPerfil")
    private Long fotoPerfil;

    @Column(name = "seguro")
    private String seguro;

    @Column(name = "andar")
    private String andar;

    @Column(name = "distrito")
    private String distrito;

    @Column(name = "morada")
    private String morada;


    public String getMorada() {
        return getEndereco() + " " + getAndar() + ", " + getCodigoPostal()
                + " - " + getLocalidade();
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getSeguro() {
        return seguro;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

    public String getAndar() {
        return andar;
    }

    public void setAndar(String andar) {
        this.andar = andar;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public Long getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(Long fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSns() {
        return sns;
    }

    public void setSns(String sns) {
        this.sns = sns;
    }

    public Long getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Long idAdmin) {
        this.idAdmin = idAdmin;
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

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getTelemovel() {
        return telemovel;
    }

    public void setTelemovel(String telemovel) {
        this.telemovel = telemovel;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public Long getIdPrivilegio() {
        return idPrivilegio;
    }

    public void setIdPrivilegio(Long idPrivilegio) {
        this.idPrivilegio = idPrivilegio;
    }
}
