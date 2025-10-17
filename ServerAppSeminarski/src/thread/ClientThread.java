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
                    case GET_ALL_KAZNA:
                        response = getAllKazna(request);
                        break;
                    case FIND_KAZNA:
                        response = findKazna(request);
                        break;
                    case ADD_KAZNA:
                        response = addKazna(request);
                        break;
                    case UPDATE_KAZNA:
                        response = updateKazna(request);
                        break;
                    case DELETE_KAZNA:
                        response = deleteKazna(request);
                        break;
                    case GET_ALL_VOZILO:
                        response = getAllVozilo(request);
                        break;
                    case ADD_VOZILO:
                        response = addVozilo(request);
                        break;
                    case UPDATE_VOZILO:
                        response = updateVozilo(request);
                        break;
                    case DELETE_VOZILO:
                        response = deleteVozilo(request);
                        break;
                    case GET_ALL_VLASNIK:
                        response = getAllVlasnik(request);
                        break;
                    case ADD_VLASNIK:
                        response = addVlasnik(request);
                        break;
                    case UPDATE_VLASNIK:
                        response = updateVlasnik(request);
                        break;
                    case FIND_VLASNIK:
                        response = findVlasnik(request);
                        break;
                    case DELETE_VLADNIK:
                        response = deleteVlasnik(request);
                        break;
                    case GET_ALL_RASKRSNICA:
                        response =  getAllRaskrsnica(request);
                        break;
                    case ADD_RASKRSNICA:
                        response = addRaskrsnica(request);
                        break;
                    case DELETE_RASKRSNICA:
                        response = deleteRaskrsnica(request);
                        break;
                    case UPDATE_RASKRSNICA:
                        response = updateRaskrsnica(request);
                        break;
                    case FIND_RASKRSNICA:
                        response = findRaskrsnica(request);
                        break;
                    case ADD_PU:
                        response = addPolicijskaUprava(request);
                        break;
                    case DELETE_PU:
                        response = deletePolicijskaUprava(request);
                        break;
                    case UPDATE_PU:
                        response = updatePolicijskaPurava(request);
                        break;
                    case FIND_PU:
                        response = findPolicijskaUprava(request);
                        break;
                    case ADD_EVIDENCIJA:
                        response = addEvidencijaKazni(request);
                        break;
                    case FIND_LIST_KAZNA:
                        response = findListKazna(request);
                        break;
                    case FIND_LIST_VOZILO:
                        response = findListuVozilo(request);
                        break;
                    case FIND_LIST_VOZILO_VLASNIK:
                        response = findListuVoziloVlasnik(request);
                        break;
                    case FIND_LIST_VLASNIK:
                        response = findListVlasnik(request);
                        break;
                    case FIND_LIST_RASKRSNICA:
                        response = findListRaskrsnica(request);
                        break;
                    case FIND_LIST_PU:
                        response = findListPolicijskaUprava(request);
                        break;
                    case FIND_LIST_PU_RASK:
                        response = findListPolicijskaUpravaRaskrsnica(request);
                        break;
                    case GET_ALL_PU:
                        response = getAllPolicijskaUprava(request);
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
    
     public Response addPolicijskaUprava(Request request){
        Response response = null;
        PolicijskaUprava pu=(PolicijskaUprava)request.getData();
        try {
            response = new Response();
            long id = Controller.getInstance().kreirajPolicijskaUprava(pu);
            response.setData(id);
            response.setStatus(ResponseStatus.SUCCESS);
        } catch(Exception ex) {
            ex.printStackTrace();
            response.setErrormessage(ex.getLocalizedMessage());
        }
        return response;
    }
     
     public Response deletePolicijskaUprava(Request request){
        Response response = null;
        PolicijskaUprava pu=(PolicijskaUprava)request.getData();
        try {
            response = new Response();
            boolean b = Controller.getInstance().obrisiPolicijskaUprava(pu);
            response.setData(b);
            response.setStatus(ResponseStatus.SUCCESS);
        } catch(Exception ex) {
            ex.printStackTrace();
            response.setErrormessage(ex.getLocalizedMessage());
        }
        return response;
    }
     
     public Response updatePolicijskaPurava(Request request){
        Response response = null;
        PolicijskaUprava pu=(PolicijskaUprava)request.getData();
        try {
            response = new Response();
            boolean b = Controller.getInstance().promeniPolicijskaUprava(pu);
            response.setData(b);
            response.setStatus(ResponseStatus.SUCCESS);
        } catch(Exception ex) {
            ex.printStackTrace();
            response.setErrormessage(ex.getLocalizedMessage());
        }
        return response;
    }
     
      public Response findPolicijskaUprava(Request request){
        Response response = null;
        PolicijskaUprava pu=(PolicijskaUprava)request.getData();
        try {
            response = new Response();
            pu = Controller.getInstance().pretraziPolicijskaUprava(pu);
            response.setData(pu);
            response.setStatus(ResponseStatus.SUCCESS);
        } catch(Exception ex) {
            ex.printStackTrace();
            response.setErrormessage(ex.getLocalizedMessage());
        }
        return response;
    }
      
       public Response findListPolicijskaUprava(Request request){
        Response response = null;
        PolicijskaUprava pu=(PolicijskaUprava)request.getData();
        try {
            response = new Response();
            List<PolicijskaUprava> lista = Controller.getInstance().vratiListuPolicijskaUprava(pu);
            response.setData(lista);
            response.setStatus(ResponseStatus.SUCCESS);
        } catch(Exception ex) {
            ex.printStackTrace();
            response.setErrormessage(ex.getLocalizedMessage());
        }
        return response;
    }
       
         public Response findListPolicijskaUpravaRaskrsnica(Request request){
        Response response = null;
        Raskrsnica r=(Raskrsnica)request.getData();
        try {
            response = new Response();
            List<PolicijskaUprava> lista = Controller.getInstance().vratiListuPolicijskaUprava(r);
            response.setData(lista);
            response.setStatus(ResponseStatus.SUCCESS);
        } catch(Exception ex) {
            ex.printStackTrace();
            response.setErrormessage(ex.getLocalizedMessage());
        }
        return response;
    }
         
    public Response getAllPolicijskaUprava(Request request){
        Response response = null;
        try {
            response = new Response();
            List<PolicijskaUprava> lista = Controller.getInstance().vratiListuSviPolicijskaUprava();
            response.setData(lista);
            response.setStatus(ResponseStatus.SUCCESS);
        } catch(Exception ex) {
            ex.printStackTrace();
            response.setErrormessage(ex.getLocalizedMessage());
        }
        return response;
    }
         
         
        
    
    //////////////////////////////////////////////////////////////////////////////////////////
    
    
    public Response getAllKazna(Request request){
        Response response = null;
        List<Kazna> kazne=new ArrayList<>();
        try {
            response = new Response();
            kazne = Controller.getInstance().vratiListuSviKazna();
            response.setData(kazne);
            response.setStatus(ResponseStatus.SUCCESS);
        } catch(Exception ex) {
            ex.printStackTrace();
            response.setErrormessage(ex.getLocalizedMessage());
        }
        return response;
    }
    
    
    public Response findKazna(Request request){
        Response response = null;
        Kazna kazna=(Kazna)request.getData();
        try {
            response = new Response();
            kazna = Controller.getInstance().pretraziKazna(kazna);
            response.setData(kazna);
            response.setStatus(ResponseStatus.SUCCESS);
        } catch(Exception ex) {
            ex.printStackTrace();
            response.setErrormessage(ex.getLocalizedMessage());
        }
        return response;
    }
    
    public Response findListKazna(Request request){
        Response response = null;
        Kazna kazna=(Kazna)request.getData();
        try {
            response = new Response();
            List<Kazna> kazne = Controller.getInstance().vratiListuKazna(kazna);
            response.setData(kazne);
            response.setStatus(ResponseStatus.SUCCESS);
        } catch(Exception ex) {
            ex.printStackTrace();
            response.setErrormessage(ex.getLocalizedMessage());
        }
        return response;
    }
    
    
    public Response addKazna(Request request){
        Response response = null;
        Kazna kazna=(Kazna)request.getData();
        try {
            response = new Response();
            long id = Controller.getInstance().kreirajKazna(kazna);
            response.setData(id);
            response.setStatus(ResponseStatus.SUCCESS);
        } catch(Exception ex) {
            ex.printStackTrace();
            response.setErrormessage(ex.getLocalizedMessage());
        }
        return response;
    }
    
    
    public Response updateKazna(Request request){
        Response response = null;
        Kazna kazna=(Kazna)request.getData();
        try {
            response = new Response();
            boolean b = Controller.getInstance().promeniKazna(kazna);
            response.setData(b);
            response.setStatus(ResponseStatus.SUCCESS);
        } catch(Exception ex) {
            ex.printStackTrace();
            response.setErrormessage(ex.getLocalizedMessage());
        }
        return response;
    }
    
    
    public Response deleteKazna(Request request){
        Response response = null;
        Kazna kazna=(Kazna)request.getData();
        try {
            response = new Response();
            boolean b = Controller.getInstance().obrisiKazna(kazna);
            response.setData(b);
            response.setStatus(ResponseStatus.SUCCESS);
        } catch(Exception ex) {
            ex.printStackTrace();
            response.setErrormessage(ex.getLocalizedMessage());
        }
        return response;
    }
    
    
    ////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    public Response getAllVozilo(Request request){
        Response response = null;
        try {
            response = new Response();
            List<Vozilo> vozila = Controller.getInstance().vratiListuSviVozilo();
            response.setData(vozila);
            response.setStatus(ResponseStatus.SUCCESS);
        } catch(Exception ex) {
            ex.printStackTrace();
            response.setErrormessage(ex.getLocalizedMessage());
        }
        return response;
    }
    
     public Response addVozilo(Request request){
        Response response = null;
        Vozilo v=(Vozilo)request.getData();
        try {
            response = new Response();
            long id = Controller.getInstance().kreirajVozilo(v);
            response.setData(id);
            response.setStatus(ResponseStatus.SUCCESS);
        } catch(Exception ex) {
            ex.printStackTrace();
            response.setErrormessage(ex.getLocalizedMessage());
        }
        return response;
    }
     
     
     public Response updateVozilo(Request request){
        Response response = null;
        Vozilo v=(Vozilo)request.getData();
        try {
            response = new Response();
            boolean b = Controller.getInstance().promeniVozilo(v);
            response.setData(b);
            response.setStatus(ResponseStatus.SUCCESS);
        } catch(Exception ex) {
            ex.printStackTrace();
            response.setErrormessage(ex.getLocalizedMessage());
        }
        return response;
    }
    
     
     public Response deleteVozilo(Request request){
        Response response = null;
        Vozilo v=(Vozilo)request.getData();
        try {
            response = new Response();
            boolean b = Controller.getInstance().obrisiVozilo(v);
            response.setData(b);
            response.setStatus(ResponseStatus.SUCCESS);
        } catch(Exception ex) {
            ex.printStackTrace();
            response.setErrormessage(ex.getLocalizedMessage());
        }
        return response;
    }
     
      public Response findVozilo (Request request){
        Response response = null;
        Vozilo vo=(Vozilo)request.getData();
        try {
            response = new Response();
            vo = Controller.getInstance().pretraziVozilo(vo);
            response.setData(vo);
            response.setStatus(ResponseStatus.SUCCESS);
        } catch(Exception ex) {
            ex.printStackTrace();
            response.setErrormessage(ex.getLocalizedMessage());
        }
        return response;
    }
      
       public Response findListuVozilo (Request request){
        Response response = null;
        Vozilo vo=(Vozilo)request.getData();
        try {
            response = new Response();
            List<Vozilo> vozila = Controller.getInstance().vratiListuVozilo(vo);
            response.setData(vozila);
            response.setStatus(ResponseStatus.SUCCESS);
        } catch(Exception ex) {
            ex.printStackTrace();
            response.setErrormessage(ex.getLocalizedMessage());
        }
        return response;
    }
       
         public Response findListuVoziloVlasnik (Request request){
        Response response = null;
        Vlasnik vlasnik=(Vlasnik)request.getData();
        try {
            response = new Response();
            List<Vozilo> vozila = Controller.getInstance().vratiListuVozilo(vlasnik);
            response.setData(vozila);
            response.setStatus(ResponseStatus.SUCCESS);
        } catch(Exception ex) {
            ex.printStackTrace();
            response.setErrormessage(ex.getLocalizedMessage());
        }
        return response;
    }
     
     
     ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     
     
      public Response getAllVlasnik(Request request){
        Response response = null;
        try {
            response = new Response();
            List<Vlasnik> vlasnici = Controller.getInstance().vratiListuSviVlasnik();
            response.setData(vlasnici);
            response.setStatus(ResponseStatus.SUCCESS);
        } catch(Exception ex) {
            ex.printStackTrace();
            response.setErrormessage(ex.getLocalizedMessage());
        }
        return response;
    }
      
      
      public Response addVlasnik(Request request){
        Response response = null;
        Vlasnik vlasnik=(Vlasnik)request.getData();
        try {
            response = new Response();
            long id = Controller.getInstance().kreirajVlasnik(vlasnik);
            response.setData(id);
            response.setStatus(ResponseStatus.SUCCESS);
        } catch(Exception ex) {
            ex.printStackTrace();
            response.setErrormessage(ex.getLocalizedMessage());
        }
        return response;
    }
      
      public Response updateVlasnik(Request request){
        Response response = null;
        Vlasnik v=(Vlasnik)request.getData();
        try {
            response = new Response();
            boolean b = Controller.getInstance().promeniVlasnik(v);
            response.setData(b);
            response.setStatus(ResponseStatus.SUCCESS);
        } catch(Exception ex) {
            ex.printStackTrace();
            response.setErrormessage(ex.getLocalizedMessage());
        }
        return response;
    }
      
      public Response findVlasnik(Request request){
        Response response = null;
        Vlasnik v=(Vlasnik)request.getData();
        try {
            response = new Response();
            v = Controller.getInstance().pretraziVlasnik(v);
            response.setData(v);
            response.setStatus(ResponseStatus.SUCCESS);
        } catch(Exception ex) {
            ex.printStackTrace();
            response.setErrormessage(ex.getLocalizedMessage());
        }
        return response;
    }
      
      
       public Response findListVlasnik(Request request){
        Response response = null;
        Vlasnik v=(Vlasnik)request.getData();
        try {
            response = new Response();
            List<Vlasnik> vlasnici = Controller.getInstance().vratiListuVlasnik(v);
            response.setData(vlasnici);
            response.setStatus(ResponseStatus.SUCCESS);
        } catch(Exception ex) {
            ex.printStackTrace();
            response.setErrormessage(ex.getLocalizedMessage());
        }
        return response;
    }
      
      public Response deleteVlasnik(Request request){
        Response response = null;
        Vlasnik v=(Vlasnik)request.getData();
        try {
            response = new Response();
            boolean b = Controller.getInstance().obrisiVlasnik(v);
            response.setData(b);
            response.setStatus(ResponseStatus.SUCCESS);
        } catch(Exception ex) {
            ex.printStackTrace();
            response.setErrormessage(ex.getLocalizedMessage());
        }
        return response;
    }
      
      
      ///////////////////////////////////////////////////////////////////////////////////////
      
       public Response getAllRaskrsnica(Request request){
        Response response = null;
        try {
            response = new Response();
            List<Raskrsnica> ras = Controller.getInstance().vratiListuSviRaskrsnice();
            response.setData(ras);
            response.setStatus(ResponseStatus.SUCCESS);
        } catch(Exception ex) {
            ex.printStackTrace();
            response.setErrormessage(ex.getLocalizedMessage());
        }
        return response;
    }
       
       public Response addRaskrsnica(Request request){
        Response response = null;
        Raskrsnica ras=(Raskrsnica)request.getData();
        try {
            response = new Response();
            long id = Controller.getInstance().kreirajRaskrsnica(ras);
            response.setData(id);
            response.setStatus(ResponseStatus.SUCCESS);
        } catch(Exception ex) {
            ex.printStackTrace();
            response.setErrormessage(ex.getLocalizedMessage());
        }
        return response;
    }
      
      public Response deleteRaskrsnica(Request request){
        Response response = null;
        Raskrsnica ras=(Raskrsnica)request.getData();
        try {
            response = new Response();
            boolean b = Controller.getInstance().obrisiRaskrsnica(ras);
            response.setData(b);
            response.setStatus(ResponseStatus.SUCCESS);
        } catch(Exception ex) {
            ex.printStackTrace();
            response.setErrormessage(ex.getLocalizedMessage());
        }
        return response;
    }
      
      
      public Response updateRaskrsnica(Request request){
        Response response = null;
        Raskrsnica r=(Raskrsnica)request.getData();
        try {
            response = new Response();
            boolean b = Controller.getInstance().promeniRaskrsnica(r);
            response.setData(b);
            response.setStatus(ResponseStatus.SUCCESS);
        } catch(Exception ex) {
            ex.printStackTrace();
            response.setErrormessage(ex.getLocalizedMessage());
        }
        return response;
    }
      
        public Response findRaskrsnica(Request request){
        Response response = null;
        Raskrsnica r=(Raskrsnica)request.getData();
        try {
            response = new Response();
            r = Controller.getInstance().pretraziRaskrsnica(r);
            response.setData(r);
            response.setStatus(ResponseStatus.SUCCESS);
        } catch(Exception ex) {
            ex.printStackTrace();
            response.setErrormessage(ex.getLocalizedMessage());
        }
        return response;
    }
        
        public Response findListRaskrsnica(Request request){
        Response response = null;
        Raskrsnica r=(Raskrsnica)request.getData();
        try {
            response = new Response();
            List<Raskrsnica> raskrsnice = Controller.getInstance().vratiListuRaskrsnica(r);
            response.setData(raskrsnice);
            response.setStatus(ResponseStatus.SUCCESS);
        } catch(Exception ex) {
            ex.printStackTrace();
            response.setErrormessage(ex.getLocalizedMessage());
        }
        return response;
    }
        
        ///////////////////////////////////////////////////////////////////////////////////
        
        
        public Response addEvidencijaKazni(Request request){
        Response response = null;
        EvidencijaKazni ek=(EvidencijaKazni)request.getData();
        try {
            response = new Response();
            long id = Controller.getInstance().kreirajEvidencijaKazne(ek);
            response.setData(id);
            response.setStatus(ResponseStatus.SUCCESS);
        } catch(Exception ex) {
            ex.printStackTrace();
            response.setErrormessage(ex.getLocalizedMessage());
        }
        return response;
    }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
}
