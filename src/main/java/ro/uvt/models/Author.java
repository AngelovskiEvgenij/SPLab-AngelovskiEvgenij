package ro.uvt.models;

public class Author {
    private String name;
    private String surname;

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

    public void print() {
        System.out.println("Autor: " + (surname.isEmpty() ? name : name + " " + surname));
    }
}