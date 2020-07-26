/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.com.educacionit.java.advanced.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Instructor
 */
public class FileListener implements Runnable {

    private ChatGUI gui;
    private int port;

    public FileListener(ChatGUI gui, int port) {
        this.gui = gui;
        this.port = port;
    }


    private void handle(Socket client) {
        Thread t = new FileHandler(client,gui);
        t.start();
    }

    public void run() {
        try {
            ServerSocket server = new ServerSocket(port);

            while(true) {
                System.out.println(".Aceptando conecciones ...");
                Socket client = server.accept();
                System.out.println(".Nueva coneccion desde :"+client.getInetAddress());
                handle(client);
            }

        } catch (IOException ex) {
            Logger.getLogger(FileListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
