/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.net.InetAddress;

/**
 *
 * @author Israel Risso
 */
public class Cliente {
    public String usuario;
    public int porta;
    public InetAddress ip;
    
    public Cliente(String usuario, int porta, InetAddress ip) {
        this.usuario = usuario;
        this.porta = porta;
        this.ip = ip;
    }
    
    public Cliente(){}
}
