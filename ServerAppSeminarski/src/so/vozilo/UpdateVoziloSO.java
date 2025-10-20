/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.vozilo;

import domain.Vozilo;
import so.AbstractSO;

/**
 *
 * @author pc
 */
public class UpdateVoziloSO extends AbstractSO{

    @Override
    protected void validate(Object o) throws Exception {
        if(o == null || !(o instanceof Vozilo)) {
            throw new Exception("prosledjeni parametar nije ispravan!");
        }
        
        if(o instanceof Vozilo){
            if(((Vozilo) o).getVlasnik()==null){
                throw new Exception("Objekat nema parametre da bi bio promenjen");
            }
        }
        
    }

    @Override
    protected Object executeOperation(Object o,Object o1,String s) throws Exception {
        return repository.edit((Vozilo)o);
    }
    
}
