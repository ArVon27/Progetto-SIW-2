package it.uniroma3.SW.spring.controller;

import java.util.ArrayList;
import java.util.Collections;
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
public class LavoroController {
	
	@Autowired
	CredentialsService credentialservice;
	@Autowired
	AnnuncioService annuncioservice;
	
	
	
	@GetMapping("/lavoro1/{prof}/{page}")
	public String lavoro1(@PathVariable("prof") String prof, @PathVariable("page") int page , Model model) {
		Credentials utente = credentialservice.getCurrentCredentials();	
		
		model.addAttribute("pagina", page);
		model.addAttribute("prof", prof);
		model.addAttribute("utente", utente);
		String ultimapagina = "no";
		String primapagina = "no";
		String paginavuota = "no";
		String separatore = "no";
		//----------------------------------------------------------------------------------------------------
		List<Annuncio> annunci = new ArrayList<>();
		
		if (prof.equals("Tutti")) {
			annunci = annuncioservice.getAnnunciClassificati("LAVORO");
		}
		else {
			annunci = annuncioservice.getByClassificazioneAndTipologia("LAVORO", prof);
	
		}
		
			Collections.reverse(annunci);
			int numeroAnnunci = annunci.size();
			
			if (numeroAnnunci==0) {
				paginavuota="si";
			}
			
			List<Annuncio> annunci1 = new ArrayList<Annuncio>();
			List<Annuncio> annunci2 = new ArrayList<Annuncio>();
			int pagineMax = numeroAnnunci/6;
			if(!annunci.isEmpty()) {
			if (numeroAnnunci%6>0) {
				pagineMax++;
			}
			if(page<pagineMax) {
				for(int i=0; i<3; i++) {
					annunci1.add(annunci.get(i+((page-1)*6)));
				}
				for(int p=0; p<3; p++) {
					annunci2.add(annunci.get(p+3+(page-1)*6));
				}
			}
			else {
					if (page==pagineMax){
						int numeroAttuale = numeroAnnunci-((pagineMax-1)*6);
						if(numeroAttuale<4) {
							for(int i=0; i<numeroAttuale; i++) {
								annunci1.add(annunci.get((i+(page-1)*6)));
								}
							separatore="si";
							}
						else {
							for(int i=0; i<3; i++) {
								annunci1.add(annunci.get(i+(page-1)*6));
								}
							for(int p=0; p<numeroAttuale-3; p++) {
								annunci2.add(annunci.get(p+(page-1)*6));
								}
							}
					}
			}
			}
				model.addAttribute("annunci1", annunci1);
				model.addAttribute("annunci2", annunci2);
				
				if(page==pagineMax){
					ultimapagina="si";
				}
				model.addAttribute("paginaFinale", ultimapagina);
				
				if(page==1){
					primapagina="si";
				}
				model.addAttribute("paginaPrima", primapagina);
				model.addAttribute("paginaVuota", paginavuota);
				model.addAttribute("separatore", separatore );
				if(page>pagineMax) {
				return "redirect:/lavoro1/"+prof +"/"+ pagineMax;
			}
		
		//----------------------------------------------------------------------------------------------------
		
		return "lavoro1.html";
	}
	
	
	
	
	
	@GetMapping("/lavoro2/{prof}/{page}")
	public String lavoro2(@PathVariable("prof") String prof, @PathVariable("page") int page , Model model) {
		Credentials utente = credentialservice.getCurrentCredentials();	
		
		model.addAttribute("pagina", page);
		model.addAttribute("prof", prof);
		model.addAttribute("utente", utente);
		String ultimapagina = "no";
		String primapagina = "no";
		String paginavuota = "no";
		String separatore = "no";
		//----------------------------------------------------------------------------------------------------
		List<Annuncio> annunci = new ArrayList<>();
		
		if (prof.equals("Tutti")) {
			annunci = annuncioservice.getAnnunciClassificati("DIPENDENTE");
		}
		else {
			annunci = annuncioservice.getByClassificazioneAndTipologia("DIPENDENTE", prof);
	
		}
		
			Collections.reverse(annunci);
			int numeroAnnunci = annunci.size();
			
			if (numeroAnnunci==0) {
				paginavuota="si";
			}
			
			List<Annuncio> annunci1 = new ArrayList<Annuncio>();
			List<Annuncio> annunci2 = new ArrayList<Annuncio>();
			int pagineMax = numeroAnnunci/6;
			if(!annunci.isEmpty()) {
			if (numeroAnnunci%6>0) {
				pagineMax++;
			}
			if(page<pagineMax) {
				for(int i=0; i<3; i++) {
					annunci1.add(annunci.get(i+((page-1)*6)));
				}
				for(int p=0; p<3; p++) {
					annunci2.add(annunci.get(p+3+(page-1)*6));
				}
			}
			else {
					if (page==pagineMax){
						int numeroAttuale = numeroAnnunci-((pagineMax-1)*6);
						if(numeroAttuale<4) {
							for(int i=0; i<numeroAttuale; i++) {
								annunci1.add(annunci.get((i+(page-1)*6)));
								}
							separatore="si";
							}
						else {
							for(int i=0; i<3; i++) {
								annunci1.add(annunci.get(i+(page-1)*6));
								}
							for(int p=0; p<numeroAttuale-3; p++) {
								annunci2.add(annunci.get(p+(page-1)*6));
								}
							}
					}
			}
			}
				model.addAttribute("annunci1", annunci1);
				model.addAttribute("annunci2", annunci2);
				
				if(page==pagineMax){
					ultimapagina="si";
				}
				model.addAttribute("paginaFinale", ultimapagina);
				
				if(page==1){
					primapagina="si";
				}
				model.addAttribute("paginaPrima", primapagina);
				model.addAttribute("paginaVuota", paginavuota);
				model.addAttribute("separatore", separatore );
				if(page>pagineMax) {
				return "redirect:/lavoro2/"+prof +"/"+ pagineMax;
			}
		
		//----------------------------------------------------------------------------------------------------
		
		return "lavoro2.html";
	}
	
	
	
	
	
	
	
	@GetMapping("/Cancella2/{id}")
    public String registraAnnuncio (@PathVariable("id") Long id, Model model) {
        
		
		
		annuncioservice.deleteAnnuncio(id);
		
        return "redirect:/home";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
