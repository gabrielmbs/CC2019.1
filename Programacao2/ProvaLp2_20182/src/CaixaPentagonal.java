public class CaixaPentagonal extends Caixa {

    private double lado;

    public CaixaPentagonal(String descricao, String personalizacao, double lado) {
        super(descricao,personalizacao);
        this.lado = lado;
    }

    @Override
    public String toString() {
        return "Caixa com " + this.personalizacao + "custa R$ " + calculaPreco() + ". Formato Pentagonal.";
    }

    @Override
    public double calculaPreco() {
        double altura = (this.lado / 2 * Math.sqrt(5) + 2 * Math.sqrt(5)) / 2;
        double areaTotal =  5.0 * (( this.lado * altura ) / 2.0);
        return (0.1 * areaTotal);
    }

    @Override
    public String pegaFormato() {
        return "Pentagonal";
    }
}
