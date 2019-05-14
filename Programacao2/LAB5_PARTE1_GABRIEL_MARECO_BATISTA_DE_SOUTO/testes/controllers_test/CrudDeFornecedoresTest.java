package controllers_test;

import controllers.CrudDeFornecedores;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrudDeFornecedoresTest {
    CrudDeFornecedores fornecedores;

    @BeforeEach
    void setUp() {
        this.fornecedores = new CrudDeFornecedores();
    }

    @Test
    void construtorTeste() {
        assertTrue(this.fornecedores.getMapaNomeFornecedor().isEmpty());
    }

    @Test
    void cadastraFornecedorTeste() {
        assertEquals("Gabriel", this.fornecedores.cadastraFornecedor("Gabriel","gabriel@gmail.com","4002-8922"));
        assertThrows(IllegalArgumentException.class,() -> this.fornecedores.cadastraFornecedor("Gabriel","gabriel@gmail.com","4002-8922"));

    }

    @Test
    void cadastraFornecedorParametrosNulos() {
        assertThrows(NullPointerException.class,() -> this.fornecedores.cadastraFornecedor(null,"gabriel@gmail.com","4002-8922"));
        assertThrows(NullPointerException.class,() -> this.fornecedores.cadastraFornecedor("Gabriel",null,"4002-8922"));
        assertThrows(NullPointerException.class,() -> this.fornecedores.cadastraFornecedor("Gabriel","gabriel@gmail.com",null));
    }

    @Test
    void cadastraFornecedorParametrosVazios() {
        assertThrows(IllegalArgumentException.class,() -> this.fornecedores.cadastraFornecedor("  ","gabriel@gmail.com","4002-8922"));
        assertThrows(IllegalArgumentException.class,() -> this.fornecedores.cadastraFornecedor("Gabriel","  ","4002-8922"));
        assertThrows(IllegalArgumentException.class,() -> this.fornecedores.cadastraFornecedor("Gabriel","gabriel@gmail.com","  "));
    }

    @Test
    void exibeFornecedorTeste() {
        this.fornecedores.cadastraFornecedor("Gabriel","gabriel@gmail.com","4002-8922");
        assertEquals("Gabriel - gabriel@gmail.com - 4002-8922", this.fornecedores.exibeFornecedor("Gabriel"));
    }

    @Test
    void exibeFornecedorTesteParametrosNulos() {
        this.fornecedores.cadastraFornecedor("Gabriel","gabriel@gmail.com","4002-8922");
        assertThrows(NullPointerException.class,() -> this.fornecedores.exibeFornecedor(null));
    }

    @Test
    void exibeFornecedorTesteParametrosVazios() {
        this.fornecedores.cadastraFornecedor("Gabriel","gabriel@gmail.com","4002-8922");
        assertThrows(IllegalArgumentException.class,() -> this.fornecedores.exibeFornecedor(" "));
    }

    @Test
    void exibeFornecedorTesteNomeInvalido() {
        this.fornecedores.cadastraFornecedor("Gabriel","gabriel@gmail.com","4002-8922");
        assertThrows(IllegalArgumentException.class,() -> this.fornecedores.exibeFornecedor("Pedro"));
    }

    @Test
    void exibeTodosOsFornecedoresTeste() {
        this.fornecedores.cadastraFornecedor("Gabriel","gabriel@gmail.com","4002-8922");
        this.fornecedores.cadastraFornecedor("Pedro","pedro@gmail.com","3322-8522");
        String todosFornecedores = this.fornecedores.exibeTodosOsFornecedores();
        assertEquals(todosFornecedores,this.fornecedores.exibeTodosOsFornecedores());
    }

    @Test
    void editaFornecedorTeste() {
        this.fornecedores.cadastraFornecedor("Gabriel","gabriel@gmail.com","4002-8922");
        this.fornecedores.editaFornecedor("Gabriel","email","gabriel2@hotmail.com");
        assertEquals("Gabriel - gabriel2@hotmail.com - 4002-8922", this.fornecedores.exibeFornecedor("Gabriel"));
        this.fornecedores.editaFornecedor("Gabriel","telefone","8822");
        assertEquals("Gabriel - gabriel2@hotmail.com - 8822", this.fornecedores.exibeFornecedor("Gabriel"));
        assertThrows(NullPointerException.class, () -> this.fornecedores.editaFornecedor(null,"telefone","8822"));
        assertThrows(NullPointerException.class, () -> this.fornecedores.editaFornecedor("Gabriel",null,"8822"));
        assertThrows(NullPointerException.class, () -> this.fornecedores.editaFornecedor("Gabriel","telefone",null));
        assertThrows(IllegalArgumentException.class, () -> this.fornecedores.editaFornecedor("  ","telefone","8822"));
        assertThrows(IllegalArgumentException.class, () -> this.fornecedores.editaFornecedor("Gabriel","  ","8822"));
        assertThrows(IllegalArgumentException.class, () -> this.fornecedores.editaFornecedor("Gabriel","telefone","  "));
        assertThrows(IllegalArgumentException.class, () -> this.fornecedores.editaFornecedor("Pedro","telefone","8822"));
        assertThrows(IllegalArgumentException.class, () -> this.fornecedores.editaFornecedor("Gabriel","EMAIL","gabriel2@hotmail.com"));
        assertThrows(IllegalArgumentException.class, () -> this.fornecedores.editaFornecedor("Gabriel","nome","gabriel2@hotmail.com"));

    }

    @Test
    void removerFornecedorTeste() {
        this.fornecedores.cadastraFornecedor("Gabriel","gabriel@gmail.com","4002-8922");
        this.fornecedores.removerFornecedor("Gabriel");
        assertThrows(IllegalArgumentException.class, () -> this.fornecedores.exibeFornecedor("Gabriel"));
        assertThrows(NullPointerException.class, () -> this.fornecedores.removerFornecedor(null));
        assertThrows(IllegalArgumentException.class, () -> this.fornecedores.removerFornecedor("  "));
        assertThrows(IllegalArgumentException.class, () -> this.fornecedores.removerFornecedor("Pedro"));
    }

    @Test
    void cadastrarProdutoParaUmFornecedoTeste() {
        this.fornecedores.cadastraFornecedor("Gabriel","gabriel@gmail.com","4002-8922");
        assertTrue(this.fornecedores.cadastrarProdutoParaUmFornecedo("Gabriel", "coxinha", "coxinha de frango", 2.00));
        assertThrows(NullPointerException.class, () -> this.fornecedores.cadastrarProdutoParaUmFornecedo(null, "coxinha", "coxinha de frango", 2.00));
        assertThrows(NullPointerException.class, () -> this.fornecedores.cadastrarProdutoParaUmFornecedo("Gabriel", null, "coxinha de frango", 2.00));
        assertThrows(NullPointerException.class, () -> this.fornecedores.cadastrarProdutoParaUmFornecedo("Gabriel", "coxinha",  null, 2.00));
        assertThrows(IllegalArgumentException.class, () -> this.fornecedores.cadastrarProdutoParaUmFornecedo("  ", "coxinha", "coxinha de frango", 2.00));
        assertThrows(IllegalArgumentException.class, () -> this.fornecedores.cadastrarProdutoParaUmFornecedo("Gabriel", "  ", "coxinha de frango", 2.00));
        assertThrows(IllegalArgumentException.class, () -> this.fornecedores.cadastrarProdutoParaUmFornecedo("Gabriel", "coxinha",  "  ", 2.00));
        assertThrows(IllegalArgumentException.class, () -> this.fornecedores.cadastrarProdutoParaUmFornecedo("Gabriel", "coxinha", "coxinha de frango", -2.00));
        assertThrows(IllegalArgumentException.class, () -> this.fornecedores.cadastrarProdutoParaUmFornecedo("Pedro", "coxinha", "coxinha de frango", 2.00));
    }

    @Test
    void exibeProdutoTeste() {
        this.fornecedores.cadastraFornecedor("Gabriel","gabriel@gmail.com","4002-8922");
        this.fornecedores.cadastrarProdutoParaUmFornecedo("Gabriel", "coxinha", "coxinha de frango", 2.00);
        assertEquals("coxinha - coxinha de frango - R$2,00", this.fornecedores.exibeProduto("coxinha", "coxinha de frango", "Gabriel"));
        assertThrows(NullPointerException.class, () -> this.fornecedores.exibeProduto(null, "coxinha de frango", "Gabriel"));
        assertThrows(NullPointerException.class, () -> this.fornecedores.exibeProduto("coxinha", null, "Gabriel"));
        assertThrows(NullPointerException.class, () -> this.fornecedores.exibeProduto("coxinha", "coxinha de frango", null));
        assertThrows(IllegalArgumentException.class, () -> this.fornecedores.exibeProduto("  ", "coxinha de frango", "Gabriel"));
        assertThrows(IllegalArgumentException.class, () -> this.fornecedores.exibeProduto("coxinha", "  ", "Gabriel"));
        assertThrows(IllegalArgumentException.class, () -> this.fornecedores.exibeProduto("coxinha", "coxinha de frango", "  "));
        assertThrows(IllegalArgumentException.class, () -> this.fornecedores.exibeProduto("coxinha", "coxinha de frango", "Pedro"));
    }

    @Test
    void exibeProdutosDosFornecedoresTeste() {
        String todosPrdutosDeTodosForneedores = this.fornecedores.exibeProdutosDosFornecedores();
        assertEquals(todosPrdutosDeTodosForneedores,this.fornecedores.exibeProdutosDosFornecedores());
    }

    @Test
    void editaProdutoTeste() {
        this.fornecedores.cadastraFornecedor("Gabriel","gabriel@gmail.com","4002-8922");
        this.fornecedores.cadastrarProdutoParaUmFornecedo("Gabriel", "coxinha", "coxinha de frango", 2.00);
        this.fornecedores.editaProduto("coxinha", "coxinha de frango", "Gabriel", 1.00);
        assertEquals("coxinha - coxinha de frango - R$1,00", this.fornecedores.exibeProduto("coxinha", "coxinha de frango", "Gabriel"));
        assertThrows(NullPointerException.class, () -> this.fornecedores.editaProduto(null, "coxinha de frango", "Gabriel", 1.00));
        assertThrows(NullPointerException.class, () -> this.fornecedores.editaProduto("coxinha",  null, "Gabriel", 1.00));
        assertThrows(NullPointerException.class, () -> this.fornecedores.editaProduto("coxinha", "coxinha de frango", null, 1.00));
        assertThrows(IllegalArgumentException.class, () -> this.fornecedores.editaProduto("   ", "coxinha de frango", "Gabriel", 1.00));
        assertThrows(IllegalArgumentException.class, () -> this.fornecedores.editaProduto("coxinha",  "   ", "Gabriel", 1.00));
        assertThrows(IllegalArgumentException.class, () -> this.fornecedores.editaProduto("coxinha", "coxinha de frango", "   ", 1.00));
        assertThrows(IllegalArgumentException.class, () -> this.fornecedores.editaProduto("coxinha", "coxinha de frango", "Pedro", 1.00));
        assertThrows(IllegalArgumentException.class, () -> this.fornecedores.editaProduto("coxinha", "coxinha de frango", "Pedro", -1.00));
    }

    @Test
    void removeProdutoTeste() {
        this.fornecedores.cadastraFornecedor("Gabriel","gabriel@gmail.com","4002-8922");
        this.fornecedores.cadastrarProdutoParaUmFornecedo("Gabriel", "coxinha", "coxinha de frango", 2.00);
        this.fornecedores.removeProduto("coxinha", "coxinha de frango","Gabriel");
        assertThrows(IllegalArgumentException.class,() -> this.fornecedores.exibeProduto("coxinha", "coxinha de frango", "Gabriel"));
        assertThrows(NullPointerException.class, () -> this.fornecedores.removeProduto(null, "coxinha de frango","Gabriel"));
        assertThrows(NullPointerException.class, () -> this.fornecedores.removeProduto("coxinha", null,"Gabriel"));
        assertThrows(NullPointerException.class, () -> this.fornecedores.removeProduto("coxinha", "coxinha de frango",null));
        assertThrows(IllegalArgumentException.class, () -> this.fornecedores.removeProduto("  ", "coxinha de frango","Gabriel"));
        assertThrows(IllegalArgumentException.class, () -> this.fornecedores.removeProduto("coxinha", "  ","Gabriel"));
        assertThrows(IllegalArgumentException.class, () -> this.fornecedores.removeProduto("coxinha", "coxinha de frango","  "));
        assertThrows(IllegalArgumentException.class, () -> this.fornecedores.removeProduto("coxinha", "coxinha de frango","Pedro"));
    }
}