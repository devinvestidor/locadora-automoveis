package br.com.karanalpe.locadora.model;

import static br.com.karanalpe.locadora.util.Constantes.DEFAULT_BIG_DECIMAL;
import static br.com.karanalpe.locadora.util.Constantes.DEFAULT_DATE;
import static br.com.karanalpe.locadora.util.Constantes.DEFAULT_STRING;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class Carro implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotNull
	private Marca marca;

	@NotEmpty
	private String descricao;

	@NotNull
	@Enumerated(EnumType.STRING)
	private Cor cor;

	@NotEmpty
	private String ano;

	private BigDecimal valorDiaria;

	private Date dtCriacao;

	private Date dtEdicao;

	public Carro() {
		this(null, null, DEFAULT_STRING, null, null, DEFAULT_BIG_DECIMAL, DEFAULT_DATE);
	}

	public Carro(Long id, Marca marca, String descricao, Cor cor, String ano, BigDecimal valorDiaria, Date dtCriacao) {
		super();
		this.id = id;
		this.marca = marca;
		this.descricao = descricao;
		this.cor = cor;
		this.ano = ano;
		this.valorDiaria = valorDiaria;
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
		Carro other = (Carro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getAno() {
		return ano;
	}

	public Cor getCor() {
		return cor;
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

	public Marca getMarca() {
		return marca;
	}

	public BigDecimal getValorDiaria() {
		return valorDiaria;
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

	public void setAno(String ano) {
		this.ano = ano;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
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

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public void setValorDiaria(BigDecimal valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	@Override
	public String toString() {
		return "Carro [id=" + id + ", marca=" + marca + ", descricao=" + descricao + ", cor=" + cor + ", ano=" + ano + ", valorDiaria="
				+ valorDiaria + ", dtCriacao=" + dtCriacao + ", dtEdicao=" + dtEdicao + "]";
	}

}
