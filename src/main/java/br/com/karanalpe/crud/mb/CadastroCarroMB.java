package br.com.karanalpe.crud.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.karanalpe.crud.model.Carro;
import br.com.karanalpe.crud.model.Marca;
import controller.CarroController;
import controller.MarcaController;

@Named
@ViewScoped
public class CadastroCarroMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CarroController carroController;

	@Inject
	private MarcaController marcaController;

	private Carro carro = new Carro();

	private Long idCarro;

	private List<Marca> marcas;

	public String excluir() {
		carroController.excluir(carro);
		return "lista-carro.xhtml?faces-redirect=true";
	}

	public Carro getCarro() {
		return carro;
	}

	public Long getIdCarro() {
		return idCarro;
	}

	public void inicializar() {
		setMarcas(marcaController.listarTodos());
		if (idCarro != null) {
			carro = carroController.porId(idCarro);
		}
	}

	public String salvar() {
		carroController.salvar(carro);
		return "lista-carro.xhtml?faces-redirect=true";
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public void setIdCarro(Long idCarro) {
		this.idCarro = idCarro;
	}

	public List<Marca> getMarcas() {
		return marcas;
	}

	public void setMarcas(List<Marca> marcas) {
		this.marcas = marcas;
	}

}
