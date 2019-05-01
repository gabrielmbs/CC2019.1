package classes;

import java.util.Objects;

/**
 * Classe que representa o aluno, em que vai guardar as informações do aluno. E ira pegar as informaçoes
 *  de um aluno quando outras classes precisar.
 *
 * @author Gabriel Mareco Batista de Souto
 */
public class Aluno {
    /**
     * Representa o nome do aluno
     */
    private String nome;
    /**
     * Representa o curso que o aluno está matriculado.
     */
    private String curso;
    /**
     * Representa a matricula do aluno, unico para todos os alunos.
     */
    private String matricula;

    /**
     * Constroi um aluno a partir do nome, seu curso e matricula.
     * retorna NullPointerException quano algum dos parametro seja passado nulo e
     * retorna IllegalArgumentException caso o paramentro passado seja vazio.
     *
     * @param nome representa o nome do aluno, do tipo String
     * @param curso o curo do aluno, do tipo String
     * @param matricula a matricula do aluno, do tipo String
     */
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

    /**
     * Ele retorna uma representação textual do aluno, ou seja, mostra todas as informações de um aluno.
     *
     * @return um string, do formato 'matricula - nome - curso'
     */
    @Override
    public String toString() {
        return this.matricula + " - " + this.nome + " - " + this.curso;
    }

    /**
     * Ele pega o nome do aluno.
     *
     * @return uma string, que representa o nome do aluno.
     */
    public String getNome() {
        return nome;
    }
    /**
     * Ele pega o curso do aluno.
     *
     * @return uma string, que representa o curso do aluno.
     */
    public String getCurso() {
        return curso;
    }

    /**
     * Ele pega a matricula do aluno.
     *
     * @return uma string, que representa a matricula do aluno.
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Compara se dois alunos são iguais, para eles serem iguais, precisam ter a mesma matricula.
     *
     * @param o Objeto que vai ser comparado
     * @return retorna true, se forem iguais, caso contrario, retorna false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(matricula, aluno.matricula);
    }

    /**
     * Gera um hashCode de um aluno, ele utiliza a matricula para isso.
     * @return um inteiro, que representa o aluno.
     */
    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }
}
