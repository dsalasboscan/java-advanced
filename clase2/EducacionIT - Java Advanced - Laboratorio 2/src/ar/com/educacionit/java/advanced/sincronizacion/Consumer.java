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
    private Data data;
    private String name;

    public  Consumer(Data data, String threadName) {
        this.data = data;
        this.name = threadName;
        new Thread(this, "Consumer-" + threadName).start();
    }
    
    public void run() {
        while(true) {
            data.get(name);
        }
    }
}
