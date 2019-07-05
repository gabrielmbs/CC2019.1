public class CaixaCircular extends Caixa {
    private double raio;

    public CaixaCircular(String descricao, String personalizacao, double raio) {
        super(descricao, personalizacao);
        this.raio = raio;
    }

    @Override
    public String toString() {
        return "Caixa com " + this.personalizacao + "custa R$ " + calculaPreco() + ". Formato Circular.";
    }

    @Override
    public double calculaPreco() {
        double areaTotal = 3.14 * this.raio * this.raio;
        return (0.1 * areaTotal);
    }

    @Override
    public String pegaFormato() {
        return "Circular";
    }


}
