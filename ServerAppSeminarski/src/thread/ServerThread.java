/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;
import util.MyConstants;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author ennouser
 */
public class ServerThread extends Thread {
    private ServerSocket serverSocket;
    private List<ClientThread> clients;
    
    public ServerThread() throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream(MyConstants.SERVER_FILE_NAME));
        int port = Integer.parseInt(prop.getProperty(MyConstants.SERVER_PORT));
        serverSocket = new ServerSocket(port);
        clients = new ArrayList<>();
        
    }
    
    @Override
    public void run() {
        while(!serverSocket.isClosed()) {
            System.out.println("Cekam klijente..");
            
            try {
                Socket socket = serverSocket.accept();
                ClientThread client = new ClientThread(socket);
                client.start();
                clients.add(client);
                System.out.println("Klijent se povezao!");
            } catch(IOException ex) {
                ex.printStackTrace();
            }
        }
        stopClients();
    }
    
    private void stopClients() {
        for(ClientThread client: clients) {
            try {
                client.getSocket().close();
            } catch(IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void stopServerThread() throws IOException {
        serverSocket.close();
    }
    
    public ServerSocket getServerSocket() {
        return serverSocket;
    }
}
    