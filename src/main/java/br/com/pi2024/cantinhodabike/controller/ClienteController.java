package br.com.pi2024.cantinhodabike.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pi2024.cantinhodabike.entity.Cliente;
import br.com.pi2024.cantinhodabike.service.ClienteService;


@RequestMapping("/cliente")
@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> salvaCliente (@RequestBody Cliente cliente) {
        Cliente clienteSalvo = this.clienteService.salvaCliente(cliente);

        ResponseEntity<Cliente> response = new ResponseEntity<>(clienteSalvo, HttpStatus.CREATED);
        return response;
    }

}

