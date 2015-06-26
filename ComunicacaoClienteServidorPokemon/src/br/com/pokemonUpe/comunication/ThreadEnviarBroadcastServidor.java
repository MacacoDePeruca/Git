package br.com.pokemonUpe.comunication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.Socket;
import java.util.Random;

public class ThreadEnviarBroadcastServidor extends Thread {
	String nomeCliente;
	
	private static boolean parar = false;

	public static void setParar(boolean opcao) {
		parar = opcao;
	}
	
	public ThreadEnviarBroadcastServidor(){
		
	}

	public void run(){
        final String IpGrupo = "233.0.0.3";
		final int porta = 3333;
		Random random = new Random();
		int i = random.nextInt();
		int contTentativas = 1;
		String verificadorServBalanc = " ";
		setParar(false);
		while(!parar){
			try {
				
				InetAddress end = InetAddress.getByName(IpGrupo);
	
				nomeCliente = "Android";
				String msg = "cliente " + nomeCliente + " " + i + " ";
				
				byte[] buff = msg.getBytes();
	
				DatagramPacket pkg = new DatagramPacket(buff, buff.length, end, porta);
	
				DatagramSocket ds = new DatagramSocket();
	            ds.send(pkg);
	            ds.close();
	            if(contTentativas != 1)
	            	Thread.sleep(2000);
			}
	
			catch (Exception e) {
				System.out.println("Nao foi possivel enviar a mensagem");
			}
			
			contTentativas++;
			if(contTentativas > 5){
				setParar(true);
			}
		}
		setParar(false);
		
		try {
			
			InetAddress grp = InetAddress.getByName("232.0.0.2");

			MulticastSocket mcs;
			
			mcs = new MulticastSocket(2222);

			mcs.joinGroup(grp);

			byte rec[] = new byte[100];

			DatagramPacket pkg = new DatagramPacket(rec, rec.length);
			
			pkg.getAddress();
			
			mcs.receive(pkg);
				
			new ThreadEscutarBroadcastCliente();
			ThreadEscutarBroadcastCliente.setParar(true);
			
			String data = new String(pkg.getData());
						  
			String s[] = data.split(" ");
			
			if(!verificadorServBalanc.equals(s[2])){
				verificadorServBalanc = s[2];
				String ipServidor = s[0];
				int portaServidor = Integer.parseInt(s[1]);
				//System.out.println(ipServidor);
				//System.out.println(portaServidor);
				
				Socket socket = new Socket(ipServidor, portaServidor);
				
				System.out.println("Conectado ao servidor via socket")
				;
				PrintStream saida = new PrintStream(socket.getOutputStream());
				new ThreadReceberMsgConxeao(socket).start();
				
				BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
				String msg;
				while (true) {
					msg = teclado.readLine();
					// envia o conteudo de 'msg' para o servidor
					saida.println(msg);
				}
				
			}
			mcs.close();
			
		}
		
		catch (Exception e) {

			e.printStackTrace();

		}
		
    }
}
