/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.evidencija_kazne;

import domain.EvidencijaKazni;
import so.AbstractSO;

/**
 *
 * @author ennouser
 */
public class FindEvidencijaSO extends AbstractSO {

    @Override
    protected void validate(Object o) throws Exception {
        if(o == null) {
            throw new Exception("prosledjeni objekat je null!");
        }
    }

    @Override
    protected Object executeOperation(Object o, Object o1, String s) throws Exception {
        return repository.getByClass((EvidencijaKazni)o, o1, s);
    }
    
}
