package modelo;

import java.util.ArrayList;
import java.util.List;

import excecoes.ExcecaoFuncionarioComIdJaCadastrado;
import excecoes.ExcecaoOcorrenciaComIdJaCadastrada;

public class Gerenciador {

	private List<Funcionario> funcionarios;
	private List<Ocorrencia> ocorrencias;
	private List<Projeto> projetos;

	public Gerenciador() {
		funcionarios = new ArrayList<Funcionario>();
		ocorrencias = new ArrayList<Ocorrencia>();
		projetos = new ArrayList<Projeto>();
	}

	public List<Funcionario> obterFuncionarios() {
		return funcionarios;
	}

	public void cadastrarFuncionario(Funcionario funcionario) {
		if (funcionarios.contains(funcionario)) {
			throw new ExcecaoFuncionarioComIdJaCadastrado();
		} else {
			funcionarios.add(funcionario);
		}
	}

	public List<Ocorrencia> obterOcorrencias() {
		return ocorrencias;
	}

	public void cadastrarOcorrencia(Ocorrencia ocorrencia) {
		if (ocorrencias.contains(ocorrencia)) {
			throw new ExcecaoOcorrenciaComIdJaCadastrada();
		} else {
			ocorrencias.add(ocorrencia);
		}
	}

	public List<Projeto> obterProjetos() {
		return projetos;
	}

	public void cadastrarProjeto(Projeto projeto) {
		projetos.add(projeto);
	}
}
