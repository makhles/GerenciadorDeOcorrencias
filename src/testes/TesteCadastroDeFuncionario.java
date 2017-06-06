package testes;

import static org.junit.Assert.*;
import modelo.Funcionario;
import modelo.Gerenciador;

import org.junit.Before;
import org.junit.Test;

import excecoes.ExcecaoFuncionarioComIdJaCadastrado;

public class TesteCadastroDeFuncionario {

	private Gerenciador gerenciador;

	@Before
	public void init() {
		gerenciador = new Gerenciador();
	}

	@Test
	public void testeCadastroVazio() throws Exception {
		assertEquals(0, gerenciador.obterFuncionarios().size());
	}

	@Test
	public void testeCadastrarFuncionario() throws Exception {
		Funcionario bob = new Funcionario(1, "Bob");
		gerenciador.cadastrarFuncionario(bob);
		assertEquals(1, gerenciador.obterFuncionarios().size());
		assertEquals(bob, gerenciador.obterFuncionarios().get(0));
	}

	@Test(expected = ExcecaoFuncionarioComIdJaCadastrado.class)
	public void testeCadastrarDoisFuncionariosComMesmoId() throws Exception {
		Funcionario bob = new Funcionario(1, "Bob");
		Funcionario alice = new Funcionario(1, "Alice");
		gerenciador.cadastrarFuncionario(bob);
		gerenciador.cadastrarFuncionario(alice);
	}
}
