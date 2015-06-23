package br.com.pokemonUpe.MainTeste;

import java.net.DatagramPacket;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import br.com.pokemonUpe.DAO.ClienteDAO;
import br.com.pokemonUpe.DAO.JogadorDAO;
import br.com.pokemonUpe.DAO.pokemonDAO;
import br.com.pokemonUpe.comunication.Cliente;
import br.com.pokemonUpe.comunication.PacoteDeDados;
import br.com.pokemonUpe.comunication.Servidor;
import br.com.pokemonUpe.comunication.ServidorDeBalanceamento;
import br.com.pokemonUpe.gameRules.Golpe;
import br.com.pokemonUpe.gameRules.Jogador;
import br.com.pokemonUpe.gameRules.MasterPokemonProgress;
import br.com.pokemonUpe.gameRules.Pokemon;
import br.com.pokemonUpe.gameRules.PokemonProgress;

public class Main {

	public static void main(String[] args) throws SQLException, UnknownHostException {
		// TODO Auto-generated method stub
	/**	List<Pokemon> poke= new ArrayList<Pokemon>();
		
		Pokemon pokemon = new Pokemon(1, "bubasaur", "planta", 2, 2, 2, 2, 2, null,1, 100); 
		
		
		
		poke.add(pokemon);
		
		Jogador j = new Jogador(1,"vitor", 2, poke, null, 0, 0, 0, null, 1, 0, 3000);
		/**
		 * n�o funciona caso o pokemon ganhe muita xp, o suficiente 
		 * pra ganhar dois n�veis por exemplo
		 
		
		
		
		
		PokemonProgress pp = new PokemonProgress();
		
		MasterPokemonProgress mp = new MasterPokemonProgress();
		
		System.out.println("NIVEL  : "+mp.calculaXP(j));
		*/
		Cliente cliente = new Cliente();
		//ServidorDeBalanceamento sdb = new ServidorDeBalanceamento();
		cliente.setNome("xaomi");
		cliente.setIp("10.0.0.1");
		cliente.setPorta(4040);
		
		//sdb.startBalanceamento();
		cliente.setNome("teste");
		
		//PacoteDeDados pg = cliente.receberPacote();
	//System.out.println(pg.getIpServidor());	
		
		
		// teste o broadcast, o DAO do servidor e algumas coisa do balanceamento
		
		/*ClienteDAO dao = new ClienteDAO();
		ServidorDeBalanceamento bala= new ServidorDeBalanceamento();
		Servidor blastoise = new Servidor("blastoise");
		System.out.println("nome do servidor : "+blastoise.getNomeDoServidor());
		System.out.println("ip host : "+blastoise.getIp());
		System.out.println("numero maximo de jogadores neste servidor : "+blastoise.getMAX_DE_CLIENTES());
		System.out.println("porta : "+blastoise.getPorta());
		System.out.println("/////////////////////////////////");
		bala.balanceamento(cliente);*/
		
		
		
		
		/*Jogador j = new Jogador(1, "Felipe Xaiver", 1, null, null, 0, 0, 0, null, 1, 9, 0);
		JogadorDAO dao = new JogadorDAO();
		
		dao.salvarJogador(j);*/
		pokemonDAO dao = new pokemonDAO();
		List<Pokemon> lista = new ArrayList<Pokemon>();
		List<Golpe> ataques = new ArrayList<Golpe>();
		//para fins de teste, n�o haver� isso aqui!
		 Golpe g1 = new Golpe(1, "mordida", "morde n� porra", 3, "f�sico"); 
		 Golpe g2 = new Golpe(2, "patada", "d� uma patada", 3, "f�sico"); 
		 Golpe g3 = new Golpe(3, "bola de fogo", "cospe uma bola de fogo", 5, "f�sico"); 
		 Golpe g4 = new Golpe(4, "jato d'agua", "cospe um jato d'agua", 5, "f�sico"); 
		 
		Pokemon p1 = new Pokemon(1, "bubasauro", "planta", 2, 2, 2, 2, 1, ataques, 1, 0);
		Pokemon p2 = new Pokemon(4, "charmander", "fogo", 2, 2, 2, 2, 1, ataques, 1, 0);
		Pokemon p3 = new Pokemon(7, "squirtle", "agua", 2, 2, 2, 2, 1, ataques, 1, 0);
		Pokemon p4 = new Pokemon(16, "pidgey", "normal", 2, 2, 2, 2, 1, ataques, 1, 0);
		Pokemon p5 = new Pokemon(37, "vulpix", "fogo", 2, 2, 2, 2, 1, ataques, 1, 0);
		
		lista.add(p1);
		lista.add(p2);
		lista.add(p3);
		lista.add(p4);
		lista.add(p5);
		
		for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
			Pokemon pokemon = (Pokemon) iterator.next();
			
		}
		
	}

}
