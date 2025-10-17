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
public class AddVoziloSO extends AbstractSO{

    @Override
    protected void preconditions(Object o) throws Exception {
        if(o == null || !(o instanceof Vozilo)) {
            throw new Exception("prosledjeni parametar nije ispravan!");
        }
    }

    @Override
    protected Object executeOperation(Object o, Object o1, String s) throws Exception {
        return repository.add((Vozilo)o);
    }
    
}
