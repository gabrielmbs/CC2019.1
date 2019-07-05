public class CaixaRetangular extends Caixa {

    private double lado1;
    private double lado2;

    public CaixaRetangular(String descricao, String personalizacao, double lado1, double lado2) {
        super(descricao, personalizacao);
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    @Override
    public String toString() {
        return "Caixa com " + this.personalizacao + "custa R$ " + calculaPreco() + ". Formato Retangular.";
    }

    @Override
    public double calculaPreco() {
        double areaTotal = this.lado1 * this.lado2;
        return (0.1 * areaTotal);
    }

    @Override
    public String pegaFormato() {
        return "Retangular";
    }
}
