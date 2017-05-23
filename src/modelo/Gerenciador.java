package modelo;

import java.util.ArrayList;
import java.util.List;

public class Gerenciador {

	private List<Funcionario> funcionarios;

	public Gerenciador() {
		funcionarios = new ArrayList<Funcionario>();
	}

	public List<Funcionario> obterFuncionarios() {
		return new ArrayList<Funcionario>();
	}

	public void cadastrarFuncionario() {
//		funcionarios.add(new Funcionario());
	}

	public int obterQuantidadeDeFuncionarios() {
		return funcionarios.size();
	}

}
