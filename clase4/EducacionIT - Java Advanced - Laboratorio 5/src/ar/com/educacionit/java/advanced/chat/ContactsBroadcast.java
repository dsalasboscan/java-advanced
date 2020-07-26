/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.com.educacionit.java.advanced.chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Instructor
 */
public class ContactsBroadcast implements Runnable {

    public void run() {
        try {
            DatagramSocket socket = new DatagramSocket();
            byte[] b = new byte[100];
            DatagramPacket dgram;
            dgram = new DatagramPacket(b, b.length, InetAddress.getByName("235.1.1.1"), 4000);
            System.err.println("Sending " + b.length + " bytes to " + dgram.getAddress() + ':' + dgram.getPort());
            while (true) {
                System.err.print(".");
                socket.send(dgram);
                Thread.sleep(1000);
            }
        } catch (Exception ex) {
            Logger.getLogger(ContactsBroadcast.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
