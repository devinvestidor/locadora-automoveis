package controller;

import static br.com.karanalpe.crud.util.Constantes.DEFAULT_DATE;

import java.io.Serializable;
import java.util.List;

import br.com.karanalpe.crud.dao.CarroDAO;
import br.com.karanalpe.crud.model.Carro;;

public class CarroController implements Serializable {

	private static final long serialVersionUID = 1L;

	public void excluir(Carro carro) {
		CarroDAO.excluir(carro);
	}

	public List<Carro> listarTodos() {
		return CarroDAO.listarTodos();
	}

	public Carro porId(Long id) {
		return CarroDAO.porId(id);
	}

	public void salvar(Carro carro) {
		if (carro.isInclusao()) {
			carro.setId(CarroDAO.getNovoId());
			carro.setDtCriacao(DEFAULT_DATE);
		}

		if (carro.isEdicao()) {
			carro.setDtEdicao(DEFAULT_DATE);
		}

		CarroDAO.salvar(carro);
	}

}
