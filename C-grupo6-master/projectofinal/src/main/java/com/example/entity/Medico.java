package com.example.entity;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Component
public class Medico {

    @Id
    @GeneratedValue
    private Long idMedico;
    //@GeneratedValue(strategy=GenerationType.SEQUENCE, generator=”pessoa_sequence”)
    //@SequenceGenerator(name=”pessoa_sequence”, sequenceName=”pes_seq”)

    @ManyToOne
    private Especialidade especialidade;

    @ManyToOne
    private Calendario calendario;

    @Column
    private Long idPrivilegio;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "genero")
    private String genero;

    @Column(name = "nome")
    private String nome;

    @Column(name = "dataNascimentoMedico")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataNascimento;

    @Column(name = "distrito")
    private String distrito;

    @Column(name = "localidade")
    private String localidade;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "contacto")
    private String contacto;

    @Column(name = "morada")
    private String morada;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "codigoPostal")
    private String codigoPostal;

    @Column(name = "andar")
    private String andar;

    @Column(name = "cv", length= 2_000)
    private String cv;

    @Column(name = "cedula")
    private String cedula;

    @Column(name = "nif")
    private String nif;


    public Long getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Long idMedico) {
        this.idMedico = idMedico;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public Long getIdPrivilegio() {
        return idPrivilegio;
    }

    public void setIdPrivilegio(Long idPrivilegio) {
        this.idPrivilegio = idPrivilegio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
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

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public Calendario getCalendario() {
        return calendario;
    }

    public void setCalendario(Calendario calendario) {
        this.calendario = calendario;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getMorada() {
        return getEndereco() + " " + getAndar() + ", " + getCodigoPostal()
                + " - " + getLocalidade();
    }

    public void setMorada(String morada) {
        this.morada = morada;
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

    public String getAndar() {
        return andar;
    }

    public void setAndar(String andar) {
        this.andar = andar;
    }

    public int getIdade() {
        LocalDate now = LocalDate.now();

        Period idade = Period.between(getDataNascimento(), now);

        return idade.getYears();
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }
}
