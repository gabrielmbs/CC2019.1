package classes;

import java.util.Objects;

public class Aluno {
    private String nome;
    private String curso;
    private String matricula;

    public Aluno(String nome, String curso, String matricula) {

        if(nome == null){
            throw new NullPointerException("NOME NULO");
        }else if(nome.trim().equals("")){
            throw new IllegalArgumentException("NOME VAZIO");
        }
        if(curso == null){
            throw new NullPointerException("CURSO NULO");
        }else if(curso.trim().equals("")){
            throw new IllegalArgumentException("CURSO VAZIO");
        }
        if(matricula == null){
            throw new NullPointerException("MATRÍCULA NULA");
        }else if(matricula.trim().equals("")){
            throw new IllegalArgumentException("MATRÍCULA VAZIA");
        }

        this.nome = nome;
        this.curso = curso;
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return this.matricula + " - " + this.nome + " - " + this.curso;
    }

    public String getNome() {
        return nome;
    }

    public String getCurso() {
        return curso;
    }

    public String getMatricula() {
        return matricula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(matricula, aluno.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }
}
