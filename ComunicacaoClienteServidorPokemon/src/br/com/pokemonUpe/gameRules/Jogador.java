package br.com.pokemonUpe.gameRules;

import java.util.List;

import ItensRules.Item;

public class Jogador {
	private int codJogador;
	private String nomeJogador;
	private int nivel;
	private List<Pokemon> myPoke;
	private List<Item> mochila;
	private int batalhas;
	private int batalhasVencidas;
	private int batalhasPerdidas;
	private Pokedex agenda;
	private int xpAcumulado;
	
	//necessário para o combate
	private int idTreinador;
	private int iniciativa;
	
	public Jogador(){
		
	}
	
	
	public Jogador(int codJogador,String nomeJogador, int nivel, List<Pokemon> myPoke,
			List<Item> mochila, int batalhas, int batalhasVencidas,
			int batalhasPerdidas, Pokedex agenda, int idTreinador,
			int iniciativa, int xp) {
		super();
		this.codJogador =codJogador;
		this.nomeJogador = nomeJogador;
		this.nivel = nivel;
		this.myPoke = myPoke;
		this.mochila = mochila;
		this.batalhas = batalhas;
		this.batalhasVencidas = batalhasVencidas;
		this.batalhasPerdidas = batalhasPerdidas;
		this.agenda = agenda;
		this.idTreinador = idTreinador;
		this.iniciativa = iniciativa;
		this.xpAcumulado = xp;
	}

	
	public int getXpAcumulado() {
		return xpAcumulado;
	}


	public void setXpAcumulado(int xpAcumulado) {
		this.xpAcumulado = xpAcumulado;
	}


	public String getNomeJogador() {
		return nomeJogador;
	}
	public void setNomeJogador(String nomeJogador) {
		this.nomeJogador = nomeJogador;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	public List<Pokemon> getMyPoke() {
		return myPoke;
	}
	public void setMyPoke(List<Pokemon> myPoke) {
		this.myPoke = myPoke;
	}
	public List<Item> getMochila() {
		return mochila;
	}
	public void setMochila(List<Item> mochila) {
		this.mochila = mochila;
	}
	public int getBatalhas() {
		return batalhas;
	}
	public void setBatalhas(int batalhas) {
		this.batalhas = batalhas;
	}
	public int getBatalhasVencidas() {
		return batalhasVencidas;
	}
	public void setBatalhasVencidas(int batalhasVencidas) {
		this.batalhasVencidas = batalhasVencidas;
	}
	public int getBatalhasPerdidas() {
		return batalhasPerdidas;
	}
	public void setBatalhasPerdidas(int batalhasPerdidas) {
		this.batalhasPerdidas = batalhasPerdidas;
	}
	public Pokedex getAgenda() {
		return agenda;
	}
	public void setAgenda(Pokedex agenda) {
		this.agenda = agenda;
	}
	public int getIdTreinador() {
		return idTreinador;
	}
	public void setIdTreinador(int idTreinador) {
		this.idTreinador = idTreinador;
	}
	public int getIniciativa() {
		return iniciativa;
	}
	public void setIniciativa(int iniciativa) {
		this.iniciativa = iniciativa;
	}
	
	
}
