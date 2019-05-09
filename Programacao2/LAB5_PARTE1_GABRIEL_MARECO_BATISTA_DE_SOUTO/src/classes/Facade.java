package classes;

public class Facade {
    private CrudDeClientes clientes;
    private CrudDeFornecedores fornecedores;

    public Facade() {
        this.clientes = new CrudDeClientes();
        this.fornecedores = new CrudDeFornecedores();
    }

    public String cadastraCliente(String cpf, String nome, String email, String localizacao){
        return this.clientes.cadastraCliente(cpf, nome, email, localizacao);
    }

    public String exibeCliente(String cpf){
        return this.clientes.exibeCliente(cpf);
    }

    public String exibeTodosOsClientes(){
        return this.clientes.exibeTodosOsClientes();
    }

    public boolean editarNomeDeUmCliente(String cpf, String nome){
        return this.clientes.editarNomeDeUmCliente(cpf,nome);
    }

    public boolean editarEmailDeUmCliente(String cpf, String email){
        return this.clientes.editarEmailDeUmCliente(cpf,email);
    }

    public boolean editarLocalizacaoDeUmCliente(String cpf, String localizacao){
        return this.clientes.editarLocalizacaoDeUmCliente(cpf,localizacao);
    }

    public boolean removerCliente(String cpf){
        return this.clientes.removerCliente(cpf);
    }

    public String cadastraFornecedor(String nome, String email, String telefone){
        return this.fornecedores.cadastraFornecedor(nome, email, telefone);
    }

    public String exibeFornecedor(String nome){
        return this.fornecedores.exibeFornecedor(nome);
    }

    public String exibeTodosOsFornecedores(){
        return this.fornecedores.exibeTodosOsFornecedores();
    }

    public boolean editarEmailDeUmFornecedor(String nome, String email){
        return this.fornecedores.editarEmailDeUmFornecedor(nome,email);
    }

    public boolean editarTelefoneDeUmFornecedor(String nome, String telefone){
        return this.fornecedores.editarTelefoneDeUmFornecedor(nome,telefone);
    }

    public boolean removerFornecedor(String nome){
        return this.fornecedores.removerFornecedor(nome);
    }
}
