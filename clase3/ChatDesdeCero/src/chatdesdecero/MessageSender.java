/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatdesdecero;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author diego
 */
public class MessageSender implements Runnable{

    private Contact contact;
    private String msg;
    
    
    @Override
    public void run() {
        try {
            send(contact.getHost(), contact.getPort(), msg);
            
         
            
        } catch (Exception err) {
            //supongo que los errores irian orientados a las fallas de comunicación
            //encotrar el receptor o algo cosas por el estilo. y me queda la duda si 
            // en la construcción de la clase Contact, se debe incluir el host o algo distinto.
        }
    }
    
    public void send(String host, int port, String msg) throws IOException{
       try{
           //tuve un error al poner el host como int asi que lo pase a String
           Socket server = new Socket(host, port);
       
        DataOutputStream ps= new DataOutputStream(server.getOutputStream());
        ps.writeUTF(msg);
        //aseguramos que todo haya sido enviado
        ps.flush();
        //cerramos las conexiones
        ps.close();
        server.close();
       }catch(IOException err){
           
       } 
    }
    
    
    
}
