package classes;

import java.util.HashMap;
import java.util.Objects;

public class Fornecedor {
    private String nome;
    private String email;
    private String telefone;
    private HashMap<Integer,Produto> listaDeProdutos;

    public Fornecedor(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.listaDeProdutos = new HashMap<>();
    }

    public HashMap<Integer,Produto> getListaDeProdutos() {
        return listaDeProdutos;
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
}
