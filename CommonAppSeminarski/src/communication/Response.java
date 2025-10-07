/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;

import java.io.Serializable;
import util.ResponseStatus;

/**
 *
 * @author ennouser
 */
public class Response implements Serializable {
    private static final long serialVersionUID = 1L;
    private ResponseStatus status;
    private Object data;
    private String errormessage;
    
    public Response() {
        
    }
    
    public Response(ResponseStatus status, Object data, String error) {
        this.status = status;
        this.data = data;
        this.errormessage = error;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrormessage() {
        return errormessage;
    }

    public void setErrormessage(String errormessage) {
        this.errormessage = errormessage;
    }

    @Override
    public String toString() {
        return "Response{" + "status=" + status + ", data=" + data + ", errormessage=" + errormessage + '}';
    }

}
