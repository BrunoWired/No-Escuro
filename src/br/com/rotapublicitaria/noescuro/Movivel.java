package br.com.rotapublicitaria.noescuro;

import br.com.rotapublicitaria.noescuro.Cenario.Direcao;

public interface Movivel extends Elemento {

	void mover(Direcao direcao, Cenario cenario);

}
