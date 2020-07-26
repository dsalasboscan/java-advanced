/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sockets.simple;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Instructor
 */
public class MulticastServer {

     public static void main(String[] args) throws InterruptedException, IOException {
        try {
                DatagramSocket socket = new DatagramSocket();


                byte[] b = "Dario Hruszecki".getBytes();
                DatagramPacket dgram;

                dgram = new DatagramPacket(b, b.length,InetAddress.getByName("235.1.1.1"), 4000);

                System.err.println("Sending " + b.length + " bytes to " +
                  dgram.getAddress() + ':' + dgram.getPort());
                while(true) {
                  System.err.print(".");
                  socket.send(dgram);
                  Thread.sleep(1000);
                }


        } catch (SocketException ex) {
            Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
        }  catch (UnknownHostException ex) {
                Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
