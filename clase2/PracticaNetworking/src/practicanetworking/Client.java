/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicanetworking;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author david.salas
 */
public class Client {
    public static void main(String[] args) {
        try {
          Socket server = new Socket("localhost", 4001);
          DataOutputStream ps = new DataOutputStream(server.getOutputStream());
          ps.writeUTF("Holaaa desde el cliente");
          ps.flush();
          ps.close();
          server.close();
            
        } catch (IOException e) {
            System.out.println("No se pudo conectar al servidor");
        }
        
    }
}
