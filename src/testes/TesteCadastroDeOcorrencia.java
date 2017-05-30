package testes;

import static org.junit.Assert.*;

import modelo.Funcionario;
import modelo.Gerenciador;
import modelo.Ocorrencia;
import modelo.Projeto;
import modelo.enums.Prioridade;
import modelo.enums.TipoOcorrencia;

import org.junit.Before;
import org.junit.Test;

import excecoes.ExcecaoOcorrenciaComIdJaCadastrada;
import excecoes.ExcecaoProjetoNaoCadastrado;

public class TesteCadastroDeOcorrencia {

	private Gerenciador gerenciador;
	private Projeto manhattan;

	@Before
	public void init() {
		gerenciador = new Gerenciador();
		manhattan = new Projeto(1, "Manhattan");
		gerenciador.cadastrarProjeto(manhattan);
	}

	@Test
	public void testeCadastroVazio() throws Exception {
		assertEquals(0, gerenciador.obterProjetos().get(0).obterOcorrencias().size());
	}

	@Test
	public void testeCadastrarOcorrencia() throws Exception {
		final String RESUMO = "TL;DR";
		Funcionario bob = new Funcionario(1, "Bob");
		Ocorrencia superBug = new Ocorrencia(1, bob, TipoOcorrencia.BUG, Prioridade.ALTA, RESUMO);
		gerenciador.cadastrarOcorrencia(superBug, manhattan);
		assertEquals(1, gerenciador.obterProjetoComId(1).obterOcorrencias().size());
		assertEquals(superBug, gerenciador.obterProjetoComId(1).obterOcorrencias().get(0));
	}

	@Test(expected = ExcecaoOcorrenciaComIdJaCadastrada.class)
	public void testeCadastrarOcorrenciaComIdJaCadastrado() throws Exception {
		final String RESUMO = "TL;DR";
		Funcionario bob = new Funcionario(1, "Bob");
		Ocorrencia superBug = new Ocorrencia(1, bob, TipoOcorrencia.BUG, Prioridade.ALTA, RESUMO);
		Ocorrencia minorBug = new Ocorrencia(1, bob, TipoOcorrencia.BUG, Prioridade.BAIXA, RESUMO);
		gerenciador.cadastrarOcorrencia(superBug, manhattan);
		gerenciador.cadastrarOcorrencia(minorBug, manhattan);
	}

	@Test(expected = ExcecaoProjetoNaoCadastrado.class)
	public void testeCadastrarOcorrenciaEmProjetoNaoCadastrado() throws Exception {
		final String RESUMO = "TL;DR";
		Funcionario bob = new Funcionario(1, "Bob");
		Ocorrencia superBug = new Ocorrencia(1, bob, TipoOcorrencia.BUG, Prioridade.ALTA, RESUMO);
		Ocorrencia minorBug = new Ocorrencia(1, bob, TipoOcorrencia.BUG, Prioridade.BAIXA, RESUMO);
		Projeto newOrder = new Projeto(2, "NewOrder");
		gerenciador.cadastrarOcorrencia(superBug, newOrder);
		gerenciador.cadastrarOcorrencia(minorBug, newOrder);
	}
}
