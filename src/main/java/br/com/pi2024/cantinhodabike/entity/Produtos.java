package br.com.pi2024.cantinhodabike.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Produtos")
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProdutos")
    private Long idProdutos;

    @Column(name = "NomeProduto")
    private String nomeProduto;

    @Column(name = "DescricaoProduto")
    private String descricaoProduto;

    @Column(name = "PrecoCusto")
    private double precoCusto;

    @Column(name = "PrecoVenda")
    private double precoVenda;

    @Column(name = "QuantEstoque")
    private int quantidadeEstoque;

    @ManyToOne
    @JoinColumn(name = "idCategorias")
    private Categorias categoria;

    //Getters e setters;

    public Long getIdProdutos() {
        return idProdutos;
    }

    public void setIdProdutos(Long idProdutos) {
        this.idProdutos = idProdutos;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }
}
