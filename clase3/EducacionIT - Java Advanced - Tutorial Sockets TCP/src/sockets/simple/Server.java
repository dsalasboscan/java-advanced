/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sockets.simple;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Instructor
 */
public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(4000);

            while(true) {
                System.out.println(".Aceptando conecciones ...");
                Socket client = server.accept();
                System.out.println(".Nueva coneccion desde :"+client.getInetAddress());
                handle(client);
            }

        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void handle(Socket client) {
        Thread t = new ClientHandler(client);
        t.start();
    }

}
