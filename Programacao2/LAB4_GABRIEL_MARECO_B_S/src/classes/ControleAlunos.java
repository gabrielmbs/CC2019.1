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

    public String cadastraAluno(String matricula, String nome, String curso) {

        if(this.mapaMatriculaAlunos.containsKey(matricula)){
            return "MATRÍCULA JÁ CADASTRADA!";
        }else{
            this.mapaMatriculaAlunos.put(matricula, new Aluno(nome, curso, matricula));
            return "CADASTRO REALIZADO!";
        }

    }

    public String exibirAluno(String matricula) {

        if (this.mapaMatriculaAlunos.containsKey(matricula)){
            return ("\nAluno: " + this.mapaMatriculaAlunos.get(matricula).toString());
        }else{
            return ("\nAluno não cadastrado.");
        }

    }

    public String novoGrupo(String nome) {

        if(this.mapaGrupo.containsKey(nome.toUpperCase())){
            return ("GRUPO JÁ CADASTRADO!");
        }else{
            this.mapaGrupo.put(nome.toUpperCase(), new Grupo(nome));
            return ("CADASTRO REALIZADO!");
        }

    }

    public String alocarAluno(String matricula, String grupo) {

        if (this.mapaGrupo.containsKey(grupo.toUpperCase()) && this.mapaMatriculaAlunos.containsKey(matricula)){

            this.mapaGrupo.get(grupo.toUpperCase()).alocar(this.mapaMatriculaAlunos.get(matricula));
            return ("ALUNO ALOCADO!");

        }else if(!this.mapaGrupo.containsKey(grupo.toUpperCase())){
            return ("Grupo não cadastrado.");
        }else{
            return ("Aluno não cadastrado.");
        }

    }

    public String imprimirGrupo(String grupo) {

        if(this.mapaGrupo.containsKey(grupo.toUpperCase())){
            return ( this.mapaGrupo.get(grupo.toUpperCase()).imprimirAlunos() );
        }else{
            return ("Grupo não cadastrado.");
        }

    }

    public String registrarAlunosResponderam(String matricula) {

        if(this.mapaMatriculaAlunos.containsKey(matricula)){
            this.alunosResponderam.add(this.mapaMatriculaAlunos.get(matricula));
            return ("ALUNO REGISTRADO!");
        }else{
            return ("Aluno não cadastrado.");
        }

    }

    public String imprimirAlunosResponderam() {

        String imprimir = "\nAlunos:\n";
        for (int i = 0; i < this.alunosResponderam.size(); i++) {
            imprimir += (i+1) + ". " + this.alunosResponderam.get(i).toString() + "\n";
        }

        return imprimir;
    }
}
