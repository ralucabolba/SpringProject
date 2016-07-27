package com.sspring.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface AuthenticationService {
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
