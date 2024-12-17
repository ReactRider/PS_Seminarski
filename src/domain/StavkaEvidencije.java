/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.Objects;
import main.KategorijaKazna;

/**
 *
 * @author Stefan
 */
public class StavkaEvidencije {
    private long rb;
    private EvidencijaKazni evidencija;
    private Kazna kazna;
    private double iznos;
    private KategorijaKazna kategorija_kazne;

    public StavkaEvidencije(long rb, EvidencijaKazni evidencija, Kazna kazna, double iznos, KategorijaKazna kategorija_kazne) {
        this.rb = rb;
        this.evidencija = evidencija;
        this.kazna = kazna;
        this.iznos = iznos;
        this.kategorija_kazne = kategorija_kazne;
    }

    public StavkaEvidencije(long rb, EvidencijaKazni evidencija, Kazna kazna, KategorijaKazna kategorija_kazne) {
        this.rb = rb;
        this.evidencija = evidencija;
        this.kazna = kazna;
        this.kategorija_kazne = kategorija_kazne;
        setIznos();
    }

    public StavkaEvidencije(EvidencijaKazni evidencija, Kazna kazna, KategorijaKazna kategorija_kazne) {
        this.evidencija = evidencija;
        this.kazna = kazna;
        this.kategorija_kazne = kategorija_kazne;
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
    
}
