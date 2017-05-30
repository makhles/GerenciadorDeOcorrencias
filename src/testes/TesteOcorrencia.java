package testes;

import static org.junit.Assert.*;

import modelo.Funcionario;
import modelo.Ocorrencia;
import modelo.enums.Prioridade;
import modelo.enums.TipoOcorrencia;

import org.junit.Before;
import org.junit.Test;

import excecoes.ExcecaoMudancaPrioridadeComOcorrenciaFechada;
import excecoes.ExcecaoMudancaResponsavelComOcorrenciaFechada;

public class TesteOcorrencia {

	private final String RESUMO = "TL;DR";
	private Ocorrencia ocorrencia;
	private Funcionario bob;

	@Before
	public void init() {
		bob = new Funcionario(1, "Bob");
		ocorrencia = new Ocorrencia(1, bob, TipoOcorrencia.BUG, Prioridade.ALTA, RESUMO);
	}

	@Test
	public void testeCriacaoOcorrencia() throws Exception {
		assertEquals(bob, ocorrencia.getResponsavel());
		assertEquals(TipoOcorrencia.BUG, ocorrencia.getTipo());
		assertEquals(Prioridade.ALTA, ocorrencia.getPrioridade());
		assertEquals(RESUMO, ocorrencia.getResumo());
		assertTrue(ocorrencia.estaAberta());
	}

	@Test
	public void testeCriarOcorrenciasDeMesmoId() throws Exception {
		Ocorrencia anotherBug = new Ocorrencia(1, bob, TipoOcorrencia.BUG, Prioridade.ALTA, RESUMO);
		assertEquals(anotherBug, ocorrencia);
	}

	@Test
	public void testeMudarResponsavelComOcorrenciaAberta() throws Exception {
		assertEquals(bob, ocorrencia.getResponsavel());
		Funcionario alice = new Funcionario(2, "Alice");
		ocorrencia.mudarResponsavel(alice);
		assertEquals(alice, ocorrencia.getResponsavel());
	}

	@Test
	public void testeMudarPrioridadeComOcorrenciaAberta() throws Exception {
		assertEquals(Prioridade.ALTA, ocorrencia.getPrioridade());
		ocorrencia.mudarPrioridade(Prioridade.BAIXA);
		assertEquals(Prioridade.BAIXA, ocorrencia.getPrioridade());
	}

	@Test
	public void testeFecharOcorrencia() throws Exception {
		ocorrencia.fecharOcorrencia();
		assertFalse(ocorrencia.estaAberta());
	}

	@Test(expected = ExcecaoMudancaResponsavelComOcorrenciaFechada.class)
	public void testeMudarResponsavelComOcorrenciaFechada() throws Exception {
		assertEquals(bob, ocorrencia.getResponsavel());
		ocorrencia.fecharOcorrencia();
		Funcionario alice = new Funcionario(2, "Alice");
		ocorrencia.mudarResponsavel(alice);
	}

	@Test(expected = ExcecaoMudancaPrioridadeComOcorrenciaFechada.class)
	public void testeMudarPrioridadeComOcorrenciaFechada() throws Exception {
		assertEquals(Prioridade.ALTA, ocorrencia.getPrioridade());
		ocorrencia.fecharOcorrencia();
		ocorrencia.mudarPrioridade(Prioridade.BAIXA);
	}

}
