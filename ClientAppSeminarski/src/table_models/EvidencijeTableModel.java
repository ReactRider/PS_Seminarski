/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table_models;
import domain.*;
import java.util.ArrayList;
import controller.Controller;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Stefan
 */
public class EvidencijeTableModel extends AbstractTableModel {
    private String[] columns = {"Policijska Uprava", "Vlasnik", "Total", "Br Kazni I Kategorije", "Br Kazni II Kategorije", "Br Kazni III Kategorije"};
    private ArrayList<EvidencijaKazni> evidencije;
    
    public EvidencijeTableModel(EvidencijaKazni ek) throws Exception {
        this.evidencije = Controller.getInstance().vratiListuEvidencijaKazni(ek);
        System.out.println(evidencije.size());
    }
    
    public EvidencijeTableModel(Kazna kazna) throws Exception {
        this.evidencije = Controller.getInstance().vratiListuEvidencijaKazni(kazna);
    }
    
    public EvidencijeTableModel(PolicijskaUprava pu) throws Exception {
        this.evidencije = Controller.getInstance().vratiListuEvidencijaKazni(pu);
    }
    
    public EvidencijeTableModel(Vozilo vozilo) throws Exception {
        this.evidencije = Controller.getInstance().vratiListuEvidencijaKazni(vozilo);
    }
    
    public EvidencijeTableModel() {
        this.evidencije = null;
    }

    @Override
    public int getRowCount() {
        if(this.evidencije != null)
            return evidencije.size();
        return 0;
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
        EvidencijaKazni evidencija = evidencije.get(rowIndex);
        
        switch(columnIndex) {
            case 0:
                return evidencija.getPu().getUsername();
            case 1:
                return evidencija.getVozilo().getVlasnik().getIme() + " " + evidencija.getVozilo().getVlasnik().getPrezime();
            case 2:
                return evidencija.getIznos_total();
            case 3:
                return evidencija.getBr_kazni_I();
            case 4:
                return evidencija.getBr_kazni_II();
            case 5:
                return evidencija.getBr_kazni_III();
              default:
                return null;
        }
    }
    
    public EvidencijaKazni get(int index) {
        if(index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        return evidencije.get(index);
    }
    
    
    
}
