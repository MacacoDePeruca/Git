package br.com.pokemonUpe.gameRules;

import java.util.List;

import br.com.pokemonUpe.DAO.pokemonDAO;

public class Pokemon {
	private int id;
	private String nome;
	private String tipo;
	private Pokemon evoluiPara;
	private Pokemon vemDe;
	private int nivel;
	private int xpAcumulado;
	
	// habilibdades 
	private int habilidade;
	private int armadura;
	private int resistencia;
	private int poderDeFogo;
	private int bonusDecaptura;
	private List<Golpe> golpes;
	private int pontosDeVida;
	private int pontosDeMagia;
	
	public Pokemon(){
		
	}
	
	

	public Pokemon(int id, String nome, String tipo, int habilidade,
			int armadura, int resistencia, int poderDeFogo, int bonusDecaptura,
			List<Golpe> golpes, int nivel, int xp) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.habilidade = habilidade;
		this.armadura = armadura;
		this.resistencia = resistencia;
		this.poderDeFogo = poderDeFogo;
		this.bonusDecaptura = bonusDecaptura;
		this.golpes = golpes;
		this.xpAcumulado = xp;
		this.nivel = nivel;
	}

	
	
	
	
	public int getNivel() {
		return nivel;
	}



	public int getXpAcumulado() {
		return xpAcumulado;
	}



	public void setXpAcumulado(int xpAcumulado) {
		this.xpAcumulado = xpAcumulado;
	}



	public void setNivel(int nivel) {
		this.nivel = nivel;
	}



	public Pokemon getEvoluiPara(){
		return evoluiPara;
	}
	public void setEvoluiPara(Pokemon evoluiPara){
		this.evoluiPara = evoluiPara;
	}
	

	public Pokemon getVemDe() {
		return vemDe;
	}



	public void setVemDe(Pokemon vemDe) {
		this.vemDe = vemDe;
	}



	public int getPoderDeFogo() {
		return poderDeFogo;
	}



	public void setPoderDeFogo(int poderDeFogo) {
		this.poderDeFogo = poderDeFogo;
	}



	public int getPontosDeVida() {
		return pontosDeVida;
	}



	public void setPontosDeVida(int pontosDeVida) {
		this.pontosDeVida = pontosDeVida;
	}



	public int getPontosDeMagia() {
		return pontosDeMagia;
	}



	public void setPontosDeMagia(int pontosDeMagia) {
		this.pontosDeMagia = pontosDeMagia;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getHabilidade() {
		return habilidade;
	}

	public void setHabilidade(int habilidade) {
		this.habilidade = habilidade;
	}

	public int getArmadura() {
		return armadura;
	}

	public void setArmadura(int armadura) {
		this.armadura = armadura;
	}

	public int getResistencia() {
		return resistencia;
	}
	

	public void setResistencia(int resistencia) {
		this.resistencia = resistencia;
	}

	public int getpoderDeFogo() {
		return poderDeFogo;
	}

	public void setpoderDeFogo(int poderDeFogo) {
		this.poderDeFogo = poderDeFogo;
	}

	public int getBonusDecaptura() {
		return bonusDecaptura;
	}

	public void setBonusDecaptura(int bonusDecaptura) {
		bonusDecaptura = bonusDecaptura;
	}

	public List<Golpe> getGolpes() {
		return golpes;
	}

	public void setGolpes(List<Golpe> golpes) {
		this.golpes = golpes;
	}
	
	public int ataque(Golpe golpe){
	int danoTotal =0;
	
		if(golpe.getTipo().equals("físico")){
			danoTotal = this.habilidade + golpe.getDanoBasico();
		}else if(golpe.getTipo().equals("magia")){
			if(this.pontosDeMagia >= 10){
				danoTotal = this.poderDeFogo + golpe.getDanoBasico();
				this.pontosDeMagia = pontosDeMagia - 10;	
			}
			
		}else if(golpe.getTipo().equals("especial")){
			danoTotal = (this.poderDeFogo + this.habilidade + golpe.getDanoBasico())*2;
		}
		
		return danoTotal;
	}
	public int superEfetivo(int dano){
		return   (dano * 2) - this.armadura;
	}
	public int naoEfetivo(int dano){
		return (dano /2) - this.armadura;
	}
	public void defesa(int danoDogolpe, Golpe golpe ){
		
		// super effetivo!
		
		if(this.tipo.equals("planta")&& golpe.getTipo().equals("fogo")){
			superEfetivo(danoDogolpe);
		}else if(this.tipo.equals("fogo") && golpe.getTipo().equals("agua")){
			superEfetivo(danoDogolpe);
		}else if (this.tipo.equals("agua") && golpe.getTipo().equals("eletrico")){
			superEfetivo(danoDogolpe);
		}else if(this.tipo.equals("psiquico")&& golpe.getTipo().equals("fantasma")){
			superEfetivo(danoDogolpe);
		}else if (this.tipo.equals("pedra") && golpe.getTipo().equals("agua")){
			superEfetivo(danoDogolpe);
		}else if (this.tipo.equals("eletrico") && golpe.getTipo().equals("pedra")){
			superEfetivo(danoDogolpe);
		}
		// não efetivo
		
		else if(this.tipo.equals("fogo")&& golpe.getTipo().equals("planta")){
			naoEfetivo(danoDogolpe);
		}else if(this.tipo.equals("agua") && golpe.getTipo().equals("fogo")){
			naoEfetivo(danoDogolpe);
		}else if (this.tipo.equals("eletrico") && golpe.getTipo().equals("agua")){
			naoEfetivo(danoDogolpe);
		}else if (this.tipo.equals("agua") && golpe.getTipo().equals("pedra")){
			naoEfetivo(danoDogolpe);
		}else if (this.tipo.equals("pedra") && golpe.getTipo().equals("eletrico")){
			naoEfetivo(danoDogolpe);
		}
		
		else {
			//dano normal
			
		}
		
	}
	
}
