package ar.com.educacionit.java.advanced.sincronizacion;

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

/**
 *
 * @author david.salas
 */
public class MainClass {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Saludo hola = new Saludo();
        
        Persona pablo = new Persona(hola, "Pablo", false);
        
        Persona luis = new Persona(hola, "Luis", false);
        
        Persona andrea = new Persona(hola, "Andrea", false);
        
        Persona pedro = new Persona(hola, "Pedro", false);
        
        Persona jefe = new Persona(hola, "JEFE", true);
        
        pablo.start();
        
        luis.start();
        
        andrea.start();
        
        pedro.start();
        
        jefe.start();
        
        
        try {
            
            pablo.join();
            
            luis.join();
            
            andrea.join();
            
            pedro.join();
            
            jefe.join();
            
        } catch (Exception e) {
            
            System.out.println(e);
            
        }
        
        
    }
    
}
