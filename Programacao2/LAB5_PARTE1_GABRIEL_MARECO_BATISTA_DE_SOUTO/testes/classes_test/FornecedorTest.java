package classes_test;

import classes.Fornecedor;
import classes.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FornecedorTest {
    private Fornecedor fornecedor;
    @BeforeEach
    void setUp() {
        this.fornecedor = new Fornecedor("Seu Gabriel","gabriel@gmail.com","83 993348765");
    }

    @Test
    void ConstrutorTeste() {
        assertEquals("Seu Gabriel", this.fornecedor.getNome());
        assertEquals("gabriel@gmail.com", this.fornecedor.getEmail());
        assertEquals("83 993348765", this.fornecedor.getTelefone());
        assertTrue(this.fornecedor.getListaDeProdutos().isEmpty());
    }

    @Test
    void ConstrutorTestePametrosNulos() {
        assertThrows(NullPointerException.class, () -> new Fornecedor(null,"email@.cm","83 99534"));
        assertThrows(NullPointerException.class, () -> new Fornecedor("Seu Gabo",null,"83 99534"));
        assertThrows(NullPointerException.class, () -> new Fornecedor("Seu Gabo","email@.cm",null));

    }

    @Test
    void ConstrutorTestePametrosVazios() {
        assertThrows(IllegalArgumentException.class, () -> new Fornecedor("  ","email@.cm","83 99534"));
        assertThrows(IllegalArgumentException.class, () -> new Fornecedor("Seu Gabo","   ","83 99534"));
        assertThrows(IllegalArgumentException.class, () -> new Fornecedor("Seu Gabo","email@.cm","  "));

    }

    @Test
    void adicionaProdutoTeste() {
        assertTrue(this.fornecedor.adicionaProduto("coxinha", "coxinha de frango", 2.50));
        assertThrows(IllegalArgumentException.class, () -> this.fornecedor.adicionaProduto("coxinha", "coxinha de frango", 2.50));
    }

    @Test
    void adicionaProdutoTesteParametrosVazios() {
        assertThrows(IllegalArgumentException.class, () -> this.fornecedor.adicionaProduto("  ", "coxinha de frango", 2.50));
        assertThrows(IllegalArgumentException.class, () -> this.fornecedor.adicionaProduto("coxinha", "  ", 2.50));
    }

    @Test
    void adicionaProdutoTesteParametrosNulos() {
        assertThrows(NullPointerException.class, () -> this.fornecedor.adicionaProduto(null, "coxinha de frango", 2.50));
        assertThrows(NullPointerException.class, () -> this.fornecedor.adicionaProduto("coxinha", null, 2.50));
    }

    @Test
    void adicionaProdutoTestePrecoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> this.fornecedor.adicionaProduto("coxinha", "coxinha de frango", -1));
    }

    @Test
    void exibeProdutoTeste() {
        this.fornecedor.adicionaProduto("coxinha", "coxinha de frango", 2.50);
        assertEquals("coxinha - coxinha de frango - R$2,50", this.fornecedor.exibeProduto("coxinha", "coxinha de frango"));
    }

    @Test
    void exibeProdutoTesteParametrosVazios() {
        this.fornecedor.adicionaProduto("coxinha", "coxinha de frango", 2.50);
        assertThrows(IllegalArgumentException.class, () -> this.fornecedor.exibeProduto(" ", "coxinha de frango"));
        assertThrows(IllegalArgumentException.class, () -> this.fornecedor.exibeProduto("coxinha", "  "));
    }

    @Test
    void exibeProdutoTesteParametrosNulos() {
        this.fornecedor.adicionaProduto("coxinha", "coxinha de frango", 2.50);
        assertThrows(NullPointerException.class, () -> this.fornecedor.exibeProduto(null, "coxinha de frango"));
        assertThrows(NullPointerException.class, () -> this.fornecedor.exibeProduto("coxinha", null));
    }

    @Test
    void exibeProdutoTesteProdutoNaoExiste() {
        this.fornecedor.adicionaProduto("coxinha", "coxinha de frango", 2.50);
        assertThrows(IllegalArgumentException.class, () -> this.fornecedor.exibeProduto("pastel", "coxinha de frango"));
    }

    @Test
    void exibeTodosProdutoDeUmFornecedorTeste() {
        this.fornecedor.adicionaProduto("coxinha", "coxinha de frango", 2.50);
        this.fornecedor.adicionaProduto("pastel", "pastel de frango", 3.00);
        String todosProdutosDeUmFornecedores = this.fornecedor.exibeTodosProdutoDeUmFornecedor();
        assertEquals(todosProdutosDeUmFornecedores, this.fornecedor.exibeTodosProdutoDeUmFornecedor());
    }

    @Test
    void editaProdutoTeste() {
        this.fornecedor.adicionaProduto("coxinha", "coxinha de frango", 2.50);
        this.fornecedor.editaProduto("coxinha", "coxinha de frango", 2.00);
        assertEquals("coxinha - coxinha de frango - R$2,00", this.fornecedor.exibeProduto("coxinha", "coxinha de frango"));
    }

    @Test
    void setEmailTeste() {
        this.fornecedor.setEmail("gabriel2@gmail.com");
        assertEquals("gabriel2@gmail.com", this.fornecedor.getEmail());
    }

    @Test
    void setEmailTesteParametroNulo() {
        assertThrows(NullPointerException.class, () -> this.fornecedor.setEmail(null));
    }

    @Test
    void setEmailTesteParametroVazio() {
        assertThrows(IllegalArgumentException.class, () -> this.fornecedor.setEmail("  "));
    }

    @Test
    void setTelefoneTeste() {
        this.fornecedor.setTelefone("4002-8922");
        assertEquals("4002-8922", this.fornecedor.getTelefone());
    }

    @Test
    void setTelefoneTesteParametroNulo() {
        assertThrows(NullPointerException.class, () -> this.fornecedor.setTelefone(null));
    }

    @Test
    void setTelefoneTesteParametroVazio() {
        assertThrows(IllegalArgumentException.class, () -> this.fornecedor.setTelefone("  "));
    }

    @Test
    void toStringTeste() {
        assertEquals("Seu Gabriel - gabriel@gmail.com - 83 993348765", this.fornecedor.toString());
    }

    @Test
    void equalsTeste() {
        Fornecedor fornecedor2 = new Fornecedor("Seu Gabriel","gabriel@gmail.com","83 993348765");
        Fornecedor fornecedor3 = new Fornecedor("Seu João","gabriel@gmail.com","83 993348765");
        assertTrue(this.fornecedor.equals(this.fornecedor));
        assertFalse(this.fornecedor.equals(null));
        assertFalse(this.fornecedor.equals("Outra classe, a classe String"));
        assertTrue(this.fornecedor.equals(fornecedor2));
        assertFalse(this.fornecedor.equals(fornecedor3));

    }

    @Test
    void hashCodeTeste() {
        Fornecedor fornecedor2 = new Fornecedor("Seu Gabriel","gabriel@gmail.com","83 993348765");
        assertEquals(fornecedor2.hashCode(),this.fornecedor.hashCode());
    }

    @Test
    void removeProdutoTeste() {
        this.fornecedor.adicionaProduto("coxinha", "coxinha de frango", 2.50);
        this.fornecedor.removeProduto("coxinha", "coxinha de frango");
        assertThrows(IllegalArgumentException.class, () -> this.fornecedor.exibeProduto("coxinha","coxinha de frango"));
    }
}