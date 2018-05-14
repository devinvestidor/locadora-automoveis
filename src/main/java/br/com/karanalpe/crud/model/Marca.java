package br.com.karanalpe.crud.model;

import static br.com.karanalpe.crud.util.Constantes.DEFAULT_DATE;
import static br.com.karanalpe.crud.util.Constantes.DEFAULT_STRING;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class Marca implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotEmpty
	private String descricao;

	private Date dtCriacao;

	private Date dtEdicao;

	public Marca() {
		this(null, DEFAULT_STRING, DEFAULT_DATE);
	}

	public Marca(Long id, String descricao, Date dtCriacao) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.dtCriacao = dtCriacao;
	}

	public String getDescricao() {
		return descricao;
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

	public boolean isEdicao() {
		return !isInclusao();
	}

	public boolean isInclusao() {
		return getId() == null;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

}
