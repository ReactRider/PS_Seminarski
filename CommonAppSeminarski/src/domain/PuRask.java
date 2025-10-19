/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.Date;

/**
 *
 * @author Stefan
 */
public class PuRask {
    private Date datum_od;
    private Date datum_do;
    private PolicijskaUprava pu;
    private Raskrsnica rask;

    public PuRask(Date datum_od, Date datum_do, PolicijskaUprava pu, Raskrsnica rask) {
        this.datum_od = datum_od;
        this.datum_do = datum_do;
        this.pu = pu;
        this.rask = rask;
    }

    public PuRask() {
    }
    
    public Date getDatum_od() {
        return datum_od;
    }

    public void setDatum_od(Date datum_od) {
        this.datum_od = datum_od;
    }

    public Date getDatum_do() {
        return datum_do;
    }

    public void setDatum_do(Date datum_do) {
        this.datum_do = datum_do;
    }

    public PolicijskaUprava getPu() {
        return pu;
    }

    public void setPu(PolicijskaUprava pu) {
        this.pu = pu;
    }

    public Raskrsnica getRask() {
        return rask;
    }

    public void setRask(Raskrsnica rask) {
        this.rask = rask;
    }
    
    
    
}
