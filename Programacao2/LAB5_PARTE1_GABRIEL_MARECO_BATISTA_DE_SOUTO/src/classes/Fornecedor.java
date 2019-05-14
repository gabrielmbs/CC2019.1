package classes;

import util.DescritorProduto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * Representa um fornecedor, ou seja, guarda e opera dados do forncedor e controla produto.
 *
 */
public class Fornecedor {
    /**
     * Representa o nome do fornecedor
     */
    private String nome;
    /**
     * Representa o email do fornecedor
     */
    private String email;
    /**
     * Represetna o telefone do forncedor
     */
    private String telefone;
    /**
     * Representa um conjunto de produtos, mapa, a chave é criada a partir de dois parametros.
     */
    private HashMap<DescritorProduto,Produto> listaDeProdutos;

    /**
     * Cria um fornecedor a partir de seu nome, email e telefone. Lanca excecoes caso algum parametro passado seja
     * nulo ou vazio.
     *
     * @param nome represeta o nome do forncedor
     * @param email representa o email do fornecedor
     * @param telefone representa o telefone do fornecedor.
     */
    public Fornecedor(String nome, String email, String telefone) {

        if(nome == null){
            throw new NullPointerException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
        }else if("".equals(nome.trim())){
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
        }
        if(email == null){
            throw new NullPointerException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
        }else if("".equals(email.trim())){
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
        }
        if(telefone == null){
            throw new NullPointerException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
        }else if("".equals(telefone.trim())){
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
        }

        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.listaDeProdutos = new HashMap<>();
    }

    /**
     * Adicina um produto no conjunto de produtos do fornedor. Lanca excecoes caso
     * algum parametro passado seja nulo, vazio.
     *
     * @param nome representa o nome do produto.
     * @param descricao representa a descricao do produto
     * @param preco representa o preco do produto
     * @return retorna true, caso seja adicionado com sucesso e excecao caso nao.
     */
    public boolean adicionaProduto(String nome, String descricao, double preco){
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
        DescritorProduto chave = new DescritorProduto(nome,descricao);
        if(this.listaDeProdutos.containsKey(chave)){
            throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
        }else{
            this.listaDeProdutos.put(chave, new Produto(nome, descricao, preco));
            return true;
        }
    }

    /**
     * Cria uma representacao textual de um dos produtos do conjunto de produtos do fornecedor.
     * E lanca excecoes caso algum parametro passado seja nulo ou vazio.
     *
     * @param nome representa o nome do produto
     * @param descricao representa a descricao do produto
     * @return uma String, que representa o produto.
     */
    public String exibeProduto(String nome, String descricao){
        if(nome == null){
            throw new NullPointerException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
        }else if("".equals(nome.trim())){
            throw new IllegalArgumentException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
        }
        if(descricao == null){
            throw new NullPointerException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
        }else if("".equals(descricao.trim())){
            throw new IllegalArgumentException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
        }

        DescritorProduto chave = new DescritorProduto(nome,descricao);
        if(this.listaDeProdutos.containsKey(chave)){
            return this.listaDeProdutos.get(chave).toString();
        }else{
            throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
        }
    }

    /**
     * Cria um representacao textual de todos os produtos do fornecdor.
     *
     * @return String, que representa todos os produtos
     */
    public String exibeTodosProdutoDeUmFornecedor() {
        ArrayList<String> todosOsProdutos = new ArrayList();
        for (Produto produto : this.listaDeProdutos.values()) {
            todosOsProdutos.add(this.nome + " - " + produto.toString());
        }
        String imprimir = String.join(" | ", todosOsProdutos);
        return imprimir;
    }

