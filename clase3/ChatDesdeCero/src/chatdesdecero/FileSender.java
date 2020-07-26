/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatdesdecero;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import javax.swing.JLabel;

/**
 *
 * @author david.salas
 */
class FileSender extends Thread {
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
            send(contact.getInetAddress().getHostName(), contact.getPort()+1, file);
            status.setForeground(new Color(102, 255, 51));
            status.setText("File enviado!");
        } catch (Exception e){
            System.out.println("Exception: " + e.getMessage());
        }
        
    }
    
    public void send(String host, int port, File file) throws IOException {
        try {
            Socket client = new Socket(host, port);
            OutputStream os = client.getOutputStream();
            FileInputStream fis = new FileInputStream(file);
            int bait;
            
            while ( (bait = fis.read()) != -1) {
                os.write(bait);
            }
            
            os.flush();
            os.close();
            client.close();
            
        } catch(Exception e) {
            System.out.println("Exception: " + e.getMessage());
        } 
    }
    
    
}
