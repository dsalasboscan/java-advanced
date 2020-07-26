/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatdesdecero;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david.salas
 */
public class ContactsBroadcast implements Runnable {

    private int port;
    
public ContactsBroadcast(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try {
            DatagramSocket socket = new DatagramSocket();
            byte[] b = String.valueOf(port).getBytes();
            InetAddress multicastAddress = InetAddress.getByName("235.1.1.1");
            DatagramPacket packet = new DatagramPacket(b, b.length, multicastAddress, 4000);
            
            while(true) {
                socket.send(packet);
                Thread.sleep(1000L);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(ContactsBroadcast.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
