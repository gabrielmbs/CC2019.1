package lab3;

import java.util.Scanner;

public class Menu {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		String entrada = "";
		Agenda agenda = new Agenda();

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

				agenda.cadastrarContato(posicao, nome, sobreNome, telefone);

			} else if (entrada.equals("L")) {

				agenda.listarContatos();

			} else if (entrada.equals("E")) {

				System.out.print("Contato> ");
				int posicao = Integer.parseInt(teclado.nextLine());
				System.out.println(agenda.pesquisarContato(posicao));

			} else if (entrada.equals("S")) {

				break;

			} else {

				System.out.println("OPÇÃO INVÁLIDA!\n");

			}

		} while (!entrada.equals("S"));
	}
}
