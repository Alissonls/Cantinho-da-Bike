package br.com.pi2024.cantinhodabike.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pi2024.cantinhodabike.entity.Cliente;
import br.com.pi2024.cantinhodabike.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    //Metodo para o POST Request;
    public Cliente salvaCliente(Cliente cliente) {
        Cliente clienteSalvo = this.clienteRepository.save(cliente);
        return clienteSalvo;

        // public Cliente salvaCliente(Cliente cliente) {
        // return clienteRepository.save(cliente);
    }

    //Metodos para os GETs Requests;
    public List<Cliente> listaClientes() {
        return clienteRepository.findAll();
    }

    public List<Cliente> buscaClientesPorIdUser(Long idUser) {
        return clienteRepository.findByIdUser(idUser);
    }

    public List<Cliente> buscaClientesPorNome(String nome) {
        return clienteRepository.findByNomeIgnoreCase(nome);
    }

    public List<Cliente> buscaClientesPorCpf(String cpf) {
        return clienteRepository.findByCpf(cpf);
    }

    public List<Cliente> buscaClientesPorCelular(String celular) {
        return clienteRepository.findByCelular(celular);
    }

    public List<Cliente> buscaClientesPorEndereco(String endereco) {
        return clienteRepository.findByEnderecoIgnoreCase(endereco);
    }

    public List<Cliente> buscaClientesPorEmail(String email) {
        return clienteRepository.findByEnderecoIgnoreCase(email);
    }

}
