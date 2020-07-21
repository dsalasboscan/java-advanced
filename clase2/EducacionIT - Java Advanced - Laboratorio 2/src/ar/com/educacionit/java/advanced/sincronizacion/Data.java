/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/

package ar.com.educacionit.java.advanced.sincronizacion;

/**
 *
 * @author Instructor
 */
public class Data {
    Integer number;
    boolean transfer = true;
    
    public Data() {
        this.number = new Integer(0);
    }
    
    public synchronized int get(String threadName) {
        while(transfer) {
            try {
                wait(5000);
            } catch(InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }
        System.out.println("Got: " + number + " From: " + threadName);
        transfer = true;
        notifyAll();
        return number;
        
    }
    
    public synchronized void put(String threadName) {
        while(!transfer) {
            try {
                wait();
            } catch(InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }
        this.number += 1;
        transfer = false;
        System.out.println("Put: " + this.number + " From: " + threadName);
        notifyAll();
    }
}
