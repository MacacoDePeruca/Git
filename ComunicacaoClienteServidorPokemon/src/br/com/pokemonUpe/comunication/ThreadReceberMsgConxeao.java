package br.com.pokemonUpe.comunication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ThreadReceberMsgConxeao extends Thread{

	private Socket conexao;
	private PrintStream saidaServBalanc;

	// construtor que recebe o socket
	public ThreadReceberMsgConxeao(Socket socket){
		this.conexao = socket;
	}
	
	public ThreadReceberMsgConxeao(Socket socket, PrintStream saida){
		this.conexao = socket;
		this.saidaServBalanc = saida;
		System.out.println("do construtor"+saida);
	}

	public void run(){
		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(this.conexao.getInputStream()));
			PrintStream saidaCliente = new PrintStream(conexao.getOutputStream());
			PrintStream teste = new PrintStream(conexao.getOutputStream());
			String msg;
			while (true) {
				// pega o que o servidor enviou e faz tratamento. Por enquanto n tem tratamendo ainda.
				msg = entrada.readLine();

				String s[] = msg.split("&");
				// imprime a mensagem recebida
				
				switch (s[0]) {
				case "01" :
						System.out.println("jogo novo! "+s[1]);
						saidaCliente.println("08&começou o jogo");
						
						teste.println("100&"+msg);
					break;
				case "02" :
					
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
					System.out.println("enviado do servidor " + s[1]);

					break;
				case "08" :
					System.out.println(s[1]);
					break;
				case "100":
					System.out.println("entrou no 100 >>>"+msg);
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
