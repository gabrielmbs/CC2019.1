package classes;

import java.util.HashSet;
import java.util.Objects;

public class Grupo {
    private String nome;
    private HashSet<Aluno> alunos;

    public Grupo(String nome) {
        this.nome = nome;
        this.alunos = new HashSet<>();

    }

    public void alocar(Aluno aluno){
        this.alunos.add(aluno);
    }
    public String imprimirAlunos(){
        System.out.println("\nAlunos do grupo " + this.nome + ":");
        String imprimir = "";
        for (Aluno aluno : alunos) {
            imprimir += "* " + aluno.toString() + "\n";
        }

        return imprimir;
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
