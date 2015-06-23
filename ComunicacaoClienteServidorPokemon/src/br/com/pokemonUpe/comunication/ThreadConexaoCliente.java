package br.com.pokemonUpe.comunication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ThreadConexaoCliente extends Thread{
	private Socket s;
	String nomeCliente;
	private static List<String> LISTA_DE_JOGADORES = new ArrayList<String>();
	PrintStream saida;
	private int contadorDeClientes =0;// 
	private int capacidadeDoServidor = 5;
	//construtor da classe
	public ThreadConexaoCliente(Socket s){
		this.s = s;
	}
	
	
	// por toda a regra de negócio da comunicação aqui
	public Boolean ConexaoComClienteEstabelecida(){
		return false;
	}
	
	
    public void run(){
    	System.out.println("conexão foi feita");
    	
    	try{
    		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
    		BufferedReader entrada = new BufferedReader(new InputStreamReader(this.s.getInputStream()));
    		
    		saida = new PrintStream(this.s.getOutputStream());
    		
    		String msg;
    		while (true) {
    			System.out.println("aqui 1");
    			System.out.println(entrada.readLine());
    			System.out.println("aqui 2");
    			msg = teclado.readLine();
    			saida.println(msg);
    			
			}
    		
    	}
    	catch (IOException e) {
    	}
    }
}
