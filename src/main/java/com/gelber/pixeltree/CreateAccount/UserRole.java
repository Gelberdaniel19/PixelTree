package com.gelber.pixeltree.CreateAccount;

import javax.persistence.*;

@Entity(name = "user_role")
public class UserRole {
    // Rows
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(targetEntity = User.class)
    private User user;

    @Enumerated(EnumType.ORDINAL)
    private Role role;

    // Constructor
    public UserRole(User user, Role role) {
        this.user = user;
        this.role = role;
    }

    protected UserRole() {

    }

    // Getters and setters
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role permissionId) {
        this.role = permissionId;
    }
}
