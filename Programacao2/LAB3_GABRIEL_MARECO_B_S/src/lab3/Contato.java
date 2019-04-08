package lab3;

import java.util.Objects;

public class Contato {
    private String nome;
    private String sobreNome;
    private String telefone;

    public Contato(String nome, String sobreNome, String telefone) {
        if (nome == null) {
            throw new NullPointerException("Nome nulo");

        }else if(nome.trim().equals("")){
            throw new IllegalArgumentException("Nome vazio");
        }
        if (sobreNome == null) {
            throw new NullPointerException("Sobrenome nulo");

        }else if(sobreNome.trim().equals("")){
            throw new IllegalArgumentException("Sobrenome vazio");
        }
        if (telefone == null) {
            throw new NullPointerException("Telefone nulo");

        }else if(telefone.trim().equals("")){
            throw new IllegalArgumentException("Telefone vazio");
        }
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.telefone = telefone;
    }

    public String exibeNome() {
        return this.nome + " " + this.sobreNome;
    }

    @Override
    public String toString() {
        return this.nome + " " + this.sobreNome + " " + "-" + " " + this.telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return Objects.equals(nome, contato.nome) &&
                Objects.equals(sobreNome, contato.sobreNome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, sobreNome);
    }
}
