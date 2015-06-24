package br.com.pokemonUpe.comunication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
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
			PrintStream saida = new PrintStream(conexao.getOutputStream());
			String msg;
			while (true) {
				// pega o que o servidor enviou e faz tratamento. Por enquanto n tem tratamendo ainda.
				msg = entrada.readLine();

				String s[] = msg.split("&");
				// imprime a mensagem recebida
				switch (s[0]) {
				case "01" :
						System.out.println("jogo novo! "+s[1]);
						saida.println("começou o jogo");
					break;
				case "02" :
					System.out.println("continuar jogo");
					break;
				case "03" :

					break;
				case "04" :

					break;
				case "05" :

					break;
				case "06" :

					break;
				case "07" :

					break;
				case "08" :

					break;

				default:
					break;
				}
				//System.out.println(msg);
				// cria uma linha visual para resposta
			}
		}
		catch (Exception e) {
			System.out.println("Conexao perdida");
			e.printStackTrace();

		}
	}
}
