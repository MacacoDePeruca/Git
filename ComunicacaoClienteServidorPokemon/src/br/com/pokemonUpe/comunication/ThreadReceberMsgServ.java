package br.com.pokemonUpe.comunication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ThreadReceberMsgServ extends Thread{
	
	Socket s;
	
	public ThreadReceberMsgServ(Socket socket){
		this.s = socket;
	}
	
	
	public void run(){
		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			String msg;
			while (true) {
				msg = entrada.readLine();
				
				//saidaCliente.println("recebi e estou enviando a msg: "+ msg);
				System.out.println(msg);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
