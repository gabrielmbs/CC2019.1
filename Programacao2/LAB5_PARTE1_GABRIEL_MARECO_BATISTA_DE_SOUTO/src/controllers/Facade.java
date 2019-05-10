package controllers;

import controllers.CrudDeClientes;
import controllers.CrudDeFornecedores;
import easyaccept.EasyAccept;

public class Facade {
    private CrudDeClientes clientes;
    private CrudDeFornecedores fornecedores;

    public Facade() {
        this.clientes = new CrudDeClientes();
        this.fornecedores = new CrudDeFornecedores();
    }

    public static void main(String[] args) {
        args = new String[] {"controllers.Facade", "acceptance_test/use_case_1.txt", "acceptance_test/use_case_2.txt",
                            "acceptance_test/use_case_3.txt"};
        EasyAccept.main(args);
    }


    //Crud Cliente
    public String adicionaCliente(String cpf, String nome, String email, String localizacao){
        return this.clientes.cadastraCliente(cpf, nome, email, localizacao);
    }

    public String exibeCliente(String cpf){
        return this.clientes.exibeCliente(cpf);
    }

    public String exibeTodosClientes(){
        return this.clientes.exibeTodosOsClientes();
    }

    public boolean editaCliente(String cpf, String atributo, String novoValor){
        return this.clientes.editarUmCliente(cpf,atributo,novoValor);
    }

    public boolean removeCliente(String cpf){
        return this.clientes.removerCliente(cpf);
    }

    //Crud Fornecedor

    public String adicionaFornecedor(String nome, String email, String telefone){
        return this.fornecedores.cadastraFornecedor(nome,email,telefone);
    }

    public String exibeFornecedor(String nome){
        return this.fornecedores.exibeFornecedor(nome);
    }

    public String exibeTodosFornecedores(){
        return this.fornecedores.exibeTodosOsFornecedores();
    }

    public boolean editaFornecedor(String nome, String atributo, String novoValor){
        return this.fornecedores.editaFornecedor(nome, atributo,novoValor);
    }

    public boolean removeFornecedor(String nome){
        return this.fornecedores.removerFornecedor(nome);
    }

    //Crud Produto

    public boolean adicionaProduto(String fornecedor, String nome, String descricao, double preco){
        return this.fornecedores.cadastrarProdutoParaUmFornecedo(fornecedor, nome,descricao,preco);
    }

    public String exibeProduto(String nome, String descricao, String fornecedor){
        return this.fornecedores.exibeProduto(nome,descricao,fornecedor);
    }

    public String exibeProdutosDosFornecedores(){
        return this.fornecedores.exibeProdutosDosFornecedores();
    }

    public boolean editaProduto(String nome, String descricao, String fornecedor, double novoPreco){
        return this.fornecedores.editaProduto(nome,descricao,fornecedor,novoPreco);
    }

    public boolean removeProduto(String nome, String descricao, String fornecedor){
        return this.fornecedores.removeProduto(nome,descricao,fornecedor);
    }

}
