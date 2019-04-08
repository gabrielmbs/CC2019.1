package lab3;

import java.util.Arrays;

public class Agenda {
    private Contato[] contatos;

    public Agenda() {
        this.contatos = new Contato[100];
    }

    public boolean cadastrarContato(int posicao, String nome, String sobreNome, String telefone) {
        if(posicao >= 1 && posicao <= 100) {
            this.contatos[posicao - 1] = new Contato(nome, sobreNome, telefone);
            return true;
        }else{
            return false;
        }
    }

    public String pesquisarContato(int posicao) {
        if( (posicao < 1 || posicao > 100) || (this.contatos[posicao - 1] == null)){
            return "POSIÇÃO INVÁLIDA!\n";
        }else {
            return "\n" + this.contatos[posicao - 1].toString() + "\n";
        }
    }

    public String listarContatos() {
        String listaDeContatos = "\n";
        for (int i = 0; i < this.contatos.length; i++) {
            if (this.contatos[i] != null) {
                listaDeContatos += (i+1) + " - " + this.contatos[i].exibeNome() + "\n";
            }
        }
        return listaDeContatos;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agenda agenda = (Agenda) o;
        return Arrays.equals(contatos, agenda.contatos);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(contatos);
    }
}
