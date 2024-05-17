package br.com.pi2024.cantinhodabike.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @PostMapping("/salvar")
    public ResponseEntity<Cliente> salvaCliente(@RequestBody Cliente cliente) {
        Cliente clienteSalvo = this.clienteService.salvaCliente(cliente);

        ResponseEntity<Cliente> response = new ResponseEntity<>(clienteSalvo, HttpStatus.CREATED);
        return response;
        // return new ResponseEntity<>(clienteSalvo, HttpStatus.CREATED);
    }

    // Endpoint para buscar todos os Clientes cadastrados, atenção ao usar pois pode
    // consumir bastante recurso dependendo da quantidade de clientes no cadastro;
    @GetMapping("/buscarTodos")
    public ResponseEntity<List<Cliente>> listaClientes() {
        List<Cliente> clientes = clienteService.listaClientes();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    // Endpoint para buscar um cliente pelo ID;
    @GetMapping("/buscar/porIdUser/{idUser}")
    public ResponseEntity<Cliente> buscaClientesPorIdUser(@PathVariable("idUser") Long idUser) {
        Cliente clientes = clienteService.buscaClientesPorIdUser(idUser);
        if (clientes == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    // Endpoint para buscar um cliente pelo Nome;
    @GetMapping("/buscar/porNome/{nome}")
    public ResponseEntity<List<Cliente>> buscaClientesPorNome(@PathVariable("nome") String nome) {
        List<Cliente> clientes = clienteService.buscaClientesPorNomeAproximado(nome);
        if (clientes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    // Endpoint para buscar um cliente pelo CPF;
    @GetMapping("/buscar/porCpf/{cpf}")
    public ResponseEntity<Cliente> buscaClientesPorCpf(@PathVariable("cpf") String cpf) {
        Cliente cliente = clienteService.buscaClientesPorCpf(cpf);
        if (cliente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    // Endpoint para buscar um cliente pelo Celular;
    @GetMapping("/buscar/porCelular/{celular}")
    public ResponseEntity<List<Cliente>> buscaClientesPorCelular(@PathVariable("celular") String celular) {
        List<Cliente> clientes = clienteService.buscaClientesPorCelular(celular);
        if (clientes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    // Endpoint para buscar um cliente pelo Endereço
    @GetMapping("/buscar/porEndereco/{endereco}")
    public ResponseEntity<List<Cliente>> buscaClientesPorEndereco(@PathVariable("endereco") String endereco) {
        List<Cliente> clientes = clienteService.buscaClientesPorEndereco(endereco);
        if (clientes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    // Endpoint para buscar um cliente pelo Email;
    @GetMapping("/buscar/porEmail/{email}")
    public ResponseEntity<List<Cliente>> buscaClientePorEmail(@PathVariable("email") String email) {
        List<Cliente> clientes = clienteService.buscaClientesPorEmail(email);
        if (clientes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    // Endpoint para excluir um cliente existente pelo ID
    @DeleteMapping("/deletar/porIdUser/{id}")
    public ResponseEntity<Void> excluirCliente(@PathVariable("id") Long id) {
        clienteService.excluirCliente(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint para excluir um cliente existente pelo CPF
    @DeleteMapping("/deletar/porCpf/{cpf}")
    public ResponseEntity<Void> excluirClientePorCpf(@PathVariable("cpf") String cpf) {
        try {
            clienteService.excluirClientePorCpf(cpf);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para atualizar um cliente pelo ID;

    @PutMapping("/atualizar/porId/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
        Cliente clienteAtualizado = clienteService.atualizarCliente(id, cliente);
        if (clienteAtualizado != null) {
            return ResponseEntity.ok(clienteAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}
