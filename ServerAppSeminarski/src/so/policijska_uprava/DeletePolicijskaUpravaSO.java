/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.policijska_uprava;

import domain.PolicijskaUprava;
import so.AbstractSO;

/**
 *
 * @author pc
 */
public class DeletePolicijskaUpravaSO extends AbstractSO{

    @Override
    protected void validate(Object o) throws Exception {
        if(o == null || !(o instanceof PolicijskaUprava)) {
            throw new Exception("prosledjeni parametar nije ispravan!");
        }
        
        if(o instanceof PolicijskaUprava){
            if(((PolicijskaUprava) o).getId()==0){
                throw new Exception("Objekat nema parametar da bi se obrisao");
            }
        }
        
    }

    @Override
    protected Object executeOperation(Object o,Object o1, String s) throws Exception {
        return repository.delete((PolicijskaUprava)o, null);
    }
    
}
