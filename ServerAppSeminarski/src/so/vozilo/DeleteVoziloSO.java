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
public class DeleteVoziloSO extends AbstractSO{

    @Override
    protected void validate(Object o) throws Exception {
        if(o == null || !(o instanceof Vozilo)) {
            throw new Exception("prosledjeni parametar nije ispravan!");
        }
        
        if(o instanceof Vozilo){
            if(((Vozilo) o).getId_vozilo()==0){
                throw new Exception("Objekat ne moze da se obrise zbog potrebnih parametrara koji nedostaju");
            }
        }
    }

    @Override
    protected Object executeOperation(Object o,Object o1, String s) throws Exception {
        return repository.delete((Vozilo)o, null);
    }
    
}
