package br.com.pi2024.cantinhodabike.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.pi2024.cantinhodabike.entity.Produtos;
import br.com.pi2024.cantinhodabike.service.ProdutoService;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    // Endpoint para cadastrar um novo produto;

    @PostMapping
    public ResponseEntity<Produtos> cadastrarProduto(@RequestBody Produtos produto) {
        Produtos novoProduto = produtoService.cadastrarProduto(produto);
        return new ResponseEntity<>(novoProduto, HttpStatus.CREATED);
    }

    // Endpoint para buscar todos os produto (Cuidado ao usar!!!);

    @GetMapping
    public ResponseEntity<List<Produtos>> listarTodosProdutos() {
        List<Produtos> produtos = produtoService.listarTodosProdutos();
        return ResponseEntity.ok(produtos);
    }

    // Endpoint para buscar um produto pelo ID;

    @GetMapping("/{id}")
    public ResponseEntity<Produtos> buscarProdutoPorId(@PathVariable("id") Long id) {
        Produtos produto = produtoService.buscarProdutoPorId(id);
        if (produto != null) {
            return ResponseEntity.ok(produto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para buscar um produto pelo nome;

    @GetMapping("/buscar/{nome}")
    public ResponseEntity<List<Produtos>> buscarProdutosPorNomeAproximado(@PathVariable("nome") String nome) {
        List<Produtos> produtosEncontrados = produtoService.buscarProdutosPorNomeAproximado(nome);
        if (!produtosEncontrados.isEmpty()) {
            return ResponseEntity.ok(produtosEncontrados);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para excluir um produto existente pelo ID;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirProduto(@PathVariable("id") Long id) {
        produtoService.excluirProduto(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint para atualizar um cliente existente pelo ID;

    @PutMapping("/{id}")
    public ResponseEntity<Produtos> atualizarProduto(@PathVariable("id") Long id, @RequestBody Produtos produto) {
        Produtos produtoAtualizado = produtoService.atualizarProduto(id, produto);
        if (produtoAtualizado != null) {
            return ResponseEntity.ok(produtoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
