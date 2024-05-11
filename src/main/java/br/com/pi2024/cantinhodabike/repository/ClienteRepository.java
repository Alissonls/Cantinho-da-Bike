package br.com.pi2024.cantinhodabike.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pi2024.cantinhodabike.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

    List<Cliente> findByIdUser(Long idUser);

    List<Cliente> findByNomeIgnoreCase(String nome);

    Cliente findByCpf(String cpf);

    List<Cliente> findByCelular(String celular);

    List<Cliente> findByEnderecoIgnoreCase(String endereco);

    List<Cliente> findByEmailIgnoreCase(String email);

    public void deleteByCpf(String cpf);


}
