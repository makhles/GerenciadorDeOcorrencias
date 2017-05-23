package modelo;

public class Projeto {

	private String nome;
	private int id;

	public Projeto(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public String obterNome() {
		return nome;
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

}
