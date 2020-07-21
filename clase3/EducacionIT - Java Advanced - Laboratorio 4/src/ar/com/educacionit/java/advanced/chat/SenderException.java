/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.com.educacionit.java.advanced.chat;

/**
 *
 * @author Instructor
 */
public class SenderException extends Exception {

    public SenderException(Throwable cause) {
        super(cause);
    }

    public SenderException(String message, Throwable cause) {
        super(message, cause);
    }

    public SenderException(String message) {
        super(message);
    }

    public SenderException() {
    }

    

}
