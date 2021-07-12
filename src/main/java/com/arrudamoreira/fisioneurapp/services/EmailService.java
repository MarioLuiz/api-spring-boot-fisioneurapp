package com.arrudamoreira.fisioneurapp.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.arrudamoreira.fisioneurapp.domain.Fisioterapeuta;

public interface EmailService {
	
	void sendMail(SimpleMailMessage msg);
	
	void sendHtmlEmail(MimeMessage msg);
	
	void sendNewPasswordEmail(Fisioterapeuta fisioterapeuta, String newPass);
}
