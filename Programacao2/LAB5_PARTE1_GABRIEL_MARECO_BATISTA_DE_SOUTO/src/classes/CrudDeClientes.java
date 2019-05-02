package classes;

import java.util.HashMap;

public class CrudDeClientes {
    private HashMap<String,Cliente> mapaCpfCliente;

    public CrudDeClientes() {
        this.mapaCpfCliente = new HashMap<>();
    }
    public String cadastraCliente(String nome, String email, String localizacao, String cpf){
        if(this.mapaCpfCliente.containsKey(cpf)){
            throw new IllegalArgumentException("Cliente já existe");
        }else{
            this.mapaCpfCliente.put(cpf,new Cliente(nome,email,localizacao,cpf));
            return cpf;
        }
    }

    public String exibeCliente(String cpf){
        if(this.mapaCpfCliente.containsKey(cpf)){
            Cliente cliente = this.mapaCpfCliente.get(cpf);
            return cliente.exibeCliente();
        }else{
            throw new IllegalArgumentException("Cliente não existe");
        }
    }
}
