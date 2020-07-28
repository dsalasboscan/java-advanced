/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatdesdecero;

import java.net.Inet4Address;
import java.util.Objects;

/**
 *
 * @author diego
 */
class Contact {
    
    private Inet4Address inetAddress;
    private int port;

    public Inet4Address getInetAddress() {
        return inetAddress;
    }

    public void setInetAddress(Inet4Address inetAddress) {
        this.inetAddress = inetAddress;
    }
    

  
  public String toString() {
        return inetAddress.toString() + ":" + port;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contact other = (Contact) obj;
        if (this.port != other.port) {
            return false;
        }
        if (!Objects.equals(this.inetAddress, other.inetAddress)) {
            return false;
        }
        return true;
    }
   
    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
    
}
