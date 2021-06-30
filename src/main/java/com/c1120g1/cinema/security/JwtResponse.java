package com.c1120g1.cinema.security;

import com.c1120g1.cinema.entity.User;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;

public class JwtResponse implements Serializable {
    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;
    private User user;
    private Collection<? extends GrantedAuthority> authorities;

    /**
     * ThuanNN
     * All functions below
     */
    public JwtResponse(String jwttoken, User user, Collection<? extends GrantedAuthority> authorities) {
        this.jwttoken = jwttoken;
        this.user = user;
        this.authorities = authorities;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return this.jwttoken;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
