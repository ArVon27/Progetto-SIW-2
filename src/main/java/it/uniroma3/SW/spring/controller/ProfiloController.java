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
import it.uniroma3.SW.spring.controller.validator.AnnuncioValidator;
import it.uniroma3.SW.spring.controller.validator.CredentialsValidator;
import it.uniroma3.SW.spring.service.AnnuncioService;
import it.uniroma3.SW.spring.service.CredentialsService;


@Controller
public class ProfiloController {
	
	@Autowired
	CredentialsService credentialservice;
	@Autowired
	AnnuncioService annuncioservice;
	@Autowired
	AnnuncioValidator annunciovalidator;

	
	@GetMapping("/Profilo")
	public String Profilo(Model model) {
		Credentials utente = credentialservice.getCurrentCredentials();	
		model.addAttribute("utente", utente);
		
		List<Annuncio> annunci = utente.getAnnunci();
		String paginavuota = "si";
		if(annunci.size()>0) {
			paginavuota = "no";
		}
		model.addAttribute("paginaVuota", paginavuota);
		model.addAttribute("Annunci", annunci);
		return "profilo.html";
	}
	
	

	@GetMapping("/Cancella/{id}")
    public String registraAnnuncio (@PathVariable("id") Long id, Model model) {
        
		
		
		annuncioservice.deleteAnnuncio(id);
		
        return "redirect:/Profilo";
	}
	Long idtemp;
	@GetMapping("/modifica/{id}")
    public String modificaAnnuncio (@PathVariable("id") Long id, Model model) {
		idtemp = id;
		Credentials utente = credentialservice.getCurrentCredentials();	
		Annuncio annuncio = new Annuncio();
		annuncio.setId(id);
		model.addAttribute("annuncio", annuncio);
		model.addAttribute("utente", utente);
		return "modifica.html";
	}
	
	
	@RequestMapping(value = { "/ModificaAnnuncio" }, method = RequestMethod.POST)
    public String cambiaAnnuncio (@ModelAttribute("annuncio") Annuncio annuncio, BindingResult credentialsBindingResult, Model model) {
        
        this.annunciovalidator.validate(annuncio, credentialsBindingResult);

        if(!credentialsBindingResult.hasErrors()) {
        	
        	annuncioservice.deleteAnnuncio(idtemp);
        	Credentials utente = credentialservice.getCurrentCredentials();
    		utente.getAnnunci().add(annuncio);
    		annuncio.setCredentials(utente);
        	 Annuncio annuncioUtente = annuncioservice.saveAnnuncio(annuncio);
        	
        	//Annuncio annuncioOld = annuncioservice.getAnnuncio(idtemp);
        	//annuncioservice.changeAnnuncio(annuncioOld, annuncio);
        	//annuncioservice.saveAnnuncio(annuncioOld);
            //return "redirect:/Profilo";
        	}
        
        return "redirect:/home";
		}
	
	
	
	
}
