package br.com.karanalpe.crud.model;

public enum Cor {

	BRANCO("Branco"), //
	PRATA("Prata"), //
	PRETO("Preto"), //
	VERMELHO("Vermelho");

	private String descricao;

	Cor(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
