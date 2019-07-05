public abstract class Caixa {
    private String descricao;
    protected String personalizacao;

    public Caixa(String descricao, String personalizacao) {
        this.descricao = descricao;
        this.personalizacao = personalizacao;
    }

    public void setPersonalizacao(String personalizacao) {
        this.personalizacao = personalizacao;
    }

    public abstract double calculaPreco();

    public abstract String pegaFormato();

    public String getPersonalizacao() {
        return personalizacao;
    }

    public String getDescricao() {
        return descricao;
    }
}
