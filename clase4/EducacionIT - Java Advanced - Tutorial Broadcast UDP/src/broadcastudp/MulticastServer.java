/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package broadcastudp;

import java.io.IOException;

/**
 *
 * @author yaphru
 */
public class MulticastServer {

    public static void main(String[] args) throws IOException {

        new MulticastServerThread().start();

    }

}
