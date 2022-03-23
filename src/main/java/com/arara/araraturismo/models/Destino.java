package com.arara.araraturismo.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "destinos")
public class Destino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "destino_generator")
    private Long id;
    @NotBlank
    @Size(max = 30)
    private String nome;
    @NotBlank
    @Size(max = 30)
    private String telefone;
    @NotBlank
    @Size(max = 30)
    private String email;
    @NotBlank
    @Size(max = 30)
    private String cidade;
    @NotBlank
    @Size(max = 25)
    private String estado;
    @NotBlank
    @Size(max = 30)
    private String bairro;
    @NotBlank
    @Size(max = 50)
    private String rua;
    @NotBlank
    @Size(max = 15)
    private String numero;

    private String latitude;

    private String longitude;
    @NotBlank
    @Size(max = 200)
    private String descricao;

    public Destino() {
    }

    public Destino(String nome, String telefone, String email, String cidade, String estado, String bairro, String rua, String numero, String latitude, String longitude, String descricao) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cidade = cidade;
        this.estado = estado;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.latitude = latitude;
        this.longitude = longitude;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
