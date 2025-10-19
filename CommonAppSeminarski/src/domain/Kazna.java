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
public class Kazna implements OpstaDomenskaKlasa{
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
    
    public Kazna(){
        
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
        return naziv;
    }

    @Override
    public String getTableName() {
        return "kazna";
    }

    @Override
    public String getColumnsForInsert() {
        return "naziv,kategorija_kazne,iznos";
    }

    @Override
    public String getValuesForInsert() {
        return "'"+this.naziv+"', '"+this.kategorija+"', "+this.iznos;
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
        return "id="+this.id_kazna;
    }

    @Override
    public String getValueForUpdate() {
        return "naziv='"+this.naziv+"', kategorija_kazne='"+this.kategorija+"', iznos="+this.iznos;
    }

    @Override
    public String getConditionForUpdate() {
        return "id="+this.id_kazna;
    }

    @Override
    public String getConditionForFind(String s, OpstaDomenskaKlasa t2) {
        if(s.equals("jedan")){
            return "naziv='"+this.naziv+"'";
        }else if(s.equals("lista")){
            return "kategorija_kazne='"+this.kategorija+"'";
        }
        return "";
    }

    @Override
    public OpstaDomenskaKlasa getObject(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<OpstaDomenskaKlasa> getList(ResultSet rs) throws Exception {
        List<OpstaDomenskaKlasa> list=new ArrayList<>();
        while(rs.next()){
            String naziv=rs.getString("kazna.naziv");
            double iznos=rs.getDouble("kazna.iznos");
            long id=rs.getLong("kazna.id");
            KategorijaKazna kategorijaKaz=KategorijaKazna.valueOf(rs.getString("kazna.kategorija_kazne"));
            Kazna k=new Kazna(id, naziv, kategorijaKaz,iznos);
            list.add(k);
        }
        return list;
    }
    
    
    
}
