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
public class DeleteVlasnikSO extends AbstractSO{

    @Override
    protected void validate(Object o) throws Exception {
        if(o == null || !(o instanceof Vlasnik)) {
            throw new Exception("prosledjeni parametar nije ispravan!");
        }
        
        if(o instanceof Vlasnik){
            if(((Vlasnik) o).getId_vlasnik()==0){
                throw new Exception("Objekat nemoze da se obrise jer nema potreban parametar");
            }
        }
        
    }

    @Override
    protected Object executeOperation(Object o, Object o1, String s) throws Exception {
        return repository.delete((Vlasnik)o, null);
    }
    
}
