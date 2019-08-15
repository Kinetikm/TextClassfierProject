package ru.caf82.lectures.lectureDB;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = "homework", catalog = "")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private int age;

    public User(String login, int age) {
        this.login = login;
        this.age = age;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Пользователь{" +
                "логин='" + login + '\'' +
                ", возраст=" + age +
                '}';
    }
}
