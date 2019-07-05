import java.util.Comparator;

public class ComparadorCaixaPelaDescricao implements Comparator<Caixa> {

    @Override
    public int compare(Caixa caixa, Caixa t1) {
        return caixa.getDescricao().compareTo(t1.getDescricao());
    }
}
