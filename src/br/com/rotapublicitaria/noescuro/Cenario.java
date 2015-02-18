package br.com.rotapublicitaria.noescuro;

import java.util.HashMap;
import java.util.Random;

public class Cenario {

	public enum Direcao {
		NORTE, SUL, LESTE, OESTE
	}

	private final int EIXO_INICIAL = 1;
	private final int EIXO_MINIMO = 5;

	private String nome;

	private int limiteEixoX;
	private int limiteEixoY;

	private HashMap<String, Elemento> mapaElementos;

	public Cenario(String nome, int eixoMaximoX, int eixoMaximoY) {

		this.nome = nome;
		this.limiteEixoX = validaEixo(eixoMaximoX);
		this.limiteEixoY = validaEixo(eixoMaximoY);

		mapaElementos = new HashMap<>();
	}

	public String getNome() {
		return nome;
	}

	public void adicionarElemento(Elemento elemento) {

		if (hasEspacoDisponivel()) {

			int eixoX = getEixoAleatorio(limiteEixoX);
			int eixoY = getEixoAleatorio(limiteEixoY);

			String posicao = getPosicao(eixoX, eixoY);

			if (isPosicaoLivre(posicao)) {

				moverElemento(elemento, eixoX, eixoY);

			} else {

				adicionarElemento(elemento);

			}

		} else {

			Comunicacao.setMensagem("Não há espaço disponível para adicionar <"
					+ elemento.getNome() + ">.");

		}

	}

	public void moverElemento(Elemento elemento, int novoEixoX, int novoEixoY) {

		if (!isForaDoLimite(novoEixoX, novoEixoY)) {

			removerElemento(elemento);

			elemento.setPosicao(novoEixoX, novoEixoY);

			mapaElementos.put(getPosicao(elemento), elemento);

		} else {

			Comunicacao.setMensagem("<" + elemento.getNome()
					+ "> não pode se mover nessa direção.");

		}

	}

	public void removerElemento(Elemento elemento) {

		mapaElementos.remove(getPosicao(elemento));

		elemento.setPosicao(0, 0);

	}

	public boolean hasElemento(Elemento elemento) {

		if (mapaElementos.get(getPosicao(elemento)) == elemento) {
			return true;
		}

		return false;
	}

	private boolean hasEspacoDisponivel() {

		int total = limiteEixoX * limiteEixoY;

		if (total - mapaElementos.size() == 0) {
			return false;
		}

		return true;
	}

	private boolean isPosicaoLivre(String posicao) {

		if (mapaElementos.get(posicao) == null) {
			return true;
		}

		return false;
	}

	private int validaEixo(int eixo) {

		if (eixo < EIXO_MINIMO) {
			eixo = EIXO_MINIMO;
		}

		return eixo;
	}

	private boolean isForaDoLimite(int novoEixoX, int novoEixoY) {

		if (novoEixoX < EIXO_INICIAL || novoEixoY < EIXO_INICIAL) {
			return true;
		}

		if (novoEixoX > limiteEixoX || novoEixoY > limiteEixoY) {
			return true;
		}

		return false;
	}

	private int getEixoAleatorio(int limite) {

		Random r = new Random();

		return r.nextInt(limite) + EIXO_INICIAL;

	}

	private String getPosicao(Elemento elemento) {
		return getPosicao(elemento.getEixoX(), elemento.getEixoY());
	}

	private String getPosicao(int x, int y) {
		return x + "," + y;
	}

	@Override
	public String toString() {
		return "cenário ('" + nome + "' [" + mapaElementos.toString() + "])";
	}

}
