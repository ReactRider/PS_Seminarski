package controller;

import domain.*;
import java.util.*;
import so.AbstractSO;
import so.evidencija_kazne.*;
import so.kazna.*;
import so.policijska_uprava.*;
import so.raskrsnica.*;
import so.vlasnik.*;
import so.vozilo.*;

public class Controller {
    private static Controller instance;
    
    private Controller() {
        
    }
    
    public static Controller getInstance() {
        if(instance == null) {
            instance = new Controller();
        }
        return instance;
    }
    
    public PolicijskaUprava login(PolicijskaUprava pu) throws Exception {
        AbstractSO loginPU = new loginPolicijskaUpravaSO();
        return (PolicijskaUprava)loginPU.execute(pu,null,"");
    }
    
    public long kreirajPolicijskaUprava(PolicijskaUprava pu) throws Exception{
        AbstractSO addPU=new AddPolicijskaUpravaSO();
        return (long)addPU.execute(pu,null,"");
    }
    
    
    public boolean obrisiPolicijskaUprava(PolicijskaUprava pu) throws Exception{
        AbstractSO deletepu=new DeletePolicijskaUpravaSO();
        return (boolean)deletepu.execute(pu,null,"");
    }
    
    
    public boolean promeniPolicijskaUprava(PolicijskaUprava pu) throws Exception{
        AbstractSO editPu = new UpdatePolicijskaUpravaSO();
        return (boolean)editPu.execute(pu, null, "");
    }
    
    public PolicijskaUprava pretraziPolicijskaUprava(PolicijskaUprava pu) throws Exception{
        AbstractSO findpu=new FindPolicijskaUpravaSO();
        ArrayList<PolicijskaUprava> lista_pu= (ArrayList<PolicijskaUprava>)findpu.execute(pu,null,"jedan");
        return lista_pu.getFirst();
    }
    
    public List<PolicijskaUprava> vratiListuPolicijskaUprava(PolicijskaUprava pu) throws Exception{
        AbstractSO findpu=new FindPolicijskaUpravaSO();
        return (List<PolicijskaUprava>)findpu.execute(pu, null, "lista");
    }
    
    public List<PolicijskaUprava> vratiListuPolicijskaUprava(Raskrsnica r) throws Exception{
        AbstractSO findPU=new FindPolicijskaUpravaSO();
        PolicijskaUprava pu=new PolicijskaUprava();
        return (List<PolicijskaUprava>)findPU.execute(pu, r, "lista");
    }
    
    public List<PolicijskaUprava> vratiListuSviPolicijskaUprava() throws Exception{
        AbstractSO getAllPU=new GetAllPolicijskaUpravaSO();
        PolicijskaUprava pu=new PolicijskaUprava();
        return (List<PolicijskaUprava>)getAllPU.execute(pu, null,"");
    }
    
    public PolicijskaUprava pretraziPolicijskaUpravaUsername(PolicijskaUprava pu) throws Exception{
        AbstractSO findPU=new FindPolicijskaUpravaSO();
        List<PolicijskaUprava> uprave =(List<PolicijskaUprava>)findPU.execute(pu, null, "samo username");
        if(uprave == null)
            return null;
        return uprave.getFirst();
    }
    
    public PolicijskaUprava pretraziPolicijskUpravaDaLiPostoji(PolicijskaUprava pu) throws Exception {
        AbstractSO findpu = new FindPolicijskaUpravaSO();
        List<PolicijskaUprava> uprava = (List<PolicijskaUprava>)findpu.execute(pu, null, "slozen upit");
        if(uprava.isEmpty()){
            return null;
        }
        return uprava.getFirst();
    }
    
