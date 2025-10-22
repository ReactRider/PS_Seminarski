/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Stefan
 */
public class StavkaEvidencije implements OpstaDomenskaKlasa {
    private long rb;
    private EvidencijaKazni evidencija;
    private Kazna kazna;
    private double iznos;
    private KategorijaKazna kategorija_kazne;
    private Raskrsnica raskrsnica;
    private LocalDateTime datumPrekrsaja;

    public StavkaEvidencije(long rb, EvidencijaKazni evidencija, LocalDateTime datumPrekrsaja, KategorijaKazna kategorija_kazne, Raskrsnica r, Kazna kazna, double iznos) {
        this.rb = rb;
        this.evidencija = evidencija;
        this.kazna = kazna;
        this.iznos = iznos;
        this.kategorija_kazne = kategorija_kazne;
        this.raskrsnica = r;
        this.datumPrekrsaja = datumPrekrsaja;
    }

    public StavkaEvidencije(long rb, EvidencijaKazni evidencija, Kazna kazna, KategorijaKazna kategorija_kazne) {
        this.rb = rb;
        this.evidencija = evidencija;
        this.kazna = kazna;
        this.kategorija_kazne = kategorija_kazne;
        setIznos();
    }

    public StavkaEvidencije(EvidencijaKazni evidencija, LocalDateTime datumPrekrsaja, KategorijaKazna kategorija_kazne, Raskrsnica r,  Kazna kazna) {
        this.evidencija = evidencija;
        this.datumPrekrsaja = datumPrekrsaja;
        this.kategorija_kazne = kategorija_kazne;
        this.raskrsnica = r;
        this.kazna = kazna;
        setIznos();
    }

    public StavkaEvidencije() {}
    
    public long getRb() {
        return rb;
    }

    public void setRb(long rb) {
        this.rb = rb;
    }

    public EvidencijaKazni getEvidencija() {
        return evidencija;
    }

    public void setEvidencija(EvidencijaKazni evidencija) {
        this.evidencija = evidencija;
    }

    public Kazna getKazna() {
        return kazna;
    }

    public void setKazna(Kazna kazna) {
        this.kazna = kazna;
    }

    public Raskrsnica getRaskrsnica() {
        return raskrsnica;
    }

    public void setRaskrsnica(Raskrsnica raskrsnica) {
        this.raskrsnica = raskrsnica;
    }
    

    public double getIznos() {
        return iznos;
    }

    public void setIznos() {
        switch(this.kategorija_kazne) {
            case KategorijaKazna.Kategorija_I:
                this.iznos = 100000;
            break;
            
            case KategorijaKazna.Kategorija_II:
                this.iznos = 50000;
            break;
            
            case KategorijaKazna.Kategorija_III:
                this.iznos = 25000;
            break;
        }
    }

    public KategorijaKazna getKategorija_kazne() {
        return kategorija_kazne;
    }

    public void setKategorija_kazne(KategorijaKazna kategorija_kazne) {
        this.kategorija_kazne = kategorija_kazne;
        setIznos();
    }

    public LocalDateTime getDatumPrekrsaja() {
        return datumPrekrsaja;
    }

    public void setDatumPrekrsaja(LocalDateTime datumPrekrsaja) {
        this.datumPrekrsaja = datumPrekrsaja;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final StavkaEvidencije other = (StavkaEvidencije) obj;
        if (this.rb != other.rb) {
            return false;
        }
        if (Double.doubleToLongBits(this.iznos) != Double.doubleToLongBits(other.iznos)) {
            return false;
        }
        if (!Objects.equals(this.evidencija, other.evidencija)) {
            return false;
        }
        if (!Objects.equals(this.kazna, other.kazna)) {
            return false;
        }
        return this.kategorija_kazne == other.kategorija_kazne;
    }
    
    @Override
    public String toString() {
        return "StavkaEvidencije{" + "rb=" + rb + ", id_evidencija=" + evidencija + ", id_kazna=" + kazna + ", iznos=" + iznos + ", kategorija_kazne=" + kategorija_kazne + '}';
    }

    @Override
    public String getTableName() {
        return "stavka_evidencije";
    }
    
    @Override
    public String getColumnsForInsert() {
        return "idEvidencije, datumPrekrsaja, kategorija_kazne, idRaskrsnice, idKazne";
    }

    @Override
    public String getValuesForInsert() {
        return this.evidencija.getId_evidencija() + ", '" + this.getDatumPrekrsaja() + "', '" + this.getKategorija_kazne() + "', " + this.raskrsnica.getId_raskrsnica() + ", " + this.kazna.getId_kazna();
    }

    @Override
    public String getCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getJoinCondition() {
        return "stavka_evidencije se JOIN evidencija_kazni ek ON se.idEvidencije = ek.idEvidencija JOIN vozilo v ON ek.id_vozilo = v.id JOIN raskrsnica r ON se.idRaskrsnice = r.id JOIN kazna k ON se.idKazne = k.id";
    }

    @Override
    public String getConditionForDelete(OpstaDomenskaKlasa t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getValueForUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getConditionForUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getConditionForFind(String s, OpstaDomenskaKlasa t2) {
        if(t2 instanceof EvidencijaKazni && s.equals("lista")) {
           return "se.idEvidencije = " + ((EvidencijaKazni)t2).getId_evidencija();
        } else return "";
    }

    @Override
    public OpstaDomenskaKlasa getObject(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<OpstaDomenskaKlasa> getList(ResultSet rs) throws Exception {
        List<OpstaDomenskaKlasa> list=new ArrayList<>();
        while(rs.next()){
            EvidencijaKazni evid = new EvidencijaKazni();
            long idEvid = rs.getLong("ek.idEvidencija");
            evid.setId_evidencija(idEvid);
            
            Vozilo v = new Vozilo();
            Long idVozilo = rs.getLong("v.id");
            String reg_oznaka = rs.getString("v.reg_oznaka");
            v.setId_vozilo(idVozilo);
            v.setReg_oznaka(reg_oznaka);
            
            evid.setVozilo(v);
            
            Kazna k = new Kazna();
            String nazivKazne = rs.getString("k.naziv");
            k.setNaziv(nazivKazne);
            
            Raskrsnica r = new Raskrsnica();
            String nazivRask = rs.getString("r.naziv");
            r.setNaziv(nazivRask);
            
            LocalDateTime datumPrekrsaja = rs.getTimestamp("se.datumPrekrsaja").toLocalDateTime();

            StavkaEvidencije stavka = new StavkaEvidencije();
            stavka.setEvidencija(evid);
            stavka.setKazna(k);
            stavka.setRaskrsnica(r);
            stavka.setDatumPrekrsaja(datumPrekrsaja);
            System.out.println(stavka);
            list.add(stavka);
        }
        return list;
    }
    
}
