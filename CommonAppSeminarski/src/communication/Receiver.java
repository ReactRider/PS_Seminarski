/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;

import java.net.Socket;
import java.io.*;

/**
 *
 * @author ennouser
 */
public class Receiver {
    private final Socket socket;
    
    public Receiver(Socket socket) {
        this.socket = socket;
    }
    
    public Object receive() throws Exception {
        try {
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            return in.readObject();
        } catch(IOException ex) {
            ex.printStackTrace();
            throw new Exception("greska kod slanja objekta\n" + ex.getMessage());
        }
    }
    
}
