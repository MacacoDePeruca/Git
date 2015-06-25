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
			PrintStream saidaServBalanc = new Servidor().getServBalanServJogo();
			String msg;
			
			while (true) {
				msg = entrada.readLine();

				String s[] = msg.split("&");
				
				switch (s[0]) {
				case "01" :
					
					System.out.println(s[1]);
					break;
					
				case "02" :
					
					break;
				case "03" :

					break;
				case "04" :

					break;
				default:
					
					break;
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}