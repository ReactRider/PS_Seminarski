package table_models;

import controller.Controller;
import java.util.ArrayList;
import domain.*;
import javax.swing.table.AbstractTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
public class KaznaTableModel extends AbstractTableModel {
    private String[] columns = {"Naziv", "Kategorija Kazne", "Iznos"};
    private ArrayList<Kazna> kazne;
    
    public KaznaTableModel() {
        this.kazne = Controller.getInstance().vratiListuSviKazna();
    }
    
    public KaznaTableModel(Kazna k) {
        this.kazne = Controller.getInstance().vratiListuKazna(k);
    }
    
    @Override
    public String getColumnName(int index) {
        return columns[index];
    }
    
    @Override
    public int getRowCount() {
        return kazne.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Kazna k = kazne.get(rowIndex);
        
        switch(columnIndex) {
            case 0:
                return k.getNaziv();
            case 1:
                return k.getKategorija();
            case 2:
                return k.getIznos();
            default:
                return null;
        }
    }
    
    public Kazna get(int index) {
        if(index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        return kazne.get(index);
    }
    
}
