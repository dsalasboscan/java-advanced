/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.com.educacionit.java.advanced.chat;

/**
 *
 * @author Instructor
 */
public class StartChat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        ChatGUI gui= new ChatGUI();
        MessageListener listener = new MessageListener(gui,5000);
        Thread t = new Thread(listener);
        t.start();

        FileListener fileListener = new FileListener(gui,5001);
        Thread t4 = new Thread(fileListener);
        t4.start();

        Thread t2 = new Thread(new ContactsBroadcast());
        t2.start();

        Thread t3= new Thread(new ContactsListeners(gui.getModeloContactos()));
        t3.start();



        gui.setVisible(true);
    }

}
