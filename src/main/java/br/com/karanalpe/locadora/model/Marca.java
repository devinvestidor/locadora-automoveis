package br.com.karanalpe.locadora.model;

import static br.com.karanalpe.locadora.util.Constantes.DEFAULT_DATE;
import static br.com.karanalpe.locadora.util.Constantes.DEFAULT_STRING;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class Marca extends BaseModel {

	private static final long serialVersionUID = 1L;

	@NotEmpty
	private String descricao;

	public Marca() {
		this(null, DEFAULT_STRING, DEFAULT_DATE);
	}

	public Marca(Long id, String descricao, Date dtInclusao) {
		super(id, dtInclusao);
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
