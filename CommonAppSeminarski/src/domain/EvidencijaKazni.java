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
public class EvidencijaKazni {
    private Long id_evidencija;
    private double iznos_total;
    private Long br_kazni_I;
    private Long br_kazni_II;
    private Long br_kazni_III;
    private double bazni_ponder;
    private PolicijskaUprava pu;
    private Vozilo vozilo;

    public EvidencijaKazni(Long id_evidencija, Long br_kazni_I, Long br_kazni_II, Long br_kazni_III, double bazni_ponder, PolicijskaUprava pu, Vozilo vozilo) {
        this.id_evidencija = id_evidencija;
        this.br_kazni_I = br_kazni_I;
        this.br_kazni_II = br_kazni_II;
        this.br_kazni_III = br_kazni_III;
        this.bazni_ponder = bazni_ponder;
        this.pu = pu;
        this.vozilo = vozilo;
        setIznos_total();
    }

    public EvidencijaKazni(Long br_kazni_I, Long br_kazni_II, Long br_kazni_III, double bazni_ponder, PolicijskaUprava pu, Vozilo vozilo) {
        this.br_kazni_I = br_kazni_I;
        this.br_kazni_II = br_kazni_II;
        this.br_kazni_III = br_kazni_III;
        this.bazni_ponder = bazni_ponder;
        this.pu = pu;
        this.vozilo = vozilo;
        setIznos_total();
    }

    public EvidencijaKazni(Long id_evidencija, double iznos_total, Long br_kazni_I, Long br_kazni_II, Long br_kazni_III, double bazni_ponder, PolicijskaUprava pu, Vozilo vozilo) {
        this.id_evidencija = id_evidencija;
        this.iznos_total = iznos_total;
        this.br_kazni_I = br_kazni_I;
        this.br_kazni_II = br_kazni_II;
        this.br_kazni_III = br_kazni_III;
        this.bazni_ponder = bazni_ponder;
        this.pu = pu;
        this.vozilo = vozilo;
    }

    public EvidencijaKazni(long id_evidencija) {
        this.id_evidencija = id_evidencija;
    }
    
    public EvidencijaKazni() {}
    
    public Long getId_evidencija() {
        return id_evidencija;
    }

    public void setId_evidencija(Long id_evidencija) {
        this.id_evidencija = id_evidencija;
    }

    public double getIznos_total() {
        return iznos_total;
    }

    public void setIznos_total() {
        this.iznos_total = this.bazni_ponder * ( this.br_kazni_I * 100000 + this.br_kazni_II * 50000 + this.br_kazni_III * 25000);
    }

    public Long getBr_kazni_I() {
        return br_kazni_I;
    }

    public void setBr_kazni_I(Long br_kazni_I) {
        this.br_kazni_I = br_kazni_I;
    }

    public Long getBr_kazni_II() {
        return br_kazni_II;
    }

    public void setBr_kazni_II(Long br_kazni_II) {
        this.br_kazni_II = br_kazni_II;
    }

    public Long getBr_kazni_III() {
        return br_kazni_III;
    }

    public void setBr_kazni_III(Long br_kazni_III) {
        this.br_kazni_III = br_kazni_III;
    }

    public double getBazni_ponder() {
        return bazni_ponder;
    }

    public void setBazni_ponder(double bazni_ponder) {
        this.bazni_ponder = bazni_ponder;
    }

    public PolicijskaUprava getPu() {
        return pu;
    }

    public void setPu(PolicijskaUprava pu) {
        this.pu = pu;
    }

    public Vozilo getVozilo() {
        return vozilo;
    }

    public void setVozilo(Vozilo vozilo) {
        this.vozilo = vozilo;
    }

    @Override
    public String toString() {
        return "EvidencijaKazni{" + "id_evidencija=" + id_evidencija + ", iznos_total=" + iznos_total + ", br_kazni_I=" + br_kazni_I + ", br_kazni_II=" + br_kazni_II + ", br_kazni_III=" + br_kazni_III + ", bazni_ponder=" + bazni_ponder + ", pu=" + pu + ", vozilo=" + vozilo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final EvidencijaKazni other = (EvidencijaKazni) obj;
        if (Double.doubleToLongBits(this.iznos_total) != Double.doubleToLongBits(other.iznos_total)) {
            return false;
        }
        if (Double.doubleToLongBits(this.bazni_ponder) != Double.doubleToLongBits(other.bazni_ponder)) {
            return false;
        }
        if (!Objects.equals(this.id_evidencija, other.id_evidencija)) {
            return false;
        }
        if (!Objects.equals(this.br_kazni_I, other.br_kazni_I)) {
            return false;
        }
        if (!Objects.equals(this.br_kazni_II, other.br_kazni_II)) {
            return false;
        }
        if (!Objects.equals(this.br_kazni_III, other.br_kazni_III)) {
            return false;
        }
        if (!Objects.equals(this.pu, other.pu)) {
            return false;
        }
        return Objects.equals(this.vozilo, other.vozilo);
    }
    
    
    
    
    
    
}
