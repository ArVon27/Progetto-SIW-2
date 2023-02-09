package it.uniroma3.SW.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.SW.spring.model.Annuncio;
import it.uniroma3.SW.spring.repository.AnnuncioRepository;
import it.uniroma3.SW.spring.repository.CredentialsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AnnuncioService {
	
	@Autowired
	protected AnnuncioRepository annuncioRepository;
	
	@Transactional
	public Annuncio getAnnuncio(Long id) {
		Optional<Annuncio> result = this.annuncioRepository.findById(id);
		return result.orElse(null);
	}
	
	public Optional<Annuncio> getAnnunciTipologia(String tipologia) {
		Optional<Annuncio> result = this.annuncioRepository.findByTipologia(tipologia);
		return result;
	}
	
	public List<Annuncio> getAnnunciClassificati(String classificazione) {
		List<Annuncio> result = this.annuncioRepository.findByClassificazione(classificazione);
		return result;
	}
	
	public List<Annuncio> getByClassificazioneAndTipologia(String classificazione, String tipologia) {
		List<Annuncio> result = this.annuncioRepository.findByClassificazioneAndTipologia(classificazione, tipologia);
		return result;
	}
	
	
	@Transactional
    public Annuncio saveAnnuncio(Annuncio annuncio) {
        return this.annuncioRepository.save(annuncio);
    }
	
	
	public void deleteAnnuncio (Long id) {
		annuncioRepository.deleteById(id);		
	}
	
	public void changeAnnuncio (Annuncio annuncioOld, Annuncio annuncio) {
		
		annuncioOld.setClassificazione(annuncio.getClassificazione());
		annuncioOld.setCognome(annuncio.getCognome());
		annuncioOld.setEmail(annuncio.getEmail());
		annuncioOld.setNome(annuncio.getNome());
		annuncioOld.setTelefono(annuncio.getTelefono());
		annuncioOld.setTesto(annuncio.getTesto());
		annuncioOld.setTipologia(annuncio.getTipologia());
	}
}
















