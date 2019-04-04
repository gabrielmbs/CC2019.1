package lab3;

public class Agenda {
	Contato[] contatos;

	public Agenda() {
		this.contatos = new Contato[100];
	}

	public void cadastrarContato(int posicao, String nome, String sobreNome, String telefone) {
		this.contatos[posicao - 1] = new Contato(nome, sobreNome, telefone);
	}

	public String pesquisarContato(int posicao) {
		return "\n" + this.contatos[posicao - 1].toString() + "\n";
	}

	public void listarContatos() {
		System.out.println("");
		for (int i = 0; i < contatos.length; i++) {
			if (this.contatos[i] != null) {
				System.out.println(i + " - " + this.contatos[i].exibeNome());
			}
		}
		System.out.println("");
	}
}
