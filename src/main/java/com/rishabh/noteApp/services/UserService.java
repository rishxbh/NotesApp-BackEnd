package com.rishabh.noteApp.services;

import com.rishabh.noteApp.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    public UserDetailsService userDetailsService();
    public User loadByEmail(String email);
}
