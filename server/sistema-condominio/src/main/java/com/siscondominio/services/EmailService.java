package com.siscondominio.services;

import com.siscondominio.model.Usuarios;

import org.springframework.mail.SimpleMailMessage;


public interface EmailService {

	// void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(Usuarios cliente, String newPass);
}