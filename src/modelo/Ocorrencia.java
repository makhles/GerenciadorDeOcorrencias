package modelo;

import excecoes.ExcecaoMudancaResponsavelComOcorrenciaFechada;
import modelo.enums.Prioridade;
import modelo.enums.TipoOcorrencia;

public class Ocorrencia {

	private int id;
	private Prioridade prioridade;
	private TipoOcorrencia tipo;
	private boolean aberta;
	private Funcionario responsavel;
	private String resumo;

	public Ocorrencia(int id, Funcionario responsavel, TipoOcorrencia tipo,
			Prioridade prioridade, String resumo) {
		this.id = id;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Ocorrencia [id=" + id + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Ocorrencia)) {
			return false;
		}
		Ocorrencia other = (Ocorrencia) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}

}
