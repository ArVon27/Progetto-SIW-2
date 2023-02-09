package it.uniroma3.SW.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.SW.spring.model.Credentials;
import it.uniroma3.SW.spring.service.CredentialsService;



@Controller
public class ProvaController {

	@Autowired
	CredentialsService credentialservice;
	
	@GetMapping("/inizio")
	public String inizio(Model model) {
		Credentials utente = credentialservice.getCredentials("asd");
		model.addAttribute("utente", utente);
		return "inizio.html";
	}

	@GetMapping("/base")
	public String base(Model model) {
		Credentials utente = credentialservice.getCredentials("asd");
		model.addAttribute("utente", utente);
		return "base.html";
	}
	
}
