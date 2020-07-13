/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.com.educacionit.java.advanced.sincronizacion;

/**
 *
 * @author Instructor
 */
public class PC {
    public static void main(String args[]) {
        Data data = new Data();
        new Producer(data, "P1");
        new Producer(data, "P2");
        new Producer(data, "P3");
        
        new Consumer(data, "C1");
        new Consumer(data, "C2");
    }
}