package com.sgworks.mobile.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "USER")
public class AppUser extends org.springframework.security.core.userdetails.User implements Serializable {

    public AppUser(String username, String password, Collection<GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    @Id
    @Column(name = "USER_ID")
    private String username;

    @Column(name = "USER_PASSWORD")
    private String password;

    @ManyToMany
    @JoinTable(name = "USER_ROLE",
            joinColumns = { @JoinColumn(name = "USER_ID") },
            inverseJoinColumns = { @JoinColumn(name = "ROLE_ID") })
    private Set<Roles> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }
}
