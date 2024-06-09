package com.order.order_system.entity;

import java.util.List; 

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "security_users")
public class AppUser extends BaseEntity<Long> {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private Integer statusCode;

    public AppUser() {}

    public AppUser(String firstName, String lastName, String username, String password, List<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = username;
        this.password = password;
        this.roles = roles;
    }

    @ManyToMany
    @JoinTable(
        name = "sec_user_roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles = new ArrayList<>();
}
