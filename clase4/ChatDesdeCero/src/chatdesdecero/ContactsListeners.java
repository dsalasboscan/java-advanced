/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatdesdecero;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author david.salas
 */
public class ContactsListeners implements Runnable {

    private DefaultListModel<Contact> modeloContactos;
    private int ownPort;
    
    public ContactsListeners(DefaultListModel<Contact> modeloContactos, int ownPort) {
        this.modeloContactos = modeloContactos;
        this.ownPort = ownPort;
     
    }

    @Override
    public void run() {
        try {
            byte[] b = new byte[100];
            DatagramPacket packet = new DatagramPacket(b, b.length);
            MulticastSocket socket = new MulticastSocket(4000);
            socket.joinGroup(InetAddress.getByName("235.1.1.1"));
            
            while (true) {
                socket.receive(packet); // blocks until a dagagram is received
                packet.setLength(b.length);
                String portAsString = new String(packet.getData(), 0, packet.getData().length);
                int newContactPort = Integer.parseInt(portAsString.trim());
                Thread t = new Thread(new ContactsHandler(modeloContactos, packet.getAddress(), newContactPort, ownPort));
                t.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(ContactsListeners.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
