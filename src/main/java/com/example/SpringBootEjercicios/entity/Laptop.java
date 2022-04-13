package com.example.SpringBootEjercicios.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Laptop {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long id;
    String marca;
    String sistemaOperativo;
    Integer memoriaRam;
    Integer discoDuro;
    Double peso;
    Double precio;
    String color;
    Boolean envioGratis;

    public Laptop() {
    }

    public Laptop(Long id, String marca, String sistemaOperativo, Integer memoriaRam, Integer discoDuro, Double peso, Double precio, String color, Boolean envioGratis) {
        this.id = id;
        this.marca = marca;
        this.sistemaOperativo = sistemaOperativo;
        this.memoriaRam = memoriaRam;
        this.discoDuro = discoDuro;
        this.peso = peso;
        this.precio = precio;
        this.color = color;
        this.envioGratis = envioGratis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public Integer getMemoriaRam() {
        return memoriaRam;
    }

    public void setMemoriaRam(Integer memoriaRam) {
        this.memoriaRam = memoriaRam;
    }

    public Integer getDiscoDuro() {
        return discoDuro;
    }

    public void setDiscoDuro(Integer discoDuro) {
        this.discoDuro = discoDuro;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getEnvioGratis() {
        return envioGratis;
    }

    public void setEnvioGratis(Boolean envioGratis) {
        this.envioGratis = envioGratis;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", sistemaOperativo='" + sistemaOperativo + '\'' +
                ", memoriaRam=" + memoriaRam +
                ", discoDuro=" + discoDuro +
                ", peso=" + peso +
                ", precio=" + precio +
                ", color='" + color + '\'' +
                ", envioGratis=" + envioGratis +
                '}';
    }
}
