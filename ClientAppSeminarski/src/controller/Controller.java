/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import domain.*;
import communication.*;
import java.net.Socket;
import util.*;
import java.util.ArrayList;
import java.util.Properties;
import java.io.FileInputStream;
/**
 *
 * @author ennouser
 */
public class Controller {
    private static Controller instance;
    private Socket socket;
    private Sender sender;
    private Receiver receiver;
    
    
    private Controller() throws Exception {
        Properties prop = new Properties();
        prop.load(new FileInputStream(MyConstants.SERVER_FILE_NAME));
        int port = Integer.parseInt(prop.getProperty(MyConstants.SERVER_PORT));
        socket = new Socket("localhost", port);
        sender = new Sender(socket);
        receiver = new Receiver(socket);
    }
    
    public static Controller getInstance() throws Exception {
        if(instance == null)
            instance = new Controller();
        return instance;
    }
    
    
    public String prijaviPolicijskaUprava(PolicijskaUprava pu) throws Exception {
        Request r = new Request();
        r.setOperation(Operation.LOGIN);
        r.setData(pu);
        sender.send(r);
        
        Response res = (Response)receiver.receive();
        
        if(res.getStatus() == ResponseStatus.SUCCESS) {
            pu = (PolicijskaUprava)res.getData();
            return pu.getUsername();
        } else {
            throw new Exception(res.getErrormessage());
        }
    }
    
}
