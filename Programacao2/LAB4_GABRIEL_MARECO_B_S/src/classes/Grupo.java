package classes;

import java.util.HashSet;
import java.util.Objects;

public class Grupo {
    private String nome;
    private HashSet<Aluno> alunos;

    public Grupo(String nome) {

        if(nome == null){
            throw new NullPointerException("NOME NULO");
        }else if(nome.trim().equals("")){
            throw new IllegalArgumentException("NOME VAZIO");
        }

        this.nome = nome;
        this.alunos = new HashSet<>();

    }

    public void alocar(Aluno aluno){
        this.alunos.add(aluno);
    }

    public String imprimirAlunos(){
        String imprimir = "\nAlunos do grupo " + this.nome + ":\n";
        for (Aluno aluno : this.alunos) {
            imprimir += "* " + aluno.toString() + "\n";
        }

        return imprimir;
    }

    public String getNome() {
        return nome;
    }

    public HashSet<Aluno> getAlunos() {
        return alunos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Grupo)) return false;
        Grupo grupo = (Grupo) o;
        return Objects.equals(nome.toUpperCase(), grupo.nome.toUpperCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
