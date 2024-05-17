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
        Produtos novoProduto = this.produtoService.cadastrarProduto(produto);
        
        ResponseEntity<Produtos> response = new ResponseEntity<>(novoProduto, HttpStatus.CREATED);
        return response;
    }

    // Endpoint para buscar todos os produto (Cuidado ao usar!!!);

    @GetMapping("/buscartodos")
    public ResponseEntity<List<Produtos>> listarTodosProdutos() {
        List<Produtos> produtos = produtoService.listarTodosProdutos();
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    // Endpoint para buscar um produto pelo ID;

    @GetMapping("/buscar/porId/{id}")
    public ResponseEntity<Produtos> buscarProdutoPorId(@PathVariable("id") Long id) {
        Produtos produto = produtoService.buscarProdutoPorId(id);
        if (produto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } 
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }

    // Endpoint para buscar um produto pelo nome;

    @GetMapping("/buscar/porNome/{nome}")
    public ResponseEntity<List<Produtos>> buscarProdutosPorNomeAproximado(@PathVariable("nome") String nome) {
        List<Produtos> produtosEncontrados = produtoService.buscarProdutosPorNomeAproximado(nome);
        if (produtosEncontrados.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } 
        return new  ResponseEntity<>(produtosEncontrados, HttpStatus.OK);
    }

    // Endpoint para excluir um produto existente pelo ID;

    @DeleteMapping("/deletar/porId/{id}")
    public ResponseEntity<Void> excluirProduto(@PathVariable("id") Long id) {
        produtoService.excluirProduto(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint para atualizar um cliente existente pelo ID;

    @PutMapping("/atualizar/porId/{id}")
    public ResponseEntity<Produtos> atualizarProduto(@PathVariable("id") Long id, @RequestBody Produtos produto) {
        Produtos produtoAtualizado = produtoService.atualizarProduto(id, produto);
        if (produtoAtualizado != null) {
            return ResponseEntity.ok(produtoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
