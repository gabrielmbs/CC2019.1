package classesTeste;

import classes.ControleAlunos;
import classes.StatusCadastro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControleAlunosTest {

    ControleAlunos turma;

    @BeforeEach
    void setUp() {
        this.turma = new ControleAlunos();

    }

    @Test
    void testeConstrutor() {
        assertTrue(this.turma.getAlunosResponderam().isEmpty());
        assertTrue(this.turma.getMapaGrupo().isEmpty());
        assertTrue(this.turma.getMapaMatriculaAlunos().isEmpty());
    }

    @Test
    void cadastraAlunoTeste() {
        assertTrue(this.turma.cadastraAluno("10","Gabriel","Computação"));
        assertFalse(this.turma.getMapaMatriculaAlunos().isEmpty());

        assertFalse(this.turma.cadastraAluno("10","Pedro","Computação"));

        try {
            this.turma.cadastraAluno(null,"Gabriel","Computação");
            fail("Falha. Uma exceção deve ser lançada!");
        }catch(NullPointerException ex){}

        try {
            this.turma.cadastraAluno("12",null,"Computação");
            fail("Falha. Uma exceção deve ser lançada!");
        }catch (NullPointerException ex){ }

        try {
            this.turma.cadastraAluno("123","Gabriel",null);
            fail("Falha. Uma exceção deve ser lançada!");
        }catch (NullPointerException ex){ }

        try {
            this.turma.cadastraAluno("   ","Gabriel","Computação");
            fail("Falha. Uma exceção deve ser lançada!");
        }catch (IllegalArgumentException ex){ }

        try {
            this.turma.cadastraAluno("231","  ","Computação");
            fail("Falha. Uma exceção deve ser lançada!");
        }catch (IllegalArgumentException ex){ }

        try {
            this.turma.cadastraAluno("432","Gabriel"," ");
            fail("Falha. Uma exceção deve ser lançada!");
        }catch (IllegalArgumentException ex){ }




    }

    @Test
    void exibirAlunoTeste() {
        this.turma.cadastraAluno("10","Gabriel","Computação");
        assertEquals("\nAluno: 10 - Gabriel - Computação", this.turma.exibirAluno("10"));
        assertEquals("\nAluno não cadastrado.", this.turma.exibirAluno("1"));
        try {
            this.turma.exibirAluno("  ");
            fail("Falha. Uma exceção deve ser lançada!");
        }catch (IllegalArgumentException ex){ }
        try {
            this.turma.exibirAluno(null);
            fail("Falha. Uma exceção deve ser lançada!");
        }catch (NullPointerException ex){ }

    }

    @Test
    void novoGrupoTeste() {
        assertTrue(this.turma.novoGrupo("Listas"));
        assertFalse(this.turma.novoGrupo("Listas"));
        assertFalse(this.turma.novoGrupo("listas"));
        assertFalse(this.turma.novoGrupo("LISTAS"));

        try {
            this.turma.novoGrupo("  ");
            fail("Falha. Uma exceção deve ser lançada!");
        }catch (IllegalArgumentException ex){ }
        try {
            this.turma.novoGrupo(null);
            fail("Falha. Uma exceção deve ser lançada!");
        }catch (NullPointerException ex){ }


    }

    @Test
    void alocarAlunoTeste() {
        this.turma.novoGrupo("Listas");
        this.turma.cadastraAluno("10","Gabriel","Computação");

        StatusCadastro resultado = this.turma.alocarAluno("10", "listas");
        assertEquals(StatusCadastro.Sucesso, resultado);
        StatusCadastro resultado2 = this.turma.alocarAluno("15", "listas");
        assertEquals(StatusCadastro.AlunoNaoCadastrado, resultado2);
        StatusCadastro resultado3 = this.turma.alocarAluno("10", "atividade");
        assertEquals(StatusCadastro.SemGrupo, resultado3);

        try {
            this.turma.alocarAluno("  ", "listas");
            fail("Falha. Uma exceção deve ser lançada!");
        }catch (IllegalArgumentException ex){ }
        try {
            this.turma.alocarAluno(null, "listas");
            fail("Falha. Uma exceção deve ser lançada!");
        }catch (NullPointerException ex){ }

        try {
            this.turma.alocarAluno("10", " ");
            fail("Falha. Uma exceção deve ser lançada!");
        }catch (IllegalArgumentException ex){ }
        try {
            this.turma.alocarAluno("10", null);
            fail("Falha. Uma exceção deve ser lançada!");
        }catch (NullPointerException ex){ }
    }

    @Test
    void imprimirGrupoTeste() {
        this.turma.novoGrupo("Listas");
        this.turma.cadastraAluno("10","Gabriel","Computação");
        this.turma.alocarAluno("10", "listas");
        assertEquals("\nAlunos do grupo Listas:\n* 10 - Gabriel - Computação\n", this.turma.imprimirGrupo("listas"));
        assertEquals("Grupo não cadastrado.", this.turma.imprimirGrupo("lista") );

        try {
            this.turma.imprimirGrupo(" ");
            fail("Falha. Uma exceção deve ser lançada!");
        }catch (IllegalArgumentException ex){ }
        try {
            this.turma.imprimirGrupo(null);
            fail("Falha. Uma exceção deve ser lançada!");
        }catch (NullPointerException ex){ }
    }

    @Test
    void registrarAlunosResponderamTeste() {
        this.turma.cadastraAluno("10","Gabriel","Computação");
        assertTrue(this.turma.registrarAlunosResponderam("10"));
        assertFalse(this.turma.registrarAlunosResponderam("15"));

        try {
            this.turma.registrarAlunosResponderam(" ");
            fail("Falha. Uma exceção deve ser lançada!");
        }catch (IllegalArgumentException ex){ }
        try {
            this.turma.registrarAlunosResponderam(null);
            fail("Falha. Uma exceção deve ser lançada!");
        }catch (NullPointerException ex){ }
    }

    @Test
    void imprimirAlunosResponderamTeste() {
        this.turma.cadastraAluno("10","Gabriel","Computação");
        this.turma.cadastraAluno("11","Pedro","Fisica");
        this.turma.registrarAlunosResponderam("11");
        this.turma.registrarAlunosResponderam("10");
        assertEquals("\nAlunos:\n1. 11 - Pedro - Fisica\n2. 10 - Gabriel - Computação\n", this.turma.imprimirAlunosResponderam());
    }
}