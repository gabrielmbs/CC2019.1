package classes;

import java.util.ArrayList;
import java.util.HashMap;

public class ControleAlunos {
    private HashMap<String, Aluno> mapaMatriculaAlunos;
    private HashMap<String, Grupo> mapaGrupo;
    private ArrayList<Aluno> alunosResponderam;

    public ControleAlunos() {
        this.mapaMatriculaAlunos = new HashMap<>();
        this.mapaGrupo = new HashMap<>();
        this.alunosResponderam = new ArrayList<>();
    }

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

    public String imprimirAlunosResponderam() {

        String imprimir = "\nAlunos:\n";
        for (int i = 0; i < this.alunosResponderam.size(); i++) {
            imprimir += (i+1) + ". " + this.alunosResponderam.get(i).toString() + "\n";
        }

        return imprimir;
    }

    public HashMap<String, Aluno> getMapaMatriculaAlunos() {
        return mapaMatriculaAlunos;
    }

    public HashMap<String, Grupo> getMapaGrupo() {
        return mapaGrupo;
    }

    public ArrayList<Aluno> getAlunosResponderam() {
        return alunosResponderam;
    }
}
