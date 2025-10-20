/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.raskrsnica;

import domain.Raskrsnica;
import so.AbstractSO;

/**
 *
 * @author pc
 */
public class DeleteRaskresnicaSO extends AbstractSO{

    @Override
    protected void validate(Object o) throws Exception {
        if(o == null || !(o instanceof Raskrsnica)) {
            throw new Exception("prosledjeni parametar nije ispravan!");
        }
        
        if(o instanceof Raskrsnica){
            if(((Raskrsnica) o).getId_raskrsnica()==0){
                throw new Exception("Objekat nema potrebne parametre da bi mogao biti obrisan");
            }
        }
    }

    @Override
    protected Object executeOperation(Object o, Object o1, String s) throws Exception {
        return repository.delete((Raskrsnica)o, null);
    }
    
}
