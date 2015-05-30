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
    	
        	
        
    }
}
