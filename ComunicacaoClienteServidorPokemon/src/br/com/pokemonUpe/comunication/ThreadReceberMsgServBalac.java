package br.com.pokemonUpe.comunication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import br.com.pokemonUpe.DAO.JogadorDAO;
import br.com.pokemonUpe.gameRules.Jogador;


public class ThreadReceberMsgServBalac extends Thread{
	
	Socket s;
	
	public ThreadReceberMsgServBalac(Socket socket){
		this.s = socket;
	}
	
	
	public void run(){
		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintStream saidaServBalanc = new Servidor().getServBalanServJogo();
			//PrintStream saidaCliente = //new PrintStream(s.getOutputStream());
			String msg;
			
			while (true) {
				// pega o que o servidor enviou e faz tratamento. Por enquanto n tem tratamendo ainda.
				msg = entrada.readLine();

				String s[] = msg.split("&");
				// imprime a mensagem recebida
				
				switch (s[0]) {
				case "01" :
					
					System.out.println(s[1]);
					break;
					
				case "02" :
					
					break;
				case "03" :

					break;
				case "04" :

					break;
				default:
					
					break;
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}