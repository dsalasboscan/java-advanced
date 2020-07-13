/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.com.educacionit.java.advanced.sincronizacion;

/**
 *
 * @author Instructor
 */
public class Producer implements Runnable {
    private Data data;
    private String name;
    public Producer(Data data, String name) {
        this.data = data;
        this.name = name;
        new Thread(this, "Producer-" + name).start();
    }
    public void run() {
        while(true) {
            data.put(this.name);
        }
    }
}
