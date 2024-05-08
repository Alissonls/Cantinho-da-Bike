package br.com.pi2024.cantinhodabike.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //Anotação usada para marcar a classe como uma entidade JPA. Isso significa que objetos desta classe podem ser mapeados para registros em um banco de dados.
@Table(name = "CadastroCliente") //Anotação que especifica o nome da tabela no banco de dados que corresponde a esta entidade. Neste caso, a tabela se chama "CadastroCliente".
public class Cliente {
    
    @Id //Anotação usada para marcar o atributo que representa a chave primária da entidade.
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //Anotação usada em conjunto com @Id para especificar a estratégia de geração de valores para a chave primária. Neste caso, está sendo utilizada a estratégia IDENTITY, que geralmente é associada a autoincremento em bancos de dados relacionais.
    @Column  //Anotação usada para mapear o atributo para uma coluna no banco de dados.
    private Long userID;  //Atributo que representa o identificador único do cliente.

    @Column(nullable = false, length = 14)  //nullable = false: Define que o atributo cpf não pode ser nulo no banco de dados. length = 14: Define o tamanho máximo da string para o CPF
    private String cpf;  // Atributo que representa o CPF do cliente.
    
    @Column
    private String nome;  //Atributo que representa o nome do cliente.

    @Column    
    private String celular;  //Atributo que representa o número de celular do cliente.
    
    @Column
    private String endereco;  //Atributo que representa o endereço do cliente.
    
    @Column
    private String email;  //Atributo que representa o endereço de e-mail do cliente.

    public Long getUserID() {
        return userID;
    }

    // // public void setUserID(Long userID) {
    // //     this.userID = userID;
    // // }

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


