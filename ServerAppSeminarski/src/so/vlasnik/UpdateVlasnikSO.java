/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.vlasnik;

import domain.Vlasnik;
import so.AbstractSO;

/**
 *
 * @author pc
 */
public class UpdateVlasnikSO extends AbstractSO{

    @Override
    protected void validate(Object o) throws Exception {
        if(o == null || !(o instanceof Vlasnik)) {
            throw new Exception("prosledjeni parametar nije ispravan!");
        }
        
        if(o instanceof Vlasnik){
            if(((Vlasnik) o).getIme().equals("") || ((Vlasnik) o).getPrezime().equals("") || ((Vlasnik) o).getGrad().equals("")){
                throw new Exception("Objekat nema potrebne parametre da bi se izvrsila zmena");
            }
        }
        
    }

    @Override
    protected Object executeOperation(Object o, Object o1, String s) throws Exception {
        return repository.edit((Vlasnik)o);
    }
    
}
