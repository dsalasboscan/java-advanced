/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciotcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author david.salas
 */
public class MinimoServidor {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServerSocket s = (ServerSocket)null;

        Socket s1;

        String cadena = "Tutorial de Java!";

        int longCad;

        OutputStream s1out;
        
        try {

            s = new ServerSocket( 4321,300 );


        } catch( IOException e ) {

        System.out.println( e );

        }
        
        while( true ) {

            try {


            // Espera para aceptar una conexión

            s1 = s.accept();


            // Obtiene un controlador de fichero de salida asociado con el socket

            s1out = s1.getOutputStream();


            // Enviamos nuestro texto

            longCad = sendString.length();

            for( int i=0; i < longCad; i++ )

            s1out.write( (int) sendString.charAt( i ) );


            // Cierra la conexión, pero no el socket del servidor

            s1.close();

            } catch( IOException e ) {

            System.out.println( e );

            }
        }
    }
}
