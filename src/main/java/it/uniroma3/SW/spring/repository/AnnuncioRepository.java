package it.uniroma3.SW.spring.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import it.uniroma3.SW.spring.model.Annuncio;

public interface AnnuncioRepository extends CrudRepository<Annuncio, Long> {
	public Optional<Annuncio> findByNome(String nome);
	
	public Optional<Annuncio> findByTipologia(String tipologia);
	
	public List<Annuncio> findByClassificazione(String classificazione);

	public List<Annuncio> findByClassificazioneAndTipologia(String classificazione, String tipologia);
}
