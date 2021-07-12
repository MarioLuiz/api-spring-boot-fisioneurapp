package com.arrudamoreira.fisioneurapp.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.thymeleaf.TemplateEngine;

import com.arrudamoreira.fisioneurapp.domain.Fisioterapeuta;

public abstract class AbstractEmailService implements EmailService {

	@Value("${default.sender}")
	private String sender;

	@Autowired
	private TemplateEngine templateEngine;

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void sendNewPasswordEmail(Fisioterapeuta fisioterapeuta, String newPass) {
		SimpleMailMessage sm = prepareNewPasswordEmail(fisioterapeuta, newPass);
		sendMail(sm);
	}

	protected SimpleMailMessage prepareNewPasswordEmail(Fisioterapeuta fisioterapeuta, String newPass) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(fisioterapeuta.getEmail());
		sm.setFrom(sender);
		sm.setSubject("Solicitação de nova senha");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("Nova senha: " + newPass);
		return sm;
	}
}
