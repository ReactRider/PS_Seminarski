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
public class RaskrsnicaTableModel extends AbstractTableModel {
    String[] columns = {"Naziv", "Grad"};
    ArrayList<Raskrsnica> raskrsnice;
    
    public RaskrsnicaTableModel() {
        this.raskrsnice = Controller.getInstance().vratiListuSviRaskrsnica();
    }
    
    public RaskrsnicaTableModel(Raskrsnica r) {
        this.raskrsnice = Controller.getInstance().vratiListuRaskrsnica(r);
    }
    
    @Override
    public String getColumnName(int index) {
        return columns[index];
    }
    
    @Override
    public int getRowCount() {
        return raskrsnice.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Raskrsnica r = raskrsnice.get(rowIndex);
        
        switch(columnIndex) {
            case 0:
                return r.getNaziv();
            case 1:
                return r.getGrad();
            default:
                return null;
        }
    }
    
    public Raskrsnica get(int index){
        if(index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        return raskrsnice.get(index);
    }
    
}
