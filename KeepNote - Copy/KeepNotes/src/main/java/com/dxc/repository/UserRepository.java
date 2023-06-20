package com.dxc.repository;

import org.springframework.stereotype.Repository;

import com.dxc.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository  extends JpaRepository<User, String>{

}
