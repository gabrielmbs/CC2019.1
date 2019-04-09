package lab3;

import java.util.Scanner;

/**
 * Classe principal, onde vai se chamar todas as outras classes, aqui mostra o
 * menu do sistema da agenda. Aqui está a Main do programa.
 *
 * @author Gabriel Mareco Batista de Souto
 */
public class Menu {

	/**
	 * Criado para organizar o codigo, para deixar a main mais legivel, esse metodo
	 * cadastra um contato na agenda.
	 *
	 * @param teclado onde o usuario ira interagir.
	 * @param agenda  objeto do tipo Agenda, para salvar o contato
	 * @param posicao utilizado para salvar o contato na posicao desejada na agenda.
	 */
	public static void cadastrar(Scanner teclado, Agenda agenda, int posicao) {
		System.out.print("Nome: ");
		String nome = teclado.nextLine();
		System.out.print("Sobrenome: ");
		String sobreNome = teclado.nextLine();
		System.out.print("Telefone: ");
		String telefone = teclado.nextLine();

		agenda.cadastrarContato(posicao, nome, sobreNome, telefone);
		System.out.println("CADASTRO REALIZADO!\n");

	}

	/**
	 * Lista os contatos de agenda, criado para deixar mais organizado o codigo.
	 *
	 * @param agenda a genda a qual vai ser listada.
	 */
	public static void listar(Agenda agenda) {
		System.out.println(agenda.listarContatos());
	}

	/**
	 * Exibi um contato da posicao desejada pelo usuario
	 *
	 * @param teclado onde o usuario vai entrar a posicao
	 * @param agenda  agenda em que está os contatos.
	 */
	public static void exibir(Scanner teclado, Agenda agenda) {
		System.out.print("Contato> ");
		int posicao = Integer.parseInt(teclado.nextLine());
		System.out.println(agenda.pesquisarContato(posicao));
	}

	/**
	 * Main principal...
	 *
	 * @param args é uma forma do “mundo externo” comunicar-se com sua aplicacao
	 *             atraves de argumentos.
	 * 
	 */
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		String entrada;
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
				cadastrar(teclado, agenda, posicao);

			} else if (entrada.equals("L")) {

				listar(agenda);

			} else if (entrada.equals("E")) {

				exibir(teclado, agenda);

			} else if (entrada.equals("S")) {

				break;

			} else {

				System.out.println("OPÇÃO INVÁLIDA!\n");

			}

		} while (!entrada.equals("S"));
	}
}
