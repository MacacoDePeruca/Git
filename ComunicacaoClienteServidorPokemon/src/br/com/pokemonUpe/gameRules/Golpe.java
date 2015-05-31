package br.com.pokemonUpe.gameRules;

public class Golpe {
	private int idGolpe;
	private String nomeGolpe;
	private String descricaoGolpe;
	private int dano;
	
	public Golpe(){
		
	}

	public int getIdGolpe() {
		return idGolpe;
	}

	public void setIdGolpe(int idGolpe) {
		this.idGolpe = idGolpe;
	}

	public String getNomeGolpe() {
		return nomeGolpe;
	}

	public void setNomeGolpe(String nomeGolpe) {
		this.nomeGolpe = nomeGolpe;
	}

	public String getDescricaoGolpe() {
		return descricaoGolpe;
	}

	public void setDescricaoGolpe(String descricaoGolpe) {
		this.descricaoGolpe = descricaoGolpe;
	}

	public int getDano() {
		return dano;
	}

	public void setDano(int dano) {
		this.dano = dano;
	}
	
	
}
