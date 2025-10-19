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
public class PolicijskaUprava implements OpstaDomenskaKlasa {
    private Long id;
    private String username;
    private String password;
    private String grad;
    private String opstina;
    private String adresa;
    private String policajac;
    
    public PolicijskaUprava(){
        
    }

    public PolicijskaUprava(Long id, String username, String password, String grad, String opstina, String adresa, String policajac) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.grad = grad;
        this.opstina = opstina;
        this.adresa = adresa;
        this.policajac=policajac;
    }

    public PolicijskaUprava(String username, String password, String grad, String opstina, String adresa, String policajac) {
        this.username = username;
        this.password = password;
        this.grad = grad;
        this.opstina = opstina;
        this.adresa = adresa;
        this.policajac = policajac;
    }

    public PolicijskaUprava(Long id, String username, String password, String adresa) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.adresa = adresa;
    }
    
    public PolicijskaUprava(String username) {
        this.username = username;
    }
    
    public PolicijskaUprava(String grad, int x) {
        this.grad = grad;
    }

    public PolicijskaUprava(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    
    public PolicijskaUprava(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public PolicijskaUprava(Long id) {
        this.id = id;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getOpstina() {
        return opstina;
    }

    public void setOpstina(String opstina) {
        this.opstina = opstina;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
    
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPolicajac() {
        return policajac;
    }

    public void setPolicajac(String policajac) {
        this.policajac = policajac;
    }

    
    @Override
    public String toString() {
        return username;
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
        final PolicijskaUprava other = (PolicijskaUprava) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.grad, other.grad)) {
            return false;
        }
        if (!Objects.equals(this.opstina, other.opstina)) {
            return false;
        }
        if (!Objects.equals(this.adresa, other.adresa)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String getTableName() {
        return "policijska_uprava";
    }

    @Override
    public String getColumnsForInsert() {
        return "username, password, grad, opstina, adresa, policajac";
    }

    @Override
    public String getValuesForInsert() {
        return "'"+this.username+"', '"+this.password+"', '"+this.grad+"', '"+this.opstina+"', '"+this.adresa+"', '"+this.policajac+"'";
    }

    @Override
    public String getJoinCondition() {
        return "policijska_uprava pu JOIN purask pr ON pu.id=pr.id_pu";
    }

    @Override
    public String getConditionForDelete(OpstaDomenskaKlasa t) {
        return "id="+this.id;
    }

    @Override
    public String getValueForUpdate() {
        return "username='"+this.username+"', password='"+this.password+"', adresa='"+this.adresa+"'";
    }

    @Override
    public String getConditionForUpdate() {
        return "id="+this.id;
    }

    @Override
    public String getConditionForFind(String s, OpstaDomenskaKlasa t2) {
        if(t2 instanceof Raskrsnica){
            if(s.equals("lista")){
                return "pr.id_raskrsnica="+((Raskrsnica) t2).getId_raskrsnica();
            }else{
                return "grad='"+this.grad+"'";
            }
        }else{
            return "username='"+this.username+"'";
        }
    }

    @Override
    public OpstaDomenskaKlasa getObject(ResultSet rs) throws Exception {
        long id = rs.getLong("policijska_uprava.id");
        String username = rs.getString("policijska_uprava.username");
        String password = rs.getString("policijska_uprava.password");
        String grad = rs.getString("policijska_uprava.grad");
        String opstina = rs.getString("policijska_uprava.opstina");
        String adresa = rs.getString("policijska_uprava.adresa");
        String policajac=rs.getString("policijska_uprava.policajac");

        return new PolicijskaUprava(id, username, password, grad, opstina, adresa, policajac);
    }

    @Override
    public List<OpstaDomenskaKlasa> getList(ResultSet rs) throws Exception {
        List<OpstaDomenskaKlasa> list=new ArrayList<>();
        while(rs.next()){
            long id=rs.getLong("policijska_uprava.id");
            String username = rs.getString("policijska_uprava.username");
            String password = rs.getString("policijska_uprava.password");
            String grad = rs.getString("policijska_uprava.grad");
            String opstina = rs.getString("policijska_uprava.opstina");
            String adresa = rs.getString("policijska_uprava.adresa");
            String policajac=rs.getString("policijska_uprava.policajac");
            PolicijskaUprava pu=new PolicijskaUprava(id, username, password, grad, opstina, adresa, policajac);
            list.add(pu);
        }
        return list;
    }

    @Override
    public String getCondition() {
        return "username='" + this.getUsername() + "' AND password='" + this.getPassword() + "'";
    }

    
    
    
    
}
