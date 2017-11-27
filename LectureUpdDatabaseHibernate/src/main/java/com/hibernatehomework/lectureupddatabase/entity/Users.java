package com.hibernatehomework.lectureupddatabase.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author �����
 */
@Entity
@Table(name = "users", schema = "databasehib")
public class Users {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idU", nullable = false) 
    private Integer id;
        
    @Column(name = "login", nullable = false)
    private String login;
    
    @Column(name = "age", nullable = false)
    private int age;
    
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Password password;
    
    @ManyToOne
    @JoinColumn(name = "idDu", nullable = false)
    private Duties duties;
    
    public Users() {
        
    }
    
    public Users(String login, int age) { 
        this.login = login;
        this.age = age;
    }
     public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getLogin() {
        return login;
    }
    
    public void setLogin(String login){
        this.login = login;
    }
    
    public int getAge() {
        return age;
    }
     
    public void setAge(int age) {
        this.age = age;
    }
    
    public Password getPassword() {
        return password;
    }
    
    public void setPassword(Password password) {
        this.password = password;
    }
    
    public Duties getDuties() {
        return duties;
    }
    public void setDuties(Duties d) {
        duties = d;
    }
    
    
    @Override
    public String toString() {
        return ("|id: " + id + "; login: " + login + "; age: " + age + "; duty: " + duties.getRule() + "|");
    }

    
  
}