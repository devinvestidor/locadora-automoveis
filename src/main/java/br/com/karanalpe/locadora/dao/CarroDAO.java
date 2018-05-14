package br.com.karanalpe.locadora.dao;

import static br.com.karanalpe.locadora.util.Constantes.DEFAULT_LONG;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.com.karanalpe.locadora.model.Carro;;;

public class CarroDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	private static List<Carro> carros;

	static {
		carros = new ArrayList<Carro>();
	}

	public static void excluir(Carro carro) {
		carros.remove(carro);
	}

	private static boolean existe(Carro carro) {
		boolean retorno = false;
		if (porId(carro.getId()) != null)
			retorno = true;

		return retorno;

	}

	public static List<Carro> getCarros() {
		return carros;
	}

	public static Long getNovoId() {
		Long novoId = DEFAULT_LONG + 1;
		if (carros.size() != 0) {
			novoId = carros.get(carros.size() - 1).getId() + 1L;
		}

		return novoId;
	}

	public static Integer getTotal() {
		return getCarros().size();
	}

	public static List<Carro> listarTodos() {
		ordenarPor(Comparator.comparing(Carro::getId));
		return getCarros();
	}

	private static void ordenarPor(Comparator<? super Carro> campo) {
		getCarros().sort(campo);
	}

	public static Carro porId(Long id) {
		List<Carro> carro = carros.stream().filter(item -> item.getId().equals(id)).collect(Collectors.toList());
		return carro.size() != 0 ? carro.get(0) : null;
	}

	public static Carro salvar(Carro carro) {
		if (existe(carro)) {
			carros.remove(carro);
		}

		carros.add(carro);
		return carro;
	}

	public static void setCarros(List<Carro> carros) {
		CarroDAO.carros = carros;
	}

}
