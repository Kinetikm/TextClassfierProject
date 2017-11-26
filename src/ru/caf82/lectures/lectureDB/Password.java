package ru.caf82.lectures.lectureDB;

import javax.persistence.*;

@Entity
@Table(name = "passwords", schema = "homework", catalog = "")

public class Password {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column
private int id;


    @Column(nullable = false)
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public Password(String password, User user) {
        this.password = password;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Пароль{" +
                "id=" + id +
                ", пароль='" + password + '\'' +
                ", пользователь=" + user +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
