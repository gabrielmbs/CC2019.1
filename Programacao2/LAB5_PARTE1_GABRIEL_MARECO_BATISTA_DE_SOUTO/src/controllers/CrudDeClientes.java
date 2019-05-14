package controllers;

import classes.Cliente;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe Controladora dos clientes.
 *
 */
public class CrudDeClientes {
    /**
     * Representa um conjunto de clientes, com a chave que representa o cpf do cliente.
     */
    private HashMap<String, Cliente> mapaCpfCliente;

    /**
     * Constroe um controlador, sem paramentro, apenas inicia.
     */
    public CrudDeClientes() {
        this.mapaCpfCliente = new HashMap<>();
    }

    /**
     * Cadastra um cliente, ou seja, salva no hashMap os clientes. A partir do cpf do cliente,
     * nome do cliente e localizacao do cliente. Retorna excecoes, caso algum dos paramentros seja nulos ou vazios
     * ou invalido.
     *
     * @param cpf String, representa o cpf do cliente
     * @param nome String, representa o nome do cliente
     * @param email String, representa o email do cliente
     * @param localizacao String, representa o localizao onde cliente trabalha.
     *
     * @return Uma String, que representa o cpf do cliente.
     */
    public String cadastraCliente(String cpf, String nome, String email, String localizacao){
        if(cpf == null){
            throw new NullPointerException("Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
        }else if("".equals(cpf.trim())){
            throw new IllegalArgumentException("Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
        }else if(cpf.length() != 11){
            throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
        }

        if(this.mapaCpfCliente.containsKey(cpf)){
            throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
        }else{
            this.mapaCpfCliente.put(cpf, new Cliente(nome, email, localizacao, cpf));
            return cpf;
        }
    }

    /**
     * Exibe uma string que representa um cliente, para o usuario. E retorna uma excecao, caso o paramentro passado
     * seja nulo, vazio ou invalido, ou seja, diferente de 11.
     *
     * @param cpf representa o cpf do aluno que vai ser exibido.
     * @return uma String, representando o cliente, no formato: "nome - localizacao - email".
     */
    public String exibeCliente(String cpf){
        if(cpf == null){
            throw new NullPointerException("Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo.");
        }else if("".equals(cpf.trim())){
            throw new IllegalArgumentException("Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo.");
        }else if(cpf.length() != 11){
            throw new IllegalArgumentException("Erro na exibicao do cliente: cpf invalido.");
        }

        if(this.mapaCpfCliente.containsKey(cpf)){
            Cliente cliente = this.mapaCpfCliente.get(cpf);
            return cliente.toString();
        }else{
            throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
        }
    }

    /**
     * Exibe todos os cientes cadastrados em forma de uma String só.
     *
     * @return uma String que representa todos os clientes
     */
    public String exibeTodosOsClientes(){
        ArrayList<String> todosOsClientes = new ArrayList<>();
        for (Cliente cliente : this.mapaCpfCliente.values()) {
            todosOsClientes.add(cliente.toString());
        }
        String imprimir = String.join(" | ", todosOsClientes);
        return imprimir;
    }

    /**
     * Edita um dos atributos dos clientes, execeto o cpf, pois é a chave.
     * E lanca excecoes caso algum paramnetro seja vazio, nulo ou invalido.
     *
     * @param cpf cpf do clinete a ser editado
     * @param atributo adtributo que vai ser modificado
     * @param novoValor valor novo do atributo
     * @return return true, qiado executado com sucessso.
     */
    public boolean editarUmCliente(String cpf,String atributo, String novoValor){
        if(cpf == null){
            throw new NullPointerException("Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.");
        }else if("".equals(cpf.trim())){
            throw new IllegalArgumentException("Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.");
        }else if(cpf.length() != 11){
            throw new IllegalArgumentException("Erro na edicao do cliente: cpf invalido.");
        }
        if(atributo == null){
            throw new NullPointerException("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
        }else if("".equals(atributo.trim())){
            throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
        }
        if(novoValor == null){
            throw new NullPointerException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
        }else if("".equals(novoValor.trim())){
            throw new IllegalArgumentException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
        }

        if(this.mapaCpfCliente.containsKey(cpf)){
            if ("nome".equals(atributo)){
                this.mapaCpfCliente.get(cpf).setNome(novoValor);
            }else if("email".equals(atributo)){
                this.mapaCpfCliente.get(cpf).setEmail(novoValor);
            }else if("localizacao".equals(atributo)){
                this.mapaCpfCliente.get(cpf).setLocalizacao(novoValor);
            }else {
                throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
            }
            return true;
        }else{
            throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
        }
    }

    /**
     * Remove um cliente do hashMap, ou seja, paga a chave.
     * E lanca exececoes caso algum paramentro seja passado seja, nulo, vazio ou invalido.
     *
     * @param cpf represeta a chave d clinte que vai ser removido
     * @return return true,caso seja executado comsucesso.
     */
    public boolean removerCliente(String cpf){
        if(cpf == null){
            throw new NullPointerException("Erro na remocao do cliente: cpf nao pode ser vazio ou nulo.");
        }else if("".equals(cpf.trim())){
            throw new IllegalArgumentException("Erro na remocao do cliente: cpf nao pode ser vazio ou nulo.");
        }else if(cpf.length() != 11){
            throw new IllegalArgumentException("Erro na remocao do cliente: cpf invalido.");
        }

        if(this.mapaCpfCliente.containsKey(cpf)){
            this.mapaCpfCliente.remove(cpf);
            return true;
        }else{
            throw new IllegalArgumentException("Erro na remocao do cliente: cliente nao existe.");
        }
    }

    /**
     * Pega o hashMap, o conjuto inteiro.
     * Utilizado apenas nos testes.
     *
     * @return retorna um hashmap.
     */
    public HashMap<String, Cliente> getMapaCpfCliente() {
        return mapaCpfCliente;
    }
}
