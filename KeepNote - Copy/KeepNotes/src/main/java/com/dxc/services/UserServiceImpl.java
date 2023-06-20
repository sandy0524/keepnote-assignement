package com.dxc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.exception.UserExistsException;
import com.dxc.model.User;
import com.dxc.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User newUser(User user) throws UserExistsException {
		final boolean existById = this.userRepository.existsById(user.getUserId());
		if(existById) {
			throw new UserExistsException("User Already Exists");
		}
		return this.userRepository.save(user);
	}

	@Override
	public void updateUserById(User user) {
		userRepository.save(user);
	}
	
	@Override
	public void deleteUserById(String userid){
		Optional<User> user=userRepository.findById(userid);
		if(user.isPresent()) {
			userRepository.deleteById(userid);
		
			userRepository.deleteById(userid);
		}
	}

	@Override
	public Optional<User> getUserById(String userid) {
		return userRepository.findById(userid);
	}
}
