package testes;

import static org.junit.Assert.*;

import modelo.Funcionario;
import modelo.Gerenciador;
import modelo.Ocorrencia;
import modelo.enums.Prioridade;
import modelo.enums.TipoOcorrencia;

import org.junit.Before;
import org.junit.Test;

import excecoes.ExcecaoOcorrenciaComIdJaCadastrada;

public class TesteCadastroDeOcorrencia {

	private Gerenciador gerenciador;

	@Before
	public void init() {
		gerenciador = new Gerenciador();
	}

	@Test
	public void testeCadastroVazio() throws Exception {
		assertEquals(0, gerenciador.obterOcorrencias().size());
	}

	@Test
	public void testeCadastrarOcorrencia() throws Exception {
		final String RESUMO = "TL;DR";
		Funcionario bob = new Funcionario(1, "Bob");
		Ocorrencia superBug = new Ocorrencia(1, bob, TipoOcorrencia.BUG, Prioridade.ALTA, RESUMO);
		gerenciador.cadastrarOcorrencia(superBug);
		assertEquals(1, gerenciador.obterOcorrencias().size());
		assertEquals(superBug, gerenciador.obterOcorrencias().get(0));
	}

	@Test(expected = ExcecaoOcorrenciaComIdJaCadastrada.class)
	public void testeCadastrarOcorrenciaComIdJaCadastrado() throws Exception {
		final String RESUMO = "TL;DR";
		Funcionario bob = new Funcionario(1, "Bob");
		Ocorrencia superBug = new Ocorrencia(1, bob, TipoOcorrencia.BUG, Prioridade.ALTA, RESUMO);
		Ocorrencia minorBug = new Ocorrencia(1, bob, TipoOcorrencia.BUG, Prioridade.BAIXA, RESUMO);
		gerenciador.cadastrarOcorrencia(superBug);
		gerenciador.cadastrarOcorrencia(minorBug);
	}
}
