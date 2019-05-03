package classes;

import java.util.Objects;

public class Produto {
    private String nome;
    private String descricao;
    private String preco;

    public Produto(String nome, String descricao, String preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return this.nome + " - " + this.descricao + " - " + this.preco;
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
