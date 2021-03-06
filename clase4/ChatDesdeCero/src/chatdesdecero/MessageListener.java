/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatdesdecero;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author david.salas
 */
public class MessageListener implements Runnable {

    private ChatGUI gui;
    private int port;
    
    public MessageListener(ChatGUI gui, int port) {
        this.gui = gui;
        this.port = port;
    }
    
    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(port);
            
            while(true) {
                System.out.println("Aceptando conexiones...");
                Socket client = server.accept();
                System.out.println("Nueva conexion desde: " + client.getInetAddress());
                handle(client);
            }
            
            
        } catch (IOException e) {
            System.out.println("No se pudo iniciar el servidor, mensaje exception: " + e.getMessage());
        }
    }
    
    private void handle(Socket client) {
        Thread t = new MessageHandler(client, gui);
        t.start();
    }
    
}