    public PolicijskaUprava pretraziPolicijskaUpravaAdresa(PolicijskaUprava pu) throws Exception{
        AbstractSO findpu=new FindPolicijskaUpravaSO();
        List<PolicijskaUprava> uprave = (List<PolicijskaUprava>)findpu.execute(pu, null, "grad i adresa");
        if (uprave == null)
            return null;
        return uprave.getFirst();
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////
    
    public List<Kazna> vratiListuSviKazna() throws Exception{
        AbstractSO getAllKazna=new GetAllKaznaSO();
        Kazna k=new Kazna();
        return (List<Kazna>)getAllKazna.execute(k,null,"");
    }
    
    public Kazna pretraziKazna(Kazna k) throws Exception{
        AbstractSO findKazna=new FindKaznaSO();
        ArrayList<Kazna> kazne = (ArrayList<Kazna>)findKazna.execute(k,null,"jedan");
        if(kazne.isEmpty())
            return null;
        return kazne.getFirst();
    }
    
    public long kreirajKazna(Kazna k) throws Exception{
        AbstractSO addKazna=new AddKaznaSO();
        return (long)addKazna.execute(k,null,"");
    }
    
    
    public boolean promeniKazna(Kazna k) throws Exception{
        AbstractSO updateKaz=new UpdateKaznaSO();
        return (boolean)updateKaz.execute(k,null,"");
    }
    
    public boolean obrisiKazna(Kazna k) throws Exception{
        AbstractSO deleteKaz=new DeleteKaznaSO();
        return (boolean)deleteKaz.execute(k,null,"");
    }
    
    
    public List<Kazna> vratiListuKazna(Kazna k) throws Exception{
        AbstractSO findKazna=new FindKaznaSO();
        return (List<Kazna>)findKazna.execute(k, null, "lista");
    }
    
    
    /////////////////////////////////////////////////////////////////////////////////////////////
    
    
    
    
    public List<Vozilo> vratiListuSviVozilo() throws Exception{
        AbstractSO getAllV=new GetAllVoziloSO();
        Vozilo v=new Vozilo();
        return (List<Vozilo>)getAllV.execute(v,null,"");
    }
    
    public long kreirajVozilo(Vozilo v) throws Exception{
        AbstractSO addVozilo=new AddVoziloSO();
        return (long)addVozilo.execute(v,null,"");
    }
    
    
    public boolean promeniVozilo(Vozilo v) throws Exception{
        AbstractSO editVozilo=new UpdateVoziloSO();
        return (boolean)editVozilo.execute(v,null,"");
    }
    
    public boolean obrisiVozilo(Vozilo v) throws Exception {
        AbstractSO deleteVozilo=new DeleteVoziloSO();
        return (boolean)deleteVozilo.execute(v,null,"");
    }
    
    
    public Vozilo pretraziVozilo(Vozilo v) throws Exception{
        AbstractSO findVozilo=new FindVoziloSO();
        ArrayList<Vozilo> vozila=(ArrayList<Vozilo>)findVozilo.execute(v,null,"jedan");
        if(vozila == null) 
            return null;
        return vozila.getFirst();
    }
    
    public List<Vozilo> vratiListuVozilo(Vozilo v) throws Exception{
        AbstractSO findVoz=new FindVoziloSO();
        return (List<Vozilo>)findVoz.execute(v, null, "lista");
    }
    
    public List<Vozilo> vratiListuVozilo(Vlasnik vl) throws Exception{
        AbstractSO findV = new FindVoziloSO();
        Vozilo vozilo = new Vozilo();
        return (List<Vozilo>)findV.execute(vozilo, vl, "lista");
    }
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    
    public List<Vlasnik> vratiListuSviVlasnik() throws Exception{
        AbstractSO getAllVlasnik=new GetAllVlasnikSO();
        Vlasnik vlasnik=new Vlasnik();
        return (List<Vlasnik>)getAllVlasnik.execute(vlasnik,null,"");
    }
    
    public long kreirajVlasnik(Vlasnik v) throws Exception{
        AbstractSO addVlasnik=new AddVlasnikSO();
        return (long)addVlasnik.execute(v,null,"");
    }
    
    
    public boolean promeniVlasnik(Vlasnik v) throws Exception{
        AbstractSO editVlasnik=new UpdateVlasnikSO();
        return (boolean)editVlasnik.execute(v,null,"");
    }
    
    
    public Vlasnik pretraziVlasnik(Vlasnik v) throws Exception{
        AbstractSO findVlasnik=new FindVlasnikSO();
        ArrayList<Vlasnik> vlasnici =  (ArrayList<Vlasnik>)findVlasnik.execute(v,null,"jedan");
        if(vlasnici.isEmpty()) {
            return null;
        }
        return vlasnici.getFirst();
    }
    
    
    public boolean obrisiVlasnik(Vlasnik v) throws Exception{
        AbstractSO deleteVlasnik=new DeleteVlasnikSO();
        return (boolean)deleteVlasnik.execute(v,null,"");
    }
    
    public List<Vlasnik> vratiListuVlasnik(Vlasnik v) throws Exception{
        AbstractSO findVl=new FindVlasnikSO();
        return (List<Vlasnik>)findVl.execute(v, null, "lista");
    }
    
    //////////////////////////////////////////////////////////////////////////////////
    
    public List<Raskrsnica> vratiListuSviRaskrsnice() throws Exception{
        AbstractSO getAllRas=new GetAllRaskrsnicaSO();
        Raskrsnica r=new Raskrsnica();
        return (List<Raskrsnica>)getAllRas.execute(r,null,"");
    }
    
    
    public long kreirajRaskrsnica(Raskrsnica r) throws Exception{
        AbstractSO addRas=new AddRaskrsnicaSO();
        return (long)addRas.execute(r,null,"");
    }
    
    public boolean obrisiRaskrsnica(Raskrsnica r) throws Exception{
        AbstractSO deleteRas=new DeleteRaskresnicaSO();
        return (boolean)deleteRas.execute(r,null,"");
    }
    
    public boolean promeniRaskrsnica(Raskrsnica r) throws Exception{
        AbstractSO updateRas=new UpdateRaskrsnicaSO();
        return (boolean) updateRas.execute(r,null,"");
    }
    
    public Raskrsnica pretraziRaskrsnica(Raskrsnica r) throws Exception{
        AbstractSO findRas=new FindRaskrsnicaSO();
        ArrayList<Raskrsnica> raskrsnice = (ArrayList<Raskrsnica>)findRas.execute(r,null,"jedan");
        if(raskrsnice.isEmpty())
            return null;
        return raskrsnice.getFirst();
    }
    
    public List<Raskrsnica> vratiListuRaskrsnica(Raskrsnica ras) throws Exception{
        AbstractSO findRas=new FindRaskrsnicaSO();
        return (List<Raskrsnica>)findRas.execute(ras, null, "lista");
    }
    
    
    public Raskrsnica daLiPostojiRaskrsnica(Raskrsnica ras) throws Exception{
        AbstractSO findRas =new FindRaskrsnicaSO();
        ArrayList<Raskrsnica> raskrsnice= (ArrayList<Raskrsnica>)findRas.execute(ras, null, "naziv");
        if(raskrsnice.isEmpty()){
            return null;
        }
        System.out.println(raskrsnice.getFirst());
        return raskrsnice.getFirst();
    }
    
    //////////////////////////////////////////////////////////////////////////////////////
    
    public long kreirajEvidencijaKazni(EvidencijaKazni ek) throws Exception{
        AbstractSO addEK=new AddEvidencijaSO();
        return (long)addEK.execute(ek,null,"");
    }

    public ArrayList<EvidencijaKazni> vratiListuEvidencijaEvidencija(EvidencijaKazni ek) throws Exception {
        AbstractSO findEvid = new FindEvidencijaSO();
        ArrayList<EvidencijaKazni> evidencije = (ArrayList<EvidencijaKazni>)findEvid.execute(ek, null, "lista");
        
        Set<Long> seen = new HashSet<>();
        ArrayList<EvidencijaKazni> finalnaLista = new ArrayList<>();
        for (EvidencijaKazni o : evidencije) 
            if (seen.add(o.getId_evidencija())) finalnaLista.add(o);
        
        return finalnaLista;
    }

    public ArrayList<EvidencijaKazni> vratiListuEvidencijaKazna(Kazna k) throws Exception {
        AbstractSO findEvid = new FindEvidencijaSO();
        EvidencijaKazni ek = new EvidencijaKazni();
        ArrayList<EvidencijaKazni> evidencije = (ArrayList<EvidencijaKazni>)findEvid.execute(ek, k, "lista");
        
        Set<Long> seen = new HashSet<>();
        ArrayList<EvidencijaKazni> finalnaLista = new ArrayList<>();
        for(EvidencijaKazni o : evidencije)
            if(seen.add(o.getId_evidencija())) finalnaLista.add(o);
        return finalnaLista;
    }

    public ArrayList<EvidencijaKazni> vratiListuEvidencijaPolicijskaUprava(PolicijskaUprava pu) throws Exception {
        AbstractSO findEvid = new FindEvidencijaSO();
        EvidencijaKazni ek = new EvidencijaKazni();
        ArrayList<EvidencijaKazni> evidencije = (ArrayList<EvidencijaKazni>)findEvid.execute(ek, pu, "lista");
        
        Set<Long> seen = new HashSet<>();
        ArrayList<EvidencijaKazni> finalnaLista = new ArrayList<>();
        for (EvidencijaKazni o : evidencije) 
            if (seen.add(o.getId_evidencija())) finalnaLista.add(o);
        
        return finalnaLista;
    }

    public ArrayList<EvidencijaKazni> vratiListuEvidencijaVozilo(Vozilo v) throws Exception {
        AbstractSO findEvid = new FindEvidencijaSO();
        EvidencijaKazni ek = new EvidencijaKazni();
        ArrayList<EvidencijaKazni> evidencije = (ArrayList<EvidencijaKazni>)findEvid.execute(ek, v, "lista");
          
        Set<Long> seen = new HashSet<>();
        ArrayList<EvidencijaKazni> finalnaLista = new ArrayList<>();
        for (EvidencijaKazni o : evidencije) 
            if (seen.add(o.getId_evidencija())) finalnaLista.add(o);
        
        return finalnaLista;
    }
}
