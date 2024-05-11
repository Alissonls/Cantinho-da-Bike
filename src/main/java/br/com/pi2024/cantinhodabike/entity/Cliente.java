package br.com.pi2024.cantinhodabike.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name = "CadastroCliente") 
public class Cliente {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "idUser") 
    private Long idUser;  

    @Column(name = "Nome")
    private String nome;  

    @Column(name = "CPF")
    private String cpf;  

    @Column(name = "Celular")    
    private String celular;  
    
    @Column(name = "Endereco")
    private String endereco;  
    
    @Column(name = "Email")
    private String email;  

    public Long getIdUser() {
        return idUser;
    }

     public void setIdUser(Long idUser) {
         this.idUser = idUser;
     }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}


