/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.educacionit.java.advanced.chat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author Instructor
 */
public class FileHandler extends Thread {

    private Socket client;
    private ChatGUI gui;

    public FileHandler(Socket client, ChatGUI gui) {
        this.client = client;
        this.gui = gui;
    }

    @Override
    public void run() {
        try {
            System.out.println("..Atendiendo coneccion desde :" + client.getInetAddress());
            InputStream is = client.getInputStream();
            final JFileChooser fc = new JFileChooser();
            //In response to a button click:
            int returnVal = fc.showOpenDialog(gui);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                FileOutputStream fos = new FileOutputStream(file);
                int bait;
                while ((bait = is.read()) != -1) {
                    fos.write(bait);
                }
                fos.flush();
                fos.close();
                gui.getIncommingMsgs().append("File "+file.getName()+" received" + "\n");
            }

           
            is.close();
            client.close();
        } catch (IOException ex) {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
