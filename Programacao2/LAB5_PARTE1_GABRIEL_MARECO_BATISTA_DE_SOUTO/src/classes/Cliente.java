package classes;

public class Cliente {
    private String nome;
    private String email;
    private String localizacao;
    private String cpf;

    public Cliente(String nome, String email, String localizacao, String cpf) {
        this.nome = nome;
        this.email = email;
        this.localizacao = localizacao;
        this.cpf = cpf;
    }

    public String exibeCliente() {
        return this.nome + " - " + this.localizacao + " - " + this.email;
    }


}
