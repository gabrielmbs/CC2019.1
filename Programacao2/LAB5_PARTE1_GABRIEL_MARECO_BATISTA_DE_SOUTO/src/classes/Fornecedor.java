package classes;

import java.util.HashMap;
import java.util.Objects;

public class Fornecedor {
    private String nome;
    private String email;
    private String telefone;
    private HashMap<DescritorProduto,Produto> listaDeProdutos;

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

    public String adicionaProduto(String nome, String descricao, String preco){
        DescritorProduto chave = new DescritorProduto(nome,descricao);
        if(this.listaDeProdutos.containsKey(chave)){
            throw new IllegalArgumentException("Produto já existe");
        }else{
            return "produto cadastrado";
        }
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString () {
        return this.nome + " - " + this.email + " - " + this.telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fornecedor that = (Fornecedor) o;
        return Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
