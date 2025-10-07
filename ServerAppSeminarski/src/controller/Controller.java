package controller;

import domain.*;
import java.util.*;
import so.AbstractSO;
import so.policijska_uprava.loginPolicijskaUpravaSO;

public class Controller {
    private static Controller instance;
    
    private Controller() {
        
    }
    
    public static Controller getInstance() {
        if(instance == null) {
            instance = new Controller();
        }
        return instance;
    }
    
    public PolicijskaUprava login(PolicijskaUprava pu) throws Exception {
        AbstractSO loginPU = new loginPolicijskaUpravaSO();
        return (PolicijskaUprava)loginPU.execute(pu);
    }
}
