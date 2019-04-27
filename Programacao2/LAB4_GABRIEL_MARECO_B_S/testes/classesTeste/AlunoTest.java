package classesTeste;

import classes.Aluno;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {

    Aluno aluno;

    @BeforeEach
    void setUp() {
        aluno = new Aluno("Gabriel", "Computação", "1");
    }

    @Test
    void ConstrutorTeste() {
        assertEquals("Gabriel", aluno.getNome());
        assertEquals("Computação", aluno.getCurso());
        assertEquals("1", aluno.getMatricula());

        try {
           aluno = new Aluno("  ", "Computação", "1");
            fail("Falha. Uma exceção deve ser lançada!");
        }catch (IllegalArgumentException ex){}
        try {
            aluno = new Aluno("Pedro", " ", "1");
            fail("Falha. Uma exceção deve ser lançada!");
        }catch (IllegalArgumentException ex){}
        try {
            aluno = new Aluno("Pedro", "Computação", " ");
            fail("Falha. Uma exceção deve ser lançada!");
        }catch (IllegalArgumentException ex){}
        try {
            aluno = new Aluno(null, "Computação", "1");
            fail("Falha. Uma exceção deve ser lançada!");
        }catch (NullPointerException ex){}
        try {
            aluno = new Aluno("Pedro", null, "1");
            fail("Falha. Uma exceção deve ser lançada!");
        }catch (NullPointerException ex){}
        try {
            aluno = new Aluno("Pedro", "Computação", null);
            fail("Falha. Uma exceção deve ser lançada!");
        }catch (NullPointerException ex){}
    }

    @Test
    void toString1() {
        assertEquals("1 - Gabriel - Computação", aluno.toString());
    }

    @Test
    void equalsTeste() {
        Aluno aluno2 = new Aluno("Gabriel", "Computação", "1");
        assertTrue(aluno.equals(aluno));
        assertFalse(aluno.equals(null));
        assertFalse(aluno.equals("Objeto de outra classe"));

        assertTrue(aluno.equals(aluno2));
        aluno2 = new Aluno("Pedro", "Fisica", "2");
        assertFalse(aluno.equals(aluno2));

    }

    @Test
    void hashCodeTeste() {
        Aluno aluno2 = new Aluno("Gabriel", "Computação", "1");
        assertEquals(aluno.hashCode(), aluno2.hashCode());
    }
}