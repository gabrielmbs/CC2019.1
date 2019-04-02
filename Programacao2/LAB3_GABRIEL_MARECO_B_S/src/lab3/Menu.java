package lab3;

import java.util.Arrays;
import java.util.Scanner;

public class Menu {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		String entrada = "";
		Contato[] contatos = new Contato[100];
		int[] posicoes = new int[100];
		int contador = 0;

		do {
			System.out.println("(C)adastrar Contato");
			System.out.println("(L)istar Contatos");
			System.out.println("(E)xibir Contato");
			System.out.println("(S)air\n");
			System.out.print("Opção> ");

			entrada = teclado.nextLine();

			if (entrada.equals("C")) {

				System.out.print("Posição: ");
				int posicao = Integer.parseInt(teclado.nextLine());
				if (posicao < 1 || posicao > 100) {
					System.out.println("POSIÇÃO INVÁLIDA!");
					continue;
				}

				System.out.print("Nome: ");
				String nome = teclado.nextLine();
				System.out.print("Sobrenome: ");
				String sobreNome = teclado.nextLine();
				System.out.print("Telefone: ");
				String telefone = teclado.nextLine();
				System.out.println("CADASTRO REALIZADO!");
				
				contatos[posicao] = new Contato(nome, sobreNome, telefone);
				posicoes[contador] = posicao;
				Arrays.sort(posicoes);

			} else if (entrada.equals("L")) {
				
				for(int i = 0; i < contador; i++) {
					System.out.format("%d - %s\n", posicoes[i], contatos[posicoes[i]].exibeNome());
				}

			} else if (entrada.equals("E")) {
				
				System.out.print("Contato> ");
				int posicao = Integer.parseInt(teclado.nextLine());
				String imprimir = contatos[posicao].toString();
				System.out.println(imprimir);

			} else if (entrada.equals("S")) {
				break;
			} else {
				System.out.println("OPÇÃO INVÁLIDA!\n");
			}

		} while (!entrada.equals("S"));
	}
}
