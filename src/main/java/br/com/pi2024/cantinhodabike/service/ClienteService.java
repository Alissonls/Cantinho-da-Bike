package br.com.pi2024.cantinhodabike.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pi2024.cantinhodabike.entity.Cliente;
import br.com.pi2024.cantinhodabike.exception.ResourceNotFoundException;
import br.com.pi2024.cantinhodabike.repository.ClienteRepository;
import jakarta.transaction.Transactional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Metodo para o POST Request;
    public Cliente salvaCliente(Cliente cliente) {
        Cliente clienteSalvo = this.clienteRepository.save(cliente);
        return clienteSalvo;

        // public Cliente salvaCliente(Cliente cliente) {
        // return clienteRepository.save(cliente);
    }

    // Metodos para os GETs Requests;
    public List<Cliente> listaClientes() {
        return clienteRepository.findAll();
    }

    public Cliente buscaClientesPorIdUser(Long idUser) {
        return clienteRepository.findByIdUser(idUser);
    }

    public List<Cliente> buscaClientesPorNomeAproximado(String nome) {
        return clienteRepository.findByNomeContainingIgnoreCase(nome);
    }

    public Cliente buscaClientesPorCpf(String cpf) {
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

    // Metodo para DELETE Request passando ID;

    public void excluirCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    // Metodo para DELETE Request passando CPF;
    @Transactional
    public void excluirClientePorCpf(String cpf) {
        Cliente cliente = clienteRepository.findByCpf(cpf);
        if (cliente != null) {
            clienteRepository.deleteByCpf(cpf);
        } else {
            throw new ResourceNotFoundException("Cliente não encontrado com o CPF: " + cpf);
        }
    }

    // Metodos para PUT Request passando ID;

    public Cliente atualizarCliente(Long id, Cliente clienteNovo) {
        Optional<Cliente> clienteExistente = clienteRepository.findById(id);
        if (clienteExistente.isPresent()) {
            clienteNovo.setIdUser(clienteExistente.get().getIdUser());
            return clienteRepository.save(clienteNovo);
        } else {
            throw new RuntimeException("Cliente não encontrado com o ID: " + id);
        }

    }
}
