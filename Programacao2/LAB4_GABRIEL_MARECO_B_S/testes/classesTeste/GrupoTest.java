package classesTeste;

import classes.Aluno;
import classes.Grupo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrupoTest {

    Grupo grupo;
    Aluno aluno;

    @BeforeEach
    void setUp() {
        this.grupo = new Grupo("Listas");
        this.aluno = new Aluno("gabriel", "computação", "1");
    }

    @Test
    void TesteConstrutor() {
        assertEquals("Listas", this.grupo.getNome());
        assertTrue(this.grupo.getAlunos().isEmpty());

        try {
            Grupo grupo2 = new Grupo(" ");
            fail("Falha. Uma exceção deve ser lançada!");
        }catch (IllegalArgumentException ex){ }
        try {
            Grupo grupo3 = new Grupo(null);
            fail("Falha. Uma exceção deve ser lançada!");
        }catch (NullPointerException ex){ }

    }

    @Test
    void alocarTeste() {
        this.grupo.alocar(this.aluno);
        assertFalse(this.grupo.getAlunos().isEmpty());

    }

    @Test
    void imprimirAlunosTeste() {
        this.grupo.alocar(this.aluno);
        assertEquals("\nAlunos do grupo Listas:\n* 1 - gabriel - computação\n", this.grupo.imprimirAlunos());
    }

    @Test
    void equalsTeste() {
        assertEquals(this.grupo, this.grupo);
        assertFalse(this.grupo.equals(null));
        assertFalse(this.grupo.equals("Objeto de outra classe"));

        Grupo grupo2 = new Grupo("Atividade");
        assertFalse(this.grupo.equals(grupo2));
        grupo2 = new Grupo("Listas");
        assertTrue(this.grupo.equals(grupo2));
    }

    @Test
    void hashCodeTeste() {
        Grupo grupo2 = new Grupo("Listas");
        assertEquals(grupo2.hashCode(), this.grupo.hashCode());
    }

}