/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import static apresentacao.janelaServidor.clientes;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author Israel Risso
 */
public class Servidor {
    
     DatagramSocket serverSocket;
         byte[] receiveData;
         byte[] sendData;
     public static void main(String args[]) throws Exception
      {
        
         
         
        
      }

    public Servidor() throws SocketException, IOException {
         serverSocket = new DatagramSocket(10000);
         
        

        for (int i = 0; i < 2; i++)
               {  receiveData = new byte[1024];
                  sendData = new byte[1024];
                  DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                  serverSocket.receive(receivePacket);
                  Cliente cliente = new Cliente();
                  cliente.usuario = new String( receivePacket.getData());
                  cliente.ip = receivePacket.getAddress();
                  cliente.porta = receivePacket.getPort();                 
                  clientes.add(cliente);
                  String resp = "conectou";
                  
                  sendData = resp.getBytes();
                  DatagramPacket sendPacket =
                  new DatagramPacket(sendData, sendData.length, cliente.ip, cliente.porta);
                  serverSocket.send(sendPacket);
               }
        
               serverSocket.close();
        
        
    }
}
