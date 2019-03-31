package lab2;

/**
 * Representa a saude mental e fisica de um aluno. Ela é responsavel por
 * gereciar a saude e dizer se a saude do aluno está fraca, ok ou forte.
 * 
 * @author Gabriel Mareco Batista de Souto
 *
 */
public class Saude {
	/**
	 * Representa a saude mental do aluno. Ela pode ser forte, ok ou fraca.
	 */
	private String saudeMental;
	/**
	 * Representa a saude fisica do aluno. Ela pode ser forte, ok ou fraca.
	 */
	private String saudeFisica;

	/**
	 * Constrói a saude do aluno. A saude mental e fisica, já iniciam como boas por
	 * padrão.
	 */
	public Saude() {
		this.saudeFisica = "boa";
		this.saudeMental = "boa";
	}

	/**
	 * Modifica a saude mental.
	 * 
	 * @param valor representa a saude que o aluno está, podendo ser, forte, fraca
	 *              ou ok.
	 */
	public void defineSaudeMental(String valor) {
		this.saudeMental = valor;
	}

	/**
	 * Modifica a saude fisica.
	 * 
	 * @param valor representa a saude que o aluno está, podendo ser, forte, fraca
	 *              ou ok.
	 */
	public void defineSaudeFisica(String valor) {
		this.saudeFisica = valor;
	}

	/**
	 * Compara as saudes fisica e mental e imprime a saude geral do aluno.
	 * 
	 * @return um valor do tipo String que representa a saude geral do aluno.
	 */
	public String getStatusGeral() {

		if (this.saudeMental.equals("boa") && this.saudeFisica.equals("boa")) {
			return "boa";
		} else if ((this.saudeMental.equals("boa") && this.saudeFisica.equals("fraca"))
				|| (this.saudeMental.equals("fraca") && this.saudeFisica.equals("boa"))) {
			return "ok";
		} else {
			return "fraca";
		}
	}
}
