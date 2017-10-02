/**
 * Ticket.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.epam.jaxws.client;

public class Ticket  implements java.io.Serializable {
    private int ID;

    private int departureCity;

    private int arrivalCity;

    private Date departureTime;

    private Date arrivalTime;

    private int price;

    private int status;

    private int passenger;

    public Ticket() {
    }

    public Ticket(
           int ID,
           int departureCity,
           int arrivalCity,
           Date departureTime,
           Date arrivalTime,
           int price,
           int status,
           int passenger) {
           this.ID = ID;
           this.departureCity = departureCity;
           this.arrivalCity = arrivalCity;
           this.departureTime = departureTime;
           this.arrivalTime = arrivalTime;
           this.price = price;
           this.status = status;
           this.passenger = passenger;
    }


    /**
     * Gets the ID value for this Ticket.
     * 
     * @return ID
     */
    public int getID() {
        return ID;
    }


    /**
     * Sets the ID value for this Ticket.
     * 
     * @param ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }


    /**
     * Gets the departureCity value for this Ticket.
     * 
     * @return departureCity
     */
    public int getDepartureCity() {
        return departureCity;
    }


    /**
     * Sets the departureCity value for this Ticket.
     * 
     * @param departureCity
     */
    public void setDepartureCity(int departureCity) {
        this.departureCity = departureCity;
    }


    /**
     * Gets the arrivalCity value for this Ticket.
     * 
     * @return arrivalCity
     */
    public int getArrivalCity() {
        return arrivalCity;
    }


    /**
     * Sets the arrivalCity value for this Ticket.
     * 
     * @param arrivalCity
     */
    public void setArrivalCity(int arrivalCity) {
        this.arrivalCity = arrivalCity;
    }


    /**
     * Gets the departureTime value for this Ticket.
     * 
     * @return departureTime
     */
    public Date getDepartureTime() {
        return departureTime;
    }


    /**
     * Sets the departureTime value for this Ticket.
     * 
     * @param departureTime
     */
    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }


    /**
     * Gets the arrivalTime value for this Ticket.
     * 
     * @return arrivalTime
     */
    public Date getArrivalTime() {
        return arrivalTime;
    }


    /**
     * Sets the arrivalTime value for this Ticket.
     * 
     * @param arrivalTime
     */
    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }


    /**
     * Gets the price value for this Ticket.
     * 
     * @return price
     */
    public int getPrice() {
        return price;
    }


    /**
     * Sets the price value for this Ticket.
     * 
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
    }


    /**
     * Gets the status value for this Ticket.
     * 
     * @return status
     */
    public int getStatus() {
        return status;
    }


    /**
     * Sets the status value for this Ticket.
     * 
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }


    /**
     * Gets the passenger value for this Ticket.
     * 
     * @return passenger
     */
    public int getPassenger() {
        return passenger;
    }


    /**
     * Sets the passenger value for this Ticket.
     * 
     * @param passenger
     */
    public void setPassenger(int passenger) {
        this.passenger = passenger;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ticket)) return false;
        Ticket other = (Ticket) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.ID == other.getID() &&
            this.departureCity == other.getDepartureCity() &&
            this.arrivalCity == other.getArrivalCity() &&
            ((this.departureTime==null && other.getDepartureTime()==null) || 
             (this.departureTime!=null &&
              this.departureTime.equals(other.getDepartureTime()))) &&
            ((this.arrivalTime==null && other.getArrivalTime()==null) || 
             (this.arrivalTime!=null &&
              this.arrivalTime.equals(other.getArrivalTime()))) &&
            this.price == other.getPrice() &&
            this.status == other.getStatus() &&
            this.passenger == other.getPassenger();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getID();
        _hashCode += getDepartureCity();
        _hashCode += getArrivalCity();
        if (getDepartureTime() != null) {
            _hashCode += getDepartureTime().hashCode();
        }
        if (getArrivalTime() != null) {
            _hashCode += getArrivalTime().hashCode();
        }
        _hashCode += getPrice();
        _hashCode += getStatus();
        _hashCode += getPassenger();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ticket.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.jaxws.epam.com/", "ticket"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("departureCity");
        elemField.setXmlName(new javax.xml.namespace.QName("", "departureCity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrivalCity");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arrivalCity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("departureTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "departureTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://service.jaxws.epam.com/", "date"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrivalTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arrivalTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://service.jaxws.epam.com/", "date"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("price");
        elemField.setXmlName(new javax.xml.namespace.QName("", "price"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("passenger");
        elemField.setXmlName(new javax.xml.namespace.QName("", "passenger"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }


    @Override
    public String toString() {
        return "Ticket{" +
                "ID=" + ID +
                ", departureCity=" + departureCity +
                ", arrivalCity=" + arrivalCity +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", price=" + price +
                ", status=" + status +
                ", passenger=" + passenger +
                ", __equalsCalc=" + __equalsCalc +
                ", __hashCodeCalc=" + __hashCodeCalc +
                '}';
    }
}
