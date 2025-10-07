/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;
import java.io.Serializable;
import util.Operation;

/**
 *
 * @author ennouser
 */
public class Request implements Serializable {
    private static final long serialVersionUID = 1L;
    private Operation operation;
    private Object data;
    private Object optionalData;
    private Object secondOptionData;
    
    
    public Request() {
        optionalData = null;
        secondOptionData = null;
    }
    
    public Request(Operation o, Object d) {
        this.operation = o;
        this.data = d;
    }
    
    public Operation getOperation() {
        return operation;
    }
    
    public void setOperation(Operation o) {
        this.operation = o;
    }
    
    public Object getData() {
        return data;
    }
    
    public void setData(Object d) {
        this.data = d;
    }
    
    public Object getOptionalData() {
        return optionalData;
    }
    
    public void setOptionalData(Object o) {
        this.optionalData = o;
    }
    
     public Object getSecondOptionData() {
        return secondOptionData;
    }
    
    public void setSecondOptionData(Object s) {
        this.secondOptionData = s;
    }
    

}
