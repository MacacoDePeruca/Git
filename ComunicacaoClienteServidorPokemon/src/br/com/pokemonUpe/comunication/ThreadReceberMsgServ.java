package br.com.pokemonUpe.comunication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import br.com.pokemonUpe.DAO.JogadorDAO;
import br.com.pokemonUpe.gameRules.Jogador;

public class ThreadReceberMsgServ extends Thread{
	
	Socket s;
	
	public ThreadReceberMsgServ(Socket socket){
		this.s = socket;
	}
	
	
	public void run(){
		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			PrintStream saidaCliente = new PrintStream(s.getOutputStream());
			
			String msg;
			
			while (true) {
				// pega o que o servidor enviou e faz tratamento. Por enquanto n tem tratamendo ainda.
				msg = entrada.readLine();

				String s[] = msg.split("&");
				// imprime a mensagem recebida
				
				switch (s[0]) {
				case "01" :
					
					Jogador jogador = new Jogador();
					JogadorDAO jogadordao = new JogadorDAO();
					
					jogador.setNomeJogador(s[1]);
					jogador.setNivel(Integer.parseInt(s[2]));
					jogador.setBatalhas(Integer.parseInt(s[3]));
					jogador.setBatalhasVencidas(Integer.parseInt(s[4]));
					jogador.setBatalhasPerdidas(Integer.parseInt(s[5]));
					
					if (jogadordao.salvarJogador(jogador)){
						System.out.println("Jogador "+ s[1] + " salvo no banco de dados");
						saidaCliente.println("01&Cliente salvo no banco de dados");
					}
					
					
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
				//System.out.println(msg);
				// cria uma linha visual para resposta
			}
				
				
				//saidaCliente.println("recebi e estou enviando a msg: "+ msg);
				//System.out.println(msg+1);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
