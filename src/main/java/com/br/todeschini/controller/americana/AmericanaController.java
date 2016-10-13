package com.br.todeschini.controller.americana;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AmericanaController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}

}
