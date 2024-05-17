package br.com.pi2024.cantinhodabike.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pi2024.cantinhodabike.entity.Produtos;
import br.com.pi2024.cantinhodabike.repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    // Metodo para o POST Request;

    public Produtos cadastrarProduto(Produtos produto) {
        Produtos cadastraProdutos = this.produtoRepository.save(produto);
        return cadastraProdutos;
    }

    // Metodos para os GETs Requests;

    public List<Produtos> listarTodosProdutos() {
        return produtoRepository.findAll();
    }

    public Produtos buscarProdutoPorId(Long id) {
        return produtoRepository.findByIdProdutos(id);
             }

    public List<Produtos> buscarProdutosPorNomeAproximado(String nome) {
        return produtoRepository.findByNomeContainingIgnoreCase(nome);
    }

    // Metodo para DELETE Request passando ID;

    public void excluirProduto(Long id) {
        produtoRepository.deleteById(id);
    }

    // Metodo para o PUT Request;

    public Produtos atualizarProduto(Long id, Produtos produto) {
        Optional<Produtos> produtoExistente = produtoRepository.findById(id);
        if (produtoExistente.isPresent()) {
            produto.setIdProdutos(produtoExistente.get().getIdProdutos());
            return produtoRepository.save(produto);
        } else {
            throw new RuntimeException("Produto não encontrado com o ID: " + id);
        }
    }

}
