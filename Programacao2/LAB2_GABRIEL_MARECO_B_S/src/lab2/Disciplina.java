package lab2;

import java.util.Arrays;

/**
 * Representa e gerencia as disciplinas de um aluno. Ela vai ser responsavel por
 * administrar os horarios de estudo do aluno e as notas da disciplina.
 * 
 * @author Gabriel Mareco Batista de Souto
 *
 */
public class Disciplina {
	/**
	 * Representa o nome da disciplina
	 */
	private String nomeDisciplina;
	/**
	 * Quantidade de horas estudadas.
	 */
	private int horas;
	/**
	 * Representa as quatro notas do aluno.
	 */
	private double[] notas;

	/**
	 * Constrói uma disciplina a partir do nome da disciplina. A quantidade de horas
	 * estudada começa zerada e quantidade de notas são 4(quatro).
	 * 
	 * @param nomeDisciplina representa o nome da discplina a ser construida
	 */
	public Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
		this.horas = 0;
		this.notas = new double[4];
	}

	/**
	 * Ele registra a quantidade horas estudada pelo aluno.
	 * 
	 * @param horas quantidade de horas estudada
	 */
	public void cadastraHoras(int horas) {
		this.horas += horas;
	}

	/**
	 * Ele registra a nota em um array de quatro posiçoes, em que cada posição é uma
	 * nota.
	 * 
	 * @param nota representa a posição da nota no array.
	 * @param valorNota representa o valor da nota a ser adicionado no array
	 */
	public void cadastraNota(int nota, double valorNota) {
		this.notas[nota - 1] = valorNota;
	}
	
	/**
	 * Calcula a media das 4(quatro) notas do aluno.
	 * 
	 * @return um valor do tipo double que representa a media das notas.
	 */
	private double media() {
		double soma = 0;

		for (int i = 0; i < 4; i++) {
			soma += notas[i];
		}
		return (soma / 4.0);
	}
	
	/**
	 * Verifica se o aluno foi aprovado ou não.
	 * 
	 * @return um valor do tipo boleano, verdadeiro ou falso, que representa se aluno passou ou não.
	 */
	public boolean aprovado() {
		return media() >= 7.0;
	}
	
	/**
	 * Retorna a String que representa a disciplina de um aluno. A
	 * representação segue o formato “Nome da disciplina  horas estudadas  media das notas  o array das notas”.
	 *
	 * 
	 * @return a representação em String da disciplina de um aluno.
	 */
	public String toString() {
		return this.nomeDisciplina + " " + this.horas + " " + media() + " " + Arrays.toString(notas);
	}
}
