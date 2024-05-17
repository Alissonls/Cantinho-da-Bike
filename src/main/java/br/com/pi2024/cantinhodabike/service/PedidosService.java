package br.com.pi2024.cantinhodabike.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pi2024.cantinhodabike.entity.Pedidos;
import br.com.pi2024.cantinhodabike.repository.PedidosRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PedidosService {

    @Autowired
    private PedidosRepository pedidosRepository;

    // Metodo para o POST Request;
    public Pedidos cadastrarPedido(Pedidos pedido) {
        Pedidos pedidoCadastrado = this.pedidosRepository.save(pedido);
        return pedidoCadastrado;

    }

    // Metodos para os GETs Requests;
    public List<Pedidos> listarTodosPedidos() {
        return pedidosRepository.findAll();
    }

    public Pedidos buscarPedidoPorId(Long id) {
        return pedidosRepository.findBfindByIdPedidos(id);
    }

    // Metodo para DELETE Request passando ID;
    public void excluirPedido(Long id) {
        pedidosRepository.deleteById(id);
    }

    // Metodos para PUT Request passando ID;
    public Pedidos atualizarPedido(Long id, Pedidos pedidoNovo) {
        Optional<Pedidos> pedidoExistente = pedidosRepository.findById(id);
        if (pedidoExistente.isPresent()) {
            pedidoNovo.setIdPedidos(pedidoExistente.get().getIdPedidos());
            return pedidosRepository.save(pedidoNovo);
        } else {
            throw new RuntimeException("Pedido não encontrado com o ID: " + id);
        }
    }

}
