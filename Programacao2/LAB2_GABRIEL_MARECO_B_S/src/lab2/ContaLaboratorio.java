package lab2;

/**
 * Representa e gerencia uma conta em dos LCC's, todo LCC precisa ter uma cota
 * de memória que por padrão é 2000mb. Ela vai ser responsável por manter o
 * registro da quantidade de espaço utilizado,
 * 
 * @author Gabriel Mareco Batista de Souto
 *
 */
public class ContaLaboratorio {

	/**
	 * Representa o nome do laboratorio.
	 */
	private String nomeLaboratorio;
	/**
	 * Quantida de espaço total que o aluno pode utilizar.
	 */
	private int cota;
	/**
	 * Espaço utilizado da conta.
	 */
	private int espacoUsado;

	/**
	 * Constrói uma conta no laboratorio a partir de nome do laboratorio.
	 * 
	 * @param nomeLaboratorio nome do laboratorio.
	 */
	public ContaLaboratorio(String nomeLaboratorio) {
		this(nomeLaboratorio, 2000);
	}

	/**
	 * Constrói uma conta no laboratorio a partir do nome do laboratorio e a
	 * quantidade total de espaço que o aluno pode utilizar. Todo espaço utilizado
	 * pelo aluno, inicia zerado.
	 * 
	 * @param nomeLaboratorio é o nome do laboratorio
	 * @param cota            quantidade total de espaço que pode se utilizar.
	 */
	public ContaLaboratorio(String nomeLaboratorio, int cota) {
		this.nomeLaboratorio = nomeLaboratorio;
		this.cota = cota;
		this.espacoUsado = 0;
	}

	/**
	 * Consume estaço da sua memoria do laboratorio.
	 * 
	 * @param mbytes é a quantidade memorio que vai cosumir do laboratorio.
	 */
	public void consomeEspaco(int mbytes) {
		this.espacoUsado += mbytes;
	}

	/**
	 * Libera espaço da memoria utilizada pelo aluno no laboratorio.
	 * 
	 * @param mbytes é a quantidade de memoria a ser liberada.
	 */
	public void liberaEspaco(int mbytes) {
		this.espacoUsado -= mbytes;
		if (this.espacoUsado < 0) {
			this.espacoUsado = 0;
		}
	}

	/**
	 * Verifica se o aluno já chegou em sua conta no laboratorio.
	 * 
	 * @return um valor boleano, ou seja, verdadeiro ou falso, se o aluno já atingiu
	 *         a conta
	 */
	public boolean atingiuCota() {
		return (this.espacoUsado >= this.cota);
	}

	/**
	 * Retorna a String que representa a conta feita do laboratorio, de um aluno. A
	 * representação segue o formato “NomeDoLaboratorio EspaçoUtilizado/Cota”.
	 *
	 * 
	 * @return a representação em String da conta feita do laboratorio, de um aluno.
	 */
	public String toString() {
		String imprimir = "";
		imprimir += this.nomeLaboratorio + " " + this.espacoUsado + "/" + this.cota;
		return imprimir;
	}

}
