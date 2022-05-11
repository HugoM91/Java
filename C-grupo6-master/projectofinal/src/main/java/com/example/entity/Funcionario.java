package com.example.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;


@Entity
@Component
public class Funcionario {

    @Id
    @GeneratedValue
    @Column(name = "idFuncionario")
    private Long idFuncionario;
    //@GeneratedValue(strategy=GenerationType.SEQUENCE, generator=”pessoa_sequence”)
    //@SequenceGenerator(name=”pessoa_sequence”, sequenceName=”pes_seq”)

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

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "telemovel")
    private String telemovel;

    @Column(name = "idPrivilegio")
    private Long idPrivilegio;

    @Column(name = "fotoPerfil")
    private Long fotoPerfil;

    @Column(name = "seguro")
    private String seguro;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "codigoPostal")
    private String codigoPostal;

    @Column(name = "andar")
    private String andar;

    @Column(name = "localidade")
    private String localidade;

    @Column(name = "morada")
    private String morada;


    public String getSeguro() {
        return seguro;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getAndar() {
        return andar;
    }

    public void setAndar(String andar) {
        this.andar = andar;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
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

    public Long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Long idFuncionario) {
        this.idFuncionario = idFuncionario;
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

    public Long getIdPrivilegio() {
        return idPrivilegio;
    }

    public void setIdPrivilegio(Long idPrivilegio) {
        this.idPrivilegio = idPrivilegio;
    }
}
