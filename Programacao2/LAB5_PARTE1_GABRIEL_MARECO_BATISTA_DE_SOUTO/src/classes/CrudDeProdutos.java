package classes;

import java.util.HashMap;

public class CrudDeProdutos {
    private HashMap<Integer, Produto> mapaDescritorProduto;
    private CrudDeFornecedores fornecedores;

    public CrudDeProdutos(){
        this.mapaDescritorProduto = new HashMap<>();
    }

    public int cadastraProduto(String nome, String descricao, String preco, String fornecedor){
        Descritor chave = new Descritor(nome, descricao);
        if(this.mapaDescritorProduto.containsKey(chave.hashCode())){
            throw new IllegalArgumentException("Produto já existe");
        }else{
            Produto produto = new Produto(nome, descricao, preco);
            this.mapaDescritorProduto.put(chave.hashCode(), produto);
            this.fornecedores.adicionaProduto(fornecedor, chave.hashCode() , produto);
            return chave.hashCode();
        }
    }

    public String exibeUmProdutoDeUmFornecedor(String nome, String descricao, String fornecedor){
        Descritor chave = new Descritor(nome, descricao);
        if(this.mapaDescritorProduto.containsKey(chave.hashCode())){
            return this.fornecedores.exibeUmProdutoDeUmFornecedor(fornecedor,chave.hashCode());
        }else{
            throw new IllegalArgumentException("Produto não existe");
        }
    }

    public String exibeTodosProdutosDeUmFornecedor(String fornecedor){
        return this.fornecedores.exibeTodosProdutosDeUmFornecedor(fornecedor);
    }

    public String exibeTodosProdutos(){
        return this.fornecedores.exibeTodosProdutos();
    }

    public boolean editarPrecoDeUmProdutoDeUmFornecedor(String nome, String descricao, String preco, String fornecedor){
        Descritor chave = new Descritor(nome, descricao);
        if(this.mapaDescritorProduto.containsKey(chave.hashCode())){
            return this.fornecedores.editarPrecoDeUmProdutoDeUmFornecedor(fornecedor,chave.hashCode(), preco);
        }else{
            throw new IllegalArgumentException("Produto não existe");
        }
    }

    public boolean removerProdutoDoFornecedor(String nome, String descricao, String fornecedor){
        Descritor chave = new Descritor(nome, descricao);
        if(this.mapaDescritorProduto.containsKey(chave.hashCode())){
            return this.fornecedores.removerProdutoDoFornecedor(fornecedor, chave.hashCode());
        }else{
            throw new IllegalArgumentException("Produto não existe");
        }
    }



}
