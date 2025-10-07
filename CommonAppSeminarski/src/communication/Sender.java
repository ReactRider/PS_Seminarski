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
public class Sender {
    private final Socket socket;
    
    public Sender(Socket socket) {
        this.socket = socket;
    }
    
    public void send(Object o) throws Exception {
        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(o);
            out.flush();
        } catch(IOException ex) {
            throw new Exception("Greska kod slanja objekta\n" + ex.getMessage());
        }
    }
}
