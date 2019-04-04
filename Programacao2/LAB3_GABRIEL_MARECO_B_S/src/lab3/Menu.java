package lab3;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Menu {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		String entrada = "";
		Contato[] contatos = new Contato[101];
		List<Integer> posicoes = new ArrayList<Integer>();

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
				System.out.println("CADASTRO REALIZADO!\n");
				
				contatos[posicao] = new Contato(nome, sobreNome, telefone);
				posicoes.add(posicao);
				Collections.sort(posicoes);

			} else if (entrada.equals("L")) {
				System.out.println("");
				for(int i = 0; i < posicoes.size(); i++) {
					System.out.println(posicoes.get(i) + " - " + contatos[posicoes.get(i)].exibeNome());
				}
				System.out.println("");
			} else if (entrada.equals("E")) {
				
				System.out.print("Contato> ");
				int posicao = Integer.parseInt(teclado.nextLine());
				String imprimir = contatos[posicao].toString();
				System.out.println("\n" + imprimir + "\n");

			} else if (entrada.equals("S")) {
				break;
				
			} else {
				System.out.println("OPÇÃO INVÁLIDA!\n");
			}

		} while (!entrada.equals("S"));
	}
}
