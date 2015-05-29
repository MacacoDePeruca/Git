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
	
	public ThreadConexaoCliente(Socket s){
		this.s = s;
	}
	PrintStream saida;
    public void run(){
    	
        	
        
    }
}
