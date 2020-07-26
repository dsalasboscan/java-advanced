/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.com.educacionit.java.advanced.chat;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author Instructor
 */
public class ContactsListeners implements Runnable {

    private DefaultListModel modeloContactos;

    public ContactsListeners(DefaultListModel modeloContactos) {
        this.modeloContactos = modeloContactos;
    }

    

    public void run() {
        try {
                byte[] b = new byte[100];
                DatagramPacket dgram = new DatagramPacket(b, b.length);
                MulticastSocket socket = new MulticastSocket(4000); // must bind receive side
                socket.joinGroup(InetAddress.getByName("235.1.1.1"));

                while(true) {
                  socket.receive(dgram); // blocks until a datagram is received
                  System.err.println("Received " + dgram.getLength() +
                    " bytes from " + dgram.getAddress() + new String(dgram.getData()));
                  dgram.setLength(b.length); // must reset length field!
                  Thread t = new Thread(new ContactsHandler(modeloContactos,dgram.getAddress()));
                  t.start();
                }



        } catch (Exception ex) {
            Logger.getLogger(ContactsListeners.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

}
