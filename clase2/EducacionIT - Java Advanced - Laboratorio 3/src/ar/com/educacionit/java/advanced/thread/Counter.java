/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.com.educacionit.java.advanced.thread;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author Instructor
 */
public class Counter extends Thread {
    private Integer i=0;
    private JTextField tf;
    private boolean sleep;
    private int sleepTime;
    private Semaphore semaphore;
    private boolean paused;

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public void setSemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }


    

    public Integer getI() {
        return i;
    }



    public int getSleepTime() {
        return sleepTime;
    }

    public void setSleepTime(int sleepTime) {
        this.sleepTime = sleepTime;
    }

    

    

    public Counter(JTextField tf) {
        this.tf = tf;
        semaphore = new Semaphore();
    }

    
    public JTextField getTf() {
        return tf;
    }

    public void setTf(JTextField tf) {
        this.tf = tf;
    }
    
    public void run() {
        while (true) {
            try {
                if (paused) {
                    semaphore.suspend();
                }
                i++;
                print();
                if (sleep) {
                    sleep(sleepTime);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Counter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void print() {
        if (tf!=null) tf.setText(i.toString());
        else System.out.println(i.toString());
    }

    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    public boolean isSleep() {
        return sleep;
    }

    public void setSleep(boolean sleep) {
        this.sleep = sleep;
    }

    public void suspender() {
        setPaused(true);
    }

    public void reanudad() {
        setPaused(false);
        semaphore.resume();
    }


}
