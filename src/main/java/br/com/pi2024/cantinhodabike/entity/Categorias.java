package br.com.pi2024.cantinhodabike.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Categorias")
public class Categorias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCategorias")
    private int idCategorias;

    @Column(name = "NomeCategorias")
    private String nomeCategorias;

    @Column(name = "Marca")
    private String marca;

    //Getters e setters;

    public int getIdCategorias() {
        return idCategorias;
    }

    public void setIdCategorias(int idCategorias) {
        this.idCategorias = idCategorias;
    }

    public String getNomeCategorias() {
        return nomeCategorias;
    }

    public void setNomeCategorias(String nomeCategorias) {
        this.nomeCategorias = nomeCategorias;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
