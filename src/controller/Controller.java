package controller;

import db.DBBroker;
import domain.*;
import java.util.ArrayList;

/**
 *
 * @author Stefan
 */
public class Controller {
    private static Controller instance;
    private DBBroker dbb;
    
    public Controller() {
        dbb = new DBBroker();
    }
    
    public static Controller getInstance() {
        if(instance == null)
            instance = new Controller();
        return instance;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    
    public boolean promeniEvidencijaKazni(EvidencijaKazni ek) {
        return dbb.promeniEvidencijaKazni(ek);
    }
    
    public EvidencijaKazni pretraziEvidencijaKazni(EvidencijaKazni ek) {
        return dbb.pretraziEvidencijaKazni(ek);
    }
    
    public boolean kreirajEvidencijaKazni(EvidencijaKazni ek) {
        return dbb.kreirajEvidencijaKazni(ek);
    }
    
    public ArrayList<EvidencijaKazni> vratiListuEvidencijaKazni(EvidencijaKazni ek) {
        return dbb.vratiListuEvidencijaKazni(ek);
    }
    
    public ArrayList<EvidencijaKazni> vratiListuEvidencijaKazni(Kazna kazna) {
        return dbb.vratiListuEvidencijaKazni(kazna);
    }
    
    public ArrayList<EvidencijaKazni> vratiListuEvidencijaKazni(PolicijskaUprava pu) {
        return dbb.vratiListuEvidencijaKazni(pu);
    }
    
    public ArrayList<EvidencijaKazni> vratiListuEvidencijaKazni(Vozilo vozilo) {
        return dbb.vratiListuEvidencijaKazni(vozilo);
    }
    
    public boolean daLiPostojiEvidencija(PolicijskaUprava pu, Vozilo v) {
        return dbb.daLiPostojiEvidencija(pu, v);
    }
    
    ////////////////////////////////////////////////////////////////////////////
    
    public ArrayList<PolicijskaUprava> vratiListuSviPolicijskaUprava() {
        return dbb.vratiListuSviPolicijskaUprava();
    }
    
    public ArrayList<PolicijskaUprava> vratiListuPolicijskaUprava(PolicijskaUprava pu) {
        return dbb.vratiListuPolicijskaUprava(pu);
    }
    
    public ArrayList<PolicijskaUprava> vratiListuPolicijskaUprava(Raskrsnica r) {
        return dbb.vratiListuPolicijskaUprava(r);
    }
    
    public boolean promeniPolicijskaUprava(PolicijskaUprava pu) {
        return dbb.promeniPolicijskaUprava(pu);
    }
    
    public boolean obrisiPolicijskaUprava(PolicijskaUprava pu) {
        return dbb.obrisiPolicijskaUprava(pu);
    }
    
    public PolicijskaUprava pretraziPolicijskaUprava(PolicijskaUprava pu) {
        return dbb.pretraziPolicijskaUprava(pu);
    }
    
    public boolean kreirajPolicijskaUprava(PolicijskaUprava pu) {
        return dbb.kreirajPolicijskaUprava(pu);
    }
    
    ////////////////////////////////////////////////////////////////////////////
    
    public ArrayList<Raskrsnica> vratiListuSviRaskrsnica() {
        return dbb.vratiListuSviRaskrsnica();
    }
    
    public ArrayList<Raskrsnica> vratiListuRaskrsnica(Raskrsnica r) {
        return dbb.vratiListuRaskrsnica(r);
    }
    
    public boolean promeniRaskrsnica(Raskrsnica r) {
        return dbb.promeniRaskrsnica(r);
    }
    
    public boolean obrisiRaskrsnica(Raskrsnica r) {
        return dbb.obrisiRaskrsnica(r);
    }
    
    public Raskrsnica pretraziRaskrsnica(Raskrsnica r) {
        return dbb.pretraziRaskrsnica(r);
    }
    
    public boolean ubaciRaskrsnica(Raskrsnica r) {
        return dbb.ubaciRaskrsnica(r);
    }
    
    ////////////////////////////////////////////////////////////////////////////
    
    public ArrayList<Kazna> vratiListuSviKazna() {
        return dbb.vratiListuSviKazna();
    }
    
    public ArrayList<Kazna> vratiListuKazna(Kazna kazna) {
        return dbb.vratiListuKazna(kazna);
    }
    
    public boolean promeniKazna(Kazna k) {
        return dbb.promeniKazna(k);
    }
    
    public boolean obrisiKazna(Kazna k) {
        return dbb.obrisiKazna(k);
    }
    
    public Kazna pretraziKazna(Kazna k) {
        return dbb.pretraziKazna(k);
    }
    
    public boolean kreirajKazna(Kazna k) {
        return dbb.kreirajKazna(k);
    }
   
    ////////////////////////////////////////////////////////////////////////////
    
    public ArrayList<Vozilo> vratiListuSviVozilo() {
        return dbb.vratiListuSviVozilo();
    }
    
    public ArrayList<Vozilo> vratiListuVozilo(Vlasnik v) {
        return dbb.vratiListuVozilo(v);
    }
    
    public ArrayList<Vozilo> vratiListuVozilo(Vozilo v) {
        return dbb.vratiListuVozilo(v);
    }
    
    public boolean promeniVozilo(Vozilo v) {
        return dbb.promeniVozilo(v);
    }
    
    public boolean obrisiVozilo(Vozilo v) {
        return dbb.obrisiVozilo(v);
    }
    
    public Vozilo pretraziVozilo(Vozilo v) {
        return dbb.pretraziVozilo(v);
    }
    
    public boolean kreirajVozilo(Vozilo v) {
        return dbb.kreirajVozilo(v);
    }
    
    ////////////////////////////////////////////////////////////////////////////
    
    
    public ArrayList<Vlasnik> vratiListuSviVlasnik() {
        return dbb.vratiListuSviVlasnik();
    }
    
    public ArrayList<Vlasnik> vratiListuVlasnik(Vlasnik v) {
        return dbb.vratiListuVlasnik(v);
    }
    
    public boolean promeniVlasnik(Vlasnik v) {
        return dbb.promeniVlasnik(v);
    }
    
    public boolean obrisiVlasnik(Vlasnik v) {
        return dbb.obrisiVlasnik(v);
    }
    
    public Vlasnik pretraziVlasnik(Vlasnik v) {
        return dbb.pretraziVlasnik(v);
    }
    
    public boolean kreirajVlasnik(Vlasnik v) {
        return dbb.kreirajVlasnik(v);
    }
    
    ////////////////////////////////////////////////////////////////////////////
    
    public PolicijskaUprava prijaviPolicijskaUprava(String username, String password) {
        return dbb.prijaviPolicijskaUprava(username, password);
    }
    
    public boolean daLiPostojiRaskrsnica(String naziv, String lokacija) {
        return dbb.daLiPostojiRaskrsnica(naziv, lokacija);
    }
    
    public boolean daLiPostojiPU(PolicijskaUprava pu) {
        return dbb.daLiPostojiPU(pu);
    }
    
    public boolean puusernameok(String username){
        return dbb.puusernameok(username);
    }
    
    public boolean puadresaok(String adresa, String grad){
        return dbb.puadresaok(adresa, grad);
    }
    
    public ArrayList<String> ucitajPU() {
        return dbb.ucitajPU();
    }
    
    public ArrayList<String> ucitajKazne() {
        return dbb.ucitajKazne();
    }
   
    public ArrayList<String> ucitajGradove() {
        return dbb.ucitajGradove();
    }
    
    public ArrayList<String> ucitajRaskrsnice() {
        return dbb.ucitajRaskrsnice();
    }
    
    public ArrayList<String> ucitajMarke() {
        return dbb.ucitajMarke();
    }
    
    public boolean kreirajStavkaEvidencije(StavkaEvidencije se) {
        return dbb.kreirajStavkaEvidencije(se);
    }
    
    public ArrayList<StavkaEvidencije> vratiListuSviStavkeEvidencije(EvidencijaKazni evid) {
        return dbb.vratiListuSviStavkeEvidencije(evid);
    }
}
