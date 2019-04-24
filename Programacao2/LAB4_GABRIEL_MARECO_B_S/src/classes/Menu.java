package classes;

import java.util.HashMap;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        String opcao = "";
        String matricula, nome, curso;
        HashMap<String, String> mapaMatriculaAlunos = new HashMap<>();
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
                matricula = teclado.nextLine();
                System.out.print("Nome: ");
                nome = teclado.nextLine();
                System.out.print("Curso: ");
                curso = teclado.nextLine();

                if(mapaMatriculaAlunos.containsKey(matricula)){
                    System.out.println("MATRÍCULA JÁ CADASTRADA!");
                }else{
                    mapaMatriculaAlunos.put(matricula, (nome + " - " + curso) );
                    System.out.println("CADASTRO REALIZADO!");
                }


            }else if(opcao.equals("E")){
                System.out.print("\nMatrícula: ");
                matricula = teclado.nextLine();

                if (mapaMatriculaAlunos.containsKey(matricula)){
                    String aluno = matricula + " - " + mapaMatriculaAlunos.get(matricula);
                    System.out.println("\nAluno: " + aluno);
                }else{
                    System.out.println("\nAluno não cadastrado.");
                }

            }


        }while(!opcao.equals("O"));
        teclado.close();
    }
}
