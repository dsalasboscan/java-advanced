/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatdesdecero;

import java.awt.Color;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import javax.swing.JLabel;

/**
 *
 * @author david.salas
 */
class MessageSender extends Thread {
    
    
    private Contact contact;
    private JLabel status;
    private String msg;

    public MessageSender(Contact contact, JLabel status, String msg) {
        this.contact = contact;
        this.status = status;
        this.msg = msg;
    }
    
    
    public void run() {
        try {
            send(contact.getInetAddress().getHostName(), contact.getPort(), msg);
            status.setForeground(new Color(102, 255, 51));
            status.setText("Mensaje enviado");
        } catch(Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }
    
    public void send(String host, int port, String msg) {
        try {
            Socket client = new Socket(host, port);
            DataOutputStream ps = new DataOutputStream(client.getOutputStream());
            ps.writeUTF(msg);
            ps.flush();
            ps.close();
            client.close();
        } catch (IOException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }
    
}
