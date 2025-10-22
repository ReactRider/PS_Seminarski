/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table_models;

import javax.swing.table.AbstractTableModel;
import java.util.*;
import domain.*;
import controller.Controller;

/**
 *
 * @author Stefan
 */
public class PUTableModel extends AbstractTableModel {
    String[] columns = {"naziv", "grad", "opstina", "adresa"};
    List<PolicijskaUprava> uprave;
    
    public PUTableModel() throws Exception{
        try{
            this.uprave = Controller.getInstance().vratiListuSviPolicijskaUprava();
        }catch(Exception e){
            throw new Exception("Greska pri ucitavanju liste!");
        }
    }
    
    public PUTableModel(PolicijskaUprava pu) throws Exception{
        try{
            this.uprave = Controller.getInstance().vratiListuPolicijskaUprava(pu);
        }catch(Exception e){
            throw new Exception("Greska pri ucitavanju liste!");
        }
    }
    
    public PUTableModel(Raskrsnica r) throws Exception{
        try{
            this.uprave = Controller.getInstance().vratiListuPolicijskaUprava(r);
        }catch(Exception e){
            throw new Exception("Greska pri ucitavanju liste!");
        }
    }
    
    
    @Override
    public int getRowCount() {
        return uprave.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }
    
    @Override
    public String getColumnName(int index) {
        return columns[index];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       PolicijskaUprava pu = uprave.get(rowIndex);
       
       switch(columnIndex) {
           case 0:
               return pu.getUsername();
           case 1:
               return pu.getGrad();
           case 2:
               return pu.getOpstina();
           case 3:
                  return pu.getAdresa();
           default:
               return null;
       }
    }
    
    public PolicijskaUprava get(int index) {
        if(index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        return uprave.get(index);
    }
    
}
