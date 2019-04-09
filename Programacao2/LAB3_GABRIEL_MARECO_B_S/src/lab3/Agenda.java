package lab3;

import java.util.Arrays;

/**
<<<<<<< HEAD
 * Agenda de contatos, classe onde interage com a classe Contato. Ela será
 * responsavel por armazenar o array de contatos e manipular o array de
 * contatos.
=======
 * Agenda de contatos, classe onde interage com a classe Contato.
 * Ela será responsavel por armazenar o array de contatos
 * e manipular o array de contatos.
>>>>>>> ded18813c34152481774c17c0e09a6ce87041dd6
 *
 * @author Gabriel Mareco Batista de Souto
 */
public class Agenda {
<<<<<<< HEAD
	/**
	 * Array de contatos do tipo contato, onde iremos salvar e manipular.
	 */
	private Contato[] contatos;

	/**
	 * Constroi uma agenda telefonica, com 100 posicoes. Todos os contatos iniciam
	 * como null.
	 *
	 */
	public Agenda() {
		this.contatos = new Contato[100];
	}

	/**
	 * Aqui ele salva, ou seja, cadastra um contato no array de contatos.
	 *
	 * @param posicao   posicao da agenda desejada
	 * @param nome      nome do contato a ser salvo
	 * @param sobreNome sobrenome do contato a ser salvo
	 * @param telefone  telefone do contato a ser salvo
	 *
	 * @return true se cadastrou com sucesso e retorna false se falhou na hora de
	 *         salvar.
	 */
	public boolean cadastrarContato(int posicao, String nome, String sobreNome, String telefone) {
		if (posicao >= 1 && posicao <= 100) {
			this.contatos[posicao - 1] = new Contato(nome, sobreNome, telefone);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Ele procura um contato na agenda e imprime se exitir esse contato. Busca pela
	 * posicao que o usuario ira entrar.
	 *
	 * @param posicao posicao a qual o usuaio deseja exibir.
	 *
	 * @return uma string, caso exista, retorna todas as informacoes do contato, no
	 *         formato 'nome sobrenome - telefone' caso não exista, retorma 'POSICAO
	 *         INVALIDA!'.
	 */
	public String pesquisarContato(int posicao) {
		if ((posicao < 1 || posicao > 100) || (this.contatos[posicao - 1] == null)) {
			return "POSIÇÃO INVÁLIDA!\n";
		} else {
			return "\n" + this.contatos[posicao - 1].toString() + "\n";
		}
	}

	/**
	 * Lista todos os contatos inseridos na agenda.
	 *
	 * @return uma string, no formato, 'posicao - nome sobrenome'
	 */
	public String listarContatos() {
		String listaDeContatos = "\n";
		for (int i = 0; i < this.contatos.length; i++) {
			if (this.contatos[i] != null) {
				listaDeContatos += (i + 1) + " - " + this.contatos[i].exibeNome() + "\n";
			}
		}
		return listaDeContatos;

	}

	/**
	 * Aqui compara se duas agendas são iguais, elas são iguais, se tiverem os
	 * mesmos contatos, nas mesmas posicoes.
	 *
	 * @param o que vai ser comparado.
	 * @return true se forem iguais ou false se forem diferentes
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Agenda agenda = (Agenda) o;
		return Arrays.equals(contatos, agenda.contatos);
	}

	/**
	 * Gera o hashcode da agenda, usuando o array de contatos.
	 *
	 * @return um inteiro, representando o array.
	 */
	@Override
	public int hashCode() {
		return Arrays.hashCode(contatos);
	}
=======
    /**
     * Array de contatos do tipo contato, onde iremos salvar e manipular.
     */
    private Contato[] contatos;

    /**
     * Constroi uma agenda telefonica, com 100 posicoes.
     * Todos os contatos iniciam como null.
     *
     */
    public Agenda() {
        this.contatos = new Contato[100];
    }

    /**
     * Aqui ele salva, ou seja, cadastra um contato no array de contatos.
     *
     * @param posicao posicao da agenda desejada
     * @param nome nome do contato a ser salvo
     * @param sobreNome sobrenome do contato a ser salvo
     * @param telefone telefone do contato a ser salvo
     *
     * @return true se cadastrou com sucesso e retorna false se falhou na hora de salvar.
     */
    public boolean cadastrarContato(int posicao, String nome, String sobreNome, String telefone) {
        if(posicao >= 1 && posicao <= 100) {
            this.contatos[posicao - 1] = new Contato(nome, sobreNome, telefone);
            return true;
        }else{
            return false;
        }
    }

    /**
     * Ele procura um contato na agenda e imprime se exitir esse contato.
     * Busca pela posicao que o usuario ira entrar.
     *
     * @param posicao posicao a qual o usuaio deseja exibir.
     *
     * @return uma string, caso exista, retorna todas as informacoes do contato, no formato 'nome sobrenome - telefone'
     *         caso não exista, retorma 'POSICAO INVALIDA!'.
     */
    public String pesquisarContato(int posicao) {
        if( (posicao < 1 || posicao > 100) || (this.contatos[posicao - 1] == null)){
            return "POSIÇÃO INVÁLIDA!\n";
        }else {
            return "\n" + this.contatos[posicao - 1].toString() + "\n";
        }
    }

    /**
     * Lista todos os contatos inseridos na agenda.
     *
     * @return uma string, no formato, 'posicao - nome sobrenome'
     */
    public String listarContatos() {
        String listaDeContatos = "\n";
        for (int i = 0; i < this.contatos.length; i++) {
            if (this.contatos[i] != null) {
                listaDeContatos += (i+1) + " - " + this.contatos[i].exibeNome() + "\n";
            }
        }
        return listaDeContatos;

    }

    /**
     * Aqui compara se duas agendas são iguais, elas são iguais, se
     * tiverem os mesmos contatos, nas mesmas posicoes.
     *
     * @param o que vai ser comparado.
     * @return true se forem iguais ou false se forem diferentes
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agenda agenda = (Agenda) o;
        return Arrays.equals(contatos, agenda.contatos);
    }

    /**
     * Gera o hashcode da agenda, usuando o array de contatos.
     *
     * @return um inteiro, representando o array.
     */
    @Override
    public int hashCode() {
        return Arrays.hashCode(contatos);
    }
>>>>>>> ded18813c34152481774c17c0e09a6ce87041dd6
}
