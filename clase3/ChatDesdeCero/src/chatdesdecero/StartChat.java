
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
        
        
        MessageListener listener = new MessageListener(gui, 5000);
        Thread t = new Thread(listener);
        t.start();
              
        FileListener fileListener =  new FileListener(gui, 5001);
        
      gui.setVisible(true);
    }
    
}


