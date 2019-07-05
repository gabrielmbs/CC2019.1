import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CaixaController {
    private Map<String, Caixa> depositoDeCaixas;

    public CaixaController() {
        this.depositoDeCaixas = new HashMap<String,Caixa>();
    }

    public void cadastraCaixaPentagonal(String descricao, String personalizacao, double lado){
        if(lado <= 0){
            throw new IllegalArgumentException("Lado nao pode ser zero ou negativo");
        }

        if(!this.depositoDeCaixas.containsKey(descricao)){
            this.depositoDeCaixas.put(descricao,new CaixaPentagonal(descricao, personalizacao, lado));
        }else{
            System.err.println("Erro: Caixa já existe.");
        }
    }

    public void cadastraCaixaRetangular(String descricao, String personalizacao, double lado1, double lado2){
        if(lado1 <= 0){
            throw new IllegalArgumentException("Lado nao pode ser zero ou negativo");
        }
        if(lado2 <= 0){
            throw new IllegalArgumentException("Lado nao pode ser zero ou negativo");
        }

        if(!this.depositoDeCaixas.containsKey(descricao)){
            this.depositoDeCaixas.put(descricao,new CaixaRetangular(descricao, personalizacao, lado1, lado2));
        }else{
            System.err.println("Erro: Caixa já existe.");
        }
    }

    public void cadastraCaixaCircular(String descricao, String personalizacao, double raio){
        if(raio <= 0){
            throw new IllegalArgumentException("Lado nao pode ser zero ou negativo");
        }

        if(!this.depositoDeCaixas.containsKey(descricao)){
            this.depositoDeCaixas.put(descricao,new CaixaCircular(descricao, personalizacao, raio));
        }else{
            System.err.println("Erro: Caixa já existe.");
        }
    }

    public void ModificarTipoDePersonalização(String descricao, String novaPersonalizacao){
        if(!this.depositoDeCaixas.containsKey(descricao)) {
            this.depositoDeCaixas.get(descricao).setPersonalizacao(novaPersonalizacao);
        }else{
            System.err.println("Erro: Caixa nao existe.");
        }
    }

    public void removerCaixa(String descricao){
        if(!this.depositoDeCaixas.containsKey(descricao)) {
            this.depositoDeCaixas.remove(descricao);
        }else{
            System.err.println("Erro: Caixa nao existe.");
        }
    }

    public int obterNumeroTotalDeCaixas(){
        return this.depositoDeCaixas.size();
    }

    public boolean consultarSeExisteCaixa(String personalizacao, String formato){
        for (Caixa caixa: this.depositoDeCaixas.values()) {
            if (caixa.getPersonalizacao().equals(personalizacao) && caixa.pegaFormato().equals(formato)){
                return true;
            }
        }
        return false;
    }

    public String RetornarCaixasAPartirDeUmaPersonalizacao(String personalizacao){
        List<Caixa> listaDeCaixas = new ArrayList<>();
        for (Caixa caixa: this.depositoDeCaixas.values()) {
            if (caixa.getPersonalizacao().equals(personalizacao)){
                listaDeCaixas.add(caixa);
            }
        }

        listaDeCaixas.sort(new ComparadorCaixaPelaDescricao());
        List<String> listaDeStringDasCaixas = new ArrayList<>();
        for (Caixa caixa : listaDeCaixas) {
            listaDeStringDasCaixas.add(caixa.getPersonalizacao());
        }

        String imprimir = String.join(" | ", listaDeStringDasCaixas);
        return imprimir;
    }

    public String RetornarCaixasAPartirDeUmFormato(String formato){
        List<Caixa> listaDeCaixas = new ArrayList<>();
        for (Caixa caixa: this.depositoDeCaixas.values()) {
            if (caixa.pegaFormato().equals(formato)){
                listaDeCaixas.add(caixa);
            }
        }

        listaDeCaixas.sort(new ComparadorCaixaPelaDescricao());
        List<String> listaDeStringDasCaixas = new ArrayList<>();
        for (Caixa caixa : listaDeCaixas) {
            listaDeStringDasCaixas.add(caixa.getPersonalizacao());
        }

        String imprimir = String.join(" | ", listaDeStringDasCaixas);
        return imprimir;
    }

    public double TotalDeRedimentos(){
        double soma = 0;
        for (Caixa caixa: this.depositoDeCaixas.values()) {
            soma += caixa.calculaPreco();
        }

        return soma;
    }

}
