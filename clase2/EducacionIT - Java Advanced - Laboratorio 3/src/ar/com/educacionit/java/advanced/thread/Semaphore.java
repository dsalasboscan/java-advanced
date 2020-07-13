/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.com.educacionit.java.advanced.thread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yaphru
 */
public class Semaphore {

    public  synchronized void suspend() {
        try {
            wait();
        } catch (InterruptedException ex) {
            Logger.getLogger(Semaphore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public  synchronized void resume() {
        notify();
    }

}
