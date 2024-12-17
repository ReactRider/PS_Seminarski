/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table_models;

import controller.Controller;
import domain.*;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Stefan
 */
public class VlasnikTableModel extends AbstractTableModel {
    private String[] columns = {"Ime", "Prezime", "Grad", "JMBG"};
    private ArrayList<Vlasnik> vlasnici;
    
    public VlasnikTableModel() {
        this.vlasnici = Controller.getInstance().vratiListuSviVlasnik();
    }
    
    public VlasnikTableModel(Vlasnik v) {
        this.vlasnici = Controller.getInstance().vratiListuVlasnik(v);
    }
    
    @Override
    public String getColumnName(int index) {
        return columns[index];
    }
    
    @Override
    public int getRowCount() {
        return vlasnici.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vlasnik v = vlasnici.get(rowIndex);
        
        switch(columnIndex) {
            case 0:
                return v.getIme();
            case 1:
                return v.getPrezime();
            case 2:
                return v.getGrad();
            case 3:
                return v.getJmbg();
            default:
                return null;
        }
    }
    
    public Vlasnik get(int index) {
        if(index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        return vlasnici.get(index);
    }
    
}
