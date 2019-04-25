package classes;

public class Aluno {
    private String nome;
    private String curso;
    private String matricula;

    public Aluno(String nome, String curso, String matricula) {
        this.nome = nome;
        this.curso = curso;
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return this.matricula + " - " + this.nome + " - " + this.curso;
    }
}
