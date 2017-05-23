package modelo;

import modelo.enums.Prioridade;
import modelo.enums.TipoOcorrencia;

public class Ocorrencia {

	private Prioridade prioridade;
	private TipoOcorrencia tipo;

	public Ocorrencia(TipoOcorrencia tipo, Prioridade prioridade) {
		this.tipo = tipo;
		this.prioridade = prioridade;
	}

	public Prioridade getPrioridade() {
		return prioridade;
	}

	public TipoOcorrencia getTipo() {
		return tipo;
	}

}
