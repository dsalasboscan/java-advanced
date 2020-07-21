/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicanetworking;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author david.salas
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(4001);
            ServerSocket server2 = new ServerSocket(4002);
            
            while(true) {
                System.out.println("Aceptando conexiones....");
                Socket client = server.accept();
                Socket client2 = server2.accept();
                System.out.println("Nueva conexión desde " + client.getInetAddress());
                handle(client);
            }
            
        } catch (IOException e) {
            System.out.println("No se pudo iniciar el server");
        }
        
    }
    
    private static void handle(Socket client) {
        Thread t = new ClientHandler(client);
        t.start();
    }
}
