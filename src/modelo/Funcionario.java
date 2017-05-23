package modelo;

public class Funcionario {

	private String nome;
	private int id;

	public Funcionario(int id, String nome) {
		this.id = id;
		this.nome = nome;
		
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
		if (!(obj instanceof Funcionario)) {
			return false;
		}
		Funcionario other = (Funcionario) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}

}
