package br.com.pi2024.cantinhodabike.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.pi2024.cantinhodabike.entity.Pedidos;
import br.com.pi2024.cantinhodabike.service.PedidosService;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {

    @Autowired
    private PedidosService pedidosService;

    // Endpoint para cadastrar um novo cliente;
    @PostMapping("/salvar")
    public ResponseEntity<Pedidos> cadastrarPedidos(@RequestBody Pedidos pedido) {
        Pedidos novoPedidos = this.pedidosService.cadastrarPedido(pedido);

        ResponseEntity<Pedidos> reponse = new ResponseEntity<>(novoPedidos, HttpStatus.CREATED);
        return reponse;
    }

    // Endpint para buscar todos os pedidos;
    @GetMapping("/buscarTodos")
    public ResponseEntity<List<Pedidos>> listarTodosPedidos() {
        List<Pedidos> pedidos = pedidosService.listarTodosPedidos();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    // Endpoint para buscar pedidos pelo ID;
    @GetMapping("/buscar/porId/{id}")
    public ResponseEntity<Pedidos> buscarPedidoPorId(@PathVariable("id") Long id) {
        Pedidos pedido = pedidosService.buscarPedidoPorId(id);
        if (pedido == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }

    // Endpoint para exlcuir pedido pelo ID;
    @DeleteMapping("/excluir/porId/{id}")
    public ResponseEntity<Void> excluirPedido(@PathVariable("id") Long id) {
        pedidosService.excluirPedido(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint para atualizar pedido pelo ID;
    @PutMapping("/atualizar/porId/{id}")
    public ResponseEntity<Pedidos> atualizarPedido(@PathVariable("id") Long id, @RequestBody Pedidos pedido) {
        Pedidos pedidoAtualizado = pedidosService.atualizarPedido(id, pedido);
        if (pedidoAtualizado != null) {
            return ResponseEntity.ok(pedidoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
