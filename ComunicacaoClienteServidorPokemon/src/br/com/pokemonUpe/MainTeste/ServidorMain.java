package br.com.pokemonUpe.MainTeste;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import br.com.pokemonUpe.comunication.Servidor;

public class ServidorMain {

	public static void main(String[] args) {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			InetAddress end = InetAddress.getByName("233.0.0.3");// envia multicast para o Ip do Grupo

			System.out.print("Informe o nome do servidor: ");
			String nomeServidor = teclado.readLine();
			
			byte[] buff = nomeServidor.getBytes();

			DatagramPacket pkg = new DatagramPacket(buff, buff.length, end,	3333);

			DatagramSocket ds = new DatagramSocket();

			ds.send(pkg);
			
			ds.close();

		}

		catch (Exception e) {

			System.out.println("Nao foi possivel enviar a mensagem");

		}
		
		Servidor servidor = new Servidor();
		servidor.StartarServidor();

	}

}
