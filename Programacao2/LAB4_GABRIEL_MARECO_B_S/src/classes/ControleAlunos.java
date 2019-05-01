package classes;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe controladora, ela é responsavel por guardar e manipular as clases, utilizada pela Main.
 *
 * @author Gabriel Mareco Batista de Souto
 */
public class ControleAlunos {
    /**
     * Um HashMap, representa o mapa, onde a chave é a matricula e o valor o associado Aluno.
     */
    private HashMap<String, Aluno> mapaMatriculaAlunos;
    /**
     * Um HashMap, representa um mapa de grupo, onde a chave é o nome do grupo e o valor é o grupo.
     */
    private HashMap<String, Grupo> mapaGrupo;
    /**
     * Um array de alunos, representa os alunos que respodneram no quadro. É utilizado pois
     * a ordem importa e pode repetir os alunos que responderam,
     */
    private ArrayList<Aluno> alunosResponderam;

    /**
     * Constroi um Controle de alunos e inicializa os HashMaps e o ArrayList.
     */
    public ControleAlunos() {
        this.mapaMatriculaAlunos = new HashMap<>();
        this.mapaGrupo = new HashMap<>();
        this.alunosResponderam = new ArrayList<>();
    }

    /**
     * Ele cadastra um aluno no controle dos alunos, para poder ser utilizado pelos demais metodos.
     * Ele adiciona o aluno no HashMap 'mapaMatriculaAluno'. Ele também retorna NullPointerException,
     * caso a matricula seja nula ou retorna illegalArgumentException, caso seja vazia, pois não faz
     * sentido continuar programa com esses valores.
     *
     * @param matricula representa a matricula do aluno, do tipo String
     * @param nome representa o nome do aluno, do tipo String
     * @param curso representa o curso do aluno, do tipo String
     * @return retorna false, caso o aluno já esteja cadastrado e retorna true, caso contrario.
     */
    public boolean cadastraAluno(String matricula, String nome, String curso) {

        if(matricula == null){
            throw new NullPointerException("MATRÍCULA NULA");
        }else if(matricula.trim().equals("")){
            throw new IllegalArgumentException("MATRÍCULA VAZIA");
        }

        if(this.mapaMatriculaAlunos.containsKey(matricula)){
            return false;
        }else{
            this.mapaMatriculaAlunos.put(matricula, new Aluno(nome, curso, matricula));
            return true;
        }

    }

    /**
     * Aqui ele exibe um aluno que já esteja cadastrado no controle.
     * Ele também retorna NullPointerException, caso a matricula seja nula ou
     * retorna illegalArgumentException, caso seja vazia, pois não faz
     * sentido continuar programa com esses valores.
     *
     * @param matricula representa a matricula do aluno.
     * @return retorna o aluno caso ele esteja cadastrado, no formato, 'Aluno: matricula - nome - curso'
     *        E retorna 'Aluno não cadastrado, caso ele não esteja cadastrado.
     */
    public String exibirAluno(String matricula) {

        if(matricula == null){
            throw new NullPointerException("MATRÍCULA NULA");
        }else if(matricula.trim().equals("")){
            throw new IllegalArgumentException("MATRÍCULA VAZIA");
        }

        if (this.mapaMatriculaAlunos.containsKey(matricula)){
            return ("\nAluno: " + this.mapaMatriculaAlunos.get(matricula).toString());
        }else{
            return ("\nAluno não cadastrado.");
        }

    }

    /**
     * Aqui ele cria um grupo novo, ou seja, adiciona a 'mapagrupo' um grupo novo.
     *
     * @param nome representa o nove do Grupo
     * @return retorna false caso o grupo já esteja e retona true, quando cadastra com sucesso.
     *
     */
    public boolean novoGrupo(String nome) {

        if(nome == null){
            throw new NullPointerException("GRUPO NULO");
        }else if(nome.trim().equals("")){
            throw new IllegalArgumentException("GRUPO VAZIO");
        }

        if(this.mapaGrupo.containsKey(nome.toUpperCase())){
            return (false);
        }else{
            this.mapaGrupo.put(nome.toUpperCase(), new Grupo(nome));
            return (true);
        }

    }

