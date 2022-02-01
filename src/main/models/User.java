package main.models;

import java.time.LocalDateTime;

public class User {

    private int id;

    private String name;

    private int age;

    public User() {
        id = LocalDateTime.now().hashCode() * (-1);
    }

    public User(boolean autoGenerate) {

        if (autoGenerate) {
            id = LocalDateTime.now().hashCode() * (-1);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Id: " + id + "\nNome: " + name + "\nIdade: " + age;
    }

    public String toStringToSave() {
        return "id: " + id + ", name: " + name + ", age: " + age;
    }
}
