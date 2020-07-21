/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.com.educacionit.java.advanced.chat;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Instructor
 */
public class FileSender implements Runnable  {
    
    private Contact contact;
    private JLabel status;
    private File file;

    public FileSender(Contact contact, JLabel status, File file) {
        this.contact = contact;
        this.status = status;
        this.file = file;
    }
  
    public void run() {
        try {
            send(contact.getInetAddres().getHostName(), contact.getPort()+1, file);
            status.setForeground(new java.awt.Color(102, 255, 51));
            status.setText("File enviado!");
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


    public void send(String host, int port, File file) throws SenderException{
        try {
            Socket server = new Socket(host, port);
            OutputStream os = server.getOutputStream();
            FileInputStream fis = new FileInputStream(file);
            int bait;
            while((bait=fis.read())!=-1) {
                os.write(bait);
            }

            os.flush();
            os.close();
            server.close();
        } catch (UnknownHostException ex) {
            Logger.getLogger(FileSender.class.getName()).log(Level.SEVERE, null, ex);
            throw new SenderException(ex);
        } catch (IOException ex) {
            Logger.getLogger(FileSender.class.getName()).log(Level.SEVERE, null, ex);
            throw new SenderException(ex);
        }
    }



}
