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
public class Raskrsnica implements OpstaDomenskaKlasa{
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
    
    public Raskrsnica(long id) {
        this.id_raskrsnica = id;
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

    @Override
    public String getTableName() {
        return "raskrsnica";
    }

    @Override
    public String getColumnsForInsert() {
        return "naziv, grad";
    }

    @Override
    public String getValuesForInsert() {
        return "'"+this.naziv+"', '"+this.grad+"'";
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
        return "id="+this.id_raskrsnica;
    }

    @Override
    public String getValueForUpdate() {
        return "naziv='"+this.naziv+"', grad='"+this.grad+"'";
    }

    @Override
    public String getConditionForUpdate() {
        return "id="+this.id_raskrsnica;                 
    }

    @Override
    public String getConditionForFind(String s, OpstaDomenskaKlasa t2) {
        if(s.equals("jedan")){
            return "naziv='"+this.naziv+"'";
        }else if(s.equals("naziv")){
            return "grad='" + this.grad + "' AND naziv='"+this.naziv+"'";
        }else{
            return "grad='"+this.grad+"'";
        }
    }

    @Override
    public OpstaDomenskaKlasa getObject(ResultSet rs) throws Exception {
        long id=rs.getLong("raskrsnica.id");
        String naziv=rs.getString("raskrsnica.naziv");
        String grad=rs.getString("raskrsnica.grad");
        Raskrsnica r=new Raskrsnica();
        r.setId_raskrsnica(id);
        r.setNaziv(naziv);
        r.setGrad(grad);
        return r;
    }

    @Override
    public List<OpstaDomenskaKlasa> getList(ResultSet rs) throws Exception {
        List<OpstaDomenskaKlasa> list=new ArrayList<>();
        while(rs.next()){
            long id=rs.getLong("raskrsnica.id");
            String naziv=rs.getString("raskrsnica.naziv");
            String grad=rs.getString("raskrsnica.grad");
            Raskrsnica r=new Raskrsnica();
            r.setId_raskrsnica(id);
            r.setNaziv(naziv);
            r.setGrad(grad);
            list.add(r);
        }
        return list;
    }
    
    
    
    
}
