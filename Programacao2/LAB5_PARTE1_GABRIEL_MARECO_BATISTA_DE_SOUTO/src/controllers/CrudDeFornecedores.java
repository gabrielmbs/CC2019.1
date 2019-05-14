package controllers;

import classes.Fornecedor;

import java.util.ArrayList;
import java.util.HashMap;

public class CrudDeFornecedores {
    /**
     * Representa um conjunto de fornecedores. Hashmap, com chave que representa nome do fornecedores.
     */
    private HashMap<String, Fornecedor> mapaNomeFornecedor;

    /**
     * Constroe um controlador de fornecedroes. Apenas inicia o hashmap
     */
    public CrudDeFornecedores() {
        this.mapaNomeFornecedor = new HashMap<>();
    }

    /**
     * Adiciona um forncedor no sistema, ou seja, adiciona no hashmap de Forneedores.
     * E retorna uma excecoes caso, algum parametro seja nulo ou vazio.
     *
     * @param nome representa o nome do fornecedor
     * @param email representa o email do fornecedor
     * @param telefone representa o telefonedo fornecedor
     * @return retorna caso sucesso o nome do fornecedor.
     */
    public String cadastraFornecedor(String nome, String email, String telefone){
        if(nome == null){
            throw new NullPointerException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
        }else if("".equals(nome.trim())){
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
        }

        if(this.mapaNomeFornecedor.containsKey(nome)){
            throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
        }else{
            this.mapaNomeFornecedor.put(nome, new Fornecedor(nome, email, telefone));
            return nome;
        }
    }

    /**
     * Exibe uma representacao textual do fornecedor. No formato, "nome - email - numero".
     *
     * @param nome representa o nome do fornecedor e a chave do hashmap.
     * @return retorna a represetacao textual de um fornecedor.
     */
    public String exibeFornecedor(String nome){
        if(nome == null){
            throw new NullPointerException("Erro na exibicao do fornecedor: nome nao pode ser vazio ou nulo.");
        }else if("".equals(nome.trim())){
            throw new IllegalArgumentException("Erro na exibicao do fornecedor: nome nao pode ser vazio ou nulo.");
        }

        if(this.mapaNomeFornecedor.containsKey(nome)){
            Fornecedor fornecedor = this.mapaNomeFornecedor.get(nome);
            return fornecedor.toString();
        }else{
            throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
        }
    }

    /**
     * Exibe uma representacao textua de todos os fornecedores cadastrados.
     *
     * @return  retorna um String, com todos os forncedores.
     */
    public String exibeTodosOsFornecedores(){
        ArrayList<String> todosOsFornecedores = new ArrayList();
        for (Fornecedor fornecedor : this.mapaNomeFornecedor.values()) {
            todosOsFornecedores.add(fornecedor.toString());
        }
        String imprimir = String.join(" | ", todosOsFornecedores);
        return imprimir;

    }

