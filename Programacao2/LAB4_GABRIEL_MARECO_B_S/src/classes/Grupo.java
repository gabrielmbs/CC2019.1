package classes;

import java.util.HashSet;
import java.util.Objects;

/**
 * classe representa um grupo de alunos, ele é responsavel por
 * armazenar alunos.
 *
 * @author Gabriel Mareco Batista de Souto
 */
public class Grupo {
    /**
     * representa o nome do grupo
     */
    private String nome;
    /**
     * representa os alunos que estão no grupo
     */
    private HashSet<Aluno> alunos;

    /**
     * Constroi um grupo a partir de seu nome. Retorna
     * NullPointerException caso o nome do grupo seja passado nulo e
     * retorna IllegalArgumentException caso ele esteja vazio.
     * E inicializa as variaveis.
     *
     * @param nome representa o nome do grupo.
     */
    public Grupo(String nome) {

        if(nome == null){
            throw new NullPointerException("NOME NULO");
        }else if(nome.trim().equals("")){
            throw new IllegalArgumentException("NOME VAZIO");
        }

        this.nome = nome;
        this.alunos = new HashSet<>();

    }

    /**
     * Aqui adiciona um aluno no grupo, ou seja,
     * adiciona no 'HashSet alunos'.
     *
     * @param aluno represeta  o objeto do tipo Aluno.
     */
    public void alocar(Aluno aluno){
        this.alunos.add(aluno);
    }

    /**
     * Responsavel por imprimir todos os alunos armazenados no
     * grupo.
     *
     * @return uma string no formato: 'Alunos do grupo nomeDoGrupo:\n aluno \n aluno...'
     */
    public String imprimirAlunos(){
        String imprimir = "\nAlunos do grupo " + this.nome + ":\n";
        for (Aluno aluno : this.alunos) {
            imprimir += "* " + aluno.toString() + "\n";
        }

        return imprimir;
    }

    /**
     * Pega o nome do grupo.
     *
     * @return uma string, que representa o nome do grupo
     */
    public String getNome() {
        return nome;
    }

    /**
     * Pega o conjunto de alunos que estão no grupo
     *
     * @return um hashset de Alunos.
     */
    public HashSet<Aluno> getAlunos() {
        return alunos;
    }

    /**
     * Compara se dois grupos são iguais, para eles serem iguais precisam
     * ter os mesmos nomes, independente de minusculo e maiusculo
     *
     * @param o representa o objeto que vai ser comparado
     * @return retorna true, caso sejam iguais e retorna false, caso contrario
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Grupo)) return false;
        Grupo grupo = (Grupo) o;
        return Objects.equals(nome.toUpperCase(), grupo.nome.toUpperCase());
    }

    /**
     * Gera um hashcode de um grupo, ele utiliza o nome do grupo para isso.
     *
     * @return um inteiro, que representa o grupo.
     */
    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
