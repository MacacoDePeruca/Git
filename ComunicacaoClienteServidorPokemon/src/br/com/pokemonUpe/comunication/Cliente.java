/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pokemonUpe.comunication;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.Socket;

/**
 *
 * @author Vitor
 */
public class Cliente {
   private int idCliente;
   private Socket conexao;

   public static PacoteDeDados receberPacote(){
       while (true) {

			try {
               //System.out.println("Esperando resposta do Servidor");
				InetAddress grp = InetAddress.getByName("232.0.0.2");

				MulticastSocket mcs = new MulticastSocket(2222);

				mcs.joinGroup(grp);

				byte rec[] = new byte[256];

				DatagramPacket pkg = new DatagramPacket(rec, rec.length);
				pkg.getAddress();
				//para pra escutar retorno do servidor
               mcs.receive(pkg);
               mcs.close();
				
				//String data = new String(pkg.getData());
				//System.out.println("getAddress : "+pkg.getAddress());
				//System.out.println("IP: " + data);
               PacoteDeDados pdd = new PacoteDeDados(pkg.getAddress().toString(), 1111, pkg.getData().toString());
               return pdd;
			}

			catch (Exception e) {

				System.out.println("Erro: " + e.getMessage());
                               

			}
       }
   }
}
