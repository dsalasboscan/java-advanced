/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.com.educacionit.java.advanced.chat;

import java.net.InetAddress;
import javax.swing.DefaultListModel;

/**
 *
 * @author Instructor
 */
public class ContactsHandler implements Runnable{

    private DefaultListModel modeloContactos;
    private InetAddress contactAddres;

    public ContactsHandler(DefaultListModel modeloContactos, InetAddress contactAddres) {
        this.modeloContactos = modeloContactos;
        this.contactAddres = contactAddres;
    }

    
    public void run() {
        Contact contacto = new Contact();
        contacto.setInetAddres(contactAddres);
        contacto.setPort(5000);
        if (!modeloContactos.contains(contacto))
            modeloContactos.addElement(contacto);
    }



}
