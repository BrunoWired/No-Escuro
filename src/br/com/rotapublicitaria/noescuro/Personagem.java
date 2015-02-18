package br.com.rotapublicitaria.noescuro;

import br.com.rotapublicitaria.noescuro.Cenario.Direcao;

public class Personagem implements Movivel {

	private String nome;

	private int eixoX;
	private int eixoY;

	private Inventario inventario;

	public Personagem(String nome) {

		this.nome = nome;

		eixoX = 0;
		eixoY = 0;

		inventario = new Inventario();
	}

	public void pegarItem(Item item, Cenario cenario) {

		if (cenario.hasElemento(item)) {

			cenario.removerElemento(item);

			inventario.adicionarItem(item);

		}
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
	public void mover(Direcao direcao, Cenario cenario) {

		int novoEixoX = eixoX;
		int novoEixoY = eixoY;

		switch (direcao) {

		case NORTE:
			novoEixoY++;
			break;
		case SUL:
			novoEixoY--;
			break;
		case LESTE:
			novoEixoX++;
			break;
		case OESTE:
			novoEixoX--;
			break;
		}

		cenario.moverElemento(this, novoEixoX, novoEixoY);

	}

	@Override
	public String toString() {
		return "personagem ('" + nome + "' {" + inventario + "})";
	}

}
