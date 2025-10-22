/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.evidencija_kazne;

import so.AbstractSO;
import domain.*;
import java.util.*;

/**
 *
 * @author ennouser
 */
public class UpdateEvidencijaSO  extends AbstractSO {

    @Override
    protected void validate(Object o) throws Exception {
       if(o == null) {
           throw new Exception("Los prosledjen ;arametar!");
       }
    }

    @Override
    protected Object executeOperation(Object o, Object o1, String str) throws Exception {
        EvidencijaKazni e = (EvidencijaKazni)o;
        List<StavkaEvidencije> stavke = e.getStavke_ev();
        
        for(StavkaEvidencije s : stavke) {
            Long id = repository.add(s);
            if(id == 0)
                return false;
            if(s.getKategorija_kazne() == KategorijaKazna.Kategorija_I) {
                e.setBr_kazni_I( e.getBr_kazni_I() + 1 );
            } else if(s.getKategorija_kazne() == KategorijaKazna.Kategorija_II) {
                e.setBr_kazni_II( e.getBr_kazni_II() + 1 );
            } else if(s.getKategorija_kazne() == KategorijaKazna.Kategorija_III) {
                e.setBr_kazni_III( e.getBr_kazni_III() + 1 );
            }
            
            repository.edit(e);
        }
        return true;
    }
    
}
