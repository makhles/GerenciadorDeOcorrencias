package testes;

import static org.junit.Assert.*;

import modelo.Ocorrencia;
import modelo.enums.Prioridade;
import modelo.enums.TipoOcorrencia;

import org.junit.Test;

public class TesteOcorrencia {

	@Test
	public void testeCriacaoOcorrencia() throws Exception {
		Ocorrencia ocorrencia = new Ocorrencia(TipoOcorrencia.BUG, Prioridade.ALTA);
		assertEquals(Prioridade.ALTA, ocorrencia.getPrioridade());
		assertEquals(TipoOcorrencia.BUG, ocorrencia.getTipo());
	}
}
