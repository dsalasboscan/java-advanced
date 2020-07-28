/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatdesdecero;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import javax.swing.JFileChooser;

/**
 *
 * @author david.salas
 */
public class FileHandler extends Thread {

    private ChatGUI gui;
    private Socket client;
    
    public FileHandler(ChatGUI gui, Socket client) {
        this.gui = gui;
        this.client = client;
    }
    
    public void run() {
        try {
            System.out.println("Atendiendo conexiones desde : " + client.getInetAddress());  
            InputStream is = client.getInputStream();
            
            JFileChooser fc = new JFileChooser();
            
            int returnVal = fc.showOpenDialog(gui);
            
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                
                FileOutputStream fos = new FileOutputStream(file);
                
                int bait;
                
                while( (bait = is.read()) != -1 ) {
                    fos.write(bait);
                }
                
                fos.flush();
                fos.close();
                
                gui.getTextAreaIncommingMsg().append("File " + file.getName() + " received " + "\n");
            }
            
            is.close();
            client.close();
        } catch(IOException e) {
            System.out.println("No se pudo recibir el mensaje, mensaje exception" + e.getMessage());
        }
    }
    
}
