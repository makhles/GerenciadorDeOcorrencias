package testes;

import static org.junit.Assert.*;

import modelo.Gerenciador;
import modelo.Projeto;

import org.junit.Before;
import org.junit.Test;

public class TesteCadastroDeProjeto {

	private Gerenciador gerenciador;

	@Before
	public void init() {
		gerenciador = new Gerenciador();
	}

	@Test
	public void testeCadastroVazio() throws Exception {
		assertTrue(gerenciador.obterProjetos().isEmpty());
	}

	@Test
	public void testeCadastrarProjeto() throws Exception {
		Projeto manhattan = new Projeto(1, "Manhattan");
		gerenciador.cadastrarProjeto(manhattan);
		assertEquals(1, gerenciador.obterProjetos().size());
		assertEquals(manhattan, gerenciador.obterProjetos().get(0));
	}
}
