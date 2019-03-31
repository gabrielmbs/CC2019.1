package lab2;

/**
 * 
 * Representa e gerencia a conta do aluno em uma cantina, como: comprar lanche, pagar divida,
 * historico de compras, quantidade de laches comprados.
 *
 * @author Gabriel Mareco Batista de Souto
 */
public class ContaCantina {

	/**
	 * Nome do estabelecimento da cantina, referente a UFCG.
	 */
	private String nomeDaCantina;

	/**
	 * Total das dividas, desde a primeira compra até ultima. Resumindo é um
	 * historico da divida.
	 */
	private int dividaTotal;

	/**
	 * Quantidade total dos itens comprados no estabelecimento.
	 */
	private int qtdItens;

	/**
	 * Total do que ainda precisa pagar do dividaTotal.
	 */
	private int faltaPagar;

	/**
	 * Constrói uma conta em uma cantina, apartir do nome da cantina. Toda conta
	 * começa com a quantidade de itens comprados zerado e divida zerada.
	 *
	 * @param nomeDaCantina o nome do estabelecimento.
	 */
	public ContaCantina(String nomeDaCantina) {
		this.nomeDaCantina = nomeDaCantina;
		this.qtdItens = 0;
		this.dividaTotal = 0;
		this.faltaPagar = 0;
	}

	/**
	 * Cadastra a compra do lache, feito pelo aluno. Incrementando a valor em sua
	 * divida e salvando a quantidade de itens comprados.
	 * 
	 * @param qtdItens      a quantidade de itens comprados.
	 * @param valorCentavos o valor da compra feita.
	 */
	public void cadastraLanche(int qtdItens, int valorCentavos) {
		this.qtdItens += qtdItens;
		this.dividaTotal += valorCentavos;
		this.faltaPagar += valorCentavos;
	}

	/**
	 * Retira da divida o valor que ele está pagando.
	 * 
	 * @param valorCentavos o valor que ele esta pagando.
	 */
	public void pagaConta(int valorCentavos) {
		this.faltaPagar -= valorCentavos;
		if (this.faltaPagar < 0) {
			this.faltaPagar = 0;
		}
	}

	/**
	 * Imprime a valor que ainda falta pagar da divida.
	 * 
	 * @return um valor, inteiro, do que ainda falta pagar.
	 */
	public int getFaltaPagar() {
		return this.faltaPagar;
	}

	/**
	 * 
	 * Retorna a String que representa a conta feita em uma cantina de um aluno. A
	 * representação segue o formato “NOME DA CANTINA QUANT.ITENS DIVIDA TOTAL”.
	 *
	 * 
	 * @return a representação em String da conta feita em uma cantina de um aluno.
	 */
	public String toString() {
		return this.nomeDaCantina + " " + this.qtdItens + " " + this.dividaTotal;
	}

}
