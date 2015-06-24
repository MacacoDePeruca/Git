package br.com.pokemonUpe.comunication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ThreadReceberMsgConxeao extends Thread{
	
	private Socket conexao;
	
	// construtor que recebe o socket
	public ThreadReceberMsgConxeao(Socket socket){
		this.conexao = socket;
	}
	
	public void run(){
		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(this.conexao.getInputStream()));
			String msg;
			while (true) {
				// pega o que o servidor enviou e faz tratamento. Por enquanto n tem tratamendo ainda.
				msg = entrada.readLine();
				// imprime a mensagem recebida
				System.out.println(msg);
				// cria uma linha visual para resposta
			}
		}
		catch (Exception e) {
			System.out.println("Conexao perdida");
			e.printStackTrace();

		}
	}
}
