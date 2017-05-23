package testes;

import static org.junit.Assert.*;

import modelo.Funcionario;
import modelo.Ocorrencia;
import modelo.enums.Prioridade;
import modelo.enums.TipoOcorrencia;

import org.junit.Test;

public class TesteOcorrencia {

	@Test
	public void testeCriacaoOcorrencia() throws Exception {
		final String RESUMO = "TL;DR";
		Funcionario bob = new Funcionario(1, "Bob");
		Ocorrencia ocorrencia = new Ocorrencia(bob, TipoOcorrencia.BUG, Prioridade.ALTA, RESUMO);
		assertEquals(bob, ocorrencia.getResponsavel());
		assertEquals(TipoOcorrencia.BUG, ocorrencia.getTipo());
		assertEquals(Prioridade.ALTA, ocorrencia.getPrioridade());
		assertEquals(Prioridade.ALTA, ocorrencia.getPrioridade());
		assertEquals(RESUMO, ocorrencia.getResumo());
		assertTrue(ocorrencia.estaAberta());
	}
}
