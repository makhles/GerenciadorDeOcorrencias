package testes;

import static org.junit.Assert.*;

import modelo.Projeto;

import org.junit.Test;

public class TesteProjeto {

	@Test
	public void testeCriarProjeto() throws Exception {
		Projeto manhattan = new Projeto(1, "Manhattan");
		assertEquals("Manhattan", manhattan.obterNome());
	}

	@Test
	public void testeIgualdadeEntreProjetos() throws Exception {
		Projeto manhattan = new Projeto(1, "Manhattan");
		Projeto newOrder = new Projeto(1, "New Order");
		assertEquals(manhattan, newOrder);
	}
}
