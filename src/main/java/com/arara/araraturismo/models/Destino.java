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

    private double latitude;

    private double longitude;
    @NotBlank
    @Size(max = 200)
    private String descricao;

    public Destino() {
    }

    public Destino(String cidade, String estado, String bairro, String rua, String numero, double latitude, double longitude, String descricao) {
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

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
