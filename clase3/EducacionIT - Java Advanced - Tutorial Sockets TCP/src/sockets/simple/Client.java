/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sockets.simple;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Instructor
 */
public class Client {


    public static void main(String[] args) {
        try {
            Socket server = new Socket("localhost", 4000);
            DataOutputStream ps = new DataOutputStream(server.getOutputStream());
            ps.writeUTF("Holaaaaaaaaa");
            ps.flush();
            ps.close();
            server.close();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



}
