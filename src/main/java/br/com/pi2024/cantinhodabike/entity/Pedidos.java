package br.com.pi2024.cantinhodabike.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "Pedidos")
public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPedidos")
    private int idPedidos;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private Cliente cliente;

    @Column(name = "DataPedido")
    private LocalDateTime dataPedido;

    @Column(name = "StatusPedido")
    private String statusPedido;

    @Column(name = "DataEntrega")
    private LocalDateTime dataEntrega;

    //Getters e setters;

    public int getIdPedidos() {
        return idPedidos;
    }

    public void setIdPedidos(int idPedidos) {
        this.idPedidos = idPedidos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }

    public LocalDateTime getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDateTime dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
}

