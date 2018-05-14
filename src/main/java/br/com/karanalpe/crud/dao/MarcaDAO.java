package br.com.karanalpe.crud.dao;

import static br.com.karanalpe.crud.util.Constantes.DEFAULT_LONG;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.com.karanalpe.crud.model.Marca;;;

public class MarcaDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	private static List<Marca> marcas;

	static {
		marcas = new ArrayList<Marca>();
		marcas.add(new Marca(1L, "Chevrolet", new Date()));
		marcas.add(new Marca(2L, "Volkswagen", new Date()));
		marcas.add(new Marca(3L, "Renault", new Date()));
		marcas.add(new Marca(4L, "Hyundai", new Date()));
		marcas.add(new Marca(5L, "Toyota", new Date()));
	}

	public static void excluir(Marca marca) {
		marcas.remove(marca);
	}

	private static boolean existe(Marca marca) {
		boolean retorno = false;
		if (porId(marca.getId()) != null)
			retorno = true;

		return retorno;

	}

	public static List<Marca> getMarcas() {
		return marcas;
	}

	public static Long getNovoId() {
		Long novoId = DEFAULT_LONG + 1;
		if (marcas.size() != 0) {
			novoId = marcas.get(marcas.size() - 1).getId() + 1L;
		}

		return novoId;
	}

	public static List<Marca> listarTodos() {
		ordenarPor(Comparator.comparing(Marca::getId));
		return getMarcas();
	}

	private static void ordenarPor(Comparator<? super Marca> campo) {
		getMarcas().sort(campo);
	}

	public static Marca porId(Long id) {
		List<Marca> marca = marcas.stream().filter(item -> item.getId().equals(id)).collect(Collectors.toList());
		return marca.size() != 0 ? marca.get(0) : null;
	}

	public static Marca salvar(Marca marca) {
		if (existe(marca)) {
			marcas.remove(marca);
		}

		marcas.add(marca);
		return marca;
	}

	public static void setMarcas(List<Marca> marcas) {
		MarcaDAO.marcas = marcas;
	}

}
