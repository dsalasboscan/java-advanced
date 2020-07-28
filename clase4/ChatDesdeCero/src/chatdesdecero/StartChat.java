/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatdesdecero;

/**
 *
 * @author david.salas
 */
public class StartChat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ChatGUI gui =  new ChatGUI();
        
        int messagePort = 5004; // Incrementar de a 2 (5000, 5002, 5004)
        int filePort = messagePort + 1;
        
        gui.setTitle("message port: " + messagePort + " filePort: " + filePort);
        
        MessageListener listener = new MessageListener(gui, messagePort);
        Thread t1 = new Thread(listener);
        t1.start();
        
        FileListener fileListener = new FileListener(gui, filePort);
        Thread t2 = new Thread(fileListener);
        t2.start();
        
        ContactsBroadcast contactsBroadcast = new ContactsBroadcast(messagePort);
        Thread t3 = new Thread(contactsBroadcast);
        t3.start();
        
        ContactsListener contactsListener = new ContactsListener(gui.getModeloContactos());
        Thread t4 = new Thread(contactsListener);
        t4.start();
        
        gui.setVisible(true);
    }
    
}
