package com.application.soundcloud.userDetails;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomUserDetails implements UserDetails {

    private String username;
    private String password;
    private String email; // Додаткове поле для email
    private Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails(String username, String password, String email, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    // Метод для отримання email
    public String getEmail() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Ваша логіка для перевірки чи не сплив термін дії акаунту
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Ваша логіка для перевірки чи акаунт не заблокований
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Ваша логіка для перевірки чи не сплив термін дії паролю
    }

    @Override
    public boolean isEnabled() {
        return true; // Ваша логіка для перевірки чи акаунт активний
    }
}
