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
public class AddKaznaSO extends AbstractSO{

    @Override
    protected void preconditions(Object o) throws Exception {
        if(o == null || !(o instanceof Kazna)) {
            throw new Exception("prosledjeni parametar nije ispravan!");
        }
    }

    @Override
    protected Object executeOperation(Object o,Object o1, String s) throws Exception {
        return repository.add((Kazna)o);
    }
    
}
