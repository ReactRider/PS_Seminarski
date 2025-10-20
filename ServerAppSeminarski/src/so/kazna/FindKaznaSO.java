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
public class FindKaznaSO extends AbstractSO {

    @Override
    protected void validate(Object o) throws Exception {
        if(o == null || !(o instanceof Kazna)) {
            throw new Exception("prosledjeni parametar nije ispravan!");
        }
        
        if(o instanceof Kazna){
            
        }
    }

    @Override
    protected Object executeOperation(Object o, Object o1, String s) throws Exception {
        return repository.getByClass((Kazna)o, null, s);
    }
    
}
