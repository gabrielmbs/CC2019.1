import lab3.Contato;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContatoTest {
    private Contato contato;

    @BeforeEach
    void setUp() {
        this.contato = new Contato("Gabriel", "Mareco", "4002-8922");
    }


    @Test
    void ConstrutorTeste() {
        assertEquals("Gabriel", this.contato.getNome());
        assertEquals("Mareco", this.contato.getSobreNome());
        assertEquals("4002-8922", this.contato.getTelefone());
        //
        assertThrows(NullPointerException.class, () -> new Contato(null, "Mareco", "0000-0000"));
        assertThrows(IllegalArgumentException.class, () -> new Contato("   ", "Mareco", "0000-0000"));
        //
        assertThrows(NullPointerException.class, () -> new Contato("Gabriel", null, "0000-0000"));
        assertThrows(IllegalArgumentException.class, () -> new Contato("Gabriel", "   ", "0000-0000"));
        //
        assertThrows(NullPointerException.class, () -> new Contato("Gabriel", "Mareco", null));
        assertThrows(IllegalArgumentException.class, () -> new Contato("Gabriel", "Mareco", "   "));

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
        Contato contato2 = new Contato("Gabriel", "Mareco", "5435-534");
        assertTrue(this.contato.equals(contato2));
    }
    @Test
    void equalsValoresDiferentesTeste() {
        Contato contato2 = new Contato("Pedro", "Mareco", "5435-534");
        assertFalse(this.contato.equals(contato2));
    }
    @Test
    void equalsTiposDiferentesTeste() {
        Object contato2 = new Object();
        assertFalse(this.contato.equals(contato2));
    }
}