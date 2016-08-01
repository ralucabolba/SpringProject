package com.sspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sspring.bean.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	public User findById(int id);

	public User findByUsername(String username);

	public User save(User user);

//	public void update(User user);

	public void delete(User user);

}
