package com.ons.itadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ons.itadmin.model.IT_Admin;

@Repository
public interface IT_Repository extends JpaRepository<IT_Admin, Long>{

	public IT_Admin adminUserName(String username);
}
