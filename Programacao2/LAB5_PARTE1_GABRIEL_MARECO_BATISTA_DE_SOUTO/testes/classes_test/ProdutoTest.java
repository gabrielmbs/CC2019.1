package classes_test;

import classes.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoTest {
    Produto produto;

    @BeforeEach
    void setUp() {
        this.produto = new Produto("coxinha","coxinha de frango",0.00);
    }

    @Test
    void construtorTeste() {
        assertEquals("coxinha",this.produto.getNome());
        assertEquals("coxinha de frango", this.produto.getDescricao());
        assertEquals(0.00,this.produto.getPreco());
    }

    @Test
    void construtorTesteParametrosNulos() {
        assertThrows(NullPointerException.class, () -> new Produto(null,"comida de carne", 5.0));
        assertThrows(NullPointerException.class, () -> new Produto("comida",null, 5.0));
    }

    @Test
    void construtorTesteParametrosVazios() {
        assertThrows(IllegalArgumentException.class, () -> new Produto("  ","comida de carne", 5.0));
        assertThrows(IllegalArgumentException.class, () -> new Produto("comida","  ", 5.0));
    }

    @Test
    void construtorTesteParametrosNegativo() {
        assertThrows(IllegalArgumentException.class, () -> new Produto("comida","comida de carne", -5.0));
    }

    @Test
    void setPrecoTeste() {
        this.produto.setPreco(2.00);
        assertEquals(2.00, this.produto.getPreco());
    }

    @Test
    void toStringTeste() {
        assertEquals("coxinha - coxinha de frango - R$0,00", this.produto.toString());
    }

    @Test
    void equalsTeste() {
        Produto produto2 = new Produto("coxinha", "coxinha de frango", 0.00);
        Produto produto3 = new Produto("pastel", "coxinha de frango", 0.00);
        assertTrue(this.produto.equals(this.produto));
        assertFalse(this.produto.equals(null));
        assertFalse(this.produto.equals("Outra classe, classe String"));
        assertTrue(this.produto.equals(produto2));
        assertFalse(this.produto.equals(produto3));

    }

    @Test
    void hashCodeTeste() {
        Produto produto2 = new Produto("coxinha", "coxinha de frango", 0.00);
        assertEquals(produto2.hashCode(), this.produto.hashCode());
    }
}