package br.com.rotapublicitaria.noescuro;

public class Item implements Elemento {

	private String nome;

	private int eixoX;
	private int eixoY;

	public Item(String nome) {

		this.nome = nome;

		eixoX = 0;
		eixoY = 0;

	}

	@Override
	public String getNome() {
		return nome;
	}

	@Override
	public int getEixoX() {
		return eixoX;
	}

	@Override
	public int getEixoY() {
		return eixoY;
	}

	@Override
	public void setPosicao(int eixoX, int eixoY) {

		this.eixoX = eixoX;
		this.eixoY = eixoY;

	}

	@Override
	public String toString() {
		return "item ('" + nome + "')";
	}

}
