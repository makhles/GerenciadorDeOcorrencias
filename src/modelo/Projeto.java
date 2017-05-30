package modelo;

import java.util.ArrayList;
import java.util.List;

import excecoes.ExcecaoOcorrenciaComIdJaCadastrada;

public class Projeto {

	private int id;
	private String nome;
	private List<Ocorrencia> ocorrencias;

	public Projeto(int id, String nome) {
		this.id = id;
		this.nome = nome;
		ocorrencias = new ArrayList<Ocorrencia>();
	}
	
	public void cadastrarOcorrencia(Ocorrencia ocorrencia) {
		if (ocorrencias.contains(ocorrencia)) {
			throw new ExcecaoOcorrenciaComIdJaCadastrada();
		} else {
			ocorrencias.add(ocorrencia);
		}
	}

	public String obterNome() {
		return nome;
	}

	public List<Ocorrencia> obterOcorrencias() {
		return ocorrencias;
	}

	@Override
	public String toString() {
		return nome;
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
		if (!(obj instanceof Projeto)) {
			return false;
		}
		Projeto other = (Projeto) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}

	public int getId() {
		return id;
	}

}
