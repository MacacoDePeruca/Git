package br.com.pokemonUpe.MainTeste;

import java.util.ArrayList;
import java.util.List;

import br.com.pokemonUpe.gameRules.Golpe;
import br.com.pokemonUpe.gameRules.Jogador;
import br.com.pokemonUpe.gameRules.Pokemon;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Pokemon> poke= new ArrayList<Pokemon>();
		
		Pokemon pokemon = new Pokemon(1, "bubasaur", "planta", 2, 2, 2, 2, 2, null); 
		
		
		
		poke.add(pokemon);
		Jogador j = new Jogador("vitor", 1, poke, null, 0, 0, 0, null, 1, 0);
		
		System.out.println("o treinador "+j.getNomeJogador()+" chama seu :"+j.getMyPoke().get(0).getNome());
		
		
	}

}
