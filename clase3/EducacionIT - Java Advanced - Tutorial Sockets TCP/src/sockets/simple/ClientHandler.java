/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sockets.simple;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Instructor
 */
public class ClientHandler extends Thread {

    private Socket client;

    public ClientHandler(Socket client) {
        this.client = client;
    }



    @Override
    public void run() {
        try {
            System.out.println("..Atendiendo coneccion desde :"+client.getInetAddress());
            DataInputStream dis = new DataInputStream(client.getInputStream());
            System.out.println("..Mensaje recibido"+ client.getInetAddress()+ ": "+ dis.readUTF());
            dis.close();
            client.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
