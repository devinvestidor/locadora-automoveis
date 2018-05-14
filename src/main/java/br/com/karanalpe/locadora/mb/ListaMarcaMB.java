package br.com.karanalpe.locadora.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.karanalpe.locadora.controller.MarcaController;
import br.com.karanalpe.locadora.model.Marca;
import br.com.karanalpe.locadora.util.FacesUtil;

@Named
@ViewScoped
public class ListaMarcaMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private MarcaController marcaController;

	private List<Marca> marcas = new ArrayList<>();

	private List<Marca> marcasSelecionadas = new ArrayList<>();

	public void excluirSelecionados() {
		for (Marca marca : marcasSelecionadas) {
			marcaController.excluir(marca);
			marcas.remove(marca);
		}

		FacesUtil.addInfoMessage("Marca(s) excluída(s) com sucesso!");
	}

	public List<Marca> getMarcas() {
		return marcas;
	}

	public List<Marca> getMarcasSelecionadas() {
		return marcasSelecionadas;
	}

	@PostConstruct
	public void inicializar() {
		marcas = marcaController.listarTodos();
	}

	public void setMarcas(List<Marca> marcas) {
		this.marcas = marcas;
	}

	public void setMarcasSelecionadas(List<Marca> marcasSelecionadas) {
		this.marcasSelecionadas = marcasSelecionadas;
	}

}
