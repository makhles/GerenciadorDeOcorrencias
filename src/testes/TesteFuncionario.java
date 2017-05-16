package testes;

import static org.junit.Assert.*;

import modelo.Gerenciador;

import org.junit.Before;
import org.junit.Test;

public class TesteFuncionario {

	private Gerenciador gerenciador;

	@Before
	public void init() {
		gerenciador = new Gerenciador();
	}
	@Test
	
	public void testeCadastroVazio() throws Exception {
		assertEquals(0, gerenciador.obterQuantidadeDeFuncionarios());
	}

	@Test
	public void testeCadastrarFuncionario() throws Exception {
		gerenciador.cadastrarFuncionario();
		assertEquals(1, gerenciador.obterQuantidadeDeFuncionarios());
	}
}
