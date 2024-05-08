package br.com.pi2024.cantinhodabike.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "AcessoSistema")
public class AcessoSistema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idLogin;

    @Column
    private String senha;

    @Column
    private String sataus;

    @Column
    private String ativo;
    


}


// CREATE TABLE `AcessoSistema` (
//    `idLogin` int NOT NULL AUTO_INCREMENT,
//    `Senha` varchar(45) NOT NULL,
//    `Status` varchar(45) NOT NULL,
//    `Ativo` tinyint NOT NULL,
//    PRIMARY KEY (`idLogin`)
//  ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci