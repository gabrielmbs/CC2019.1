package lab3;

import java.util.Objects;

/**
<<<<<<< HEAD
 * Representa o contato, onde vai guardar todas informções do contato E ira
 * pegar todas as informacoes de um contato, quando agenda precisar.
=======
 * Representa o contato, onde vai guardar todas informções do contato
 * E ira pegar todas as informacoes de um contato, quando agenda precisar.
>>>>>>> ded18813c34152481774c17c0e09a6ce87041dd6
 *
 * @author Gabriel Mareco Batista de Souto
 */
public class Contato {
<<<<<<< HEAD
	/**
	 * Representa o nome do contato
	 */
	private String nome;
	/**
	 * Representa o sobrenome do contato.
	 */
	private String sobreNome;
	/**
	 * Representa o telefone do contato.
	 */
	private String telefone;

	/**
	 * Constroi um contato apartir do nome, sobrenome e telefone de um contato.
	 * Retona NullPointerException caso algum parametro seja passado nulo e retorna
	 * IllegalArgumentException caso o parametro passado seja vazio
	 *
	 * @param nome      nome do contato
	 * @param sobreNome sobrenome do contato
	 * @param telefone  telefone do contato
	 */
	public Contato(String nome, String sobreNome, String telefone) {
		if (nome == null) {
			throw new NullPointerException("Nome nulo");
=======
    /**
     * Representa o nome do contato
     */
    private String nome;
    /**
     * Representa o sobrenome do contato.
     */
    private String sobreNome;
    /**
     * Representa o telefone do contato.
     */
    private String telefone;

    /**
     * Constroi um contato apartir do nome, sobrenome e telefone de um contato.
     *
     * @param nome nome do contato
     * @param sobreNome sobrenome do contato
     * @param telefone telefone do contato
     */
    public Contato(String nome, String sobreNome, String telefone) {
        if (nome == null) {
            throw new NullPointerException("Nome nulo");
>>>>>>> ded18813c34152481774c17c0e09a6ce87041dd6

		} else if (nome.trim().equals("")) {
			throw new IllegalArgumentException("Nome vazio");
		}
		if (sobreNome == null) {
			throw new NullPointerException("Sobrenome nulo");

		} else if (sobreNome.trim().equals("")) {
			throw new IllegalArgumentException("Sobrenome vazio");
		}
		if (telefone == null) {
			throw new NullPointerException("Telefone nulo");

		} else if (telefone.trim().equals("")) {
			throw new IllegalArgumentException("Telefone vazio");
		}
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.telefone = telefone;
	}

<<<<<<< HEAD
	/**
	 * Ele pega o nome do contato, foi utilizado para testar o construtor.
	 *
	 * @return uma string, que representa o nome do contato.
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Ele pega o sobrenome do contato, foi utilizado para testar o construtor.
	 *
	 * @return uma string, que representa o sobrenome do contato.
	 */
	public String getSobreNome() {
		return this.sobreNome;
	}

	/**
	 * Ele pega o telefone do contato, foi utilizado para testar o construtor.
	 *
	 * @return uma string, que representa o telefone do contato.
	 */
	public String getTelefone() {
		return this.telefone;
	}

	/**
	 * Aqui ele exibe o nome de um contato, utilizado quando agenda pede para listar
	 * os contato.
	 *
	 * @return uma string, no formato 'nome sobrenome'
	 */
	public String exibeNome() {
		return this.nome + " " + this.sobreNome;
	}

	/**
	 * Ele retorna uma representacao textual do contato, ou seja, mostra todas as
	 * informacoes de um contato. Utilizada quando agenda pede para exibir um
	 * contato.
	 *
	 * @return uma string, no formato 'nome sobrenome - telefone'
	 */
	@Override
	public String toString() {
		return this.nome + " " + this.sobreNome + " " + "-" + " " + this.telefone;
	}

	/**
	 * Compara se todos contatos são iguais, para eles serem iguais precisam ter os
	 * mesmos nomes e sobrenomes.
	 *
	 * @param o objeto que vai ser comparado.
	 * @return retorna true, se forem igais, caso contrario, retorna false.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Contato contato = (Contato) o;
		return Objects.equals(nome, contato.nome) && Objects.equals(sobreNome, contato.sobreNome);
	}

	/**
	 * Gera um hashCode de um contato, ele utiliza o nome e sobrenome do contato
	 * para isso.
	 *
	 * @return um inteiro, que representa o contato.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(nome, sobreNome);
	}
=======
    /**
     * Ele pega o nome do contato, foi utilizado para testar o construtor.
     *
     * @return uma string, que representa o nome do contato.
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Ele pega o sobrenome do contato, foi utilizado para testar o construtor.
     *
     * @return uma string, que representa o sobrenome do contato.
     */
    public String getSobreNome() {
        return this.sobreNome;
    }

    /**
     * Ele pega o telefone do contato, foi utilizado para testar o construtor.
     *
     * @return uma string, que representa o telefone do contato.
     */
    public String getTelefone() {
        return this.telefone;
    }

    /**
     * Aqui ele exibe o nome de um contato, utilizado quando agenda pede para listar os contato.
     *
     * @return uma string, no formato 'nome sobrenome'
     */
    public String exibeNome() {
        return this.nome + " " + this.sobreNome;
    }

    /**
     * Ele retorna uma representacao textual do contato, ou seja, mostra todas as informacoes
     * de um contato. Utilizada quando  agenda pede para exibir um contato.
     *
     * @return uma string, no formato 'nome sobrenome - telefone'
     */
    @Override
    public String toString() {
        return this.nome + " " + this.sobreNome + " " + "-" + " " + this.telefone;
    }

    /**
     * Compara se todos contatos são iguais, para eles serem iguais precisam ter
     * os mesmos nomes e sobrenomes.
     *
     * @param o objeto que vai ser comparado.
     * @return retorna true, se forem igais, caso contrario, retorna false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return Objects.equals(nome, contato.nome) &&
                Objects.equals(sobreNome, contato.sobreNome);
    }

    /**
     * Gera um hashCode de um contato, ele utiliza o nome e sobrenome do contato para isso.
     *
     * @return um inteiro, que representa o contato.
     */
    @Override
    public int hashCode() {
        return Objects.hash(nome, sobreNome);
    }
>>>>>>> ded18813c34152481774c17c0e09a6ce87041dd6
}
