package com.ons.itadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ons.itadmin.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	public User getUserById(long id);
}
