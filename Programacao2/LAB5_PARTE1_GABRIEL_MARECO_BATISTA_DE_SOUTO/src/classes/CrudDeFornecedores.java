package classes;

import java.util.ArrayList;
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
        ArrayList<String> todosOsFornecedores = new ArrayList();
        for (Fornecedor fornecedor : this.mapaNomeFornecedor.values()) {
            todosOsFornecedores.add(fornecedor.toString());
        }
        String imprimir = String.join(" | ", todosOsFornecedores);
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

    public boolean removerFornecedor(String nome){
        if(this.mapaNomeFornecedor.containsKey(nome)){
            this.mapaNomeFornecedor.remove(nome);
            return true;
        }else{
            throw new IllegalArgumentException("Fornecedor não existe");
        }
    }

    public String CadastrarProdutoParaUmFornecedo(String nome, String descricao, String preco, String fornecedor){
        this.mapaNomeFornecedor.get(fornecedor).
    }
}
