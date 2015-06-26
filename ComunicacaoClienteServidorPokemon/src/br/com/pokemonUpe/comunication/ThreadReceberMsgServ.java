package br.com.pokemonUpe.comunication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import br.com.pokemonUpe.DAO.JogadorDAO;
import br.com.pokemonUpe.DAO.PokedexDAO;
import br.com.pokemonUpe.DAO.ServidorDAO;
import br.com.pokemonUpe.DAO.pokemonDAO;
import br.com.pokemonUpe.gameRules.Jogador;
import br.com.pokemonUpe.gameRules.Pokemon;

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
				msg = entrada.readLine();

				String s[] = msg.split("&");
				
				switch (s[0]) {
				case "01" :
					
					Jogador jogador = new Jogador();
					JogadorDAO jogadordao = new JogadorDAO();
					
					jogador.setNomeJogador(s[1]);
					jogador.setNivel(Integer.parseInt(s[2]));
					jogador.setBatalhas(Integer.parseInt(s[3]));
					jogador.setBatalhasVencidas(Integer.parseInt(s[4]));
					jogador.setBatalhasPerdidas(Integer.parseInt(s[5]));
					
					Pokemon pokemon = null;
					pokemonDAO pokemonDao = new pokemonDAO();
					if(s[6].equals("1")){
						pokemon = new Pokemon(1, "bubasaur", "planta", 2, 2, 2, 2, 2, null,1, 100);
						
						pokemonDao.salvarPokemon(pokemon, 1);
						
					}
					if(s[6].equals("2")){
						pokemon = new Pokemon(1, "charmander", "planta", 2, 2, 2, 2, 2, null,1, 100);
						System.out.println("entrou no 2");
						pokemonDao.salvarPokemon(pokemon, 2);
					}
					if(s[6].equals("3")){
						pokemon = new Pokemon(1, "squirtle", "planta", 2, 2, 2, 2, 2, null,1, 100);
						pokemonDao.salvarPokemon(pokemon, 3);
					}
					
					
					if (!jogadordao.salvarJogador(jogador)){
						System.out.println("Jogador "+ s[1] + " salvo no banco de dados");
						saidaCliente.println("01&Cliente salvo no banco de dados");
					}
					
					
					break;
				case "02" :
					new ServidorDAO().addClienteOnLine(s[1]);
					break;
				case "03" :
					System.out.println(s[1]);
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
