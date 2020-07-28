/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatdesdecero;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author david.salas
 */
public class MessageHandler extends Thread {

    private Socket client;
    private ChatGUI gui;
    
    public MessageHandler(Socket client, ChatGUI gui) {
        this.client = client;
        this.gui = gui;
    }
    
    public void run() {
        try {
            DataInputStream dis = new DataInputStream(client.getInputStream());
            String msg = "." + client.getInetAddress() + ":" + client.getPort() + " -> " + dis.readUTF();
            System.out.println(msg);
            gui.getTextAreaIncommingMsg().append(msg + "\n");
            dis.close();
            client.close();
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
