package br.univel.model;

import java.io.Serializable;

public class Pet implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private int version;

	private String nome;

	private String especie;

	private String nome_dono;

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(final int version) {
		this.version = version;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Pet)) {
			return false;
		}
		Pet other = (Pet) obj;
		if (id != null) {
			if (!id.equals(other.id)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getNome_dono() {
		return nome_dono;
	}

	public void setNome_dono(String nome_dono) {
		this.nome_dono = nome_dono;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (nome != null && !nome.trim().isEmpty())
			result += "nome: " + nome;
		if (especie != null && !especie.trim().isEmpty())
			result += ", especie: " + especie;
		if (nome_dono != null && !nome_dono.trim().isEmpty())
			result += ", nome_dono: " + nome_dono;
		return result;
	}
}