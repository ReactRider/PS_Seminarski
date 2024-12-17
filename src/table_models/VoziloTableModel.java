/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table_models;

import controller.Controller;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import domain.*;

/**
 *
 * @author Stefan
 */
public class VoziloTableModel extends AbstractTableModel {
    
    private ArrayList<Vozilo> vozila;
    private String[] columns = {"Marka", "Model", "Registraciona oznaka", "Vlasnik"};

    public VoziloTableModel() {
        this.vozila = Controller.getInstance().vratiListuSviVozilo();
    }
    
    public VoziloTableModel(Vlasnik v) {
        this.vozila = Controller.getInstance().vratiListuVozilo(v);
    }
    
    public VoziloTableModel(Vozilo v) {
        this.vozila = Controller.getInstance().vratiListuVozilo(v);
    }
    
    @Override
    public int getRowCount() {
        return vozila.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }
    
    @Override
    public String getColumnName(int index){
        return columns[index];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vozilo v = vozila.get(rowIndex);
        
        switch(columnIndex) {
            case 0 :
                return v.getMarka();
            case 1:
                return v.getModel();
            case 2:
                return v.getReg_oznaka();
            case 3:
                return v.getVlasnik().getIme() + " " + v.getVlasnik().getPrezime();
            default:
                return null;
        }
    }
    
    public Vozilo get(int index) {
        if(index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        return vozila.get(index);
    }
    
}
