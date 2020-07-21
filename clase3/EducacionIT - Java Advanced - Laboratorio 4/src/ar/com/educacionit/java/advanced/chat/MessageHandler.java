/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.com.educacionit.java.advanced.chat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Instructor
 */
public class MessageHandler extends Thread {

    private Socket client;
    private ChatGUI gui;

    public MessageHandler(Socket client, ChatGUI gui) {
        this.client = client;
        this.gui = gui;
    }



    @Override
    public void run() {
        try {
            System.out.println("..Atendiendo coneccion desde :"+client.getInetAddress());
            DataInputStream dis = new DataInputStream(client.getInputStream());
            String msg = "."+client.getInetAddress()+ ":"+client.getPort()+" -> "+  dis.readUTF();
            System.out.println(msg);
            gui.getIncommingMsgs().append(msg+"\n");
            dis.close();
            client.close();
        } catch (IOException ex) {
            Logger.getLogger(MessageHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
