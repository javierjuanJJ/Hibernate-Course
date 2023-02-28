package com.example.projecthibernatejpa_springboot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class User {
    @Id
    private Long id;
    @Column
    private String userName;
    @Column
    private String userMessage;

    public User(Long id, String userName, String userMessage) {
        this.id = id;
        this.userName = userName;
        this.userMessage = userMessage;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(userName, user.userName) && Objects.equals(userMessage, user.userMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, userMessage);
    }

}
