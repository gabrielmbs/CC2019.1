import lab3.Contato;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContatoTest {
    private Contato contato;

    @BeforeEach
    void setUp() {
        this.contato = new Contato("Gabriel","Mareco","4002-8922");
    }

    @Test
    void exibeNomeTeste() {
        assertEquals("Gabriel Mareco", this.contato.exibeNome());

    }

    @Test
    void toStringTeste() {
        assertEquals("Gabriel Mareco - 4002-8922", this.contato.toString());
    }

    @Test
    void equalsValoresIguaisTeste() {
        Contato contato2 = new Contato("Gabriel","Mareco","5435-534");
        assertTrue(this.contato.equals(contato2));
    }
    @Test
    void equalsValoresDiferentesTeste() {
        Contato contato2 = new Contato("Pedro","Mareco","5435-534");
        assertFalse(this.contato.equals(contato2));
    }
    @Test
    void equalsTiposDiferentesTeste() {
        Object contato2 = new Object();
        assertFalse(this.contato.equals(contato2));
    }

}