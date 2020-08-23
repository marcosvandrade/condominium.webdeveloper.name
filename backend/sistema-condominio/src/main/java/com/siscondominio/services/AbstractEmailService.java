package com.siscondominio.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import com.siscondominio.model.Usuarios;

public abstract class AbstractEmailService implements EmailService {
	
	@Value("${default.sender}")
	private String sender;
	
	// @Override
	// public void sendOrderConfirmationEmail(Pedido obj) {
	// 	SimpleMailMessage sm = prepareSimpleMailMessageFromPedido(obj);
	// 	sendEmail(sm);
	// }

	// protected SimpleMailMessage prepareSimpleMailMessageFromPedido(Pedido obj) {
	// 	SimpleMailMessage sm = new SimpleMailMessage();
	// 	sm.setTo(obj.getCliente().getEmail());
	// 	sm.setFrom(sender);
	// 	sm.setSubject("Pedido confirmado! Código: " + obj.getId());
	// 	sm.setSentDate(new Date(System.currentTimeMillis()));
	// 	sm.setText(obj.toString());
	// 	return sm;
	// }
	
	@Override
	public void sendNewPasswordEmail(Usuarios email, String newPass) {
		SimpleMailMessage sm = prepareNewPasswordEmail(email, newPass);
		sendEmail(sm);
	}
	
	protected SimpleMailMessage prepareNewPasswordEmail(Usuarios email, String newPass) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(email.getEmail());
		sm.setFrom(sender);
		sm.setSubject("Solicitação de nova senha");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("Nova senha: " + newPass);
		return sm;
	}
}
