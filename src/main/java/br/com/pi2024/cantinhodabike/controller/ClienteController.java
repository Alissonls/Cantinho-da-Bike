package br.com.pi2024.cantinhodabike.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.pi2024.cantinhodabike.entity.Cliente;
import br.com.pi2024.cantinhodabike.service.ClienteService;

@RequestMapping("/cliente")
@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> salvaCliente(@RequestBody Cliente cliente) {
        Cliente clienteSalvo = this.clienteService.salvaCliente(cliente);

        ResponseEntity<Cliente> response = new ResponseEntity<>(clienteSalvo, HttpStatus.CREATED);
        return response;
        // return new ResponseEntity<>(clienteSalvo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listaClientes() {
        List<Cliente> clientes = clienteService.listaClientes();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("buscarPorIdUser")
    public ResponseEntity<List<Cliente>> buscaClientesPorIdUser(@RequestParam Long idUser) {
        List<Cliente> clientes = clienteService.buscaClientesPorIdUser(idUser);
        if (clientes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }
   
    @GetMapping("buscarPorNome")
    public ResponseEntity<List<Cliente>> buscaClientesPorNome(@RequestParam String nome) {
        List<Cliente> clientes = clienteService.buscaClientesPorNome(nome);
        if (clientes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("buscarPorCpf")
    public ResponseEntity<List<Cliente>> buscaClientesPorCpf(@RequestParam String cpf) {
        List<Cliente> clientes = clienteService.buscaClientesPorCpf(cpf);
        if (clientes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("buscarPorCelular")
    public ResponseEntity<List<Cliente>> buscaClientesPorCelular(@RequestParam String celular) {
        List<Cliente> clientes = clienteService.buscaClientesPorCelular(celular);
        if (clientes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("buscarPorEndereco")
    public ResponseEntity<List<Cliente>> buscaClientesPorEndereco(@RequestParam String endereco) {
        List<Cliente> clientes = clienteService.buscaClientesPorEndereco(endereco);
        if (clientes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("buscarPorEmail")
    public ResponseEntity<List<Cliente>> buscaClientePorEmail(@RequestParam String email) {
        List<Cliente> clientes = clienteService.buscaClientesPorEmail(email);
        if (clientes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }
}
