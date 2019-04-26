package classes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ControleAlunos turma = new ControleAlunos();

        String opcao = "";
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

                System.out.println(turma.cadastraAluno(matricula, nome, curso));

            }else if(opcao.equals("E")){

                System.out.print("\nMatrícula: ");
                String matricula = teclado.nextLine();

                System.out.println(turma.exibirAluno(matricula));

            }else if(opcao.equals("N")){

                System.out.print("\nGrupo: ");
                String nome = teclado.nextLine();

                System.out.println(turma.novoGrupo(nome));

            }else if(opcao.equals("A")){

                System.out.print("\n(A)locar Aluno ou (I)mprimir Grupo? ");
                opcao = teclado.nextLine();

                if (opcao.equals("A")) {

                    System.out.print("\nMatricula: ");
                    String matricula = teclado.nextLine();
                    System.out.print("Grupo: ");
                    String grupo = teclado.nextLine();

                    System.out.println(turma.alocarAluno(matricula, grupo));

                } else if (opcao.equals("I")) {

                    System.out.print("\nGrupo: ");
                    String grupo = teclado.nextLine();

                    System.out.println(turma.imprimirGrupo(grupo));

                }

            }else if(opcao.equals("R")){

                System.out.print("\nMatrícula: ");
                String matricula = teclado.nextLine();

                System.out.println(turma.registrarAlunosResponderam(matricula));

            }else if (opcao.equals("I")){

                System.out.println(turma.imprimirAlunosResponderam());

            }

        }while (!opcao.equals("O"));
        teclado.close();

    }
}
