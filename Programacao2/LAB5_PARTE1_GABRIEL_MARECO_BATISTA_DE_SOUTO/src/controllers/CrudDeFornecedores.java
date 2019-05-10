package controllers;

import classes.Fornecedor;

import java.util.ArrayList;
import java.util.HashMap;

public class CrudDeFornecedores {
    private HashMap<String, Fornecedor> mapaNomeFornecedor;

    public CrudDeFornecedores() {
        this.mapaNomeFornecedor = new HashMap<>();
    }

    public String cadastraFornecedor(String nome, String email, String telefone){
        if(nome == null){
            throw new NullPointerException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
        }else if("".equals(nome.trim())){
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
        }

        if(this.mapaNomeFornecedor.containsKey(nome)){
            throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
        }else{
            this.mapaNomeFornecedor.put(nome, new Fornecedor(nome, email, telefone));
            return nome;
        }
    }

    public String exibeFornecedor(String nome){
        if(nome == null){
            throw new NullPointerException("Erro na exibicao do fornecedor: nome nao pode ser vazio ou nulo.");
        }else if("".equals(nome.trim())){
            throw new IllegalArgumentException("Erro na exibicao do fornecedor: nome nao pode ser vazio ou nulo.");
        }

        if(this.mapaNomeFornecedor.containsKey(nome)){
            Fornecedor fornecedor = this.mapaNomeFornecedor.get(nome);
            return fornecedor.toString();
        }else{
            throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
        }
    }

    public String exibeTodosOsFornecedores(){
        ArrayList<String> todosOsFornecedores = new ArrayList();
        for (Fornecedor fornecedor : this.mapaNomeFornecedor.values()) {
            todosOsFornecedores.add(fornecedor.toString());
        }
        String imprimir = String.join(" | ", todosOsFornecedores);
        return imprimir;

    }

    public boolean editaFornecedor(String nome, String atributo, String novoValor){
        if(nome == null){
            throw new NullPointerException("Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
        }else if("".equals(nome.trim())){
            throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
        }
        if(atributo == null){
            throw new NullPointerException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
        }else if("".equals(atributo.trim())){
            throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
        }else if("nome".equals(atributo)){
            throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
        }
        if(novoValor == null){
            throw new NullPointerException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
        }else if("".equals(novoValor.trim())){
            throw new IllegalArgumentException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
        }

        if(this.mapaNomeFornecedor.containsKey(nome)){
            if("email".equals(atributo)){
                this.mapaNomeFornecedor.get(nome).setEmail(novoValor);
            }else if ("telefone".equals(atributo)){
                this.mapaNomeFornecedor.get(nome).setTelefone(novoValor);
            }else{
                throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
            }
            return true;
        }else{
            throw new IllegalArgumentException("Erro na edicao do fornecedor: fornecedor nao existe.");
        }
    }

    public boolean removerFornecedor(String nome){
        if(nome == null){
            throw new NullPointerException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser nulo.");
        }else if("".equals(nome.trim())){
            throw new IllegalArgumentException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio.");
        }

        if(this.mapaNomeFornecedor.containsKey(nome)){
            this.mapaNomeFornecedor.remove(nome);
            return true;
        }else{
            throw new IllegalArgumentException("Erro na remocao do fornecedor: fornecedor nao existe.");
        }
    }

    public boolean cadastrarProdutoParaUmFornecedo(String fornecedor, String nome, String descricao, double preco){
        if(fornecedor == null){
            throw new NullPointerException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
        }else if("".equals(fornecedor.trim())){
            throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
        }

        if(this.mapaNomeFornecedor.containsKey(fornecedor)){
            return this.mapaNomeFornecedor.get(fornecedor).adicionaProduto(nome,descricao,preco);
        }else{
            throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
        }

    }

    public String exibeProduto(String nome, String descricao, String fornecedor){
        if(fornecedor == null){
            throw new NullPointerException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
        }else if("".equals(fornecedor.trim())){
            throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
        }

        if(this.mapaNomeFornecedor.containsKey(fornecedor)){
            return this.mapaNomeFornecedor.get(fornecedor).exibeProduto(nome,descricao);
        }else{
            throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
        }
    }

    public boolean editaProduto(String nome, String descricao, String fornecedor, double novoPreco){
        if(fornecedor == null){
            throw new NullPointerException("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
        }else if("".equals(fornecedor.trim())){
            throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
        }

        if(this.mapaNomeFornecedor.containsKey(fornecedor)){
            return this.mapaNomeFornecedor.get(fornecedor).editaProduto(nome,descricao,novoPreco);
        }else{
            throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao existe.");
        }
    }
}
