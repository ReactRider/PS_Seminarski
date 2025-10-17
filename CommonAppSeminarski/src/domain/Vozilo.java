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
public class Vozilo implements OpstaDomenskaKlasa{
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
    
    public Vozilo(){
        
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

    @Override
    public String getTableName() {
        return "vozilo";
    }

    @Override
    public String getColumnsForInsert() {
        return "reg_oznaka, marka, model, id_vlasnik";
    }

    @Override
    public String getValuesForInsert() {
        return "'"+this.reg_oznaka+"', '"+this.marka+"', '"+this.model+"', "+this.vlasnik.getId_vlasnik();
    }

    @Override
    public String getCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getJoinCondition() {
        return "vozilo v JOIN vlasnik vl ON v.id_vlasnik=vl.id";
    }

    @Override
    public String getConditionForDelete(OpstaDomenskaKlasa t) {
        if(this.id_vozilo!=null){
            return "id="+this.id_vozilo+" AND id_vlasnik="+this.vlasnik.getId_vlasnik();
        }else{
            return "id_vlasnik="+this.vlasnik.getId_vlasnik();
        }
    }

    @Override
    public String getValueForUpdate() {
        return "id_vlasnik="+this.vlasnik.getId_vlasnik();
    }

    @Override
    public String getConditionForUpdate() {
        return "id="+this.id_vozilo;
    }

    @Override
    public String getConditionForFind(String s, OpstaDomenskaKlasa t2) {
        if(s.equals("lista")){
            if(t2 instanceof Vlasnik){
                return "vl.grad='"+this.vlasnik.getGrad()+"'";
            }else{
                return "v.marka='"+this.marka+"'";
            }
        }else{
            return "v.reg_oznaka='"+this.reg_oznaka+"'";
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
            long id=rs.getLong("v.id");
            String registracija=rs.getString("v.reg_oznaka");
            String marka=rs.getString("v.marka");
            String model=rs.getString("v.model");
            Vlasnik vlasnik=new Vlasnik();
            long id_v=rs.getLong("v.id_vlasnik");
            String ime=rs.getString("vl.ime");
            String prezime=rs.getString("vl.prezime");
            String jmbg=rs.getString("vl.jmbg");
            String grad=rs.getString("vl.grad");
            vlasnik.setId_vlasnik(id_v);
            vlasnik.setIme(ime);
            vlasnik.setPrezime(prezime);
            vlasnik.setJmbg(jmbg);
            vlasnik.setGrad(grad);
            Vozilo vozilo=new Vozilo();
            vozilo.setId_vozilo(id);
            vozilo.setReg_oznaka(registracija);
            vozilo.setMarka(marka);
            vozilo.setModel(model);
            vozilo.setVlasnik(vlasnik);
            list.add(vozilo);
        }
        return list;
    }
    
}
