/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.kazna;

import domain.Kazna;
import so.AbstractSO;

/**
 *
 * @author pc
 */
public class DeleteKaznaSO extends AbstractSO{

    @Override
    protected void validate(Object o) throws Exception {
        if(o == null || !(o instanceof Kazna)) {
            throw new Exception("prosledjeni parametar nije ispravan!");
        }
        
        if(o instanceof Kazna){
            if(((Kazna) o).getId_kazna()!=0){
                throw new Exception("Objekat nema potreban parametar da bi bio obrisan");
            }
        }
    }

    @Override
    protected Object executeOperation(Object o,Object o1, String s) throws Exception {
        return repository.delete((Kazna)o, null);
    }
    
}
