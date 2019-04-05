package lab3;

public class Contato {
	private String nome;
	private String sobreNome;
	private String telefone;

	public Contato(String nome, String sobreNome, String telefone) {
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.telefone = telefone;
	}
	
	public String exibeNome() {
		return this.nome + " " + this.sobreNome;
	}

	@Override
	public String toString() {
		return this.nome + " " + this.sobreNome + " " + "-" + " " + this.telefone;
	}
}