    /**
     * Edita algum atrivbuto do fornecedor, exceto sua chave, no caso o seu nome.
     * Lanca excecao caso algum parametro passado seja nulo ou vazio.
     *
     * @param nome representa o nome do forncedor, a chave do hashmap
     * @param atributo representa o atributo a ser modificado.
     * @param novoValor representa um novo valor do atributo.
     * @return retorna caso sucesso, true, caso não lanca excecoes.
     */
    public boolean editaFornecedor(String nome, String atributo, String novoValor){
        if(nome == null){
            throw new NullPointerException("Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
        }else if("".equals(nome.trim())){
            throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
        }
        if(atributo == null){
            throw new NullPointerException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
        }else if("".equals(atributo.trim())){
            throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
        }else if("nome".equals(atributo)){
            throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
        }
        if(novoValor == null){
            throw new NullPointerException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
        }else if("".equals(novoValor.trim())){
            throw new IllegalArgumentException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
        }

        if(this.mapaNomeFornecedor.containsKey(nome)){
            if("email".equals(atributo)){
                this.mapaNomeFornecedor.get(nome).setEmail(novoValor);
            }else if ("telefone".equals(atributo)){
                this.mapaNomeFornecedor.get(nome).setTelefone(novoValor);
            }else{
                throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
            }
            return true;
        }else{
            throw new IllegalArgumentException("Erro na edicao do fornecedor: fornecedor nao existe.");
        }
    }

    /**
     * Remove um fornecedor do sistema, ou seja, remove a chave do hashMap.
     * E lanca excecoes, caso o paramentro passado seja vazio ou nulo.
     *
     * @param nome representa o nome do forncedor a ser retirado.
     * @return retorna true, casoseja removido com sucesso e retorna excecoes caso contrario.
     */
    public boolean removerFornecedor(String nome){
        if(nome == null){
            throw new NullPointerException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser nulo.");
        }else if("".equals(nome.trim())){
            throw new IllegalArgumentException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio.");
        }

        if(this.mapaNomeFornecedor.containsKey(nome)){
            this.mapaNomeFornecedor.remove(nome);
            return true;
        }else{
            throw new IllegalArgumentException("Erro na remocao do fornecedor: fornecedor nao existe.");
        }
    }

    /**
     * Cadastra um produto em fornecedor, ou seja, adiciona um produto na colecao de produtos de um forncedor.
     * Lanca excecoes, caso algum dos parametros seja nulo, vazio ou invalido, cono caso do preco negativo.
     *
     * @param fornecedor representa o fornecedor que vai receber o produto
     * @param nome representa o nome do produto
     * @param descricao representa a descricao do produto
     * @param preco representa o preco do produto
     * @return retorna true, caso seja adicionado com sucesso e excecoes, caso contrario.
     */
    public boolean cadastrarProdutoParaUmFornecedo(String fornecedor, String nome, String descricao, double preco){
        if(fornecedor == null){
            throw new NullPointerException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
        }else if("".equals(fornecedor.trim())){
            throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
        }

        if(this.mapaNomeFornecedor.containsKey(fornecedor)){
            return this.mapaNomeFornecedor.get(fornecedor).adicionaProduto(nome,descricao,preco);
        }else{
            throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
        }

    }

    /**
     * Exibe uma representacao textual de um produto.E lanca exececoes caso algum parametro seja nulo ou vazio.
     *
     * @param nome representa o nome do produto.
     * @param descricao representa a descricao do produto
     * @param fornecedor representa o forncedor que tem o produto.
     * @return retorna uma String, que representa o produto.
     */
    public String exibeProduto(String nome, String descricao, String fornecedor){
        if(fornecedor == null){
            throw new NullPointerException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
        }else if("".equals(fornecedor.trim())){
            throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
        }

        if(this.mapaNomeFornecedor.containsKey(fornecedor)){
            return this.mapaNomeFornecedor.get(fornecedor).exibeProduto(nome,descricao);
        }else{
            throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
        }
    }

    /**
     * Exibe uma representacao textual de todos os produtos cadastrados no sistema.
     *
     * @return retorna uma string que representa todos os produtos.
     */
    public String exibeProdutosDosFornecedores(){
        ArrayList<String> todosOsProdutos = new ArrayList();
        for (Fornecedor fornecedor : this.mapaNomeFornecedor.values()) {
            todosOsProdutos.add(fornecedor.exibeTodosProdutoDeUmFornecedor());
        }
        String imprimir = String.join(" | ", todosOsProdutos);
        return imprimir;
    }

    /**
     * Edita o preco do produto, pois seu nome e descrica sao suas chaves e nao podem ser editadas.
     * Lanca excecoes caso algum parametro passado seja vazio, nulo ou invalido.
     *
     * @param nome representa o nome do produto
     * @param descricao representa a descricao do produto
     * @param fornecedor representa o nome do forncedor
     * @param novoPreco representa o novo valor do preco
     * @return retorna true caso seja modificado com sucesso.
     */
    public boolean editaProduto(String nome, String descricao, String fornecedor, double novoPreco){
        if(fornecedor == null){
            throw new NullPointerException("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
        }else if("".equals(fornecedor.trim())){
            throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
        }

        if(this.mapaNomeFornecedor.containsKey(fornecedor)){
            return this.mapaNomeFornecedor.get(fornecedor).editaProduto(nome,descricao,novoPreco);
        }else{
            throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao existe.");
        }
    }

    /**
     * Remove um produto do sistema a partir de sua chave, n caso, nome e descrcao.
     * Lanca exececoes caso algum parametro seja passado nulo ou vazio.
     *
     * @param nome representa o nome do produto
     * @param descricao representa a descricao  do produto
     * @param fornecedor representa o nome do fornecedor
     * @return retorna true, caso seja removido com sucesso e excecoes caso contrario.
     */
    public boolean removeProduto(String nome, String descricao, String fornecedor){
        if(fornecedor == null){
            throw new NullPointerException("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
        }else if("".equals(fornecedor.trim())){
            throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
        }

        if(this.mapaNomeFornecedor.containsKey(fornecedor)){
            return this.mapaNomeFornecedor.get(fornecedor).removeProduto(nome,descricao);
        }else{
            throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao existe.");
        }
    }

    /**
     * Pega o hashmap do sistema.
     * Utilizado apenas nos testes
     * @return retorna um hashmap representando o conjunto de forncedres.
     */
    public HashMap<String, Fornecedor> getMapaNomeFornecedor() {
        return mapaNomeFornecedor;
    }
}
