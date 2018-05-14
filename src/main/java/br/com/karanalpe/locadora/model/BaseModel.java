package br.com.karanalpe.locadora.model;

import static br.com.karanalpe.locadora.util.Constantes.DEFAULT_DATE;

import java.io.Serializable;
import java.util.Date;;

public class BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private Date dtCriacao;

	private Date dtEdicao;

	public BaseModel() {
		this(null, DEFAULT_DATE);
	}

	public BaseModel(Long id, Date dtCriacao) {
		super();
		this.id = id;
		this.dtCriacao = dtCriacao;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseModel other = (BaseModel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Date getDtCriacao() {
		return dtCriacao;
	}

	public Date getDtEdicao() {
		return dtEdicao;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public boolean isEdicao() {
		return !isInclusao();
	}

	public boolean isInclusao() {
		return getId() == null;
	}

	public void setDtCriacao(Date dtCriacao) {
		this.dtCriacao = dtCriacao;
	}

	public void setDtEdicao(Date dtEdicao) {
		this.dtEdicao = dtEdicao;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "BaseModel [id=" + id + ", dtCriacao=" + dtCriacao + ", dtEdicao=" + dtEdicao + "]";
	}

}
