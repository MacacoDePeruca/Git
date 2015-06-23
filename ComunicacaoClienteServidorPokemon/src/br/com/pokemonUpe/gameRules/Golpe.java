package br.com.pokemonUpe.gameRules;

public class Golpe {
	private int idGolpe;
	private String nomeGolpe;
	private String descricaoGolpe;
	private int danoBasico;
	private String tipo;
	public Golpe(){
		
	}
	

	public Golpe(int idGolpe, String nomeGolpe, String descricaoGolpe,
			int danoBasico, String tipo) {
		super();
		this.idGolpe = idGolpe;
		this.nomeGolpe = nomeGolpe;
		this.descricaoGolpe = descricaoGolpe;
		this.danoBasico = danoBasico;
		this.tipo = tipo;
	}


	public int getDanoBasico() {
		return danoBasico;
	}


	public void setDanoBasico(int danoBasico) {
		this.danoBasico = danoBasico;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
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
