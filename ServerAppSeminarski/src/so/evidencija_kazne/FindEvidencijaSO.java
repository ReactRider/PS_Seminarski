/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.evidencija_kazne;

import domain.EvidencijaKazni;
import domain.StavkaEvidencije;
import java.util.List;
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
        List<EvidencijaKazni> evidencije = repository.getByClass((EvidencijaKazni)o, o1, s);
        
        for(EvidencijaKazni e : evidencije) {
            StavkaEvidencije se = new StavkaEvidencije();
            List<StavkaEvidencije> stavke = repository.getByClass((StavkaEvidencije)se, e, "lista");
            e.setStavke_ev(stavke);
        }
        
        return evidencije;
    }
    
}
