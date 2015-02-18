package br.com.rotapublicitaria.noescuro;

public class Comunicacao {

	private static String mensagem;

	public static void setMensagem(String mensagem) {
		Comunicacao.mensagem = mensagem;
	}

	public static String getMensagem() {
		return Comunicacao.mensagem != null ? Comunicacao.mensagem : "";
	}

}
