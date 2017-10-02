package com.epam.jaxws.exceptions;

/**
 * Created by Mikhail_Kiarko on 2/3/2017.
 */
public class DAOExceptionFault {
    /**
     * Fault Code
     */
    private String faultCode;
    /**
     * Fault String
     */
    private String faultString;
    /**
     * @return the faultCode
     */
    public String getFaultCode() {
        return faultCode;
    }
    /**
     * @param faultCode the faultCode to set
     */
    public void setFaultCode(String faultCode) {
        this.faultCode = faultCode;
    }
    /**
     * @return the faultString
     */
    public String getFaultString() {
        return faultString;
    }
    /**
     * @param faultString the faultString to set
     */
    public void setFaultString(String faultString) {
        this.faultString = faultString;
    }
}
