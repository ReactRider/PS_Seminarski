/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table_models;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import domain.*;

/**
 *
 * @author ennouser
 */
public class StavkeEvidencijeTableModel extends AbstractTableModel {
    private List<StavkaEvidencije> stavke = null;
    private String[] columns = {"Vozilo","Kazna", "Raskrsnica", "Datum Prekrsaja"};
    
    public StavkeEvidencijeTableModel(List<StavkaEvidencije> stavke) {
        this.stavke = stavke;
    }
    

    @Override
    public int getRowCount() {
        return stavke.size();
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
        StavkaEvidencije stavka = stavke.get(rowIndex);
        
        switch(columnIndex) {
            case 0:
                return stavka.getEvidencija().getVozilo().getReg_oznaka();
            case 1:
                return stavka.getKazna().getNaziv();
            case 2:
                return stavka.getRaskrsnica().getNaziv();
            case 3:
                return stavka.getDatumPrekrsaja();
            default:
                return null;
        }
    }
      
    public StavkaEvidencije get(int index) {
        if(index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        return stavke.get(index);
    }
}
