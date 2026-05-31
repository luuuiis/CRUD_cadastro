package com.luuuiis.teste_projeto1.repository;

import java.util.*;
import org.springframework.stereotype.Repository;
import com.luuuiis.teste_projeto1.model.Produto;


@Repository  // spring vai reconhecer essa classe como um componente de acesso a dados, ou seja, um repositório
public class ProdutoRepository {
    private List<Produto> produtos = new ArrayList<Produto>();
    private Integer ultimoID = 0;

    /**
     * Produtos é uma lista com todos os intens de tipo <Produto> (classe criada no model)
     * @return uma lista de produtos em que cada produto tem seus atributos
     */
    public List<Produto> obterTodos(){
        return produtos;
    }

    /**
     * Stream -> vai de Produto em Produto na lista produtos
     * Filter -> verifica se o id do Produto é igual ao do parametro
     * findFirst -> Pega apenas o primeiro caso em que o id é igual
     * @param id do Produto que quero buscar
     * @return Produto em que o id que passei de parametro é igual
     */
    public Optional<Produto> obterPorID(Integer id){
        return produtos.stream()
        .filter(p -> p.getId().equals(id))
        .findFirst();
    }

    /**
     * Adiciona um id a cada produto criado a partir do ultimoID 
     * e depois adiciona na lista produtos
     * @param produto que quero adicionar com todos os atributos
     * @return
     */
    public Produto adicionar(Produto produto){
        ultimoID++;
        produto.setId(ultimoID); //adiciona o id ao produto
        produtos.add(produto); //adiona na lista depois de criado
        return produto;
    }

    /**
     * Remove o Produto da lista de produtos no qual o id é igual ao id do parametro
     * @param id que vou buscar
     */
    public void deletar(Integer id){
        produtos.removeIf(p -> p.getId().equals(id));
    }

    /**
     * 1 -> procuro um produto pelo id usando o metodo obterPorID 
     * e salvo em uma variavel Optional<Produto>
     * 2 -> se o produto estiver vazio eu trato a exceção
     * 3 -> deleto o produto encontrado usando o metodo deletar
     * 4 -> adiciono o novo produto a lista com os novos atributos
     * 5 -> retorno produto
     * @param produto que quero atualizar
     * @return produto atualizado
     */
    public Produto atualizar(Produto produto){

        //Primeiro buscar o produto todo na lista produtos e salvar em uma variavel

        Optional<Produto> produtoEncontrado = obterPorID(produto.getId());
        if (produtoEncontrado.isEmpty()){
            throw new InputMismatchException("Produto nao encontrado");
        }

        //Segundo remover o produto

        deletar(produto.getId());

        //Terceiro adicionar novo produto

        produtos.add(produto);
        return produto;
    }

}
