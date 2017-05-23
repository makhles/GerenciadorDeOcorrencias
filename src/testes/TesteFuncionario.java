package testes;

import static org.junit.Assert.*;

import modelo.Funcionario;
import modelo.Gerenciador;

import org.junit.Before;
import org.junit.Test;

public class TesteFuncionario {

//	private Gerenciador gerenciador;
//
//	@Before
//	public void init() {
//		gerenciador = new Gerenciador();
//	}
//

	@Test
	public void testeCriarBob() throws Exception {
		Funcionario bob = new Funcionario(1, "Bob");
		assertEquals("Bob", bob.toString());
	}

	@Test
	public void testarIgualdade() throws Exception {
		Funcionario bob1 = new Funcionario(1, "Bob");
		Funcionario bob2 = new Funcionario(1, "Bob");
		assertEquals(bob1, bob2);
	}

//	@Test
//	public void testeCadastroVazio() throws Exception {
//		assertEquals(0, gerenciador.obterQuantidadeDeFuncionarios());
//	}
//
//	@Test
//	public void testeCadastrarFuncionario() throws Exception {
//		gerenciador.cadastrarFuncionario();
//		assertEquals(1, gerenciador.obterQuantidadeDeFuncionarios());
//	}
}
