package com.siscondominio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.siscondominio.model.Usuarios;
import com.siscondominio.repository.UserRepository;
import com.siscondominio.security.UserSS;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	BCryptPasswordEncoder pe;
	
	@Autowired
	private UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuarios cli = repo.findByEmail(email);
		if (cli == null) {
			throw new UsernameNotFoundException(email);
		}
		// o pe.encode desabilitou a criptografia no login
		return new UserSS(cli.getId(), cli.getEmail(), pe.encode(cli.getSenha()), cli.getPerfis());
	}
	
}