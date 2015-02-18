package br.com.rotapublicitaria.noescuro;

import java.util.Scanner;

import br.com.rotapublicitaria.noescuro.Cenario.Direcao;

public class Inicial {

	public static void main(String[] args) {

		Cenario quarto = new Cenario("quarto", 1, 1);

		Personagem sofia = new Personagem("Sofia");

		quarto.adicionarElemento(sofia);

		System.out.println(Comunicacao.getMensagem());
		
		System.out.println(quarto);
		
		controle(sofia, quarto);

	}
	
	private static void controle(Personagem p, Cenario c) {
		
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext()) {

			String comando = scanner.nextLine();

			switch (comando) {

			case "frente":
				p.mover(Direcao.NORTE, c);
				break;
			case "atras":
				p.mover(Direcao.SUL, c);
				break;
			case "direita":
				p.mover(Direcao.LESTE, c);
				break;
			case "esquerda":
				p.mover(Direcao.OESTE, c);
				break;

			}
			
			System.out.println(Comunicacao.getMensagem());
			
			System.out.println(c);

		}
		
	}

}
