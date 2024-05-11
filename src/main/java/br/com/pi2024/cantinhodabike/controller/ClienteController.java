package br.com.pi2024.cantinhodabike.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.pi2024.cantinhodabike.entity.Cliente;
import br.com.pi2024.cantinhodabike.exception.ResourceNotFoundException;
import br.com.pi2024.cantinhodabike.service.ClienteService;

@RequestMapping("/cliente")
@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Endpoint para cadastrar um novo cliente;

    @PostMapping
    public ResponseEntity<Cliente> salvaCliente(@RequestBody Cliente cliente) {
        Cliente clienteSalvo = this.clienteService.salvaCliente(cliente);

        ResponseEntity<Cliente> response = new ResponseEntity<>(clienteSalvo, HttpStatus.CREATED);
        return response;
        // return new ResponseEntity<>(clienteSalvo, HttpStatus.CREATED);
    }

    // Endpoint para buscar todos os Clientes cadastrados, atenção ao usar pois pode
    // consumir bastante recurso dependendo da quantidade de clientes no cadastro;
    @GetMapping
    public ResponseEntity<List<Cliente>> listaClientes() {
        List<Cliente> clientes = clienteService.listaClientes();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    // Endpoint para buscar um cliente pelo ID;
    @GetMapping("buscarPorIdUser")
    public ResponseEntity<List<Cliente>> buscaClientesPorIdUser(@RequestParam Long idUser) {
        List<Cliente> clientes = clienteService.buscaClientesPorIdUser(idUser);
        if (clientes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    // Endpoint para buscar um cliente pelo Nome;
    @GetMapping("buscarPorNome")
    public ResponseEntity<List<Cliente>> buscaClientesPorNome(@RequestParam String nome) {
        List<Cliente> clientes = clienteService.buscaClientesPorNome(nome);
        if (clientes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    // Endpoint para buscar um cliente pelo CPF;
    @GetMapping("buscarPorCpf")
    public ResponseEntity<Cliente> buscaClientesPorCpf(@RequestParam String cpf) {
        Cliente cliente = clienteService.buscaClientesPorCpf(cpf);
        if (cliente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    // Endpoint para buscar um cliente pelo Celular;
    @GetMapping("buscarPorCelular")
    public ResponseEntity<List<Cliente>> buscaClientesPorCelular(@RequestParam String celular) {
        List<Cliente> clientes = clienteService.buscaClientesPorCelular(celular);
        if (clientes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    // Endpoint para buscar um cliente pelo Endereço
    @GetMapping("buscarPorEndereco")
    public ResponseEntity<List<Cliente>> buscaClientesPorEndereco(@RequestParam String endereco) {
        List<Cliente> clientes = clienteService.buscaClientesPorEndereco(endereco);
        if (clientes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    // Endpoint para buscar um cliente pelo Email;
    @GetMapping("buscarPorEmail")
    public ResponseEntity<List<Cliente>> buscaClientePorEmail(@RequestParam String email) {
        List<Cliente> clientes = clienteService.buscaClientesPorEmail(email);
        if (clientes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    // Endpoint para excluir um cliente existente pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCliente(@PathVariable("id") Long id) {
        clienteService.excluirCliente(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint para excluir um cliente existente pelo CPF
    @DeleteMapping("/excluirPorCpf/{cpf}")
    public ResponseEntity<Void> excluirClientePorCpf(@PathVariable("cpf") String cpf) {
        try {
            clienteService.excluirClientePorCpf(cpf);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
