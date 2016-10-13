package com.br.todeschini.email;

import org.junit.Test;

public class EmailServiceTest {
	
	@Test
	public void enviarEmailTeste(){
		EmailService es = new EmailService();
		
		es.enviar("Fernando Belém", "fernando.abelem@gmail.com");
	}

}
