package br.com.karanalpe.locadora.model;

import java.math.BigDecimal;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.karanalpe.locadora.util.Constantes;

public class Carro extends BaseModel {

	private static final long serialVersionUID = 1L;

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

	public Carro() {
		this(null, Constantes.DEFAULT_STRING, null, Constantes.DEFAULT_STRING, Constantes.DEFAULT_BIG_DECIMAL);
	}

	public Carro(Marca marca, String descricao, Cor cor, String ano, BigDecimal valorDiaria) {
		super();
		this.marca = marca;
		this.descricao = descricao;
		this.cor = cor;
		this.ano = ano;
		this.valorDiaria = valorDiaria;
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

	public Marca getMarca() {
		return marca;
	}

	public BigDecimal getValorDiaria() {
		return valorDiaria;
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

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public void setValorDiaria(BigDecimal valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

}
