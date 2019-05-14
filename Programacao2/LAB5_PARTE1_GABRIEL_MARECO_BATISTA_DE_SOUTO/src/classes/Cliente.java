package classes;

import java.util.Objects;

/**
 * Representa um cliente, ou seja, guarda e opera sobre os dados dos clientes.
 *
 */
public class Cliente {
    /**
     * Representa o nome do cliente
     */
    private String nome;
    /**
     * representa  o email do cliente
     */
    private String email;
    /**
     * representa a localizacao do trabalho do cliente
     */
    private String localizacao;
    /**
     * represena o cpf do cliente.
     */
    private String cpf;

    /**
     * Controe um cliente a partir de seu nome, email, localizacoo e cpf. Lanca excecoes, caso
     * algum parametro passado seja nulo ou vazio.
     *
     * @param nome representa o nome do cliente
     * @param email represnta o email do cliente
     * @param localizacao representa a localiacao do cliente
     * @param cpf representa o cpf do cliente
     */
    public Cliente(String nome, String email, String localizacao, String cpf) {
        if(nome == null){
            throw new NullPointerException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
        }else if("".equals(nome.trim())){
            throw new IllegalArgumentException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
        }
        if(email == null){
            throw new NullPointerException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
        }else if("".equals(email.trim())){
            throw new IllegalArgumentException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
        }
        if(localizacao == null){
            throw new NullPointerException("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
        }else if("".equals(localizacao.trim())){
            throw new IllegalArgumentException("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
        }
        if(cpf == null){
            throw new NullPointerException("Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
        }else if("".equals(cpf.trim())){
            throw new IllegalArgumentException("Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
        }else if(cpf.length() != 11){
            throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
        }
        this.nome = nome;
        this.email = email;
        this.localizacao = localizacao;
        this.cpf = cpf;
    }

    /**
     * Modifica o nome do cliente. E lanca excecoes caso o parametro seja nulo ou vazio.
     *
     * @param nome representa o nome do cliente.
     */
    public void setNome(String nome) {
        if(nome == null){
            throw new NullPointerException("Erro na edicao do cliente: nome nao pode ser vazio ou nulo.");
        }else if("".equals(nome.trim())){
            throw new IllegalArgumentException("Erro na edicao do cliente: nome nao pode ser vazio ou nulo.");
        }
        this.nome = nome;
    }

    /**
     * Modifica o email do cliente. E lanca excecoes caso o parametro seja nulo ou vazio.
     *
     * @param email representa o email do cliente.
     */
    public void setEmail(String email) {
        if(email == null){
            throw new NullPointerException("Erro na edicao do cliente: email nao pode ser vazio ou nulo.");
        }else if("".equals(email.trim())){
            throw new IllegalArgumentException("Erro na edicao do cliente: email nao pode ser vazio ou nulo.");
        }
        this.email = email;
    }

    /**
     * Modifica o localizacao do cliente. E lanca excecoes caso o parametro seja nulo ou vazio.
     *
     * @param localizacao representa o localizacao do cliente.
     */
    public void setLocalizacao(String localizacao) {
        if(localizacao == null){
            throw new NullPointerException("Erro na edicao do cliente: localizacao nao pode ser vazia ou nula.");
        }else if("".equals(localizacao.trim())){
            throw new IllegalArgumentException("Erro na edicao do cliente: localizacao nao pode ser vazia ou nula.");
        }
        this.localizacao = localizacao;
    }

    /**
     * Utilizado apenas nos testes
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     * Utilizado apenas nos testes
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * Utilizado apenas nos testes
     * @return
     */
    public String getLocalizacao() {
        return localizacao;
    }

    /**
     * Utilizado apenas nos testes
     * @return
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * representacao textual do cliente.
     *
     * @return String, no formato "nome - localizacao - email"
     */
    @Override
    public String toString () {
        return this.nome + " - " + this.localizacao + " - " + this.email;
    }

    /**
     * Compara se um objeto é igual um ojeto do tipo Cliente.
     *
     * @param o representa o objeto a ser compaado
     * @return retorna true, caso eles sejam iguais e false, caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cpf, cliente.cpf);
    }

    /**
     * Cria uma representacao inteira de um cliente.
     *
     * @return inteiro, que representa um cliente
     */
    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}
