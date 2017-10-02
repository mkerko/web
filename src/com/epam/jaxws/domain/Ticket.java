package com.epam.jaxws.domain;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.sql.Date;

/**
 * Created by Mikhail_Kiarko on 1/26/2017.
 */
@XmlRootElement(name = "ticket")
@XmlType(propOrder = {
        "ID",
        "departureCity",
        "arrivalCity",
        "departureTime",
        "arrivalTime",
        "price",
        "status",
        "passenger"})
public class Ticket {
    private int ID;
    private int departureCity;
    private int arrivalCity;
    private int departureTime;
    private int arrivalTime;
    private int price;
    private int status;
    private int passenger;

    public Ticket(int ID, int departureCity, int arrivalCity, int departureTime, int arrivalTime, int price, int status, int passenger) {
        this.ID = ID;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
        this.status = status;
        this.passenger = passenger;
    }

    public Ticket() {
    }

    public int getID() {
        return ID;
    }
    @XmlElement
    public void setID(int ID) {
        this.ID = ID;
    }

    public int getDepartureCity() {
        return departureCity;
    }
    @XmlElement
    public void setDepartureCity(int departureCity) {
        this.departureCity = departureCity;
    }

    public int getArrivalCity() {
        return arrivalCity;
    }
    @XmlElement
    public void setArrivalCity(int arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public int getDepartureTime() {
        return departureTime;
    }

    @XmlElement(name = "departureTime", required = true)
//    @XmlJavaTypeAdapter(DateAdapter.class)
    public void setDepartureTime(int departureTime) {
        this.departureTime = departureTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    @XmlElement(name = "arrivalTime", required = true)
//    @XmlJavaTypeAdapter(DateAdapter.class)
    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getPrice() {
        return price;
    }
    @XmlElement
    public void setPrice(int price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }
    @XmlElement
    public void setStatus(int status) {
        this.status = status;
    }

    public int getPassenger() {
        return passenger;
    }
    @XmlElement
    public void setPassenger(int passenger) {
        this.passenger = passenger;
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
                '}';
    }
}
