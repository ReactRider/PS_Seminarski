/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.*;
import java.util.ArrayList;
import domain.*;
import main.KategorijaKazna;

/**
 *
 * @author Stefan
 */

public class DBBroker {
    
    ////////////////////////////////////////////////////////////////////////////
    
    public EvidencijaKazni pretraziEvidencijaKazni(EvidencijaKazni ek) {
        String query = "SELECT * FROM evidencija_kazni where id_evidencija=" + ek.getId_evidencija();
        Connection conn = DBConnection.getInstance().getConnection();
        EvidencijaKazni evi_kaz = null;
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()) 
                evi_kaz = new EvidencijaKazni(rs.getLong(1), rs.getDouble(2), rs.getLong(3), rs.getLong(4), rs.getLong(5), rs.getDouble(6), ucitajPUPoID(rs.getLong(7)), ucitajVoziloPoID(rs.getLong(8)));
        } catch(Exception e) {
            System.out.println("Greska pri ucitavanju evidencije kazni!\n" + e.getMessage());
            return null;
        }

        return evi_kaz;
    }    
    
    public boolean kreirajEvidencijaKazni(EvidencijaKazni ek) {
        String query = "INSERT INTO evidencija_kazni (iznos_total, br_kazni_I_kat, br_kazni_II_kat, br_kazni_III_kat, bazni_ponder, id_pu, id_vozilo) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection conn = DBConnection.getInstance().getConnection();
        
        try {
            PreparedStatement pst = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            pst.setDouble(1, ek.getIznos_total());
            pst.setLong(2, ek.getBr_kazni_I());
            pst.setLong(3, ek.getBr_kazni_II());
            pst.setLong(4, ek.getBr_kazni_III());
            pst.setDouble(5, ek.getBazni_ponder());
            pst.setLong(6, ek.getPu().getId());
            pst.setLong(7, ek.getVozilo().getId_vozilo());
            pst.executeUpdate();
            
            ResultSet rs = pst.getGeneratedKeys();
            if(rs.next())
                ek.setId_evidencija(rs.getLong(1));
        } catch(Exception e) {
            System.out.println("Greska pri kreiranju evidencije kazni!\n" + e.getMessage());
            return false;
        }
        
        return true;
    }
    
    public boolean promeniEvidencijaKazni(EvidencijaKazni ek) {
        String query = "UPDATE evidencija_kazni SET iznos_total="+ek.getIznos_total()+ ", br_kazni_I_kat=" + ek.getBr_kazni_I() + ", br_kazni_II_kat=" + ek.getBr_kazni_II() + ", br_kazni_III_kat=" + ek.getBr_kazni_III() + ", bazni_ponder="+ ek.getBazni_ponder() + "WHERE id_evidencija="+ek.getId_evidencija();
        Connection conn = DBConnection.getInstance().getConnection();
        
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(query);
        } catch(Exception e) {
            System.out.println("Greska pri izmeni evidencije kazni!\n" + e.getMessage());
            return false;
        }
        
        return true;
    } 
    
    public ArrayList<Long> ucitajIDSEvidencija() {
        String query = "SELECT id_evidencija FROM evidencija_kazni";
        Connection conn = DBConnection.getInstance().getConnection();
        ArrayList<Long> ids = new ArrayList<Long>();
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()) 
                ids.add(rs.getLong(1));
            } catch(Exception e) {
            System.out.println("Greska pri ucitavanju svih id-jeva evidencija kazni.\n" + e.getMessage());
        }
        
        return ids;
    }
    
    public ArrayList<EvidencijaKazni> vratiListuEvidencijaKazni(EvidencijaKazni ek) {
        String query = "";
        ArrayList<EvidencijaKazni> evidencije = new ArrayList<EvidencijaKazni>();
        long id = ek.getId_evidencija();
        
        switch((int)id) {
            case 0:
                query = "SELECT * FROM evidencija_kazni WHERE iznos_total <= 250000";
            break;
            
            case 1:
                query = "SELECT * FROM evidencija_kazni WHERE iznos_total > 250000 AND iznos_total <= 500000";
            break;
            
            case 2:
                query = "SELECT * FROM evidencija_kazni WHERE iznos_total > 500000";
            break;
        }
        Connection conn = DBConnection.getInstance().getConnection();
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
        
            while(rs.next()){
                evidencije.add(new EvidencijaKazni(rs.getLong(1), rs.getDouble(2), rs.getLong(3), rs.getLong(4), rs.getLong(5), rs.getDouble(6), ucitajPUPoID(rs.getLong(7)), ucitajVoziloPoID(rs.getLong(8)) ));
            }
            
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
        return evidencije;
    }
    
    public ArrayList<EvidencijaKazni> vratiListuEvidencijaKazni(Kazna kazna) {
        String query = "SELECT evid_kaz.* FROM evidencija_kazni evid_kaz JOIN stavka_evidencije stav_evid ON evid_kaz.id_evidencija = stav_evid.id_evidencija WHERE id_kazna="+vratiKaznaId(kazna.getNaziv());
        Connection conn = DBConnection.getInstance().getConnection();
        ArrayList<EvidencijaKazni> evidencije = new ArrayList<EvidencijaKazni>();
        try {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        while(rs.next()){
            evidencije.add(new EvidencijaKazni(rs.getLong(1), rs.getDouble(2), rs.getLong(3), rs.getLong(4), rs.getLong(5), rs.getDouble(6), ucitajPUPoID(rs.getLong(7)), ucitajVoziloPoID(rs.getLong(8)) ));
        }
            
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
        return evidencije;
    }
    
    public ArrayList<EvidencijaKazni> vratiListuEvidencijaKazni(PolicijskaUprava pu) {
        String query = "SELECT evid_kaz.* FROM evidencija_kazni evid_kaz WHERE id_pu="+vratiPUId(pu.getUsername());
        Connection conn = DBConnection.getInstance().getConnection();
        ArrayList<EvidencijaKazni> evidencije = new ArrayList<EvidencijaKazni>();
        try {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        while(rs.next()){
            evidencije.add(new EvidencijaKazni(rs.getLong(1), rs.getDouble(2), rs.getLong(3), rs.getLong(4), rs.getLong(5), rs.getDouble(6), ucitajPUPoID(rs.getLong(7)), ucitajVoziloPoID(rs.getLong(8)) ));
        }
            
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
        return evidencije;
    }
    
    public ArrayList<EvidencijaKazni> vratiListuEvidencijaKazni(Vozilo v) {
        String query = "SELECT evid_kaz.* FROM evidencija_kazni evid_kaz WHERE id_vozilo="+vratiVoziloId(v.getReg_oznaka());
        Connection conn = DBConnection.getInstance().getConnection();
        ArrayList<EvidencijaKazni> evidencije = new ArrayList<EvidencijaKazni>();
        try {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        while(rs.next())
            evidencije.add(new EvidencijaKazni(rs.getLong(1), rs.getDouble(2), rs.getLong(3), rs.getLong(4), rs.getLong(5), rs.getDouble(6), ucitajPUPoID(rs.getLong(7)), ucitajVoziloPoID(rs.getLong(8)) ));
            
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
        return evidencije;
    }
    
    public boolean daLiPostojiEvidencija(PolicijskaUprava pu, Vozilo v) {
        String query = "SELECT * FROM evidencija_kazni WHERE id_pu=" + pu.getId() + " AND id_vozilo=" + v.getId_vozilo();
        Connection conn = DBConnection.getInstance().getConnection();
        EvidencijaKazni obj = null;
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()) 
                obj = new EvidencijaKazni(rs.getLong(1), rs.getDouble(2), rs.getLong(3), rs.getLong(4), rs.getLong(5), rs.getDouble(6), ucitajPUPoID(rs.getLong(7)), ucitajVoziloPoID(rs.getLong(8)));
        } catch(Exception e) {
            System.out.println("Greska pri proveri da li postoji evidencija kazni.\n" + e.getMessage());
        }
        
        if(obj == null)
            return false;
        return true;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    
    public ArrayList<PolicijskaUprava> vratiListuSviPolicijskaUprava() {
        String query = "SELECT * FROM policijska_uprava";
        Connection conn = DBConnection.getInstance().getConnection();
        ArrayList<PolicijskaUprava> uprave = new ArrayList<PolicijskaUprava>();
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()) 
                uprave.add(new PolicijskaUprava(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6) ));
        } catch(Exception e) {
            System.out.println("Greska pri ucitavanju policijskih uprava\n" + e.getMessage());
        }
        
        return uprave;
    }
    
    public PolicijskaUprava pretraziPolicijskaUprava(PolicijskaUprava pu) {
        String query = "SELECT * FROM policijska_uprava where username='"+pu.getUsername()+"'";
        Connection conn = DBConnection.getInstance().getConnection();
        PolicijskaUprava pol_uprava = null;
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()) 
                pol_uprava = new PolicijskaUprava(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
        } catch(Exception e) {
            System.out.println("Greska pri ucitavanju policijske uprave prema username-u!\n" + e.getMessage());
            return null;
        }

        return pol_uprava;
    }    
    
    public boolean kreirajPolicijskaUprava(PolicijskaUprava pu) {
        String query = "INSERT INTO policijska_uprava (username, password, grad, opstina, adresa) VALUES (?, ?, ?, ?, ?)";
        Connection conn = DBConnection.getInstance().getConnection();
        
        try {
            PreparedStatement pst = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, pu.getUsername());
            pst.setString(2, pu.getPassword());
            pst.setString(3, pu.getGrad());
            pst.setString(4, pu.getOpstina());
            pst.setString(5, pu.getAdresa());
            pst.executeUpdate();
            ResultSet rs = pst.getGeneratedKeys();
            if(rs.next())
                pu.setId(rs.getLong(1));
        } catch(Exception e) {
            System.out.println("Greska pri kreiranju policijske uprave!\n" + e.getMessage());
            return false;
        }
        
        return true;
    }
    
    public boolean promeniPolicijskaUprava(PolicijskaUprava pu) {
        String query = "UPDATE policijska_uprava SET username='" + pu.getUsername() + "', " + "password='" + pu.getPassword() + "', adresa='" + pu.getAdresa() + "' WHERE id="+pu.getId();
       
        Connection conn = DBConnection.getInstance().getConnection();
        
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(query);
        } catch(Exception e) {
            System.out.println("Greska pri izmeni policijske uprave!\n" + e.getMessage());
            return false;
        }
        
        return true;
    } 
    
    public boolean obrisiPolicijskaUprava(PolicijskaUprava pu) {
        if(obrisiPUIzPuRask(pu) && obrisiStavkeSaPuID(pu) && obrisiPUIzEvidencije(pu)) {
            String query = "DELETE FROM policijska_uprava WHERE id="+pu.getId();
            Connection conn = DBConnection.getInstance().getConnection();

            try {
                Statement st = conn.createStatement();
                st.executeUpdate(query);
            } catch(Exception e) {
                System.out.println("Greska pri brisanju policijske uprave!\n" + e.getMessage());
                return false;
            }
            return true;
        }
        return false;
    }
    
    public ArrayList<PolicijskaUprava> vratiListuPolicijskaUprava(PolicijskaUprava pu) {
        String query = "SELECT * FROM policijska_uprava WHERE grad='"+pu.getGrad()+"'";
        Connection conn = DBConnection.getInstance().getConnection();
        ArrayList<PolicijskaUprava> uprave = new ArrayList<PolicijskaUprava>();
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()) 
                uprave.add(new PolicijskaUprava( rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6) ) );
        } catch(Exception e) {
            System.out.println("Greska pri ucitavanju policijskih uprava prema gradu\n" + e.getMessage());
        }
        
        return uprave;
    
    }
    
    public ArrayList<PolicijskaUprava> vratiListuPolicijskaUprava(Raskrsnica r) {
        String query = "SELECT pu.* FROM policijska_uprava pu JOIN purask pr ON pu.id = pr.id_pu WHERE pr.id_rask="+vratiRaskrsnicaId(r.getNaziv()) ;
        Connection conn = DBConnection.getInstance().getConnection();
        ArrayList<PolicijskaUprava> uprave = new ArrayList<PolicijskaUprava>();
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()) 
                uprave.add(new PolicijskaUprava( rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6) ) );
        } catch(Exception e) {
            System.out.println("Greska pri ucitavanju policijskih uprava prema nazivu raskrsnice\n" + e.getMessage());
        }
        
        return uprave;
    
    }
    
    ////////////////////////////////////////////////////////////////////////////
    
    public ArrayList<Raskrsnica> vratiListuSviRaskrsnica() {
        String query = "SELECT * FROM raskrsnica";
        Connection conn = DBConnection.getInstance().getConnection();
        ArrayList<Raskrsnica> raskrsnice = new ArrayList<Raskrsnica>();
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()) 
                raskrsnice.add(new Raskrsnica(rs.getLong(1), rs.getString(2), rs.getString(3)) );
        } catch(Exception e) {
            System.out.println("Greska pri ucitavanju raskrsnica\n" + e.getMessage());
        }
        
        return raskrsnice;
    }
    
    public boolean ubaciRaskrsnica(Raskrsnica r) {
        String query = "INSERT INTO raskrsnica (naziv, grad) VALUES (?, ?)";
        Connection conn = DBConnection.getInstance().getConnection();
        
        try {
            PreparedStatement pst = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, r.getNaziv());
            pst.setString(2, r.getGrad());
            pst.executeUpdate();
            ResultSet rs = pst.getGeneratedKeys();
            if(rs.next())
                r.setId_raskrsnica(rs.getLong(1));
        } catch(Exception e) {
            System.out.println("Greska pri ubacivanju raskrsnice!\n" + e.getMessage());
            return false;
        }
        
        return true;
    }
    
    public Raskrsnica pretraziRaskrsnica(Raskrsnica r) {
        String query = "SELECT * FROM raskrsnica where naziv='"+r.getNaziv()+"'";
        Connection conn = DBConnection.getInstance().getConnection();
        Raskrsnica raskrsnica = null;
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()) 
                raskrsnica = new Raskrsnica(rs.getLong(1), rs.getString(2), rs.getString(3));
        } catch(Exception e) {
            System.out.println("Greska pri ucitavanju raskrsnice prema nazivu!\n" + e.getMessage());
            return null;
        }

        return raskrsnica;
    }    
    
    public boolean promeniRaskrsnica(Raskrsnica r) {
        String query = "UPDATE raskrsnica SET naziv='" + r.getNaziv() + "', grad='" + r.getGrad()+ "' WHERE id_raskrsnica="+r.getId_raskrsnica();
       
        Connection conn = DBConnection.getInstance().getConnection();
        
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(query);
        } catch(Exception e) {
            System.out.println("Greska pri izmeni raskrsnice!\n" + e.getMessage());
            return false;
        }
        
        return true;
    } 
    
    public boolean obrisiRaskrsnica(Raskrsnica r) {
        if(obrisiRaskrsnicuIzPuRask(r)) {
            String query = "DELETE FROM raskrsnica WHERE id_raskrsnica="+r.getId_raskrsnica();
            Connection conn = DBConnection.getInstance().getConnection();

            try {
                Statement st = conn.createStatement();
                st.executeUpdate(query);
            } catch(Exception e) {
                System.out.println("Greska pri brisanju raskrsnice!\n" + e.getMessage());
                return false;
            }
            return true;
        }
        return false;
    }
    
    public ArrayList<Raskrsnica> vratiListuRaskrsnica(Raskrsnica r) {
        String query = "SELECT * FROM raskrsnica WHERE grad='"+ r.getGrad() +"'";
        Connection conn = DBConnection.getInstance().getConnection();
        ArrayList<Raskrsnica> raskrsnice = new ArrayList<Raskrsnica>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
        
            while(rs.next())
                raskrsnice.add(new Raskrsnica(rs.getLong(1), rs.getString(2), rs.getString(3)));
        } catch(Exception e) {
            System.out.println("Greska pri ucitavanju svih raskrsnica odredjenog grada!\n" + e.getMessage());
        }
        
        return raskrsnice;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    
    public ArrayList<Kazna> vratiListuSviKazna() {
        String query = "SELECT * FROM kazna";
        Connection conn = DBConnection.getInstance().getConnection();
        ArrayList<Kazna> kazne = new ArrayList<Kazna>();
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()) 
                kazne.add(new Kazna(rs.getLong(1), rs.getString(2), KategorijaKazna.valueOf(rs.getString(3)), rs.getDouble(4)) );
        } catch(Exception e) {
            System.out.println("Greska pri ucitavanju kazni\n" + e.getMessage());
        }
        
        return kazne;
    }
    
    public Kazna pretraziKazna(Kazna k) {
        String query = "SELECT * FROM kazna where naziv='"+k.getNaziv()+"'";
        Connection conn = DBConnection.getInstance().getConnection();
        Kazna kazna = null;
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()) 
                kazna = new Kazna(rs.getLong(1), rs.getString(2), KategorijaKazna.valueOf(rs.getString(3)), rs.getDouble(4));
        } catch(Exception e) {
            System.out.println("Greska pri ucitavanju kazni prema nazivu!\n" + e.getMessage());
            return null;
        }

        return kazna;
    }    
    
    public boolean kreirajKazna(Kazna k) {
        String query = "INSERT INTO kazna (naziv, kategorija, iznos) VALUES (?, ?, ?)";
        Connection conn = DBConnection.getInstance().getConnection();
        
        try {
            PreparedStatement pst = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, k.getNaziv());
            pst.setString(2, String.valueOf(k.getKategorija()));
            pst.setDouble(3, k.getIznos());
            pst.executeUpdate();
            ResultSet rs = pst.getGeneratedKeys();
            if(rs.next())
                k.setId_kazna(rs.getLong(1));
        } catch(Exception e) {
            System.out.println("Greska pri kreiranju kazne!\n" + e.getMessage());
            return false;
        }
        
        return true;
    }
    
    public boolean promeniKazna(Kazna k) {
        String query = "UPDATE kazna SET naziv='" + k.getNaziv() + "', " + "kategorija='" + k.getKategorija()+ "', iznos="+k.getIznos() + " WHERE id_kazna="+k.getId_kazna();
       
        Connection conn = DBConnection.getInstance().getConnection();
        
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(query);
        } catch(Exception e) {
            System.out.println("Greska pri izmeni kazne!\n" + e.getMessage());
            return false;
        }
        
        return true;
    } 
    
    public boolean obrisiKazna(Kazna k) {
        String query = "DELETE FROM kazna WHERE id_kazna="+k.getId_kazna();
        Connection conn = DBConnection.getInstance().getConnection();
        
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(query);
        } catch(Exception e) {
            System.out.println("Greska pri brisanju kazne!\n" + e.getMessage());
            return false;
        }
        return true;
    }
    
    public ArrayList<Kazna> vratiListuKazna(Kazna k) {
        String query = "SELECT * FROM kazna WHERE kategorija='"+ k.getKategorija() +"'";
        Connection conn = DBConnection.getInstance().getConnection();
        ArrayList<Kazna> kazne = new ArrayList<Kazna>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
        
            while(rs.next())
                kazne.add(new Kazna(rs.getLong(1), rs.getString(2), KategorijaKazna.valueOf(rs.getString(3)), rs.getDouble(4)));
        } catch(Exception e) {
            System.out.println("Greska pri ucitavanju svih kazni odredjene kategorije!\n" + e.getMessage());
        }
        
        return kazne;
    }
    
    
    ////////////////////////////////////////////////////////////////////////////
  
    public ArrayList<Vozilo> vratiListuSviVozilo() {
        String query = "SELECT * FROM vozilo";
        Connection conn = DBConnection.getInstance().getConnection();
        ArrayList<Vozilo> vozila = new ArrayList<Vozilo>();
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()) 
                vozila.add(new Vozilo(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), ucitajVlasnikPoID(rs.getLong(5))));
            
        } catch(Exception e) {
            System.out.println("Greska pri ucitavanju vozila!\n" + e.getMessage());
            return null;
        }

        return vozila;
    }
    
    public ArrayList<Vozilo> vratiListuVozilo(Vlasnik v) {
        String query = "SELECT voz.* FROM vozilo voz JOIN vlasnik vlas ON voz.id_vlasnik = vlas.id_vlasnik WHERE vlas.grad='" + v.getGrad() + "'";
        Connection conn = DBConnection.getInstance().getConnection();
        ArrayList<Vozilo> vozila = new ArrayList<Vozilo>();
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()) 
                vozila.add(new Vozilo(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), ucitajVlasnikPoID(rs.getLong(5))));
            
        } catch(Exception e) {
            System.out.println("Greska pri ucitavanju vozila prema kriterijumu vlasnika!\n" + e.getMessage());
            return null;
        }

        return vozila;
    }
    
    public ArrayList<Vozilo> vratiListuVozilo(Vozilo v) {
        String query = "SELECT * FROM vozilo WHERE marka='" + v.getMarka() + "'";
        Connection conn = DBConnection.getInstance().getConnection();
        ArrayList<Vozilo> vozila = new ArrayList<Vozilo>();
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()) 
                vozila.add(new Vozilo(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), ucitajVlasnikPoID(rs.getLong(5))));
            
        } catch(Exception e) {
            System.out.println("Greska pri ucitavanju vozila prema kriterijumu marke!\n" + e.getMessage());
            return null;
        }

        return vozila;
    }
    
    public Vozilo pretraziVozilo(Vozilo v) {
        String query = "SELECT * FROM vozilo where reg_oznaka='"+v.getReg_oznaka()+"'";
        Connection conn = DBConnection.getInstance().getConnection();
        Vozilo vozilo = null;
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()) 
                vozilo = new Vozilo(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), ucitajVlasnikPoID(rs.getLong(5)));
        } catch(Exception e) {
            System.out.println("Greska pri ucitavanju vozila po registracionoj oznaci!\n" + e.getMessage());
            return null;
        }

        return vozilo;
    }    
    
    public boolean kreirajVozilo(Vozilo v) {
        String query = "INSERT INTO vozilo (reg_oznaka, marka, model, id_vlasnik) VALUES (?, ?, ?, ?)";
        Connection conn = DBConnection.getInstance().getConnection();
        
        try {
            PreparedStatement pst = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, v.getReg_oznaka());
            pst.setString(2, v.getMarka());
            pst.setString(3, v.getModel());
            pst.setLong(4, v.getVlasnik().getId_vlasnik());
            pst.executeUpdate();
            ResultSet rs = pst.getGeneratedKeys();
            if(rs.next())
                v.setId_vozilo(rs.getLong(1));
        } catch(Exception e) {
            System.out.println("Greska pri kreiranju vozila!\n" + e.getMessage());
            return false;
        }
        
        return true;
    }
    
    public boolean promeniVozilo(Vozilo v) {
        String query = "UPDATE vozilo SET id_vlasnik="+v.getVlasnik().getId_vlasnik() + " WHERE id_vozilo="+v.getId_vozilo();
        Connection conn = DBConnection.getInstance().getConnection();
        
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(query);
        } catch(Exception e) {
            System.out.println("Greska pri izmeni vozila!\n" + e.getMessage());
            return false;
        }
        
        return true;
    } 
     
    public boolean obrisiVozilo(Vozilo v) {
        String query = "";
        
        if(v.getId_vozilo() != null)
            query = "DELETE FROM vozilo WHERE id_vozilo="+v.getId_vozilo() + " AND id_vlasnik=" + v.getVlasnik().getId_vlasnik();
        else 
            query = "DELETE FROM vozilo WHERE id_vlasnik=" + v.getVlasnik().getId_vlasnik();
        
        Connection conn = DBConnection.getInstance().getConnection();
        
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(query);
        } catch(Exception e) {
            System.out.println("Greska pri brisanju vozila!\n" + e.getMessage());
            return false;
        }
        return true;
    }
   
    ////////////////////////////////////////////////////////////////////////////
     
    public ArrayList<Vlasnik> vratiListuSviVlasnik() {
        String query = "SELECT * FROM vlasnik";
        Connection conn = DBConnection.getInstance().getConnection();
        ArrayList<Vlasnik> vlasnici = new ArrayList<Vlasnik>();
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next())
                vlasnici.add(new Vlasnik(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)) );
        } catch(Exception e) {
            System.out.println("Greska pri ucitavanju vlasnika\n" + e.getMessage());
        }
        
        return vlasnici;
    }
    
    public ArrayList<Vlasnik> vratiListuVlasnik(Vlasnik v) {
        String query = "SELECT * FROM vlasnik WHERE grad='"+v.getGrad()+"'";
        Connection conn = DBConnection.getInstance().getConnection();
        ArrayList<Vlasnik> vlasnici = new ArrayList<Vlasnik>();
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next())
                vlasnici.add(new Vlasnik(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)) );
        } catch(Exception e) {
            System.out.println("Greska pri ucitavanju vlasnika prema gradu\n" + e.getMessage());
        }
        
        return vlasnici;
    }
    
    public Vlasnik pretraziVlasnik(Vlasnik v) {
        String query = "SELECT * FROM vlasnik where jmbg='"+v.getJmbg()+"'";
        Connection conn = DBConnection.getInstance().getConnection();
        Vlasnik vlasnik = null;
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()) 
                vlasnik = new Vlasnik(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
        } catch(Exception e) {
            System.out.println("Greska pri ucitavanju vlasnika prema JMBG!\n" + e.getMessage());
            return null;
        }

        return vlasnik;
    }    
    
    public boolean kreirajVlasnik(Vlasnik v) {
        String query = "INSERT INTO vlasnik (ime, prezime, jmbg, grad) VALUES (?, ?, ?, ?)";
        Connection conn = DBConnection.getInstance().getConnection();
        
        try {
            PreparedStatement pst = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, v.getIme());
            pst.setString(2, v.getPrezime());
            pst.setString(3, v.getJmbg());
            pst.setString(4, v.getGrad());
            pst.executeUpdate();
            ResultSet rs = pst.getGeneratedKeys();
            if(rs.next())
                v.setId_vlasnik(rs.getLong(1));
        } catch(Exception e) {
            System.out.println("Greska pri kreiranju vlasnika!\n" + e.getMessage());
            return false;
        }
        
        return true;
    }
    
    public boolean promeniVlasnik(Vlasnik v) {
        String query = "UPDATE vlasnik SET ime='" + v.getIme() + "', prezime='" + v.getPrezime() + "', grad='" + v.getGrad() + "' WHERE id_vlasnik="+v.getId_vlasnik();
       
        Connection conn = DBConnection.getInstance().getConnection();
        
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(query);
        } catch(Exception e) {
            System.out.println("Greska pri izmeni vlasnika!\n" + e.getMessage());
            return false;
        }
        
        return true;
    } 
    
    public boolean obrisiVlasnik(Vlasnik v) {
        String query = "DELETE FROM vlasnik WHERE id_vlasnik="+v.getId_vlasnik();
        Connection conn = DBConnection.getInstance().getConnection();
        
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(query);
            obrisiVozilo(new Vozilo(v));
        } catch(Exception e) {
            System.out.println("Greska pri brisanju vlasnika!\n" + e.getMessage());
            return false;
        }
        return true;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    
    public PolicijskaUprava prijaviPolicijskaUprava(String username, String password) {
        String query = "SELECT * FROM policijska_uprava WHERE username='"+ username + "' AND password='"+ password +"'";
        Connection conn = DBConnection.getInstance().getConnection();
        PolicijskaUprava pu_temp = null;
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()) 
                pu_temp = new PolicijskaUprava(rs.getLong(1), rs.getString(2), rs.getString(3));
        } catch(Exception e) {
            System.out.println("Greska pri log in-u korisnika!\n" + e.getMessage());
        }
        return pu_temp;
    }

    public Vlasnik ucitajVlasnikPoID(long id) {
        String query = "SELECT * FROM vlasnik where id_vlasnik="+id;
        Connection conn = DBConnection.getInstance().getConnection();
        Vlasnik vlasnik = null;
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()) 
                vlasnik = new Vlasnik(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
        } catch(Exception e) {
            System.out.println("Greska pri ucitavanju vlasnika po ID!\n" + e.getMessage());
            return null;
        }

        return vlasnik;
    }

    public Vozilo ucitajVoziloPoID(long id) {
        String query = "SELECT * FROM vozilo where id_vozilo="+id;
        Connection conn = DBConnection.getInstance().getConnection();
        Vozilo vozilo = null;
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()) 
                vozilo = new Vozilo(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), ucitajVlasnikPoID(rs.getLong(5)));
        } catch(Exception e) {
            System.out.println("Greska pri ucitavanju vozila po ID!\n" + e.getMessage());
            return null;
        }

        return vozilo;
    }
    
    public PolicijskaUprava ucitajPUPoID(long id) {
        String query = "SELECT * FROM policijska_uprava where id="+id;
        Connection conn = DBConnection.getInstance().getConnection();
        PolicijskaUprava pu = null;
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()) 
                pu = new PolicijskaUprava(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
        } catch(Exception e) {
            System.out.println("Greska pri ucitavanju policijske uprave po ID!\n" + e.getMessage());
            return null;
        }

        return pu;
    }
    
    public boolean daLiPostojiRaskrsnica(String naziv, String grad) {
        String query = "SELECT * FROM raskrsnica WHERE naziv='" + naziv + "'";
        Connection conn = DBConnection.getInstance().getConnection();
        Raskrsnica r = null;
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()) 
                r = new Raskrsnica(rs.getLong(1), rs.getString(2), rs.getString(3));
        } catch(Exception e) {
            System.out.println("Greska pri proveri da li postoji raskrsnica.\n" + e.getMessage());
        }
        
        if(r == null)
            return false;
        
        return true;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    
    public boolean obrisiRaskrsnicuIzPuRask(Raskrsnica r) {
        String query = "DELETE FROM purask WHERE id_rask=" + r.getId_raskrsnica();
        Connection conn = DBConnection.getInstance().getConnection();
        
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(query);
        } catch(Exception e) {
            System.out.println("Greska pri brisanju raskrsnice iz asocijativne klase!\n" + e.getMessage());
            return false;
        }
        return true;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    
    public boolean obrisiPUIzPuRask(PolicijskaUprava pu) {
        String query = "DELETE FROM purask WHERE id_pu=" + pu.getId();
        Connection conn = DBConnection.getInstance().getConnection();
        
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(query);
        } catch(Exception e) {
            System.out.println("Greska pri brisanju policijske uprave iz asocijativne klase!\n" + e.getMessage());
            return false;
        }
        return true;
    }
    
    public boolean obrisiPUIzEvidencije(PolicijskaUprava pu) {
        String query = "DELETE FROM evidencija_kazni WHERE id_pu=" + pu.getId();
        Connection conn = DBConnection.getInstance().getConnection();
        
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(query);
        } catch(Exception e) {
            System.out.println("Greska pri brisanju policijske uprave iz evidencije kazni!\n" + e.getMessage());
            return false;
        }
        return true;
    }
    
    public long[] uzmiIDEvidencijeSaPUID(PolicijskaUprava pu) {
        String query = "SELECT id_evidencija FROM evidencija_kazni WHERE id_pu=" + pu.getId();
        Connection conn = DBConnection.getInstance().getConnection();
        long[] ids = new long[512];
        int counter = 0;
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
                ids[counter++] = rs.getLong(1);
        } catch(Exception e) {
            System.out.println("Greska!\n" + e.getMessage());
        }
        
        return ids;
    }
    
    public boolean obrisiStavkeSaPuID(PolicijskaUprava pu) {
        long[] ids = uzmiIDEvidencijeSaPUID(pu);
        String query = "DELETE FROM stavka_evidencije WHERE id_evidencija=";
        Connection conn = DBConnection.getInstance().getConnection();
        
        try {
            Statement st = conn.createStatement();
            for(int i = 0; i < ids.length; i++)
                st.executeUpdate(query + ids[i]);
        } catch(Exception e) {
            System.out.println("Greska pri brisanju stavki evidencija!\n" + e.getMessage());
            return false;
        }
        return true;
    }
    
    public boolean daLiPostojiPU(PolicijskaUprava pu) {
        String query = "SELECT * FROM policijska_uprava WHERE username='" + pu.getUsername() + "' OR (adresa='" + pu.getAdresa() + "' AND grad='" + pu.getGrad() + "')" + " OR (grad='" + pu.getGrad() + "' AND opstina='" + pu.getOpstina() + "')";
        Connection conn = DBConnection.getInstance().getConnection();
        PolicijskaUprava pol_upr = null;
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()) 
                pol_upr = new PolicijskaUprava(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
        } catch(Exception e) {
            System.out.println("Greska pri proveri da li postoji policijska uprava.\n" + e.getMessage());
        }
        
        if(pol_upr == null)
            return false;
        
        return true;
    }
    
    public boolean puusernameok(String username) {
        String query = "SELECT * FROM policijska_uprava WHERE username='"+ username+"'";
        Connection conn = DBConnection.getInstance().getConnection();
        PolicijskaUprava pol_upr = null;
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()) 
                pol_upr = new PolicijskaUprava(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
        } catch(Exception e) {
            System.out.println("Greska pri proveri da li postoji policijska uprava prema username-u.\n" + e.getMessage());
        }
        
        if(pol_upr == null)
            return true;
        
        return false;
    }
    
    public boolean puadresaok(String adresa, String grad) {
        String query = "SELECT * FROM policijska_uprava WHERE adresa='"+ adresa+"' AND grad='" + grad +"'";
        Connection conn = DBConnection.getInstance().getConnection();
        PolicijskaUprava pol_upr = null;
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()) 
                pol_upr = new PolicijskaUprava(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
        } catch(Exception e) {
            System.out.println("Greska pri proveri da li postoji policijska uprava prema adresi i gradu.\n" + e.getMessage());
        }
        
        if(pol_upr == null)
            return true;
        
        return false;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    
    public long vratiVoziloId(String registracija) {
        String query = "SELECT id_vozilo FROM vozilo WHERE reg_oznaka='"+registracija+"'";
        Connection conn = DBConnection.getInstance().getConnection();
        long id = 0;
        
        try {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        while(rs.next())
            id = rs.getLong(1);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
        return id;
    }
    
    public long vratiPUId(String naziv) {
        String query = "SELECT id FROM policijska_uprava WHERE username='"+naziv+"'";
        Connection conn = DBConnection.getInstance().getConnection();
        long id = 0;
        
        try {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        while(rs.next())
            id = rs.getLong(1);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
        return id;
    }
    
    public long vratiKaznaId(String naziv) {
        String query = "SELECT id_kazna FROM kazna WHERE naziv='"+naziv+"'";
        Connection conn = DBConnection.getInstance().getConnection();
        long id = 0;
        
        try {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        while(rs.next())
            id = rs.getLong(1);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
        return id;
    }
    
    public String vratiKaznaNaziv(long id) {
        String query = "SELECT naziv FROM kazna WHERE id_kazna="+id;
        Connection conn = DBConnection.getInstance().getConnection();
        String s = "";
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while(rs.next())
                s = rs.getString(1);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
        return s;
    }
    
    public long vratiRaskrsnicaId(String naziv) {
        String query = "SELECT id_raskrsnica FROM raskrsnica WHERE naziv='"+naziv+"'";
        Connection conn = DBConnection.getInstance().getConnection();
        long id = 0;
        
        try {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        while(rs.next())
            id = rs.getLong(1);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
        return id;
    }
    
    public ArrayList<String> ucitajKazne() {
        String query = "SELECT naziv FROM kazna";
        Connection conn = DBConnection.getInstance().getConnection();
        ArrayList<String> nazivi = new ArrayList<String>();
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()) 
                nazivi.add(rs.getString(1));
            } catch(Exception e) {
            System.out.println("Greska pri ucitavanju svih naziva kazni.\n" + e.getMessage());
        }
        
        return nazivi;
    }
    
    public ArrayList<String> ucitajPU() {
        String query = "SELECT username FROM policijska_uprava";
        Connection conn = DBConnection.getInstance().getConnection();
        ArrayList<String> nazivi = new ArrayList<String>();
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()) 
                nazivi.add(rs.getString(1));
            } catch(Exception e) {
            System.out.println("Greska pri ucitavanju svih naziva policijskih upravi.\n" + e.getMessage());
        }
        
        return nazivi;
    }
    
    public ArrayList<String> ucitajGradove() {
        String query = "SELECT DISTINCT grad FROM raskrsnica";
        Connection conn = DBConnection.getInstance().getConnection();
        ArrayList<String> gradovi = new ArrayList<String>();
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()) 
                gradovi.add(rs.getString(1));
            } catch(Exception e) {
            System.out.println("Greska pri ucitavanju svih gradova.\n" + e.getMessage());
        }
        
        return gradovi;
    }
    
    public ArrayList<String> ucitajRaskrsnice() {
        String query = "SELECT naziv FROM raskrsnica";
        Connection conn = DBConnection.getInstance().getConnection();
        ArrayList<String> raskrsnice = new ArrayList<String>();
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()) 
                raskrsnice.add(rs.getString(1));
            } catch(Exception e) {
            System.out.println("Greska pri ucitavanju svih gradova.\n" + e.getMessage());
        }
        
        return raskrsnice;
    }
    
    public ArrayList<String> ucitajMarke() {
        String query = "SELECT DISTINCT marka FROM vozilo";
        Connection conn = DBConnection.getInstance().getConnection();
        ArrayList<String> marke = new ArrayList<String>();
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()) 
                marke.add(rs.getString(1));
            } catch(Exception e) {
            System.out.println("Greska pri ucitavanju svih marki vozila.\n" + e.getMessage());
        }
        
        return marke;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    public boolean kreirajStavkaEvidencije(StavkaEvidencije se) {
        if(daLiPostojiStavkaEvidencije(se))
            return false;
        
        String query = "INSERT INTO stavka_evidencije (id_evidencija, id_kazna, iznos, kategorija_kazne) VALUES (?, ?, ?, ?)";
        Connection conn = DBConnection.getInstance().getConnection();
        
        try {
            PreparedStatement pst = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pst.setLong(1, se.getEvidencija().getId_evidencija());
            pst.setLong(2, se.getKazna().getId_kazna());
            pst.setDouble(3, se.getIznos());
            pst.setString(4, String.valueOf(se.getKategorija_kazne()));
            pst.executeUpdate();
            ResultSet rs = pst.getGeneratedKeys();
            if(rs.next())
                se.setRb(rs.getLong(1));
        } catch(Exception e) {
            System.out.println("Greska pri kreiranju stavke evidencije!\n" + e.getMessage());
            return false;
        }
        
        return true;
    }
    
    public boolean daLiPostojiStavkaEvidencije(StavkaEvidencije se) {
        String query = "SELECT * FROM stavka_evidencije WHERE id_evidencija=" + se.getEvidencija().getId_evidencija() + " AND id_kazna=" + se.getKazna().getId_kazna();
        Connection conn = DBConnection.getInstance().getConnection();
        StavkaEvidencije obj = null;
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()) 
                obj = new StavkaEvidencije(rs.getLong(1), new EvidencijaKazni(rs.getLong(2)), new Kazna(rs.getLong(3)), rs.getDouble(4), KategorijaKazna.valueOf(rs.getString(5)));
        } catch(Exception e) {
            System.out.println("Greska pri proveri da li postoji stavka evidencije.\n" + e.getMessage());
        }
        
        if(obj == null)
            return false;
        
        return true;
    }
    
    public ArrayList<StavkaEvidencije> vratiListuSviStavkeEvidencije(EvidencijaKazni evid) {
        String query = "SELECT * FROM stavka_evidencije WHERE id_evidencija=" + evid.getId_evidencija();
        Connection conn = DBConnection.getInstance().getConnection();
        ArrayList<StavkaEvidencije> stavke = new ArrayList<StavkaEvidencije>();
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()) 
                stavke.add(new StavkaEvidencije(rs.getLong(1), new EvidencijaKazni(rs.getLong(2)), new Kazna(vratiKaznaNaziv(rs.getLong(3))), rs.getDouble(4), KategorijaKazna.valueOf(rs.getString(5))));
        } catch(Exception e) {
            System.out.println("Greska pri ucitavnju svih stavki evidencija!\n" + e.getMessage());
        }
        
        return stavke;
    }
}

