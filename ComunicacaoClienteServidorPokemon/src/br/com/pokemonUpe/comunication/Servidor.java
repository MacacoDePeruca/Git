/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pokemonUpe.comunication;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Vitor
 */
public class Servidor {
    private final int MAX_DE_CLIENTES =10;
	private int porta;
	private String ip;
    private ServerSocket serverSocket;
    private Socket socket;
    private String nomeDoServidor;
    private int clientesOnline;
    private static PrintStream servBalanServJogo;
    private static int qtdJogadoresOnLine;
    private LogDeComunicacao log = new LogDeComunicacao();
    
    public Servidor(){
    	
    }
    
    public Servidor(String nomeServidor){
    	
    }
    
    public Servidor(String nomeServidor, String ip, int porta) throws UnknownHostException{
    	
    	this.porta = porta;
    	this.ip = ip;
    	this.nomeDoServidor = nomeServidor;
    	
    }
    
	public ServerSocket getServerSocket() {
		return serverSocket;
	}
	
	public void setServerSocket(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}
	
	public Socket getSocket() {
		return socket;
	}
	
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	
	public LogDeComunicacao getLog() {
		return log;
	}
	
	public void setLog(LogDeComunicacao log) {
		this.log = log;
	}
	
	public int getMAX_DE_CLIENTES() {
		return MAX_DE_CLIENTES;
	}
	
	public String getNomeDoServidor() {
		return nomeDoServidor;
	}
	
	public void setNomeDoServidor(String nomeDoServidor) {
		this.nomeDoServidor = nomeDoServidor;
	}
	
	public int getPorta() {
		return porta;
	}

	public void setPorta(int porta) {
		this.porta = porta;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getClientesOnline() {
		return clientesOnline;
	}
	
	public void setClientesOnline(int clientesOnline) {
		this.clientesOnline = clientesOnline;
	}
	
	public PrintStream getServBalanServJogo() {
		return servBalanServJogo;
	}

	public static void setServBalanServJogo(PrintStream servBalanServ) {
		servBalanServJogo = servBalanServ;
	}
	
	public static int getQtdJogadoresOnLine() {
		return qtdJogadoresOnLine;
	}

	public static void setQtdJogadoresOnLine() {
		qtdJogadoresOnLine = qtdJogadoresOnLine + 1;
	}
	
	public void StartarServidor(){
        
        try {
            serverSocket = new ServerSocket(porta);
            log.aguardandoConexaoComOservidor();
            while (true){
               
                Socket s = serverSocket.accept();
                new ThreadConexaoCliente(s, nomeDoServidor).start();
                log.aguardandoConexaoComOservidor();
                
            }
        } catch (IOException ex) {
            ex.getMessage();
        }finally{
            try { 
                
            	serverSocket.close();
                
            } catch (Exception e) {
             e.printStackTrace();   
            }
        }
    }

	
}
