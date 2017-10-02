package com.epam.jaxws.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.sql.Date;

/**
 * Created by Mikhail_Kiarko on 1/26/2017.
 */
@XmlRootElement(name = "user")
@XmlType(propOrder = {"ID", "name", "surname", "patronymic"})
public class User {
    private int ID;
    private String name;
    private String surname;
    private String patronymic;

    public User(int ID, String name, String surname, String patronymic) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public User() {
    }

    public int getID() {
        return ID;
    }
    @XmlElement
    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }
    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    @XmlElement
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }
    @XmlElement
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", ID=" + ID +
                '}';
    }
}
