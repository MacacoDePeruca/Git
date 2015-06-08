package br.com.pokemonUpe.comunication;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ThreadEnviarBroadcastServidor {
String nomeCliente;
	
	public ThreadEnviarBroadcastServidor(String nome){
		this.nomeCliente = nome;
	}
	
	public void run(){
        final String IpGrupo = "233.0.0.3";
		final int porta = 3333;
		
		try {

			InetAddress end = InetAddress.getByName(IpGrupo);//envia multicast para o IpGrupo

			byte[] buff = nomeCliente.getBytes();

			DatagramPacket pkg = new DatagramPacket(buff, buff.length, end, porta);

			DatagramSocket ds = new DatagramSocket();//responsável para enviar
            ds.send(pkg);
            ds.close();
                        
		}

		catch (Exception e) {

			System.out.println("Nao foi possivel enviar a mensagem");

		}
    }
}
