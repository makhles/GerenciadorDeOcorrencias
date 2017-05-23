package modelo;

import java.util.ArrayList;
import java.util.List;

import excecoes.ExcecaoFuncionarioComIdJaCadastrado;

public class Gerenciador {

	private List<Funcionario> funcionarios;

	public Gerenciador() {
		funcionarios = new ArrayList<Funcionario>();
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
}
