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
    
    
    public boolean promeniVozilo(Vozilo v) throws Exception{
        Request r=new Request();
        r.setOperation(Operation.UPDATE_VOZILO);
        r.setData(v);
        sender.send(r);
        
        Response res=(Response)receiver.receive();
        
        if(res.getStatus()==ResponseStatus.SUCCESS){
            return true;
        }else{
            return false;
        }
    } 
            
    
    public ArrayList<Vlasnik> vratiListuSviVlasnik() throws Exception{
        Request r=new Request();
        r.setOperation(Operation.GET_ALL_VLASNIK);
        r.setData(null);
        sender.send(r);
        
        Response res=(Response)receiver.receive();
        
        if(res.getStatus()==ResponseStatus.SUCCESS){
            return (ArrayList<Vlasnik>)res.getData();
        }else{
            throw new Exception(res.getErrormessage());
        }
    }
    
    
    public Vozilo pretraziVozilo(Vozilo v) throws Exception{
        Request r=new Request();
        r.setOperation(Operation.FIND_VOZILO);
        r.setData(v);
        sender.send(r);
        
        Response res=(Response)receiver.receive();
        
        if(res.getStatus()==ResponseStatus.SUCCESS){
            return (Vozilo)res.getData();
        }else{
            throw new Exception(res.getErrormessage());
        }
    }
    
    
    public long kreirajVozilo(Vozilo v) throws Exception{
        Request r=new Request();
        r.setOperation(Operation.ADD_VOZILO);
        r.setData(v);
        sender.send(r);
        
        Response res=(Response)receiver.receive();
        
        if(res.getStatus()==ResponseStatus.SUCCESS){
            return (long)res.getData();
        }else{
            throw new Exception(res.getErrormessage());
        }
    }
    
    public Kazna pretraziKazna(Kazna k) throws Exception{
        Request r=new Request();
        r.setOperation(Operation.FIND_KAZNA);
        r.setData(k);
        sender.send(r);
        
        Response res=(Response)receiver.receive();
        
        if(res.getStatus()==ResponseStatus.SUCCESS){
            return (Kazna)res.getData();
        }else{
            throw new Exception(res.getErrormessage());
        }
    }
    
    
    public boolean promeniKazna(Kazna k) throws Exception{
        Request r=new Request();
        r.setOperation(Operation.UPDATE_KAZNA);
        r.setData(k);
        sender.send(r);
        
        Response res=(Response)receiver.receive();
        
        if(res.getStatus()==ResponseStatus.SUCCESS){
            return (boolean)res.getData();
        }else{
            throw new Exception(res.getErrormessage());
        }
    }
    
    public long kreirajKazna(Kazna k) throws Exception{
        Request r=new Request();
        r.setOperation(Operation.ADD_KAZNA);
        r.setData(k);
        sender.send(r);
        
        Response res=(Response)receiver.receive();
        
        if(res.getStatus()==ResponseStatus.SUCCESS){
            return (long)res.getData();
        }else{
            throw new Exception(res.getErrormessage());
        }
    }
    
    
    public boolean promeniPolicijskaUprava(PolicijskaUprava pu) throws Exception{
        Request r=new Request();
        r.setOperation(Operation.UPDATE_PU);
        r.setData(pu);
        sender.send(r);
        
        Response res=(Response)receiver.receive();
        
        if(res.getStatus()==ResponseStatus.SUCCESS){
            return (boolean)res.getData();
        }else{
            throw new Exception(res.getErrormessage());
        }
    }
    
    public long kreirajPolicijskaUprava(PolicijskaUprava pu) throws Exception{
        Request r=new Request();
        r.setOperation(Operation.ADD_PU);
        r.setData(pu);
        sender.send(r);
        
        Response res=(Response)receiver.receive();
        
        if(res.getStatus()==ResponseStatus.SUCCESS){
            return (long)res.getData();
        }else{
            throw new Exception(res.getErrormessage());
        }
    }
    
    public boolean promeniVlasnik(Vlasnik v) throws Exception{
        Request r=new Request();
        r.setOperation(Operation.UPDATE_VLASNIK);
        r.setData(v);
        sender.send(r);
        
        Response res=(Response)receiver.receive();
        
        if(res.getStatus()==ResponseStatus.SUCCESS){
            return (boolean)res.getData();
        }else{
            throw new Exception(res.getErrormessage());
        }
    }
    
    public Vlasnik pretraziVlasnik(Vlasnik v) throws Exception{
        Request r=new Request();
        r.setOperation(Operation.FIND_VLASNIK);
        r.setData(v);
        sender.send(r);
        
        Response res=(Response)receiver.receive();
        
        if(res.getStatus()==ResponseStatus.SUCCESS){
            return (Vlasnik)res.getData();
        }else{
            throw new Exception(res.getErrormessage());
        }
    }
    
    
      public long kreirajVlasnik(Vlasnik v) throws Exception{
        Request r=new Request();
        r.setOperation(Operation.ADD_VLASNIK);
        r.setData(v);
        sender.send(r);
        
        Response res=(Response)receiver.receive();
        
        if(res.getStatus()==ResponseStatus.SUCCESS){
            return (long)res.getData();
        }else{
            throw new Exception(res.getErrormessage());
        }
    }
    
    public boolean obrisiKazna(Kazna k) throws Exception{
        Request r=new Request();
        r.setOperation(Operation.DELETE_KAZNA);
        r.setData(k);
        sender.send(r);
        
        Response res=(Response)receiver.receive();
        
        if(res.getStatus()==ResponseStatus.SUCCESS){
            return (boolean)res.getData();
        }else{
            throw new Exception(res.getErrormessage());
        }
    }
    
    
    public boolean obrisiPolicijskaUprava(PolicijskaUprava pu) throws Exception{
        Request r=new Request();
        r.setOperation(Operation.DELETE_PU);
        r.setData(pu);
        sender.send(r);
        
        Response res=(Response)receiver.receive();
        
        if(res.getStatus()==ResponseStatus.SUCCESS){
            return (boolean)res.getData();
        }else{
            throw new Exception(res.getErrormessage());
        }
    }
    
    
    public boolean obrisiRaskrsnica(Raskrsnica ras) throws Exception{
        Request r=new Request();
        r.setOperation(Operation.DELETE_RASKRSNICA);
        r.setData(ras);
        sender.send(r);
        
        Response res=(Response)receiver.receive();
        
        if(res.getStatus()==ResponseStatus.SUCCESS){
            return (boolean)res.getData();
        }else{
            throw new Exception(res.getErrormessage());
        }
    }
    
    public boolean obrisiVlasnik(Vlasnik v) throws Exception{
        Request r=new Request();
        r.setOperation(Operation.DELETE_VLADNIK);
        r.setData(v);
        sender.send(r);
        
        Response res=(Response)receiver.receive();
        
        if(res.getStatus()==ResponseStatus.SUCCESS){
            return (boolean)res.getData();
        }else{
            throw new Exception(res.getErrormessage());
        }
    }
    
    public boolean obrisiVozilo(Vozilo v) throws Exception{
        Request r=new Request();
        r.setOperation(Operation.DELETE_VOZILO);
        r.setData(v);
        sender.send(r);
        
        Response res=(Response)receiver.receive();
        
        if(res.getStatus()==ResponseStatus.SUCCESS){
            return (boolean)res.getData();
        }else{
            throw new Exception(res.getErrormessage());
        }
    }
    
    public PolicijskaUprava pretraziPolicijskaUprava(PolicijskaUprava pu) throws Exception{
        Request r=new Request();
        r.setOperation(Operation.FIND_PU);
        r.setData(pu);
        sender.send(r);
        
        Response res=(Response)receiver.receive();
        
        if(res.getStatus()==ResponseStatus.SUCCESS){
            return (PolicijskaUprava)res.getData();
        }else{
            throw new Exception(res.getErrormessage());
        }
    }
    
    public Raskrsnica pretraziRaskrsnica(Raskrsnica raskrsnica) throws Exception{
        Request r=new Request();
        r.setOperation(Operation.FIND_RASKRSNICA);
        r.setData(raskrsnica);
        sender.send(r);
        
        Response res=(Response)receiver.receive();
        
        if(res.getStatus()==ResponseStatus.SUCCESS){
            return (Raskrsnica)res.getData();
        }else{
            throw new Exception(res.getErrormessage());
        }
    }
    
    public long ubaciRaskrsnica(Raskrsnica raskrsnica) throws Exception{
        Request r=new Request();
        r.setOperation(Operation.ADD_RASKRSNICA);
        r.setData(raskrsnica);
        sender.send(r);
        
        Response res=(Response)receiver.receive();
        
        if(res.getStatus()==ResponseStatus.SUCCESS){
            return (long)res.getData();
        }else{
            throw new Exception(res.getErrormessage());
        }
    }
    
    
    public boolean promeniRaskrsnica(Raskrsnica ras) throws Exception{
        Request r=new Request();
        r.setOperation(Operation.UPDATE_RASKRSNICA);
        r.setData(ras);
        sender.send(r);
        
        Response res=(Response)receiver.receive();
        
        if(res.getStatus()==ResponseStatus.SUCCESS){
            return (boolean)res.getData();
        }else{
            throw new Exception(res.getErrormessage());
        }
    }
    
    public ArrayList<Kazna> vratiListuSviKazna() throws Exception{
        Request r=new Request();
        r.setOperation(Operation.GET_ALL_KAZNA);
        r.setData(null);
        sender.send(r);
        
        Response res=(Response)receiver.receive();
        
        if(res.getStatus()==ResponseStatus.SUCCESS){
            return (ArrayList<Kazna>)res.getData();
        }else{
            throw new Exception(res.getErrormessage());
        }
    }
    
    
    public ArrayList<Kazna> vratiListuKazna(Kazna k) throws Exception{
        Request r=new Request();
        r.setOperation(Operation.FIND_LIST_KAZNA);
        r.setData(k);
        sender.send(r);
        
        Response res=(Response)receiver.receive();
        
        if(res.getStatus()==ResponseStatus.SUCCESS){
            return (ArrayList<Kazna>)res.getData();
        }else{
            throw new Exception(res.getErrormessage());
        }
    }
    
    public ArrayList<Vozilo> vratiListuSviVozilo() throws Exception{
        Request r=new Request();
        r.setOperation(Operation.GET_ALL_VOZILO);
        r.setData(null);
        sender.send(r);
        
        Response res=(Response)receiver.receive();
        
        if(res.getStatus()==ResponseStatus.SUCCESS){
            return (ArrayList<Vozilo>)res.getData();
        }else{
            throw new Exception(res.getErrormessage());
        }
    }
    
    public ArrayList<Vozilo> vratiListuVozilo(Vozilo v) throws Exception{
        Request r=new Request();
        r.setOperation(Operation.FIND_LIST_VOZILO);
        r.setData(v);
        sender.send(r);
        
        Response res=(Response)receiver.receive();
        
        if(res.getStatus()==ResponseStatus.SUCCESS){
            return (ArrayList<Vozilo>)res.getData();
        }else{
            throw new Exception(res.getErrormessage());
        }
    }
    
    public ArrayList<Vozilo> vratiListuVozilo(Vlasnik v) throws Exception{
        Request r=new Request();
        r.setOperation(Operation.FIND_LIST_VOZILO_VLASNIK);
        r.setData(v);
        sender.send(r);
        
        Response res=(Response)receiver.receive();
        
        if(res.getStatus()==ResponseStatus.SUCCESS){
            return (ArrayList<Vozilo>)res.getData();
        }else{
            throw new Exception(res.getErrormessage());
        }
    }
    
    public ArrayList<Vlasnik> vratiListuVlasnik(Vlasnik v) throws Exception{
        Request r=new Request();
        r.setOperation(Operation.FIND_LIST_VLASNIK);
        r.setData(v);
        sender.send(r);
        
        Response res=(Response)receiver.receive();
        
        if(res.getStatus()==ResponseStatus.SUCCESS){
            return (ArrayList<Vlasnik>)res.getData();
        }else{
            throw new Exception(res.getErrormessage());
        }
    }
    
    public ArrayList<Raskrsnica> vratiListuRaskrsnica(Raskrsnica ras) throws Exception{
        Request r=new Request();
        r.setOperation(Operation.FIND_LIST_RASKRSNICA);
        r.setData(ras);
        sender.send(r);
        
        Response res=(Response)receiver.receive();
        
        if(res.getStatus()==ResponseStatus.SUCCESS){
            return (ArrayList<Raskrsnica>)res.getData();
        }else{
            throw new Exception(res.getErrormessage());
        }
    }
    
    public ArrayList<Raskrsnica> vratiListuSviRaskrsnica() throws Exception {
        Request r = new Request();
        r.setOperation(Operation.GET_ALL_RASKRSNICA);
        r.setData(null);
        sender.send(r);
        
        Response res=(Response)receiver.receive();
        
        if(res.getStatus()==ResponseStatus.SUCCESS){
            return (ArrayList<Raskrsnica>)res.getData();
        }else{
            throw new Exception(res.getErrormessage());
        }
    }
    
    public ArrayList<PolicijskaUprava> vratiListuPolicijskaUprava(PolicijskaUprava pu) throws Exception{
        Request r=new Request();
        r.setOperation(Operation.FIND_LIST_PU);
        r.setData(pu);
        sender.send(r);
        
        Response res=(Response)receiver.receive();
        
        if(res.getStatus()==ResponseStatus.SUCCESS){
            return (ArrayList<PolicijskaUprava>)res.getData();
        }else{
            throw new Exception(res.getErrormessage());
        }
    }
    
    public ArrayList<PolicijskaUprava> vratiListuPolicijskaUprava(Raskrsnica ras) throws Exception{
        Request r=new Request();
        r.setOperation(Operation.FIND_LIST_PU_RASK);
        r.setData(ras);
        sender.send(r);
        
        Response res=(Response)receiver.receive();
        
        if(res.getStatus()==ResponseStatus.SUCCESS){
            return (ArrayList<PolicijskaUprava>)res.getData();
        }else{
            throw new Exception(res.getErrormessage());
        }
    }
    
    
    public ArrayList<PolicijskaUprava> vratiListuSviPolicijskaUprava() throws Exception{
        Request r=new Request();
        r.setOperation(Operation.GET_ALL_PU);
        r.setData(null);
        sender.send(r);
        
        Response res=(Response)receiver.receive();
        
        if(res.getStatus()==ResponseStatus.SUCCESS){
            return (ArrayList<PolicijskaUprava>)res.getData();
        }else{
            throw new Exception(res.getErrormessage());
        }
    }
    
    
     public long kreirajEvidencijaKazni(EvidencijaKazni e) throws Exception{
        Request r=new Request();
        r.setOperation(Operation.ADD_EVIDENCIJA);
        r.setData(e);
        sender.send(r);
        
        Response res=(Response)receiver.receive();
        
        if(res.getStatus()==ResponseStatus.SUCCESS){
            return (long)res.getData();
        }else{
            throw new Exception(res.getErrormessage());
        }
    }
    
    
    
}
