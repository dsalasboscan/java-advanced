/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatdesdecero;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import javax.swing.DefaultListModel;

/**
 *
 * @author david.salas
 */
public class ContactsListener implements Runnable {
    
    private DefaultListModel<Contact> modeloContactos;

    public ContactsListener(DefaultListModel<Contact> modeloContactos) {
        this.modeloContactos = modeloContactos;
    }

    @Override
    public void run() {
        try {
            byte[] b = new byte[100];
            DatagramPacket packet = new DatagramPacket(b, b.length);
            MulticastSocket socket = new MulticastSocket(4000);
            socket.joinGroup(InetAddress.getByName("235.1.1.1"));
            
            while (true) {
                socket.receive(packet);
                packet.setLength(b.length);
                String portAsString = new String(packet.getData(), 0, packet.getData().length);
                int newContactPort = Integer.parseInt(portAsString.trim());
                Thread t = new Thread(new ContactsHandler(modeloContactos, packet.getAddress(), newContactPort));
                t.start();
            }
            
        } catch(Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        
    }
}
