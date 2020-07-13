/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package ar.com.educacionit.java.advanced.sincronizacion;

/**
 *
 * @author instructor
 */
public class Persona extends Thread {
    
    private String nombre;
    private Saludo saludo;
    private boolean esJefe;
    
    
    public Persona(Saludo saludo, String nombre, boolean esJefe) {
        this.nombre = nombre;
        this.saludo = saludo;
        this.esJefe = esJefe;
    }
    
    public void run() {
        
        System.out.println("("+nombre+" llega)");
        
        if (esJefe)
            
            saludo.saludoJefe();
        
        else
            
            saludo.esperarJefe(nombre);
        
    }
}
