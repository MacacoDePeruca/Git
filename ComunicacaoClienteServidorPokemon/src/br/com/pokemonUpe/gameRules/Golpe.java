package br.com.pokemonUpe.gameRules;

public class Golpe {
	private int idGolpe;
	private String nomeGolpe;
	private String descricaoGolpe;
	private int danoBasico;
	
	public Golpe(){
		
	}
	

	public Golpe(int idGolpe, String nomeGolpe, String descricaoGolpe,
			int danoBasico) {
		super();
		this.idGolpe = idGolpe;
		this.nomeGolpe = nomeGolpe;
		this.descricaoGolpe = descricaoGolpe;
		this.danoBasico = danoBasico;
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
		return danoBasico;
	}

	public void setDano(int dano) {
		this.danoBasico = dano;
	}
	
	
}
