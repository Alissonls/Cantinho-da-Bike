package br.com.pi2024.cantinhodabike.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pi2024.cantinhodabike.entity.Cliente;
import br.com.pi2024.cantinhodabike.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    
    public Cliente salvaCliente (Cliente cliente) {
        Cliente clienteSalvo = this.clienteRepository.save(cliente);
        return clienteSalvo;
        
    }

    

}
