/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Stefan
 */
public class Vlasnik implements OpstaDomenskaKlasa{
    private Long id_vlasnik;
    private String ime;
    private String prezime;
    private String jmbg;
    private String grad;
    
    public Vlasnik(Long id_vlasnik, String ime, String prezime, String jmbg, String grad) {
        this.id_vlasnik = id_vlasnik;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.grad = grad;
    }

    public Vlasnik(String ime, String prezime, String jmbg, String grad) {
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.grad = grad;
    }

    public Vlasnik(Long id_vlasnik, String ime, String prezime, String grad) {
        this.id_vlasnik = id_vlasnik;
        this.ime = ime;
        this.prezime = prezime;
        this.grad = grad;
    }
    
    public Vlasnik(String jmbg) {
        this.jmbg = jmbg;
    }
    
    public Vlasnik(String grad, int x) {
        this.grad = grad;
    }

    public Vlasnik(Long id_vlasnik) {
        this.id_vlasnik = id_vlasnik;
    }
    
    public Vlasnik() {}
    
    
    
    public Long getId_vlasnik() {
        return id_vlasnik;
    }

    public void setId_vlasnik(Long id_vlasnik) {
        this.id_vlasnik = id_vlasnik;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }
    
    @Override
    public String toString() {
        return ime + " " + prezime;
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
        final Vlasnik other = (Vlasnik) obj;
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.prezime, other.prezime)) {
            return false;
        }
        if (!Objects.equals(this.jmbg, other.jmbg)) {
            return false;
        }
        if (!Objects.equals(this.grad, other.grad)) {
            return false;
        }
        return Objects.equals(this.id_vlasnik, other.id_vlasnik);
    }

    @Override
    public String getTableName() {
        return "vlasnik";
    }

    @Override
    public String getColumnsForInsert() {
        return "ime, prezime, jmbg, grad";
    }

    @Override
    public String getValuesForInsert() {
        return "'"+this.ime+"', '"+this.prezime+"', '"+this.jmbg+"', '"+this.grad+"'";
    }

    @Override
    public String getCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getJoinCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getConditionForDelete(OpstaDomenskaKlasa t) {
        return "id="+this.id_vlasnik;
    }

    @Override
    public String getValueForUpdate() {
        return "ime='"+this.ime+"', prezime='"+this.prezime+"', grad='"+this.grad+"'";
    }

    @Override
    public String getConditionForUpdate() {
        return "id="+this.id_vlasnik;
    }

    @Override
    public String getConditionForFind(String s, OpstaDomenskaKlasa t2) {
        if(s.equals("jedan")){
            return "jmbg='"+this.jmbg+"'";
        }else{
            return "grad='"+this.grad+"'";
        }
    }

    @Override
    public OpstaDomenskaKlasa getObject(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<OpstaDomenskaKlasa> getList(ResultSet rs) throws Exception {
        List<OpstaDomenskaKlasa> list=new ArrayList<>();
        while(rs.next()){
            long id=rs.getLong("vlasnik.id");
            String ime=rs.getString("vlasnik.ime");
            String prezime=rs.getString("vlasnik.prezime");
            String jmbg=rs.getString("vlasnik.jmbg");
            String grad=rs.getString("vlasnik.grad");
            Vlasnik v=new Vlasnik();
            v.setId_vlasnik(id);
            v.setIme(ime);
            v.setPrezime(prezime);
            v.setJmbg(jmbg);
            v.setGrad(grad);
            list.add(v);
        }
        return list;
        
    }

}
