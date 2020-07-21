/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.com.educacionit.java.advanced.chat;

import java.awt.Color;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Instructor
 */
public class MessageSender implements Runnable  {
    
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
            send(contact.getInetAddres().getHostName(), contact.getPort(), msg);
            status.setForeground(new java.awt.Color(102, 255, 51));
            status.setText("Mensaje enviado!");
        } catch (SenderException ex) {
            Logger.getLogger(ChatGUI.class.getName()).log(Level.SEVERE, null, ex);
            status.setForeground(Color.RED);
            status.setText("Mensaje NO enviado! - "+ex.getMessage());
        } catch ( NumberFormatException ex) {
            Logger.getLogger(ChatGUI.class.getName()).log(Level.SEVERE, null, ex);
            status.setForeground(Color.RED);
            status.setText("Mensaje NO enviado! - numero de puerto invalido: "+contact.getPort());
        }
    }


    public void send(String host, int port, String msg) throws SenderException{
        try {
            Socket server = new Socket(host, port);
            DataOutputStream ps = new DataOutputStream(server.getOutputStream());
            ps.writeUTF(msg);
            ps.flush();
            ps.close();
            server.close();
        } catch (UnknownHostException ex) {
            Logger.getLogger(MessageSender.class.getName()).log(Level.SEVERE, null, ex);
            throw new SenderException(ex);
        } catch (IOException ex) {
            Logger.getLogger(MessageSender.class.getName()).log(Level.SEVERE, null, ex);
            throw new SenderException(ex);
        }
    }



}
