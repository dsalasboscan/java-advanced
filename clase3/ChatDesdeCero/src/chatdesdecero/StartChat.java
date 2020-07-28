
package chatdesdecero;

/**
 *
 * @author diego
 */
public class StartChat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        ChatGUI gui= new ChatGUI();
        int messagePort = 5000;
        int filePort = messagePort + 1;
        gui.setTitle("message Port: " + messagePort + " File Port: " + filePort);
        gui.setVisible(true);
        
        
        
        MessageListener listener = new MessageListener(gui, messagePort);
        Thread t = new Thread(listener);
        t.start();
        
        FileListener fileListener= new FileListener(gui, filePort);
        Thread t2 = new Thread(fileListener);
        t2.start();      
        
     
    }
    
}


