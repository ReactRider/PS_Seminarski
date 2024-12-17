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
public class Kazna {
    private long id_kazna;
    private String naziv;
    private KategorijaKazna kategorija;
    private double iznos;

    public Kazna(long id_kazna, String naziv, KategorijaKazna kategorija, double iznos) {
        this.id_kazna = id_kazna;
        this.naziv = naziv;
        this.kategorija = kategorija;
        this.iznos = iznos;
    }

    public Kazna(String naziv, KategorijaKazna kategorija, double iznos) {
        this.naziv = naziv;
        this.kategorija = kategorija;
        this.iznos = iznos;
    }
    
    public Kazna(KategorijaKazna kategorija) {
        this.kategorija = kategorija;
    }
    
    public Kazna(String naziv) {
        this.naziv = naziv;
    }
    
    public Kazna(long id_kazna) {
        this.id_kazna = id_kazna;
    }
    
    public long getId_kazna() {
        return id_kazna;
    }

    public void setId_kazna(long id_kazna) {
        this.id_kazna = id_kazna;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public KategorijaKazna getKategorija() {
        return kategorija;
    }

    public void setKategorija(KategorijaKazna kategorija) {
        this.kategorija = kategorija;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
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
        final Kazna other = (Kazna) obj;
        if (this.id_kazna != other.id_kazna) {
            return false;
        }
        if (Double.doubleToLongBits(this.iznos) != Double.doubleToLongBits(other.iznos)) {
            return false;
        }
        if (!Objects.equals(this.naziv, other.naziv)) {
            return false;
        }
        return this.kategorija == other.kategorija;
    }

    @Override
    public String toString() {
        return "Kazna{" + "id_kazna=" + id_kazna + ", naziv=" + naziv + ", kategorija=" + kategorija + ", iznos=" + iznos + '}';
    }
    
    
    
}
