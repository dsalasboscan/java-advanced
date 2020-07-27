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
 * @author diego
 */
class FileListener implements Runnable {
    private ChatGUI gui;
    private int port;
    
    public FileListener(ChatGUI gui, int port){
        this.gui = gui;
        this.port = port;
    }
 private void handle(Socket client){
        Thread t = new FileHandler(client, gui);
        t.start();
    }
    

    
    @Override
    public void run(){
        try {
              ServerSocket server = new ServerSocket(port);
              
              while(true){
                  System.out.println("Aceptando conexiones...");
                  Socket client = server.accept();
                  System.out.println("Nueva conexion desde : " + client.getInetAddress());
                       
              }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
   
}
