package com.br.todeschini.email;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	public void enviar(String nome, String emailDestinatario){
		
		try {
			Email email = new SimpleEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(485);
			email.setAuthenticator(new DefaultAuthenticator("fernando.abelem.test@gmail.com", "fernandobelemtest"));
			email.setSSLOnConnect(false);

			email.setFrom("fernando.abelem.test@gmail.com");
			email.setSubject("Mensagem App Todeschini");
			email.setMsg("Olá " + nome + ". Um usuário acaba de enviar uma mensagem.");
			email.addTo(emailDestinatario);
			email.send();

		} catch (EmailException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
