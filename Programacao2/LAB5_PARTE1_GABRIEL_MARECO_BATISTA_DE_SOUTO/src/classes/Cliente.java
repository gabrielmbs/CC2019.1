package classes;

import java.util.Objects;

public class Cliente {
    private String nome;
    private String email;
    private String localizacao;
    private String cpf;

    public Cliente(String nome, String email, String localizacao, String cpf) {
        if(nome == null){
            throw new NullPointerException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
        }else if("".equals(nome.trim())){
            throw new IllegalArgumentException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
        }
        if(email == null){
            throw new NullPointerException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
        }else if("".equals(email.trim())){
            throw new IllegalArgumentException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
        }
        if(localizacao == null){
            throw new NullPointerException("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
        }else if("".equals(localizacao.trim())){
            throw new IllegalArgumentException("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
        }
        if(cpf == null){
            throw new NullPointerException("Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
        }else if("".equals(cpf.trim())){
            throw new IllegalArgumentException("Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
        }else if(cpf.length() != 11){
            throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
        }
        this.nome = nome;
        this.email = email;
        this.localizacao = localizacao;
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    @Override
    public String toString () {
        return this.nome + " - " + this.localizacao + " - " + this.email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cpf, cliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}
