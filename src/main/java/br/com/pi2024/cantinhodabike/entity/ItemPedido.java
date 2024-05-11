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
@Table(name = "ItemPedido")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idItemPedido")
    private int idItemPedido;

    @ManyToOne
    @JoinColumn(name = "idPedido")
    private Pedidos pedido;

    @ManyToOne
    @JoinColumn(name = "idProduto")
    private Produtos produto;

    @Column(name = "quantPedido")
    private int quantidadePedido;

    @Column(name = "precoUnitario")
    private double precoUnitario;

    @Column(name = "Frete")
    private double frete;

    // Construtores, getters e setters;

    public int getIdItemPedido() {
        return idItemPedido;
    }

    public void setIdItemPedido(int idItemPedido) {
        this.idItemPedido = idItemPedido;
    }

    public Pedidos getPedido() {
        return pedido;
    }

    public void setPedido(Pedidos pedido) {
        this.pedido = pedido;
    }

    public Produtos getProduto() {
        return produto;
    }

    public void setProduto(Produtos produto) {
        this.produto = produto;
    }

    public int getQuantidadePedido() {
        return quantidadePedido;
    }

    public void setQuantidadePedido(int quantidadePedido) {
        this.quantidadePedido = quantidadePedido;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public double getFrete() {
        return frete;
    }

    public void setFrete(double frete) {
        this.frete = frete;
    }

}
