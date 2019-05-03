package classes;

import java.util.Objects;

public class Descritor {
    private String nome;
    private String descricao;


    public Descritor(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Descritor descritor = (Descritor) o;
        return Objects.equals(nome, descritor.nome) &&
                Objects.equals(descricao, descritor.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao);
    }
}
