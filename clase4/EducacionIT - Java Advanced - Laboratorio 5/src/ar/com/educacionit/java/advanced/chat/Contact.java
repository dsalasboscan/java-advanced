/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.com.educacionit.java.advanced.chat;

import java.net.InetAddress;

/**
 *
 * @author Instructor
 */
public class Contact {

    private InetAddress inetAddres;
    private int port;

    public InetAddress getInetAddres() {
        return inetAddres;
    }

    public void setInetAddres(InetAddress inetAddres) {
        this.inetAddres = inetAddres;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return inetAddres.toString()+":"+port;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contact other = (Contact) obj;
        if (this.inetAddres != other.inetAddres && (this.inetAddres == null || !this.inetAddres.equals(other.inetAddres))) {
            return false;
        }
        if (this.port != other.port) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + (this.inetAddres != null ? this.inetAddres.hashCode() : 0);
        hash = 71 * hash + this.port;
        return hash;
    }

    
    

}
