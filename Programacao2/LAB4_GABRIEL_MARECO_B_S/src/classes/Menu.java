package classes;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        String opcao = "";
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

        }while(!opcao.equals("O"));
    }
}
