package br.com.karanalpe.crud.mb;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.karanalpe.crud.model.Marca;
import controller.MarcaController;

@Named
@ViewScoped
public class CadastroMarcaMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private Marca marca = new Marca();

	private Long idMarca;

	@Inject
	private MarcaController marcaController;

	public String excluir() {
		marcaController.excluir(marca);
		return "lista-marca.xhtml?faces-redirect=true";
	}

	public Long getIdMarca() {
		return idMarca;
	}

	public Marca getMarca() {
		return marca;
	}

	public void inicializar() {
		if (idMarca != null) {
			marca = marcaController.porId(idMarca);
		}
	}

	public String salvar() {
		marcaController.salvar(marca);
		return "lista-marca.xhtml?faces-redirect=true";
	}

	public void setIdMarca(Long idMarca) {
		this.idMarca = idMarca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

}
