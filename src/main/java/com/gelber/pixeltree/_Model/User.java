package com.gelber.pixeltree._Model;

import javax.management.relation.RoleList;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "user")
public class User {
    // Rows
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 32, nullable = false, unique = true)
    @Size(min=4, max = 32)
    private String username;

    @Column(nullable = false, unique = true)
    @Email
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany(targetEntity = UserRole.class,
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserRole> roleList;

    @Column(nullable = false)
    private boolean active = true;

    @Column(nullable = false)
    private boolean expired = false;

    @Column(nullable = false)
    private boolean verified = false;

    public User() {
        this.roleList = new ArrayList<UserRole>();
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UserRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<UserRole> permissionList) {
        this.roleList = permissionList;
    }

    public void addRole(UserRole userRole){
        this.roleList.add(userRole);
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }
}