package br.com.karanalpe.locadora.mb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.karanalpe.locadora.controller.CarroController;
import br.com.karanalpe.locadora.controller.MarcaController;

@Named
@ViewScoped
public class TelaInicialMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private MarcaController marcaController;

	@Inject
	private CarroController carroController;

	private Integer totalMarcas;

	private Integer totalCarros;

	@PostConstruct
	public void inicializar() {
		setTotalMarcas(marcaController.getTotal());
		setTotalCarros(carroController.getTotal());
	}

	public Integer getTotalMarcas() {
		return totalMarcas;
	}

	public void setTotalMarcas(Integer totalMarcas) {
		this.totalMarcas = totalMarcas;
	}

	public Integer getTotalCarros() {
		return totalCarros;
	}

	public void setTotalCarros(Integer totalCarros) {
		this.totalCarros = totalCarros;
	}

}
