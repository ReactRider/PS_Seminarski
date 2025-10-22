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
public class EvidencijaKazni implements OpstaDomenskaKlasa{
    private Long id_evidencija;
    private double iznos_total;
    private Long br_kazni_I;
    private Long br_kazni_II;
    private Long br_kazni_III;
    private double bazni_ponder;
    private PolicijskaUprava pu;
    private Vozilo vozilo;
    private List<StavkaEvidencije> stavke_ev;
    

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
        this.iznos_total = this.bazni_ponder * ( this.br_kazni_I * 75000 + this.br_kazni_II * 50000 + this.br_kazni_III * 25000);
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

    public List<StavkaEvidencije> getStavke_ev() {
        return stavke_ev;
    }

    public void setStavke_ev(List<StavkaEvidencije> stavke_ev) {
        this.stavke_ev = stavke_ev;
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

    @Override
    public String getTableName() {
        return "evidencija_kazni";
    }

    @Override
    public String getColumnsForInsert() {
        return "iznos_total, br_kazni_I, br_kazni_II, br_kazni_III, bazni_ponder, id_pu, id_vozilo";
    }

    @Override
    public String getValuesForInsert() {
        return this.iznos_total+", "+this.br_kazni_I+", "+this.br_kazni_II+", "+this.br_kazni_III+", "+this.bazni_ponder+", "+this.pu.getId()+", "+this.vozilo.getId_vozilo();
    }

    @Override
    public String getCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getJoinCondition() {
        return "evidencija_kazni ek JOIN policijska_uprava pu ON ek.id_pu = pu.id JOIN vozilo v ON ek.id_vozilo = v.id JOIN vlasnik vl ON v.idVlasnik=vl.id JOIN stavka_evidencije se ON ek.idEvidencija = se.idEvidencije JOIN raskrsnica r ON se.idRaskrsnice = r.id";
    }

    @Override
    public String getConditionForDelete(OpstaDomenskaKlasa t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getValueForUpdate() {
        this.setIznos_total();
        return "br_kazni_I = " + this.getBr_kazni_I() + ", br_kazni_II=" + this.getBr_kazni_II() + ", br_kazni_III = " + this.getBr_kazni_III() + ", iznos_total = " + this.getIznos_total() ;
    }

    @Override
    public String getConditionForUpdate() {
        return "idEvidencija = " + this.getId_evidencija();
    }

    @Override
    public String getConditionForFind(String s, OpstaDomenskaKlasa t2) {
        if(t2 == null && s.equals("pretraga")) 
            return "ek.id_pu = " + this.getPu().getId() + " AND ek.id_vozilo = " + this.getVozilo().getId_vozilo();
        
        if(t2 == null) {
            long num = this.getId_evidencija();
            if(num == 0) 
                return "ek.iznos_total <= 200000";
            else if(num == 1) 
                return "ek.iznos_total > 200000 AND ek.iznos_total <= 400000";
            else if(num == 2) 
                return "ek.iznos_total > 400000";
        } else if(t2 instanceof PolicijskaUprava) {
            return "pu.username='" + ((PolicijskaUprava)t2).getUsername() + "'";
        } else if(t2 instanceof Vozilo) {
            return "v.reg_oznaka='" + ((Vozilo)t2).getReg_oznaka() + "'";
        } else if(t2 instanceof Kazna) {
            return "se.idKazne=" + ((Kazna)t2).getId_kazna();
        } 
        
        return "bubicaa<3";
    }

    @Override
    public OpstaDomenskaKlasa getObject(ResultSet rs) throws Exception {
        long id_ek=rs.getLong("ek.idEvidencija");
            double iznos_total=rs.getDouble("ek.iznos_total");
            double ponder=rs.getDouble("ek.bazni_ponder");
            long brKazniI=rs.getInt("ek.br_kazni_I");
            long brKazniII=rs.getInt("ek.br_kazni_II");
            long brKazniIII=rs.getInt("ek.br_kazni_III");
            long id_pu=rs.getLong("pu.id");
            long id_v=rs.getLong("v.id");
            String username = rs.getString("pu.username");
            String password = rs.getString("pu.password");
            String grad_pu = rs.getString("pu.grad");
            String opstina = rs.getString("pu.opstina");
            String adresa = rs.getString("pu.adresa");
            String policajac=rs.getString("pu.policajac");
            PolicijskaUprava pu=new PolicijskaUprava(id_pu, username, password, grad_pu, opstina, adresa, policajac);
            String registracija=rs.getString("v.reg_oznaka");
            String marka=rs.getString("v.marka");
            String model=rs.getString("v.model");
            Vlasnik vlasnik=new Vlasnik();
            long id_vlasnik=rs.getLong("vl.id");
            String ime=rs.getString("vl.ime");
            String prezime=rs.getString("vl.prezime");
            String jmbg=rs.getString("vl.jmbg");
            String grad_vlasnik=rs.getString("vl.grad");
            vlasnik.setId_vlasnik(id_vlasnik);
            vlasnik.setIme(ime);
            vlasnik.setPrezime(prezime);
            vlasnik.setJmbg(jmbg);
            vlasnik.setGrad(grad_vlasnik);
            Vozilo vozilo=new Vozilo();
            vozilo.setId_vozilo(id_v);
            vozilo.setReg_oznaka(registracija);
            vozilo.setMarka(marka);
            vozilo.setModel(model);
            vozilo.setVlasnik(vlasnik);
            EvidencijaKazni evidencija=new EvidencijaKazni();
            evidencija.setId_evidencija(id_ek);
            evidencija.setBazni_ponder(ponder);
            evidencija.setBr_kazni_I(brKazniI);
            evidencija.setBr_kazni_II(brKazniII);
            evidencija.setBr_kazni_III(brKazniIII);
            evidencija.setIznos_total();
            evidencija.setPu(pu);
            evidencija.setVozilo(vozilo);
            return evidencija;
    }

    @Override
    public List<OpstaDomenskaKlasa> getList(ResultSet rs) throws Exception {
        List<OpstaDomenskaKlasa> list=new ArrayList<>();
        while(rs.next()){
            //ek je evidencija_kacni, pu je policijska_uprava, v je vozilo, vl je vlasnik
            long id_ek=rs.getLong("ek.idEvidencija");
            double iznos_total=rs.getDouble("ek.iznos_total");
            double ponder=rs.getDouble("ek.bazni_ponder");
            long brKazniI=rs.getInt("ek.br_kazni_I");
            long brKazniII=rs.getInt("ek.br_kazni_II");
            long brKazniIII=rs.getInt("ek.br_kazni_III");
            long id_pu=rs.getLong("pu.id");
            long id_v=rs.getLong("v.id");
            String username = rs.getString("pu.username");
            String password = rs.getString("pu.password");
            String grad_pu = rs.getString("pu.grad");
            String opstina = rs.getString("pu.opstina");
            String adresa = rs.getString("pu.adresa");
            String policajac=rs.getString("pu.policajac");
            PolicijskaUprava pu=new PolicijskaUprava(id_pu, username, password, grad_pu, opstina, adresa, policajac);
            String registracija=rs.getString("v.reg_oznaka");
            String marka=rs.getString("v.marka");
            String model=rs.getString("v.model");
            Vlasnik vlasnik=new Vlasnik();
            long id_vlasnik=rs.getLong("vl.id");
            String ime=rs.getString("vl.ime");
            String prezime=rs.getString("vl.prezime");
            String jmbg=rs.getString("vl.jmbg");
            String grad_vlasnik=rs.getString("vl.grad");
            vlasnik.setId_vlasnik(id_vlasnik);
            vlasnik.setIme(ime);
            vlasnik.setPrezime(prezime);
            vlasnik.setJmbg(jmbg);
            vlasnik.setGrad(grad_vlasnik);
            Vozilo vozilo=new Vozilo();
            vozilo.setId_vozilo(id_v);
            vozilo.setReg_oznaka(registracija);
            vozilo.setMarka(marka);
            vozilo.setModel(model);
            vozilo.setVlasnik(vlasnik);
            EvidencijaKazni evidencija=new EvidencijaKazni();
            evidencija.setId_evidencija(id_ek);
            evidencija.setBazni_ponder(ponder);
            evidencija.setBr_kazni_I(brKazniI);
            evidencija.setBr_kazni_II(brKazniII);
            evidencija.setBr_kazni_III(brKazniIII);
            evidencija.setIznos_total();
            evidencija.setPu(pu);
            evidencija.setVozilo(vozilo);
            list.add(evidencija);
        }
        return list;
    }
    
    
}
