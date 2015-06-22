package br.com.pokemonUpe.MainTeste;

import java.net.DatagramPacket;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.pokemonUpe.DAO.ClienteDAO;
import br.com.pokemonUpe.DAO.JogadorDAO;
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
		 * não funciona caso o pokemon ganhe muita xp, o suficiente 
		 * pra ganhar dois níveis por exemplo
		 
		
		
		
		
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
		
		Jogador j = new Jogador(1, "Felipe Xaiver", 1, null, null, 0, 0, 0, null, 1, 9, 0);
		JogadorDAO dao = new JogadorDAO();
		
		dao.salvarJogador(j);
		
		
	}

}
