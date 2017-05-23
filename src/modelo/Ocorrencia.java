package modelo;

import excecoes.ExcecaoMudancaResponsavelComOcorrenciaFechada;
import modelo.enums.Prioridade;
import modelo.enums.TipoOcorrencia;

public class Ocorrencia {

	private Prioridade prioridade;
	private TipoOcorrencia tipo;
	private boolean aberta;
	private Funcionario responsavel;
	private String resumo;

	public Ocorrencia(Funcionario responsavel, TipoOcorrencia tipo,
			Prioridade prioridade, String resumo) {
		this.responsavel = responsavel;
		this.tipo = tipo;
		this.prioridade = prioridade;
		this.resumo = resumo;
		aberta = true;
	}

	public Prioridade getPrioridade() {
		return prioridade;
	}

	public TipoOcorrencia getTipo() {
		return tipo;
	}

	public boolean estaAberta() {
		return aberta;
	}

	public Funcionario getResponsavel() {
		return responsavel;
	}

	public String getResumo() {
		return resumo;
	}

	public void mudarResponsavel(Funcionario novoResponsavel) {
		if (estaAberta()) {
			responsavel = novoResponsavel;
		} else {
			throw new ExcecaoMudancaResponsavelComOcorrenciaFechada();
		}
	}

	public void mudarPrioridade(Prioridade novaPrioridade) {
		if (estaAberta()) {
			prioridade = novaPrioridade;
		} else {
			throw new excecoes.ExcecaoMudancaPrioridadeComOcorrenciaFechada();
		}
	}

	public void fecharOcorrencia() {
		aberta = false;
	}

}
