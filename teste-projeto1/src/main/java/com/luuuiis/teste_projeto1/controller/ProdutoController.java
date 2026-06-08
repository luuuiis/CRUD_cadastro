package com.luuuiis.teste_projeto1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.luuuiis.teste_projeto1.model.Produto;
import com.luuuiis.teste_projeto1.services.ProdutoService;
import java.util.*;

@RestController
@RequestMapping("/api/produtos") //rota base para acessar os endpoints desse controller, ou seja, localhost:8080/produtos
public class ProdutoController {
    
    @Autowired // injeção de dependência, o spring vai criar uma instancia do ProdutoService e injetar aqui
    private ProdutoService produtoService;

    //mapeia a rota para o metodo obterTodos, ou seja, quando eu fizer uma requisição do tipo GET para localhost:8080/produtos, esse metodo vai ser executado
    @GetMapping // ex: "/adicionar" -> localhost:8080/produtos/adicionar
    public List<Produto> obterTodos(){
        return produtoService.obterTodos();
    }

    @GetMapping("/{id}") // ex: "/1" -> localhost:8080/produtos/1
    public Optional<Produto> obterPorID(@PathVariable Integer id){
        return produtoService.obterPorID(id);
    }

    // @RequestBody -> o spring vai pegar o corpo da requisição e transformar em um objeto do tipo Produto
    @PostMapping 
    public Produto adicionar(@RequestBody Produto produto){ 
        return produtoService.adicionar(produto);
    }

}


