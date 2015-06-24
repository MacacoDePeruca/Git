package br.com.pokemonUpe.comunication;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.sql.SQLException;

import br.com.pokemonUpe.DAO.ClienteDAO;
import br.com.pokemonUpe.DAO.ServidorDAO;

//import com.mysql.jdbc.PreparedStatement;


public class ThreadEscutarBroadcastCliente extends Thread{
	/**
	 * essa thread vai ser usada para escutar o cliente
	 * e depois mand outro broadcast
	 */
	int clientesOnLine = 0;
	public void run(){
		
		String verificador = " ";
		String msg;
		try {
			while(true){
				//System.out.println("Servidor escutando");
				InetAddress grp = InetAddress.getByName("233.0.0.3");
	
				MulticastSocket mcs;
				
				mcs = new MulticastSocket(3333);
	
				mcs.joinGroup(grp);
	
				byte rec[] = new byte[256];
	
				DatagramPacket pkg = new DatagramPacket(rec, rec.length);
				
				pkg.getAddress();
				
				//System.out.println("Aguardando Broadcasting");
				mcs.receive(pkg);
				
				String data = new String(pkg.getData());
				String s[] = data.split(" ");
				
				if (s[0].equals("cliente")){//trata o multicast vindo do cliente 
					
					String ip = pkg.getAddress().toString();
					int porta = pkg.getPort();

					Cliente cliente = new Cliente();
					
					cliente.setIdCliente(1);
					cliente.setNome(s[1]);
					cliente.setIp(ip);
					cliente.setPorta(porta);

					ClienteDAO dao = new ClienteDAO();
					
					if(dao.salvarCliente(cliente)== true){
						clientesOnLine++;
					}
					
					System.out.println("ON THE LINE : " + clientesOnLine);
					
					// grita voltando
					ServidorDeBalanceamento bala = new ServidorDeBalanceamento();
					msg = bala.balanceamento(); //chama o metodo de balanceamento que vai retornar o ip e porta do servidor disponível
					
					grp = InetAddress.getByName("232.0.0.2");
					
					byte[] buff = msg.getBytes();
					
					pkg = new DatagramPacket(buff, buff.length, grp, 2222);
					
					DatagramSocket ds = new DatagramSocket();
					
					ds.send(pkg);
					
					ds.close();
					
					mcs.close();

				}
				
				else if (s[0].equals("servidor")){//trata o multicast vindo do servidor
					
					if(!verificador.equals(s[4])){
						System.out.println("Servidor "+ s[3] +" ativo");
						try {
							ServidorDAO servDao = new ServidorDAO();
							servDao.atualizarServidor(s[1], s[3], s[2]);
						} catch (SQLException e) {
							e.printStackTrace();
						}
						new ThreadServBalanceamentoServJogo(s[1], 1234, 2).start();
						verificador = s[4];
					}
				}
				
				else{
					System.out.println("Remedente indisponível");
				}
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
