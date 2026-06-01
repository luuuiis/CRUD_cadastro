package com.luuuiis.teste_projeto1.services;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.luuuiis.teste_projeto1.model.Produto;
import com.luuuiis.teste_projeto1.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired // injeção de dependência, o spring vai criar uma instancia do ProdutoRepository e injetar aqui
    private ProdutoRepository produtoRepository;

    /**
     * Produtos é uma lista com todos os intens de tipo <Produto> (classe criada no model)
     * @return uma lista de produtos em que cada produto tem seus atributos
     */
    public List<Produto> obterTodos(){
        return produtoRepository.obterTodos();
    }

    /**
     * Usa a função obterPorID do ProdutoRepository para buscar um produto pelo id
     * @param id do Produto que quero buscar
     * @return Produto em que o id que passei de parametro é igual
     */
    public Optional<Produto> obterPorID(Integer id){
        return produtoRepository.obterPorID(id);
    }

    /**
     * Usando o metodo adicionar do ProdutoRepository para criar um novo produto, ou seja, adicionar um produto a lista de produtos
     * @param produto que quero adicionar com todos os atributos
     * @return Produto criado com o id adicionado e os atributos que passei de parametro
     */
    public Produto adicionar(Produto produto){
        // Aqui poderia ter regra de negocio
        // ex: adioconar apenas produtos com quantidade maior que 0, ou valor maior que 0, etc
        return produtoRepository.adicionar(produto);
    }

    /**
     * Usa a função deletar do ProdutoRepository para deletar um produto pelo id
     * @param id que vou buscar para deletar
     */
    public void deletar(Integer id){
        produtoRepository.deletar(id);
    }

    public Produto atualizar(Integer id, Produto produto){
        // Validação no id
        produto.setId(id); //garante que o id do produto seja o mesmo do parametro
        return produtoRepository.atualizar(produto);
    }

}
