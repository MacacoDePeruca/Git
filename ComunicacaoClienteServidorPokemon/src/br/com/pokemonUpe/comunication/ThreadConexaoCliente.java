package br.com.pokemonUpe.comunication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.pokemonUpe.DAO.ServidorDAO;


public class ThreadConexaoCliente extends Thread{
	private Socket s;
	String nomeCliente;
	String nomeServ;
	private static List<String> LISTA_DE_JOGADORES = new ArrayList<String>();
	PrintStream saida;
	private int contadorDeClientes = 0;
	
	
	//construtor da classe
	public ThreadConexaoCliente(Socket s, String nomeServ){
		this.s = s;
		this.nomeServ = nomeServ;
	}
	
	
	// por toda a regra de negócio da comunicação aqui
	public Boolean conexaoComClienteEstabelecida() throws SQLException{
		
		PrintStream saidaServBalanc = new Servidor().getServBalanServJogo();
		saidaServBalanc.println("02&" + nomeServ);
		
		//contadorDeClientes = new ServidorDAO().addClienteOnLine(nomeServ);
		System.out.println(contadorDeClientes);
		return false;
	}
	
	
    public void run(){
    	System.out.println("conexão foi feita");
    	try {
			conexaoComClienteEstabelecida();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	try{
    		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
    		
    		saida = new PrintStream(this.s.getOutputStream());
    		new ThreadReceberMsgConxeao(s).start();
    		
    		String msg;
    		while (true){
    			msg = teclado.readLine();
    			saida.println(msg);
    			
			}
    		
    	}
    	catch (IOException e) {
    	}
    }
}
