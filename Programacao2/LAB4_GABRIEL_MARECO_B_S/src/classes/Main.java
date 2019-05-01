package classes;

import java.util.Scanner;

/**
 * Classe main, responsavel por interagir com o usuario, através das entradas e saidas.
 *
 * @author Gabriel Mareco Batista de Souto
 */
public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ControleAlunos turma = new ControleAlunos();

        String opcao;
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

            switch (opcao) {
                case "C": {

                    System.out.print("\nMatrícula: ");
                    String matricula = teclado.nextLine();

                    System.out.print("Nome: ");
                    String nome = teclado.nextLine();

                    System.out.print("Curso: ");
                    String curso = teclado.nextLine();

                    if(turma.cadastraAluno(matricula, nome, curso)){
                        System.out.println("CADASTRO REALIZADO!");
                    }else{
                        System.out.println("MATRÍCULA JÁ CADASTRADA!");
                    }

                    break;
                }
                case "E": {

                    System.out.print("\nMatrícula: ");
                    String matricula = teclado.nextLine();

                    System.out.println(turma.exibirAluno(matricula));

                    break;
                }
                case "N": {

                    System.out.print("\nGrupo: ");
                    String nome = teclado.nextLine();

                    if(turma.novoGrupo(nome)){
                        System.out.println("CADASTRO REALIZADO!");
                    }else{
                        System.out.println("GRUPO JÁ CADASTRADO!");
                    }

                    break;
                }
                case "A":

                    System.out.print("\n(A)locar Aluno ou (I)mprimir Grupo? ");
                    opcao = teclado.nextLine();

                    if (opcao.equals("A")) {

                        System.out.print("\nMatricula: ");
                        String matricula = teclado.nextLine();

                        System.out.print("Grupo: ");
                        String grupo = teclado.nextLine();

                        StatusCadastro resultado = turma.alocarAluno(matricula, grupo);
                        if (resultado.equals(StatusCadastro.Sucesso)){
                            System.out.println("ALUNO ALOCADO!");
                        }else  if(resultado.equals(StatusCadastro.SemGrupo)){
                            System.out.println("Grupo não cadastrado.");
                        }else{
                            System.out.println("Aluno não cadastrado.");
                        }

                    } else if (opcao.equals("I")) {

                        System.out.print("\nGrupo: ");
                        String grupo = teclado.nextLine();

                        System.out.println(turma.imprimirGrupo(grupo));

                    }

                    break;
                case "R": {

                    System.out.print("\nMatrícula: ");
                    String matricula = teclado.nextLine();

                    if(turma.registrarAlunosResponderam(matricula)){
                        System.out.println("ALUNO REGISTRADO!");
                    }else{
                        System.out.println("Aluno não cadastrado.");
                    }

                    break;
                }
                case "I":

                    System.out.println(turma.imprimirAlunosResponderam());

                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        }while (!opcao.equals("O"));
        teclado.close();

    }
}
