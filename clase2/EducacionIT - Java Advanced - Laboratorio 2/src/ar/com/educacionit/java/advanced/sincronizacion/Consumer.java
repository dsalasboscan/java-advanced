/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.com.educacionit.java.advanced.sincronizacion;

/**
 *
 * @author Instructor
 */
public class Consumer implements Runnable {
    private Q q;

    public  Consumer(Q q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }
    
    public void run() {
        while(true) {
            q.get();
        }
    }
}
