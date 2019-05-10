package classes;

import util.DescritorProduto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Fornecedor {
    private String nome;
    private String email;
    private String telefone;
    private HashMap<DescritorProduto,Produto> listaDeProdutos;

    public Fornecedor(String nome, String email, String telefone) {

        if(nome == null){
            throw new NullPointerException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
        }else if("".equals(nome.trim())){
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
        }
        if(email == null){
            throw new NullPointerException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
        }else if("".equals(email.trim())){
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
        }
        if(telefone == null){
            throw new NullPointerException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
        }else if("".equals(telefone.trim())){
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
        }

        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.listaDeProdutos = new HashMap<>();
    }

    public boolean adicionaProduto(String nome, String descricao, double preco){
        if(nome == null){
            throw new NullPointerException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
        }else if("".equals(nome.trim())){
            throw new IllegalArgumentException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
        }
        if(descricao == null){
            throw new NullPointerException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
        }else if("".equals(descricao.trim())){
            throw new IllegalArgumentException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
        }
        DescritorProduto chave = new DescritorProduto(nome,descricao);
        if(this.listaDeProdutos.containsKey(chave)){
            throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
        }else{
            this.listaDeProdutos.put(chave, new Produto(nome, descricao, preco));
            return true;
        }
    }

    public String exibeProduto(String nome, String descricao){
        if(nome == null){
            throw new NullPointerException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
        }else if("".equals(nome.trim())){
            throw new IllegalArgumentException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
        }
        if(descricao == null){
            throw new NullPointerException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
        }else if("".equals(descricao.trim())){
            throw new IllegalArgumentException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
        }

        DescritorProduto chave = new DescritorProduto(nome,descricao);
        if(this.listaDeProdutos.containsKey(chave)){
            return this.listaDeProdutos.get(chave).toString();
        }else{
            throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
        }
    }

    public String exibeTodosProdutos() {
        ArrayList<String> todosOsProdutos = new ArrayList();
        for (Produto produto : this.listaDeProdutos.values()) {
            todosOsProdutos.add(produto.toString());
        }
        String imprimir = String.join(" | ", todosOsProdutos);
        return imprimir;
    }

    public boolean editaProduto(String nome, String descricao, double novoPreco){
        if(nome == null){
            throw new NullPointerException("Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
        }else if("".equals(nome.trim())){
            throw new IllegalArgumentException("Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
        }
        if(descricao == null){
            throw new NullPointerException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
        }else if("".equals(descricao.trim())){
            throw new IllegalArgumentException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
        }
        if(novoPreco < 0){
            throw new NullPointerException("Erro na edicao de produto: preco invalido.");
        }

        DescritorProduto chave = new DescritorProduto(nome,descricao);
        if(this.listaDeProdutos.containsKey(chave)){
            this.listaDeProdutos.get(chave).setPreco(novoPreco);
            return true;
        }else{
            throw new IllegalArgumentException("Erro na edicao de produto: produto nao existe.");
        }
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString () {
        return this.nome + " - " + this.email + " - " + this.telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fornecedor that = (Fornecedor) o;
        return Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    public boolean removeProduto(String nome, String descricao) {
        if(nome == null){
            throw new NullPointerException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
        }else if("".equals(nome.trim())){
            throw new IllegalArgumentException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
        }
        if(descricao == null){
            throw new NullPointerException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
        }else if("".equals(descricao.trim())){
            throw new IllegalArgumentException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
        }

        DescritorProduto chave = new DescritorProduto(nome,descricao);
        if(this.listaDeProdutos.containsKey(chave)){
            this.listaDeProdutos.remove(chave);
            return true;
        }else{
            throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
        }
    }
}
