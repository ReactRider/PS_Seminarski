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
public class AddPolicijskaUpravaSO extends AbstractSO{

    @Override
    protected void validate(Object o) throws Exception {
        if(o == null || !(o instanceof PolicijskaUprava)) {
            throw new Exception("prosledjeni parametar nije ispravan!");
        }
        
        if(o instanceof PolicijskaUprava){
            if(((PolicijskaUprava) o).getAdresa().equals("") || ((PolicijskaUprava) o).getGrad().equals("") || ((PolicijskaUprava) o).getOpstina().equals("") || ((PolicijskaUprava) o).getPassword().equals("") || ((PolicijskaUprava) o).getUsername().equals("") || ((PolicijskaUprava) o).getPolicajac().equals("")){
                throw new Exception("Objeakt nema potrebne parametre da bi mogao biti sacuvan");
            }
        }
    }

    @Override
    protected Object executeOperation(Object o,Object o1, String s) throws Exception {
        return repository.add((PolicijskaUprava)o);
    }
    
}
