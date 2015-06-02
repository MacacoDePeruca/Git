package br.com.pokemonUpe.gameRules;

import java.util.ArrayList;
import java.util.List;

public class Pokedex {
	/*
	 * arrumar um jeito de guardar as img's dos personagens do jogo
	*private  nomePokemon
	*descrição
	*characterRef
	*battlesRef
	*faceRef
	*iconsRef
	*/
	List<Pokemon> pokemons;
	List<Golpe> ataques = new ArrayList<Golpe>();
	//para fins de teste, não haverá isso aqui!
	 Golpe g1 = new Golpe(1, "mordida", "morde né porra", 3); 
	 Golpe g2 = new Golpe(2, "patada", "dá uma patada", 3); 
	 Golpe g3 = new Golpe(3, "bola de fogo", "cospe uma bola de fogo", 5); 
	 Golpe g4 = new Golpe(4, "jato d'agua", "cospe um jato d'agua", 5); 
	
	 
	//para fins de teste não haverá isso aqui!
		Pokemon p1 = new Pokemon(1, "bubasauro", "planta", 2, 2, 2, 2, 1, ataques, 1, 0);
		Pokemon p2 = new Pokemon(4, "charmander", "fogo", 2, 2, 2, 2, 1, ataques, 1, 0);
		Pokemon p3 = new Pokemon(7, "squirtle", "agua", 2, 2, 2, 2, 1, ataques, 1, 0);
		Pokemon p4 = new Pokemon(16, "pidgey", "normal", 2, 2, 2, 2, 1, ataques, 1, 0);
		Pokemon p5 = new Pokemon(37, "vulpix", "fogo", 2, 2, 2, 2, 1, ataques, 1, 0);
	
		public void adicionarAtaques(){
		ataques.add(g1);
		ataques.add(g2);
		ataques.add(g3);
		ataques.add(g4);
		}
	public void adicionarPokemons(){
		pokemons.add(p1);
		pokemons.add(p2);
		pokemons.add(p3);
		pokemons.add(p4);
		pokemons.add(p5);
	}
}
