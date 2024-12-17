/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.Objects;

/**
 *
 * @author Stefan
 */
public class Vozilo {
    private Long id_vozilo;
    private String reg_oznaka;
    private String marka;
    private String model;
    private Vlasnik vlasnik;

    public Vozilo(Long id_vozilo, String reg_oznaka, String marka, String model, Vlasnik vlasnik) {
        this.id_vozilo = id_vozilo;
        this.reg_oznaka = reg_oznaka;
        this.marka = marka;
        this.model = model;
        this.vlasnik = vlasnik;
    }

    public Vozilo(String reg_oznaka, String marka, String model, Vlasnik vlasnik) {
        this.reg_oznaka = reg_oznaka;
        this.marka = marka;
        this.model = model;
        this.vlasnik = vlasnik;
    }

    public Vozilo(Long id_vozilo) {
        this.id_vozilo = id_vozilo;
    }

    public Vozilo(String reg_oznaka) {
        this.reg_oznaka = reg_oznaka;
    }
    
    public Vozilo(String marka, int x) {
        this.marka = marka;
    }
    
    
    public Vozilo(Long id_vozilo, Vlasnik vlasnik) {
        this.id_vozilo = id_vozilo;
        this.vlasnik = vlasnik;
    }

    public Vozilo(Vlasnik vlasnik) {
        this.vlasnik = vlasnik;
    }
    
    public Long getId_vozilo() {
        return id_vozilo;
    }

    public void setId_vozilo(Long id_vozilo) {
        this.id_vozilo = id_vozilo;
    }

    public String getReg_oznaka() {
        return reg_oznaka;
    }

    public void setReg_oznaka(String reg_oznaka) {
        this.reg_oznaka = reg_oznaka;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Vlasnik getVlasnik() {
        return vlasnik;
    }

    public void setVlasnik(Vlasnik vlasnik) {
        this.vlasnik = vlasnik;
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
        final Vozilo other = (Vozilo) obj;
        if (!Objects.equals(this.reg_oznaka, other.reg_oznaka)) {
            return false;
        }
        if (!Objects.equals(this.marka, other.marka)) {
            return false;
        }
        if (!Objects.equals(this.model, other.model)) {
            return false;
        }
        if (!Objects.equals(this.id_vozilo, other.id_vozilo)) {
            return false;
        }
        return Objects.equals(this.vlasnik, other.vlasnik);
    }
    
    @Override
    public String toString() {
        return marka + " " + model + ", " + reg_oznaka;
    }
    
}
