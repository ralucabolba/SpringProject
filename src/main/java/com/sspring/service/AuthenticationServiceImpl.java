package com.sspring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sspring.dao.UserDao;

@Service
public class AuthenticationServiceImpl implements AuthenticationService, UserDetailsService {
	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.sspring.bean.User user;

		try {
			user = userDao.findUserByUsername(username);
			if (user == null) {
				throw new UsernameNotFoundException("Username not found.");
			}
		} catch (Exception e) {
			throw new UsernameNotFoundException("Database error");
		}

		return buildUserFromUserEntity(user);
	}

	private User buildUserFromUserEntity(com.sspring.bean.User userEntity) {
		String username = userEntity.getUsername();
		String password = userEntity.getPassword();

		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(userEntity.getRole().getRole()));

		User springUser = new User(username, password, authorities);

		return springUser;
	}
}
