package com.siscondominio.services;

import org.springframework.mail.SimpleMailMessage;

import com.siscondominio.model.Usuarios;


public interface EmailService {
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(Usuarios email, String newPass);
}
