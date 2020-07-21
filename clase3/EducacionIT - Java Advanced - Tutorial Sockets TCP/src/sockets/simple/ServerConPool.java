/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sockets.simple;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Instructor
 */
public class ServerConPool {

    private static ExecutorService ejecutor = Executors.newFixedThreadPool(2);

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
            Logger.getLogger(ServerConPool.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void handle(Socket client) {
        ClientHandler handler = new ClientHandler(client);
        ejecutor.execute(handler);
    }

}
