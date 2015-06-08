package br.com.pokemonUpe.comunication;

public class PacoteDeDados {
	private String ipServidor ;
    int porta ;
    String msg;

    public PacoteDeDados(String ipServidor, int porta, String msg) {
        this.ipServidor = ipServidor;
        this.porta = porta;
        this.msg = msg;
    }

    
    public String getIpServidor() {
        return ipServidor;
    }

    public void setIpServidor(String ipServidor) {
        this.ipServidor = ipServidor;
    }

    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    
    
}
