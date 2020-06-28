package com.gelber.pixeltree._Model;

import org.thymeleaf.util.StringUtils;

import javax.persistence.*;

@Entity(name = "email_change_token")
public class EmailChangeToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne(targetEntity = User.class,
            fetch = FetchType.EAGER)
    private User user;

    private String token;

    private String newEmail;

    public EmailChangeToken(User user, String newEmail) {
        this.user = user;
        this.newEmail = newEmail;
        token = StringUtils.randomAlphanumeric(32);
    }

    public EmailChangeToken() {
        token = StringUtils.randomAlphanumeric(32);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }
}
