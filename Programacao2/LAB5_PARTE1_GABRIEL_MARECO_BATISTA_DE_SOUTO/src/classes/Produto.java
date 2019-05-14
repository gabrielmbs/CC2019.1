package classes;

import java.util.Objects;

/**
 * Classe que representa um produto, ou seja, guarda e opera sobre os dados do produto.
 *
 */
public class Produto {
    /**
     * Representa o nome o produto
     */
    private String nome;
    /**
     * Representa a descricao do produto
     */
    private String descricao;
    /**
     * Representa o preco do produto
     */
    private double preco;

    /**
     * Constroe um produto a partir de seu nome, descricao e valor. E lanca excecoes caso algum parametro seja
     * nulo, vazio ou invalido.
     *
     * @param nome representa o nome do produto
     * @param descricao representa a descricao do produto
     * @param preco representa o preco do produto
     */
    public Produto(String nome, String descricao, double preco) {
        if(nome == null){
            throw new NullPointerException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
        }else if("".equals(nome.trim())){
            throw new IllegalArgumentException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
        }
        if(descricao == null){
            throw new NullPointerException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
        }else if("".equals(descricao.trim())){
            throw new IllegalArgumentException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
        }
        if(preco < 0){
            throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
        }
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    /**
     * Modifica o preco do produto
     * @param preco represeta o novo preco
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * pega o nome do produto
     * Utilizado apenas nos testes
     * @return string, representa o nome do produto
     */
    public String getNome() {
        return nome;
    }

    /**
     * pega o descricao do produto
     * Utilizado apenas nos testes
     * @return string, representa o descricao do produto
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * pega o preco do produto
     * Utilizado apenas nos testes
     * @return double, representa o preco do produto
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Cria uma representacao textual do produto.
     *
     * @return returna uma string que representa o produto.
     */
    @Override
    public String toString() {
        String resultado = String.format("%.2f", this.preco);
        return this.nome + " - " + this.descricao + " - " +"R$"+ resultado;
    }

    /**
     * Compara dos objetos para ver se  são igauis.
     *
     * @param o objeto a ser comparado.
     * @return retorna true caso seja iguais e retorna false caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(nome, produto.nome) &&
                Objects.equals(descricao, produto.descricao);
    }

    /**
     * Cria uma representacao inteira do obejeto
     * @return inteiro, que representa o produto.
     */
    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao);
    }
}
