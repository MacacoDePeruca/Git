package br.com.pokemonUpe.gameRules;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MasterPokemonProgress {
	List<Pokemon> minhaLista = new ArrayList<Pokemon>();
	
	public int calculaXP(Jogador treinador){
		int precisaParaSubirDeNivel =0;
		for(int i =0; i <= treinador.getNivel();i++){
			precisaParaSubirDeNivel = precisaParaSubirDeNivel+ (i*1000);
		}
		
		if(treinador.getXpAcumulado() >= precisaParaSubirDeNivel){
			return treinador.getNivel() +1;
		}else {
			return treinador.getNivel();
		}
		/**
		 * agora tem que dar um jeito de fazer com que o jogador 
		 * possa ganhar um novo pokemon
		 */
	}
	
	public Pokemon novoPokemon(Jogador j){
		
		Pokemon p = new Pokemon();
		Random r = new Random();
		
		int idDopokemon = r.nextInt(152);
		
		
	
		
		return p;
	}
	
	
}
