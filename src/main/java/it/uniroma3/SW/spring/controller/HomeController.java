package it.uniroma3.SW.spring.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import it.uniroma3.SW.spring.model.Annuncio;
import it.uniroma3.SW.spring.model.Credentials;
import it.uniroma3.SW.spring.model.Credentials;
import it.uniroma3.SW.spring.controller.validator.CredentialsValidator;
import it.uniroma3.SW.spring.service.AnnuncioService;
import it.uniroma3.SW.spring.service.CredentialsService;


@Controller
public class HomeController {
	@Autowired
	CredentialsService credentialservice;
	@Autowired
	AnnuncioService annuncioservice;
	
	@GetMapping("/home")
	public String home(Model model) {
		Credentials utente = credentialservice.getCurrentCredentials();	
		model.addAttribute("utente", utente);
		return "home.html";
	}

	@GetMapping("/lavoro1")
	public String lavoro1Home(Model model) {
		return "redirect:/lavoro1/Tutti/1";
	}
	
	@GetMapping("/lavoro2")
	public String lavoro2Home(Model model) {
		return "redirect:/lavoro2/Tutti/1";
	}
	
	@GetMapping("/CreaAnnuncio1")
	public String CreaAnnuncio1(Model model) {
		Credentials utente = credentialservice.getCurrentCredentials();	
		model.addAttribute("utente", utente);
		return "CreaAnnuncio1.html";
	}
	
	@GetMapping("/CreaAnnuncio2")
	public String CreaAnnuncio2(Model model) {
		Credentials utente = credentialservice.getCurrentCredentials();	
		Annuncio annuncio = new Annuncio();
		model.addAttribute("annuncio", annuncio);
		model.addAttribute("utente", utente);
		return "CreaAnnuncio2.html";
	}
	
	@GetMapping("/CreaAnnuncio3")
	public String CreaAnnuncio3(Model model) {
		Credentials utente = credentialservice.getCurrentCredentials();	
		Annuncio annuncio = new Annuncio();
		model.addAttribute("annuncio", annuncio);
		model.addAttribute("utente", utente);
		return "CreaAnnuncio3.html";
	}
	
	@GetMapping("/help")
	public String help(Model model) {
		Credentials utente = credentialservice.getCurrentCredentials();	
		model.addAttribute("utente", utente);
		return "help.html";
	}
	
}
