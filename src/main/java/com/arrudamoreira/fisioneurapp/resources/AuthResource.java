package com.arrudamoreira.fisioneurapp.resources;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arrudamoreira.fisioneurapp.dto.EmailDTO;
import com.arrudamoreira.fisioneurapp.dto.PacienteLoginDTO;
import com.arrudamoreira.fisioneurapp.security.JWTUtil;
import com.arrudamoreira.fisioneurapp.security.UserSS;
import com.arrudamoreira.fisioneurapp.services.AuthService;
import com.arrudamoreira.fisioneurapp.services.UserService;

@RestController
@RequestMapping(value = "/auth")
public class AuthResource {
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private AuthService service;
	
	@RequestMapping(value = "/refresh_token", method = RequestMethod.POST)
	public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
		UserSS user = UserService.authenticated();
		String token = jwtUtil.generateToken(user.getUsername());
		response.addHeader("Authorization", "Bearer " + token);
		response.addHeader("access-control-expose-headers", "Authorization");
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/forgot", method = RequestMethod.POST)
	public ResponseEntity<Void> forgot(@Valid @RequestBody EmailDTO objDto) {
		service.sendNewPassword(objDto.getEmail());
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/paciente", method = RequestMethod.POST)
	public ResponseEntity<Void> autenticaPaciente(@Valid @RequestBody PacienteLoginDTO objDto) {
		service.autenticaPaciente(objDto);
		return ResponseEntity.noContent().build();
	}
}
