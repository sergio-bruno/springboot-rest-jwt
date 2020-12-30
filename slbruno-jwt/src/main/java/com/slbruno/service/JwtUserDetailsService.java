package com.slbruno.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.slbruno.dao.UserDao;
import com.slbruno.model.DAOPhone;
import com.slbruno.model.DAOUser;
import com.slbruno.model.UserDTO;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		DAOUser user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("Usuário não encontrado com esse login: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}
	
    public DAOUser retornaDadosByUsername(String username) throws UsernameNotFoundException {
    	return userDao.findByUsername(username);
    }
	
	public DAOUser save(UserDTO user) {
		DAOUser newUser = new DAOUser();
		DAOPhone daoPhone = new DAOPhone();
		
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setFirstname(user.getFirstname());
		newUser.setLastname(user.getLastname());
		newUser.setEmail(user.getEmail());
		
		daoPhone.setNumber(0);
		daoPhone.setArea_code(0);
		daoPhone.setCountry_code("+55");

		
		
		
		
		
		return userDao.save(newUser);
	}
}