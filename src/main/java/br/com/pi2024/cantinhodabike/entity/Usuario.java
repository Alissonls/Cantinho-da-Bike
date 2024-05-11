package br.com.pi2024.cantinhodabike.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "AcessoSistema")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLogin")
    private Long idLogin;

    @Column(name = "Senha")
    private String senha;

    @Column(name = "Status")
    private String sataus;

    @Column(name = "Ativo")
    private String ativo;

    //Getters e setters;

    public Long getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(Long idLogin) {
        this.idLogin = idLogin;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSataus() {
        return sataus;
    }

    public void setSataus(String sataus) {
        this.sataus = sataus;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }
    


}
