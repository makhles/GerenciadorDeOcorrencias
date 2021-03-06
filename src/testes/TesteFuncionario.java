package testes;

import static org.junit.Assert.assertEquals;
import modelo.Funcionario;

import org.junit.Test;

public class TesteFuncionario {

	@Test
	public void testeCriarBob() throws Exception {
		Funcionario bob = new Funcionario(1, "Bob");
		assertEquals("Bob (1)", bob.toString());
	}

	@Test
	public void testarIgualdade() throws Exception {
		Funcionario bob = new Funcionario(1, "Bob");
		Funcionario alice = new Funcionario(1, "Alice");
		assertEquals(bob, alice);
	}
}
