package controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.com.karanalpe.crud.dao.MarcaDAO;
import br.com.karanalpe.crud.model.Marca;

public class MarcaController implements Serializable {

	private static final long serialVersionUID = 1L;

	public void excluir(Marca marca) {
		MarcaDAO.excluir(marca);
	}

	public List<Marca> listarTodos() {
		return MarcaDAO.listarTodos();
	}

	public Marca porId(Long id) {
		return MarcaDAO.porId(id);
	}

	public void salvar(Marca marca) {
		if (marca.isInclusao()) {
			marca.setId(MarcaDAO.getNovoId());
			marca.setDtCriacao(new Date());
		}

		if (marca.isEdicao()) {
			marca.setDtEdicao(new Date());
		}

		MarcaDAO.salvar(marca);
	}

}
