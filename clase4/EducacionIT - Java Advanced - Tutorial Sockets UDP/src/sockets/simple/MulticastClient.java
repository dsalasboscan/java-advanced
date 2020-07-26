/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sockets.simple;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Instructor
 */
public class MulticastClient {


    public static void main(String[] args) throws IOException {

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
                }



        } catch (SocketException ex) {
            Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
        }  catch (UnknownHostException ex) {
                Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



}
