package br.com.pokemonUpe.comunication;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

import br.com.pokemonUpe.gameRules.Pokemon;

public class ThreadReceberMsgConxeao extends Thread{

	private Socket conexao;
	
	// construtor que recebe o socket
	public ThreadReceberMsgConxeao(Socket socket){
		this.conexao = socket;
	}
	
//	public ThreadReceberMsgConxeao(Socket socket, PrintStream saida){
	//	this.conexao = socket;
		//this.saidaServBalanc = saida;
		//System.out.println("do construtor"+saida);
	//}

	public void run(){
		try {
			DataOutputStream out = (DataOutputStream) conexao.getOutputStream();
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(this.conexao.getInputStream()));
			PrintStream saidaCliente = new PrintStream(conexao.getOutputStream());
			PrintStream saidaServidor = new Servidor().getServBalanServJogo();
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
						//saidaServidor.println("100&"+ msg.substring(2));
						
					break;
				case "02" :
					//continuar jogo
					break;
				case "03" :
					//pokedex
					break;
				case "04" :
					//amigos
					break;
				case "05" :
					//status
					break;
				case "06" :
					//meus pokemons
					
					break;
				case "07" :
					//trocar pokemons

					break;
				case "08" :
					// batalha
					
					break;
				case "80" :
					// o calculo do ataque é feito no cliente
					
					// opções da batalha ; ataque
					//80&id_jogador_atacante&id_pokemon&DanoBasico&id_jogador_defensor
					System.out.println("entrou no 80"+s[1]);
					//saidaCliente.println("06&tem que escrever em algum lugar!"+s[1]);
						
					out.writeUTF(s[1]);
					
					break;
				case "81" :
					// opções da batalha : defesa
					break;
				case "82" :
					// opções da batalha : golpe especial
					break;
				case "83" :
					// opções da batalha : desistir da batalha
					break;
				case "84" :
					// opções da batalha : usar itens 
					break;
				case "85" :
					// opções da batalha : trocar de pokemon
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
