package by.bsu.domain.DTO;

import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Created by Mikhail on 10.12.2017.
 */
@Component
public class UpdatePasswordDTO {
    private int id;
    private String previous;
    private String next;

    public UpdatePasswordDTO(int id, String previous, String next) {
        this.id = id;
        this.previous = previous;
        this.next = next;
    }

    public UpdatePasswordDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdatePasswordDTO that = (UpdatePasswordDTO) o;
        return Objects.equals(getPrevious(), that.getPrevious()) &&
                Objects.equals(getNext(), that.getNext());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPrevious(), getNext());
    }

    @Override
    public String toString() {
        return "UpdatePasswordDTO{" +
                "previous='" + previous + '\'' +
                ", next='" + next + '\'' +
                '}';
    }
}
