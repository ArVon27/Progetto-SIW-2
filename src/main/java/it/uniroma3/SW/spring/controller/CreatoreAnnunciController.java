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
import it.uniroma3.SW.spring.controller.validator.AnnuncioValidator;
import it.uniroma3.SW.spring.controller.validator.CredentialsValidator;
import it.uniroma3.SW.spring.service.AnnuncioService;
import it.uniroma3.SW.spring.service.CredentialsService;



@Controller
public class CreatoreAnnunciController {
	@Autowired
	CredentialsService credentialservice;
	@Autowired
	AnnuncioService annuncioservice;
	@Autowired
	AnnuncioValidator annunciovalidator;
	
	
	@RequestMapping(value = { "/CreaAnnuncio2" }, method = RequestMethod.POST)
    public String registraAnnuncio (@ModelAttribute("annuncio") Annuncio annuncio, BindingResult credentialsBindingResult, Model model) {
        
        this.annunciovalidator.validate(annuncio, credentialsBindingResult);

        if(!credentialsBindingResult.hasErrors()) {
        	Credentials utente = credentialservice.getCurrentCredentials();
    		utente.getAnnunci().add(annuncio);
    		annuncio.setCredentials(utente);
            Annuncio annuncioUtente = annuncioservice.saveAnnuncio(annuncio);
            
            return "redirect:/home";
        	}
        
        return "redirect:/home";
		}
	
	
	@RequestMapping(value = { "/CreaAnnuncio3" }, method = RequestMethod.POST)
    public String registraAnnuncio2 (@ModelAttribute("annuncio") Annuncio annuncio, BindingResult credentialsBindingResult, Model model) {
        
        this.annunciovalidator.validate(annuncio, credentialsBindingResult);

        if(!credentialsBindingResult.hasErrors()) {

    		Credentials utente = credentialservice.getCurrentCredentials();
    		utente.getAnnunci().add(annuncio);
    		annuncio.setCredentials(utente);
            Annuncio annuncioUtente = annuncioservice.saveAnnuncio(annuncio);
            
            return "redirect:/home";
        	}
        
        return "redirect:/home";
		}
	}
