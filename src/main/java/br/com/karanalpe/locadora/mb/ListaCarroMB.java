package br.com.karanalpe.locadora.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.karanalpe.locadora.controller.CarroController;
import br.com.karanalpe.locadora.model.Carro;
import br.com.karanalpe.locadora.util.FacesUtil;

@Named
@ViewScoped
public class ListaCarroMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CarroController carroController;

	private List<Carro> carros = new ArrayList<>();

	private List<Carro> carrosSelecionados = new ArrayList<>();

	public void excluirSelecionados() {
		for (Carro carro : carrosSelecionados) {
			carroController.excluir(carro);
			carros.remove(carro);
		}

		FacesUtil.addInfoMessage("Carro(s) excluída(s) com sucesso!");
	}

	public List<Carro> getCarros() {
		return carros;
	}

	public List<Carro> getCarrosSelecionados() {
		return carrosSelecionados;
	}

	@PostConstruct
	public void inicializar() {
		carros = carroController.listarTodos();
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}

	public void setCarrosSelecionados(List<Carro> carrosSelecionados) {
		this.carrosSelecionados = carrosSelecionados;
	}

}
