package modelo;

import java.util.ArrayList;
import java.util.List;

import excecoes.ExcecaoFuncionarioComIdJaCadastrado;
import excecoes.ExcecaoOcorrenciaComIdJaCadastrada;
import excecoes.ExcecaoProjetoNaoCadastrado;

public class Gerenciador {

	private List<Funcionario> funcionarios;
	private List<Projeto> projetos;

	public Gerenciador() {
		funcionarios = new ArrayList<Funcionario>();
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

	public void cadastrarOcorrencia(Ocorrencia ocorrencia, Projeto projeto) {
		Projeto p = obterProjetoComId(projeto.getId());
		if (p != null) {
			List<Ocorrencia> ocorrencias = p.obterOcorrencias();
			if (ocorrencias.contains(ocorrencia)) {
				throw new ExcecaoOcorrenciaComIdJaCadastrada();
			} else {
				p.cadastrarOcorrencia(ocorrencia);
			}
		} else {
			throw new ExcecaoProjetoNaoCadastrado();
		}
	}

	public List<Projeto> obterProjetos() {
		return projetos;
	}

	public void cadastrarProjeto(Projeto projeto) {
		projetos.add(projeto);
	}

	public Projeto obterProjetoComId(int id) {
		Projeto projeto = null;
		for (Projeto p : projetos) {
			if (p.getId() == id) {
				projeto = p;
			}
		}
		return projeto;
	}
}
