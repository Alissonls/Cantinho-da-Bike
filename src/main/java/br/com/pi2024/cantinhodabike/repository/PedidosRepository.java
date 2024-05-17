package br.com.pi2024.cantinhodabike.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pi2024.cantinhodabike.entity.Pedidos;

@Repository
public interface PedidosRepository extends JpaRepository<Pedidos, Long> {
    Pedidos findBfindByIdPedidos(Long idPedidos);
}