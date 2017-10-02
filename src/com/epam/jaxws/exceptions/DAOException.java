package com.epam.jaxws.exceptions;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.ws.WebFault;

/**
 * Created by Mikhail_Kiarko on 12/28/2016.
 */
@WebFault(name="DAOExceptionFault",targetNamespace="http://example.com/")
@XmlRootElement
public class DAOException extends Exception{
    private static final long serialVersionUID = -6647544772732631047L;
    private DAOExceptionFault fault;
    public DAOException() {
        // TODO Auto-generated constructor stub
    }
    protected DAOException(DAOExceptionFault fault) {
        super(fault.getFaultString());
        this.fault = fault;
    }
    public DAOException(String message, DAOExceptionFault faultInfo){
        super(message);
        this.fault = faultInfo;
    }
    public DAOException(String message, DAOExceptionFault faultInfo, Throwable cause){
        super(message,cause);
        this.fault = faultInfo;
    }
    public DAOExceptionFault getFaultInfo(){
        return fault;
    }
    public DAOException(String message) {
        super(message);
    }
    public DAOException(String code, String message) {
        super(message);
        this.fault = new DAOExceptionFault();
        this.fault.setFaultString(message);
        this.fault.setFaultCode(code);
    }
    public DAOException(Throwable cause) {
        super(cause);
    }

    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }
}
