/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.evidencija_kazne;

import domain.EvidencijaKazni;
import domain.StavkaEvidencije;
import so.AbstractSO;

/**
 *
 * @author pc
 */
public class AddEvidencijaSO extends AbstractSO{

    @Override
    protected void validate(Object o) throws Exception {
        if(o == null || !(o instanceof EvidencijaKazni)) {
            throw new Exception("prosledjeni objeakt nije odgovarajuce klase!");
        }
        
        if(o instanceof EvidencijaKazni){
            if(((EvidencijaKazni) o).getPu()==null || ((EvidencijaKazni) o).getVozilo()==null){
                throw new Exception("Objekat ne sadrzi sve potrebno da bi bilo sacuvano");
            }
        }
        
    }

    @Override
    protected Object executeOperation(Object o,Object o1, String s) throws Exception {
        EvidencijaKazni ek=(EvidencijaKazni)o;
        ek.setId_evidencija(repository.add(ek));
       
        for(StavkaEvidencije sek:ek.getStavke_ev()){
            sek.getEvidencija().setId_evidencija(ek.getId_evidencija());
            
            sek.setRb(repository.add(sek));
            
        }
        
        return ek.getId_evidencija();
    }
    
}
