package controllers;

import classes.Cliente;

import java.util.ArrayList;
import java.util.HashMap;

public class CrudDeClientes {
    private HashMap<String, Cliente> mapaCpfCliente;

    public CrudDeClientes() {
        this.mapaCpfCliente = new HashMap<>();
    }

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

    public String exibeTodosOsClientes(){
        ArrayList<String> todosOsClientes = new ArrayList<>();
        for (Cliente cliente : this.mapaCpfCliente.values()) {
            todosOsClientes.add(cliente.toString());
        }
        String imprimir = String.join(" | ", todosOsClientes);
        return imprimir;
    }

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
}
