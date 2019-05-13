package classes_test;

import classes.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {
    private Cliente cliente;
    private Cliente cliente2;

    @BeforeEach
    void setUp() {
        this.cliente = new Cliente("Gabriel","gabriel@gmail.com","CAA","11111111111");
        this.cliente2 = new Cliente("Gabriel","gabriel@gmail.com","CAA","11111111111");

    }

    @Test
    void TesteConstrutor() {
        assertEquals("Gabriel", this.cliente.getNome());
        assertEquals("gabriel@gmail.com", this.cliente.getEmail());
        assertEquals("CAA", this.cliente.getLocalizacao());
        assertEquals("11111111111", this.cliente.getCpf());
    }

    @Test
    void TesteConstrutorParametrosNulos() {
        assertThrows(NullPointerException.class, () -> new Cliente(null, "gabriel@gmail.cm", "CAA", "11111111111"));
        assertThrows(NullPointerException.class, () -> new Cliente("Gabriel", null, "CAA", "11111111111"));
        assertThrows(NullPointerException.class, () -> new Cliente("gabriel", "gabriel@gmail.cm", null, "11111111111"));
        assertThrows(NullPointerException.class, () -> new Cliente("gabriel", "gabriel@gmail.cm", "CAA", null));
    }

    @Test
    void TesteConstrutorParametrosVazios() {
        assertThrows(IllegalArgumentException.class, () -> new Cliente("  ", "gabriel@gmail.cm", "CAA", "11111111111"));
        assertThrows(IllegalArgumentException.class, () -> new Cliente("Gabriel", "  ", "CAA", "11111111111"));
        assertThrows(IllegalArgumentException.class, () -> new Cliente("gabriel", "gabriel@gmail.cm", "  ", "11111111111"));
        assertThrows(IllegalArgumentException.class, () -> new Cliente("gabriel", "gabriel@gmail.cm", "CAA", "  "));
    }

    @Test
    void TesteConstrutorCPFInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Cliente("gabriel", "gabriel@gmail.cm", "CAA", "111111111112"));
        assertThrows(IllegalArgumentException.class, () -> new Cliente("gabriel", "gabriel@gmail.cm", "CAA", "11111111"));

    }

    @Test
    void TesteSetNome() {
        this.cliente.setNome("Pedro");
        assertEquals("Pedro", this.cliente.getNome());
    }

    @Test
    void TesteSetNomeNulo() {
        assertThrows(NullPointerException.class, () -> this.cliente.setNome(null));
    }

    @Test
    void TesteSetNomeVazio() {
        assertThrows(IllegalArgumentException.class, () -> this.cliente.setNome("  "));
    }

    @Test
    void TesteSetEmail() {
        this.cliente.setEmail("gabriel2@gmail.com");
        assertEquals("gabriel2@gmail.com", this.cliente.getEmail());
    }

    @Test
    void TesteSetEmailNulo() {
        assertThrows(NullPointerException.class, () -> this.cliente.setEmail(null));
    }

    @Test
    void TesteSetEmailVazio() {
        assertThrows(IllegalArgumentException.class, () -> this.cliente.setEmail("  "));
    }

    @Test
    void TesteSetLocalizacao() {
        this.cliente.setLocalizacao("Casa");
        assertEquals("Casa", this.cliente.getLocalizacao());
    }

    @Test
    void TesteSetLocalizacaoNulo() {
        assertThrows(NullPointerException.class, () -> this.cliente.setLocalizacao(null));
    }

    @Test
    void TesteSetLocalizacaoVazio() {
        assertThrows(IllegalArgumentException.class, () -> this.cliente.setLocalizacao("  "));
    }


    @Test
    void TesteToString() {
        assertEquals(this.cliente.toString(),this.cliente2.toString());
    }

    @Test
    void TesteEqualsEleMesmo() {
        assertTrue(this.cliente.equals(this.cliente));
    }

    @Test
    void TesteEqualsNulo() {
        assertFalse(this.cliente.equals(null));
    }

    @Test
    void TesteEqualsOutraClasse() {
        assertFalse(this.cliente.equals("Classe String"));
    }

    @Test
    void TesteEqualsObjetosIguais() {
        assertTrue(this.cliente.equals(this.cliente2));
    }

    @Test
    void TestehashCode() {
        assertEquals(this.cliente.hashCode(),this.cliente2.hashCode());
    }
}