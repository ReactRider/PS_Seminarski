/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.policijska_uprava;

import domain.PolicijskaUprava;
import so.AbstractSO;
/**
 *
 * @author ennouser
 */
public class loginPolicijskaUpravaSO extends AbstractSO {

    @Override
    protected void validate(Object o) throws Exception {
        if(o == null || !(o instanceof PolicijskaUprava)) {
            throw new Exception("prosledjeni parametar nije ispravan!");
        }
        
        if(o instanceof PolicijskaUprava){
            if(((PolicijskaUprava) o).getUsername().equals("") || ((PolicijskaUprava) o).getPassword().equals("")){
                throw new Exception("Objekat nema potrebne parametre da bi mogao da se uloguje");
            }
        }
    }

    @Override
    protected Object executeOperation(Object o, Object o1, String s) throws Exception {
        return repository.login((PolicijskaUprava) o);
    }
   
    
}
