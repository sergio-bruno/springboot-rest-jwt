package com.slbruno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.slbruno.service.JwtUserDetailsService;

import com.slbruno.exception.BadRequest;

/*
//Para retornar o Token
import org.springframework.security.core.userdetails.UserDetails;
import com.slbruno.config.JwtTokenUtil;
import com.slbruno.model.JwtResponse;
*/

import com.slbruno.model.DAOUser;
import com.slbruno.model.JwtRequest;
import com.slbruno.model.UserDTO;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	/*
	 * //Para retornar o Token
	 * 
	 * @Autowired 
	 * private JwtTokenUtil jwtTokenUtil;
	 */

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	// public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest
	// authenticationRequest) throws Exception {
	public DAOUser createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		/*
		 * //Para retornar o Token 
		 * final UserDetails userDetails = userDetailsService
		 * .loadUserByUsername(authenticationRequest.getUsername()); 
		 * final String token = jwtTokenUtil.generateToken(userDetails); 
		 * return ResponseEntity.ok(new JwtResponse(token));
		 */

		// Para retornar dados do usuário
		DAOUser dadosUsuario;
		dadosUsuario = userDetailsService.retornaDadosByUsername(authenticationRequest.getUsername());
		System.out.print(dadosUsuario.getDaoPhones().toString());
		return dadosUsuario;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
		return ResponseEntity.ok(userDetailsService.save(user));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new BadRequest("usuário desabilitado!");
		} catch (BadCredentialsException e) {
			throw new BadRequest("Falha na autenticação");
		}
	}
}