    /**
     * Aqui ele aloca um aluno que esteja cadastrado no controle, para um
     * grupo que esteja cadastrado no controle. É utilizado um tipo criado por mim, para manter
     * o encasulamento, pois precisa retorna tres valores booleanos.
     * Ele também retorna NullPointerException, caso a matricula ou grupo, seja nula ou
     * retorna illegalArgumentException, caso seja vazia, pois não faz
     * sentido continuar programa com esses valores.
     *
     * @param matricula representa a matricula do aluno que vai ser alocado.
     * @param grupo representa o grupo, o qual o aluno vai entrar
     * @return retorna StatusCadastro.Sucesso, caso o aluno seja alocado com sucesso
     *         retorna StatusCadastro.SemGrupo, caso o grupo passado não esteja cadastrado.
     *         retorna StatusCadastro.AlunoNaoCadastrado, caso o aluno não esteja cadastrado no controle.
     *
     */
    public StatusCadastro alocarAluno(String matricula, String grupo) {

        if(matricula == null){
            throw new NullPointerException("MATRÍCULA NULA");
        }else if(matricula.trim().equals("")){
            throw new IllegalArgumentException("MATRÍCULA VAZIA");
        }

        if(grupo == null){
            throw new NullPointerException("GRUPO NULO");
        }else if(grupo.trim().equals("")){
            throw new IllegalArgumentException("GRUPO VAZIO");
        }

        if (this.mapaGrupo.containsKey(grupo.toUpperCase()) && this.mapaMatriculaAlunos.containsKey(matricula)){

            this.mapaGrupo.get(grupo.toUpperCase()).alocar(this.mapaMatriculaAlunos.get(matricula));
            return (StatusCadastro.Sucesso);

        }else if(!this.mapaGrupo.containsKey(grupo.toUpperCase())){

            return (StatusCadastro.SemGrupo);

        }else{

            return (StatusCadastro.AlunoNaoCadastrado);
        }

    }

    /**
     * Responsavel por imprimir as informçoes de um grupo, ou seja, nome e alunos que nele estão.
     * Ele também retorna NullPointerException, caso o grupo, seja nulo ou
     * retorna illegalArgumentException, caso seja vazio, pois não faz
     * sentido continuar programa com esses valores.
     *
     * @param grupo nome que representa o grupo a ser impresso.
     * @return retona um string no formato, "Alunos do grupo NomeDoGrupo:\n aluno\n aluno...'
     *         retorna 'Grupo não cadastrado, caso o grupo não esteja no controle.
     *
     */
    public String imprimirGrupo(String grupo) {

        if(grupo == null){
            throw new NullPointerException("GRUPO NULO");
        }else if(grupo.trim().equals("")){
            throw new IllegalArgumentException("GRUPO VAZIO");
        }

        if(this.mapaGrupo.containsKey(grupo.toUpperCase())){
            return ( this.mapaGrupo.get(grupo.toUpperCase()).imprimirAlunos() );
        }else{
            return ("Grupo não cadastrado.");
        }

    }

    /**
     * Ele adiciona um aluno no ArrayList alunosResponderam,mantendo a ordem
     * que foi inserido. Ele também retorna NullPointerException, caso a matricula, seja nula ou
     * retorna illegalArgumentException, caso seja vazia, pois não faz
     * sentido continuar programa com esses valores.
     *
     * @param matricula representa a matricula do aluno que vai ser registrado.
     * @return retorna true caso aluno seja registrado com sucesso.
     *         retorna false caso o aluno não esteja no controle.
     */
    public boolean registrarAlunosResponderam(String matricula) {

        if(matricula == null){
            throw new NullPointerException("MATRÍCULA NULA");
        }else if(matricula.trim().equals("")){
            throw new IllegalArgumentException("MATRÍCULA VAZIA");
        }

        if(this.mapaMatriculaAlunos.containsKey(matricula)){
            this.alunosResponderam.add(this.mapaMatriculaAlunos.get(matricula));
            return (true);
        }else{
            return (false);
        }

    }

    /**
     * Ele imprime todos alunos que respondeu no quadro,mantendo a ordem
     * de quem respodeu primeiro até o ultimo. Ele utiliza o ArrayList para isso.
     *
     * @return retorna todos os alunos que respoderam, no formato:
     * 'Alunos:\n 1. aluno\n 2. aluno\n ...'
     */
    public String imprimirAlunosResponderam() {

        String imprimir = "\nAlunos:\n";
        for (int i = 0; i < this.alunosResponderam.size(); i++) {
            imprimir += (i+1) + ". " + this.alunosResponderam.get(i).toString() + "\n";
        }

        return imprimir;
    }

    /**
     * Responsavel por pegar o HashMap mapaMatriculaAlunos
     * utilizado nos testes.
     * @return o HashMap mapaMatriculaAlunos
     */
    public HashMap<String, Aluno> getMapaMatriculaAlunos() {
        return mapaMatriculaAlunos;
    }

    /**
     * Responsavel por pegar o HashMap mapaGrupo
     * utilizado nos testes.
     * @return o HashMap mapaGrupo
     */
    public HashMap<String, Grupo> getMapaGrupo() {
        return mapaGrupo;
    }

    /**
     * Responsavel por pegar o ArrayList alunosResponderam
     * utilizado nos testes.
     * @return o HashMap alunosResponderam
     */
    public ArrayList<Aluno> getAlunosResponderam() {
        return alunosResponderam;
    }
}
