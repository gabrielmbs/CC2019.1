package classes;

import java.util.HashMap;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        String opcao = "";
        HashMap<String, Aluno> mapaMatriculaAlunos = new HashMap<>();
        HashMap<String, Grupo> mapaGrupo = new HashMap<>();
        Scanner teclado = new Scanner(System.in);

        do{

            System.out.println("\n(C)adastrar Aluno");
            System.out.println("(E)xibir Aluno");
            System.out.println("(N)ovo Grupo");
            System.out.println("(A)locar Aluno no Grupo e Imprimir Grupos");
            System.out.println("(R)egistrar Aluno que Respondeu");
            System.out.println("(I)mprimir Alunos que Responderam");
            System.out.println("(O)ra, vamos fechar o programa!");
            System.out.print("\n\nOpção> ");

            opcao = teclado.nextLine();

            if(opcao.equals("C")){

                System.out.print("\nMatrícula: ");
                String matricula = teclado.nextLine();
                System.out.print("Nome: ");
                String nome = teclado.nextLine();
                System.out.print("Curso: ");
                String curso = teclado.nextLine();

                if(mapaMatriculaAlunos.containsKey(matricula)){
                    System.out.println("MATRÍCULA JÁ CADASTRADA!");
                }else{
                    mapaMatriculaAlunos.put(matricula, new Aluno(nome, curso, matricula));
                    System.out.println("CADASTRO REALIZADO!");
                }


            }else if(opcao.equals("E")){
                System.out.print("\nMatrícula: ");
                String matricula = teclado.nextLine();

                if (mapaMatriculaAlunos.containsKey(matricula)){
                    System.out.println("\nAluno: " + mapaMatriculaAlunos.get(matricula).toString());
                }else{
                    System.out.println("\nAluno não cadastrado.");
                }

            }else if(opcao.equals("N")){
                System.out.print("\nGrupo: ");
                String nome = teclado.nextLine();

                if(mapaGrupo.containsKey(nome.toUpperCase())){
                    System.out.println("GRUPO JÁ CADASTRADO!");
                }else{
                    mapaGrupo.put(nome.toUpperCase(), new Grupo(nome));
                    System.out.println("CADASTRO REALIZADO!");
                }

            }else if(opcao.equals("A")){
                System.out.print("\n(A)locar Aluno ou (I)mprimir Grupo? ");
                opcao = teclado.nextLine();
                if(opcao.equals("A")){
                    System.out.print("\nMatricula: ");
                    String matricula = teclado.nextLine();
                    System.out.print("Grupo: ");
                    String grupo = teclado.nextLine();
                    if (mapaGrupo.containsKey(grupo.toUpperCase()) && mapaMatriculaAlunos.containsKey(matricula)){
                        mapaGrupo.get(grupo.toUpperCase()).alocar(mapaMatriculaAlunos.get(matricula));
                        System.out.println("ALUNO ALOCADO!");

                    }else if(!mapaGrupo.containsKey(grupo.toUpperCase())){
                        System.out.println("Grupo não cadastrado.");
                    }else{
                        System.out.println("Aluno não cadastrado.");
                    }

                }else if(opcao.equals("I")){
                    System.out.print("\nGrupo: ");
                    String grupo = teclado.nextLine();
                    if(mapaGrupo.containsKey(grupo.toUpperCase())){
                        mapaGrupo.get(grupo.toUpperCase()).imprimirAlunos();
                    }
                }
            }


        }while(!opcao.equals("O"));
        teclado.close();
    }
}
