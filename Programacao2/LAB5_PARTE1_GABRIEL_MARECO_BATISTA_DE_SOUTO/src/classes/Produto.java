package classes;

import java.util.Objects;

public class Produto {
    private String nome;
    private String descricao;
    private double preco;

    public Produto(String nome, String descricao, double preco) {
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
        if(preco < 0){
            throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
        }
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        String resultado = String.format("%.2f", this.preco);
        return this.nome + " - " + this.descricao + " - " +"R$"+ resultado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(nome, produto.nome) &&
                Objects.equals(descricao, produto.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao);
    }
}
