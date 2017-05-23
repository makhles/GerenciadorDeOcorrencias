package modelo;

import java.util.ArrayList;
import java.util.List;

import excecoes.ExcecaoFuncionarioComIdJaCadastrado;

public class Gerenciador {

	private List<Funcionario> funcionarios;
	private List<Ocorrencia> ocorrencias;

	public Gerenciador() {
		funcionarios = new ArrayList<Funcionario>();
		ocorrencias = new ArrayList<Ocorrencia>();
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
		ocorrencias.add(ocorrencia);
	}
}
