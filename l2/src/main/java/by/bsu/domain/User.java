package by.bsu.domain;


import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Created by Mikhail on 06.12.2017.
 */
@Component
public class User {

    private int id;
    private String email;
    private String password;
    private String name;
    private String surname;
    private String faculty;
    private int course;
    private int group;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getCourse() == user.getCourse() &&
                getGroup() == user.getGroup() &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getPassword(), user.getPassword()) &&
                Objects.equals(getName(), user.getName()) &&
                Objects.equals(getSurname(), user.getSurname()) &&
                Objects.equals(getFaculty(), user.getFaculty());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail(), getPassword(), getName(), getSurname(), getFaculty(), getCourse(), getGroup());
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", faculty='" + faculty + '\'' +
                ", course=" + course +
                ", group=" + group +
                '}';
    }
}
