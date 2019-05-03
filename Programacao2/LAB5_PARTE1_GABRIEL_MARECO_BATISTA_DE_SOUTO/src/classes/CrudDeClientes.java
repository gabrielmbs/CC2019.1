package classes;

import java.util.HashMap;

public class CrudDeClientes {
    private HashMap<String,Cliente> mapaCpfCliente;

    public CrudDeClientes() {
        this.mapaCpfCliente = new HashMap<>();
    }

    public String cadastraCliente(String cpf, String nome, String email, String localizacao){
        if(this.mapaCpfCliente.containsKey(cpf)){
            throw new IllegalArgumentException("Cliente já existe");
        }else{
            this.mapaCpfCliente.put(cpf, new Cliente(nome, email, localizacao, cpf));
            return cpf;
        }
    }

    public String exibeCliente(String cpf){
        if(this.mapaCpfCliente.containsKey(cpf)){
            Cliente cliente = this.mapaCpfCliente.get(cpf);
            return cliente.toString();
        }else{
            throw new IllegalArgumentException("Cliente não existe");
        }
    }

    public String exibeTodosOsClientes(){
        String imprimir = "";
        int controle = 0;
        for (Cliente cliente : this.mapaCpfCliente.values()) {
            if(controle > 0 && controle < this.mapaCpfCliente.size()){
                imprimir += " | ";
            }
            imprimir += cliente.toString();
            controle += 1;
        }
        return imprimir;
    }

    public boolean editarNomeDeUmCliente(String cpf, String nome){
        if(this.mapaCpfCliente.containsKey(cpf)){
            this.mapaCpfCliente.get(cpf).setNome(nome);
            return true;
        }else{
            throw new IllegalArgumentException("Cliente não existe");
        }
    }

    public boolean editarEmailDeUmCliente(String cpf, String email){
        if(this.mapaCpfCliente.containsKey(cpf)){
            this.mapaCpfCliente.get(cpf).setEmail(email);
            return true;
        }else{
            throw new IllegalArgumentException("Cliente não existe");
        }
    }

    public boolean editarLocalizacaoDeUmCliente(String cpf, String localizacao){
        if(this.mapaCpfCliente.containsKey(cpf)){
            this.mapaCpfCliente.get(cpf).setLocalizacao(localizacao);
            return true;
        }else{
            throw new IllegalArgumentException("Cliente não existe");
        }
    }

    public boolean removerCliente(String cpf){
        if(this.mapaCpfCliente.containsKey(cpf)){
            this.mapaCpfCliente.remove(cpf);
            return true;
        }else{
            throw new IllegalArgumentException("Cliente não existe");
        }
    }
}
