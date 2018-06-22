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

    public Servidor() throws SocketException, IOException {
        serverSocket = new DatagramSocket(10000);

        while (true) {
            receiveData = new byte[1024];
            sendData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            
            String pacote = new String(receivePacket.getData()).trim();
            
            Cliente cliente;
            String resp;
            
            System.out.println("'" + pacote + "'");
            cliente = new Cliente(pacote, receivePacket.getPort(), receivePacket.getAddress());
            if (clientes.size() > 1 && pacote.equalsIgnoreCase("inicia")) break;
            else if (pacote.equalsIgnoreCase("inicia")) {
                resp = "sai daqui";
            } else {
                clientes.add(cliente);
                resp = "conectou";
            }
            
            sendData = resp.getBytes();
            DatagramPacket sendPacket
                    = new DatagramPacket(sendData, sendData.length, cliente.ip, cliente.porta);
            serverSocket.send(sendPacket);
        }

        serverSocket.close();

    }
}
