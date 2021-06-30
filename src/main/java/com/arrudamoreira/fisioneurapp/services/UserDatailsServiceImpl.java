package com.arrudamoreira.fisioneurapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.arrudamoreira.fisioneurapp.domain.Fisioterapeuta;
import com.arrudamoreira.fisioneurapp.repositories.FisioterapeutaRepository;
import com.arrudamoreira.fisioneurapp.security.UserSS;

@Service
public class UserDatailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private FisioterapeutaRepository repo; 
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Fisioterapeuta fisio = repo.findByEmail(email);
		
		if(fisio == null) {
			throw new UsernameNotFoundException(email);
		}
		
		return new UserSS(fisio.getId(),fisio.getEmail(),fisio.getSenha(),fisio.getPerfis());
	}

}
