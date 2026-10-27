package ro.uvt.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String surname;

    protected Author() {
    }

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Author(String fullName) {
        int idx = fullName.lastIndexOf(' ');
        if (idx < 0) {
            this.name = fullName;
            this.surname = "";
        } else {
            this.name = fullName.substring(0, idx);
            this.surname = fullName.substring(idx + 1);
        }
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void print() {
        System.out.println("Author: " + (surname == null || surname.isEmpty() ? name : name + " " + surname));
    }
}