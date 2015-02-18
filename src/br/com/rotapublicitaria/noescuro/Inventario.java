package br.com.rotapublicitaria.noescuro;

import java.util.ArrayList;

public class Inventario {

	private ArrayList<Item> listaItens;

	public Inventario() {

		listaItens = new ArrayList<>();

	}

	public void adicionarItem(Item item) {
		listaItens.add(item);
	}

	@Override
	public String toString() {
		return "invent�rio " + listaItens.toString();
	}

}
