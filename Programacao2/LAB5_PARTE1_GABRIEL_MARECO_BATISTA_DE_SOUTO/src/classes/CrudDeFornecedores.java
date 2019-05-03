package classes;

import java.util.HashMap;

public class CrudDeFornecedores {
    private HashMap<String, Fornecedor> mapaNomeFornecedor;

    public CrudDeFornecedores() {
        this.mapaNomeFornecedor = new HashMap<>();
    }

    public String cadastraFornecedor(String nome, String email, String telefone){
        if(this.mapaNomeFornecedor.containsKey(nome)){
            throw new IllegalArgumentException("Fornecedor já existe");
        }else{
            this.mapaNomeFornecedor.put(nome, new Fornecedor(nome, email, telefone));
            return nome;
        }
    }

    public String exibeFornecedor(String nome){
        if(this.mapaNomeFornecedor.containsKey(nome)){
            Fornecedor fornecedor = this.mapaNomeFornecedor.get(nome);
            return fornecedor.toString();
        }else{
            throw new IllegalArgumentException("Fornecedor não existe");
        }
    }

    public String exibeTodosOsFornecedores(){
        String imprimir = "";
        int controle = 0;
        for (Fornecedor fornecedor : this.mapaNomeFornecedor.values()) {
            if(controle > 0 && controle < this.mapaNomeFornecedor.size()){
                imprimir += " | ";
            }
            imprimir += fornecedor.toString();
            controle += 1;
        }
        return imprimir;
    }

    public boolean editarEmailDeUmFornecedor(String nome, String email){
        if(this.mapaNomeFornecedor.containsKey(nome)){
            this.mapaNomeFornecedor.get(nome).setEmail(email);
            return true;
        }else{
            throw new IllegalArgumentException("Fornecedor não existe");
        }
    }

    public boolean editarTelefoneDeUmFornecedor(String nome, String telefone){
        if(this.mapaNomeFornecedor.containsKey(nome)){
            this.mapaNomeFornecedor.get(nome).setTelefone(telefone);
            return true;
        }else{
            throw new IllegalArgumentException("Fornecedor não existe");
        }
    }

    public boolean removerCliente(String nome){
        if(this.mapaNomeFornecedor.containsKey(nome)){
            this.mapaNomeFornecedor.remove(nome);
            return true;
        }else{
            throw new IllegalArgumentException("Fornecedor não existe");
        }
    }

    public boolean adicionaProduto(String nome, int id, Produto produto) {
        if (this.mapaNomeFornecedor.containsKey(nome)) {
            this.mapaNomeFornecedor.get(nome).getListaDeProdutos().put(id,produto);
            return true;
        } else {
            throw new IllegalArgumentException("Fornecedor não existe");
        }
    }

    public String exibeUmProdutoDeUmFornecedor(String nome, int id){
        if (this.mapaNomeFornecedor.containsKey(nome)) {
            return this.mapaNomeFornecedor.get(nome).getListaDeProdutos().get(id).toString();
        } else {
            throw new IllegalArgumentException("Fornecedor não existe");
        }
    }
    public String exibeTodosProdutosDeUmFornecedor(String nome){
        if (this.mapaNomeFornecedor.containsKey(nome)) {
            String imprimir = "";
            int controle = 0;
            for (Produto produto : this.mapaNomeFornecedor.get(nome).getListaDeProdutos().values()) {
                if(controle > 0 && controle < this.mapaNomeFornecedor.size()){
                    imprimir += " | ";
                }
                imprimir += produto.toString();
                controle += 1;
            }
            return imprimir;
        } else {
            throw new IllegalArgumentException("Fornecedor não existe");
        }
    }

    public String exibeTodosProdutos() {
        String imprimir = "";
        for (Fornecedor fornecedor : this.mapaNomeFornecedor.values()) {
            int controle = 0;
            for (Produto produto : fornecedor.getListaDeProdutos().values()) {
                if(controle > 0 && controle < this.mapaNomeFornecedor.size()){
                    imprimir += " | ";
                }
                imprimir += produto.toString();
                controle += 1;
            }

        }
        return imprimir;
    }

    public boolean editarPrecoDeUmProdutoDeUmFornecedor(String nome, int id, String preco) {
        if (this.mapaNomeFornecedor.containsKey(nome)) {
            this.mapaNomeFornecedor.get(nome).getListaDeProdutos().get(id).setPreco(preco);
            return true;
        } else {
            throw new IllegalArgumentException("Fornecedor não existe");
        }
    }

    public boolean removerProdutoDoFornecedor(String nome, int id) {
        if (this.mapaNomeFornecedor.containsKey(nome)) {
            this.mapaNomeFornecedor.get(nome).getListaDeProdutos().remove(id);
            return true;
        } else {
            throw new IllegalArgumentException("Fornecedor não existe");
        }
    }
}
