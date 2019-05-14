package controllers_test;

import controllers.CrudDeClientes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrudDeClientesTest {
    CrudDeClientes clientes;

    @BeforeEach
    void setUp() {
        this.clientes = new CrudDeClientes();
    }

    @Test
    void construtorTeste() {
        assertTrue(this.clientes.getMapaCpfCliente().isEmpty());
    }

    @Test
    void cadastraClienteTeste() {
        assertEquals("11111111111", this.clientes.cadastraCliente("11111111111","Gabriel", "gabriel@gmail.com", "CAA"));
    }

    @Test
    void cadastraClienteTesteParametrosNulos() {
        assertThrows(NullPointerException.class, () -> this.clientes.cadastraCliente(null,"Gabriel", "gabriel@gmail.com", "CAA"));
        assertThrows(NullPointerException.class, () -> this.clientes.cadastraCliente("11111111111",null, "gabriel@gmail.com", "CAA"));
        assertThrows(NullPointerException.class, () -> this.clientes.cadastraCliente("11111111111","Gabriel", null, "CAA"));
        assertThrows(NullPointerException.class, () -> this.clientes.cadastraCliente("11111111111","Gabriel", "gabriel@gmail.com", null));
    }

    @Test
    void cadastraClienteTesteParametrosVazios() {
        assertThrows(IllegalArgumentException.class, () -> this.clientes.cadastraCliente("  ","Gabriel", "gabriel@gmail.com", "CAA"));
        assertThrows(IllegalArgumentException.class, () -> this.clientes.cadastraCliente("11111111111","  ", "gabriel@gmail.com", "CAA"));
        assertThrows(IllegalArgumentException.class, () -> this.clientes.cadastraCliente("11111111111","Gabriel", "  ", "CAA"));
        assertThrows(IllegalArgumentException.class, () -> this.clientes.cadastraCliente("11111111111","Gabriel", "gabriel@gmail.com", "  "));
    }

    @Test
    void cadastraClienteTesteCPFInvalido() {
        assertThrows(IllegalArgumentException.class, () -> this.clientes.cadastraCliente("111111111112","Gabriel", "gabriel@gmail.com", "CAA"));
        assertThrows(IllegalArgumentException.class, () -> this.clientes.cadastraCliente("1111111110","Gabriel", "gabriel@gmail.com", "CAA"));
    }

    @Test
    void cadastraClienteTesteCPFJaExistente() {
        this.clientes.cadastraCliente("11111111111","Pedro", "gabriel@gmail.com", "CAA");
        assertThrows(IllegalArgumentException.class, () -> this.clientes.cadastraCliente("11111111111","Gabriel", "gabriel@gmail.com", "CAA"));
    }

    @Test
    void exibeClienteTeste() {
        this.clientes.cadastraCliente("11111111111","Gabriel", "gabriel@gmail.com", "CAA");
        assertEquals("Gabriel - CAA - gabriel@gmail.com", this.clientes.exibeCliente("11111111111"));
    }

    @Test
    void exibeClienteTesteParametroNulo() {
        this.clientes.cadastraCliente("11111111111","Gabriel", "gabriel@gmail.com", "CAA");
        assertThrows(NullPointerException.class,() -> this.clientes.exibeCliente(null));
    }

    @Test
    void exibeClienteTesteParametroVazio() {
        this.clientes.cadastraCliente("11111111111","Gabriel", "gabriel@gmail.com", "CAA");
        assertThrows(IllegalArgumentException.class,() -> this.clientes.exibeCliente("  "));
    }

    @Test
    void exibeClienteTesteCPFInvalido() {
        this.clientes.cadastraCliente("11111111111","Gabriel", "gabriel@gmail.com", "CAA");
        assertThrows(IllegalArgumentException.class,() -> this.clientes.exibeCliente("111111111112"));
        assertThrows(IllegalArgumentException.class,() -> this.clientes.exibeCliente("11111111112"));
        assertThrows(IllegalArgumentException.class,() -> this.clientes.exibeCliente("1111111112"));
    }

    @Test
    void exibeTodosOsClientesTeste() {
        this.clientes.cadastraCliente("11111111111","Gabriel", "gabriel@gmail.com", "CAA");
        this.clientes.cadastraCliente("11111111112","Pedro", "pedro@gmail.com", "SPLAB");
        String todosClientes = this.clientes.exibeTodosOsClientes();
        assertEquals(todosClientes,this.clientes.exibeTodosOsClientes());
    }

    @Test
    void editarUmClienteTeste() {
        this.clientes.cadastraCliente("11111111111","Pedro", "gabriel@gmail.com", "CAA");
        this.clientes.editarUmCliente("11111111111","nome", "Gabriel");
        assertEquals("Gabriel - CAA - gabriel@gmail.com", this.clientes.exibeCliente("11111111111"));
        this.clientes.editarUmCliente("11111111111","email", "pedro@gmail.com");
        assertEquals("Gabriel - CAA - pedro@gmail.com", this.clientes.exibeCliente("11111111111"));
        this.clientes.editarUmCliente("11111111111","localizacao", "SPLAB");
        assertEquals("Gabriel - SPLAB - pedro@gmail.com", this.clientes.exibeCliente("11111111111"));
    }

    @Test
    void editarUmClienteTesteParametrosNulos() {
        this.clientes.cadastraCliente("11111111111","Pedro", "gabriel@gmail.com", "CAA");
        assertThrows(NullPointerException.class, () -> this.clientes.editarUmCliente(null,"nome", "Gabriel"));
        assertThrows(NullPointerException.class, () -> this.clientes.editarUmCliente("11111111111",null, "Gabriel"));
        assertThrows(NullPointerException.class, () -> this.clientes.editarUmCliente("11111111111","nome", null));
    }

    @Test
    void editarUmClienteTesteParametrosVazios() {
        this.clientes.cadastraCliente("11111111111","Pedro", "gabriel@gmail.com", "CAA");
        assertThrows(IllegalArgumentException.class, () -> this.clientes.editarUmCliente("  ","nome", "Gabriel"));
        assertThrows(IllegalArgumentException.class, () -> this.clientes.editarUmCliente("11111111111","  ", "Gabriel"));
        assertThrows(IllegalArgumentException.class, () -> this.clientes.editarUmCliente("11111111111","nome", "  "));
    }

    @Test
    void editarUmClienteTesteParametrosInvalidos() {
        this.clientes.cadastraCliente("11111111111","Pedro", "gabriel@gmail.com", "CAA");
        assertThrows(IllegalArgumentException.class, () -> this.clientes.editarUmCliente("111111111112","nome", "Gabriel"));
        assertThrows(IllegalArgumentException.class, () -> this.clientes.editarUmCliente("1111111112","nome", "Gabriel"));
        assertThrows(IllegalArgumentException.class, () -> this.clientes.editarUmCliente("11111111111","preco", "2.00"));
        assertThrows(IllegalArgumentException.class, () -> this.clientes.editarUmCliente("11111111112","nome", "Gabriel"));

    }

    @Test
    void removerClienteTeste() {
        this.clientes.cadastraCliente("11111111111","Pedro", "gabriel@gmail.com", "CAA");
        this.clientes.removerCliente("11111111111");
        assertThrows(IllegalArgumentException.class, () -> this.clientes.exibeCliente("11111111111"));
        assertThrows(IllegalArgumentException.class, () -> this.clientes.removerCliente("11111111111"));
    }

    @Test
    void removerClienteTesteParametroNulo() {
        this.clientes.cadastraCliente("11111111111","Pedro", "gabriel@gmail.com", "CAA");
        assertThrows(NullPointerException.class, () -> this.clientes.removerCliente(null));
    }

    @Test
    void removerClienteTesteParametroVazio() {
        this.clientes.cadastraCliente("11111111111","Pedro", "gabriel@gmail.com", "CAA");
        assertThrows(IllegalArgumentException.class, () -> this.clientes.removerCliente("  "));
    }

    @Test
    void removerClienteTesteCPFInvalido() {
        this.clientes.cadastraCliente("11111111111","Pedro", "gabriel@gmail.com", "CAA");
        assertThrows(IllegalArgumentException.class, () -> this.clientes.removerCliente("111111110"));
    }
}