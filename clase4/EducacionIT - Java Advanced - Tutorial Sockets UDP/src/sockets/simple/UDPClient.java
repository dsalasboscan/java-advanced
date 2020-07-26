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
public class UDPClient {

        public static void main(String[] args) throws InterruptedException {
        try {
                DatagramSocket socket = new DatagramSocket(4000, InetAddress.getByName("localhost"));
                DatagramPacket dato = new DatagramPacket(new byte[100], 100);
                while ( true) {
                try {
                    socket.receive(dato);
                    System.out.println(new String(dato.getData()));
                    Thread.currentThread().sleep(2000);
                } catch (IOException ex) {
                    Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
        } catch (SocketException ex) {
            Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
        }  catch (UnknownHostException ex) {
                Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
