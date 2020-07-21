/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicanetworking;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author david.salas
 */
public class ClientHandler extends Thread {
    private Socket client;

    public ClientHandler(Socket client) {
        this.client = client;
    }
    
    public void run() {
        try {
            System.out.println("Atendeniendo conexion desde: " + client.getInetAddress());
            DataInputStream dis = new DataInputStream(client.getInputStream());
            System.out.println("Mensaje recibido" + client.getInetAddress() + dis.readUTF());
            dis.close();
            client.close();
            
        } catch (IOException e) {
            System.out.println("Error al recibir datos del cliente");
        }
        
    }
}
