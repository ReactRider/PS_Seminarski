package thread;

import communication.*;
import domain.*;
import controller.Controller;
import java.net.Socket;
import util.*;
import java.util.*;


public class ClientThread extends Thread {
    private Socket socket;
    private Sender sender;
    private Receiver receiver;
    
    public ClientThread(Socket socket) {
        this.socket = socket;
        sender = new Sender(socket);
        receiver = new Receiver(socket);
    }
    
    @Override 
    public void run() {
        Request request = null;
        Response response = null;
        
        while(!socket.isClosed()) {
            try {
                request = (Request)receiver.receive();
                switch(request.getOperation()) {
                    case LOGIN:
                        response = login(request);
                        break;
                }
            
                sender.send(response);
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public Socket getSocket(){
        return socket;
    }
    
    public Response login(Request request) {
        Response response = null;
        PolicijskaUprava pu = (PolicijskaUprava)request.getData();
        
        try {
            response = new Response();
            pu = Controller.getInstance().login(pu);
            response.setData(pu);
            response.setStatus(ResponseStatus.SUCCESS);
        } catch(Exception ex) {
            ex.printStackTrace();
            response.setErrormessage(ex.getLocalizedMessage());
        }
        return response;
    }
}
