/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatdesdecero;

import java.net.InetAddress;
import javax.swing.DefaultListModel;

/**
 *
 * @author david.salas
 */
public class ContactsHandler implements Runnable {
    private DefaultListModel<Contact> modeloContactos;
    private InetAddress inetAddress;
    private int port;
    private int ownPort;

    public ContactsHandler(DefaultListModel<Contact> modeloContactos, InetAddress inetAddress, int port, int ownPort) {
        this.modeloContactos = modeloContactos;
        this.inetAddress = inetAddress;
        this.port = port;
        this.ownPort = ownPort;
    }

    @Override
    public void run() {
        Contact contact = new Contact();
        contact.setInetAddress(inetAddress);
        contact.setPort(port);
        
        if (ownPort == port)
            return;
        
        if (!modeloContactos.contains(contact))
            modeloContactos.addElement(contact);
    }
}
