package br.com.pi2024.cantinhodabike.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.pi2024.cantinhodabike.entity.Produtos;

@Repository
public interface ProdutoRepository extends JpaRepository<Produtos, Long> {
    Produtos findByIdProdutos(Long idProdutos);

    List<Produtos> findByNomeProdutoContainingIgnoreCase(String nomeProduto);
}
