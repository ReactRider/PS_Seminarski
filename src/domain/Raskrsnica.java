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
public class Raskrsnica {
    private long id_raskrsnica;
    private String naziv;
    private String grad;

    public Raskrsnica(long id_raskrsnica, String naziv, String grad) {
        this.id_raskrsnica = id_raskrsnica;
        this.naziv = naziv;
        this.grad = grad;
    }

    public Raskrsnica(String naziv, String grad) {
        this.naziv = naziv;
        this.grad = grad;
    }

    public Raskrsnica(String grad) {
        this.grad = grad;
    }
    
    public Raskrsnica() {}

    public long getId_raskrsnica() {
        return id_raskrsnica;
    }

    public void setId_raskrsnica(long id_raskrsnica) {
        this.id_raskrsnica = id_raskrsnica;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Raskrsnica other = (Raskrsnica) obj;
        if (this.id_raskrsnica != other.id_raskrsnica) {
            return false;
        }
        if (!Objects.equals(this.naziv, other.naziv)) {
            return false;
        }
        return Objects.equals(this.grad, other.grad);
    }

    @Override
    public String toString() {
        return naziv;
    }
    
    
    
    
}
