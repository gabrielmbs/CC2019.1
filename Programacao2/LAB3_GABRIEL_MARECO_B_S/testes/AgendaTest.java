import lab3.Agenda;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgendaTest {
	private Agenda agenda;

	@BeforeEach
	void setUp() {
		this.agenda = new Agenda();
	}

	@Test
	void TestecadastrarContatoPosicaoValida() {
		assertTrue(agenda.cadastrarContato(1, "Gabriel", "Mareco", "(83) 99231-8975"));
		// Cadastrar um novo contato em posição existente
		assertTrue(agenda.cadastrarContato(1, "Mateus", "Silva", "(83) 99231-0000"));
		assertTrue(agenda.cadastrarContato(100, "Pedro", "Perreira", "(83) 4002-8922"));

	}

	@Test
	void TestecadastrarContatoPosicaoInvalida() {
		assertFalse(agenda.cadastrarContato(0, "Gabriel", "Mareco", "(83) 99231-8975"));
		assertFalse(agenda.cadastrarContato(101, "Mateus", "Silva", "(83) 99231-0000"));
	}

	@Test
	void pesquisarContatoPosicaoValidaTeste() {
		agenda.cadastrarContato(1, "Gabriel", "Mareco", "(83) 99231-8975");
		assertEquals("\nGabriel Mareco - (83) 99231-8975\n", agenda.pesquisarContato(1));

	}

	@Test
	void pesquisarContatoPosicaoInvalidaTeste() {
		agenda.cadastrarContato(1, "Gabriel", "Mareco", "(83) 99231-8975");
		assertEquals("POSIÇÃO INVÁLIDA!\n", agenda.pesquisarContato(2));
		assertEquals("POSIÇÃO INVÁLIDA!\n", agenda.pesquisarContato(0));
	}

	@Test
	void listarContatosTeste() {
		agenda.cadastrarContato(50, "Gabriel", "Mareco", "(83) 99231-8975");
		agenda.cadastrarContato(100, "Pedro", "Mareco", "(83) 99231-0000");
		agenda.cadastrarContato(1, "Mateus", "Silva", "(83) 3333-8465");
		assertEquals("\n1 - Mateus Silva\n" + "50 - Gabriel Mareco\n" + "100 - Pedro Mareco\n",
				agenda.listarContatos());
	}

	@Test
	void equalsMesmoTipoTeste() {
		Agenda agenda2 = new Agenda();
		assertTrue(agenda.equals(agenda2));
		assertTrue(agenda.equals(agenda));

	}

	@Test
	void equalsTiposDiferentesTeste() {
		Object agenda2 = new Object();
		assertFalse(agenda.equals(agenda2));
		assertFalse(agenda.equals(null));
	}

	@Test
	void equalsValoresDiferentesTeste() {
		Agenda agenda2 = new Agenda();
		agenda.cadastrarContato(1, "Gabriel", "Mareco", "(83) 99231-8975");
		assertFalse(agenda.equals(agenda2));
	}

	@Test
	void hashCodeTeste() {
		Agenda agenda2 = new Agenda();
		assertEquals(agenda.hashCode(), agenda2.hashCode());
	}
}