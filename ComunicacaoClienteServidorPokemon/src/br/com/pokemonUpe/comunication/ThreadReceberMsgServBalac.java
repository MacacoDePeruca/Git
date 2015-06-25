package br.com.pokemonUpe.comunication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;


public class ThreadReceberMsgServBalac extends Thread{
	
	Socket s;
	
	public ThreadReceberMsgServBalac(Socket socket){
		this.s = socket;
	}
	
	
	public void run(){
		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintStream saidaCliente = new Servidor().getServBalanServJogo();
			//PrintStream saidaCliente = //new PrintStream(s.getOutputStream());
			String msg;
			while (true) {
				msg = entrada.readLine();
				saidaCliente.println("ok");
				//saidaCliente.println("recebi e estou enviando a msg: "+ msg);
				System.out.println(msg);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}