    /**
     * Modifica o preco do produto, e lanca excecoes caso algum parametro seja vazio, nulo ou invalido.
     *
     * @param nome representa o nome do produto
     * @param descricao representa a descricao do produto
     * @param novoPreco representa o novo valor do preco.
     * @return retorna true, caso seja modicado com sucesso e excecao caso contrario.
     */
    public boolean editaProduto(String nome, String descricao, double novoPreco){
        if(nome == null){
            throw new NullPointerException("Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
        }else if("".equals(nome.trim())){
            throw new IllegalArgumentException("Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
        }
        if(descricao == null){
            throw new NullPointerException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
        }else if("".equals(descricao.trim())){
            throw new IllegalArgumentException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
        }
        if(novoPreco < 0){
            throw new NullPointerException("Erro na edicao de produto: preco invalido.");
        }

        DescritorProduto chave = new DescritorProduto(nome,descricao);
        if(this.listaDeProdutos.containsKey(chave)){
            this.listaDeProdutos.get(chave).setPreco(novoPreco);
            return true;
        }else{
            throw new IllegalArgumentException("Erro na edicao de produto: produto nao existe.");
        }
    }

    /**
     * Modifica email do fornecedor e lanca excecao caso paramentro passado seja nulo ou vazio.
     *
     * @param email representa o novo valor do email
     */
    public void setEmail(String email) {
        if(email == null){
            throw new NullPointerException("Erro na edicao do fornecedor: email nao pode ser vazio ou nulo.");
        }else if("".equals(email.trim())){
            throw new IllegalArgumentException("Erro na edicao do fornecedor: email nao pode ser vazio ou nulo.");
        }
        this.email = email;
    }

    /**
     * Modifica o telefone do fornecedor e lanca excecao casoo parametro passado seja vazio, nulo.
     *
     * @param telefone representa o novo valor do telefone.
     */
    public void setTelefone(String telefone) {
        if(telefone == null){
            throw new NullPointerException("Erro na edicao do fornecedor: telefone nao pode ser vazio ou nulo.");
        }else if("".equals(telefone.trim())){
            throw new IllegalArgumentException("Erro na edicao do fornecedor: telefone nao pode ser vazio ou nulo.");
        }
        this.telefone = telefone;
    }

    /**
     * Pega nome do fornecedor.
     * Utilizado apenas nos testes
     * @return String, que representa o nome do fornecedor
     */
    public String getNome() {
        return nome;
    }

    /**
     * pega o email do fornecedor
     * Utilizado apenas nos testes
     * @return String, que representa o email do forncedor
     */
    public String getEmail() {
        return email;
    }

    /**
     * pega o telefone do fornecedor
     * Utilizados nos testes
     * @return String, que representa o telefone do forncedor.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * pega o conjuto de produtos do forncedor
     * Utilizado nos testes
     * @return Hashmap, que representa o conjunto de produtos.
     */
    public HashMap<DescritorProduto, Produto> getListaDeProdutos() {
        return listaDeProdutos;
    }

    /**
     * Cria uma representacao textual do forncedor.
     *
     * @return String, que representa o fornecedor.
     */
    @Override
    public String toString () {
        return this.nome + " - " + this.email + " - " + this.telefone;
    }

    /**
     * Compara se um objeto do tipo fornecdor é igual a outro objeto.
     *
     * @param o objeto a ser comparado
     * @return retorna true caso seja iguais e false caso contrarip.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fornecedor that = (Fornecedor) o;
        return Objects.equals(nome, that.nome);
    }

    /**
     * Cria uma representacao inteira do objeto Forncedor.
     * @return inteiro, que representa o forncedor.
     */
    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    /**
     * Remove produto do conjuto e consequetemente do sistema. E lanca excecoes caso algum parametro passado,
     * seja nulo ou vazio.
     *
     * @param nome representa o nome do produto
     * @param descricao representa a descricao do produto
     * @return retorna true, caso seja removido com sucesso e excecao caso contrario.
     */
    public boolean removeProduto(String nome, String descricao) {
        if(nome == null){
            throw new NullPointerException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
        }else if("".equals(nome.trim())){
            throw new IllegalArgumentException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
        }
        if(descricao == null){
            throw new NullPointerException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
        }else if("".equals(descricao.trim())){
            throw new IllegalArgumentException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
        }

        DescritorProduto chave = new DescritorProduto(nome,descricao);
        if(this.listaDeProdutos.containsKey(chave)){
            this.listaDeProdutos.remove(chave);
            return true;
        }else{
            throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
        }
    }
}
