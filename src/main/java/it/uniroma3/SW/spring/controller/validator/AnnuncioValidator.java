package it.uniroma3.SW.spring.controller.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.uniroma3.SW.spring.model.Annuncio;

@Component
public class AnnuncioValidator implements Validator {


	
	final int MAX_NOME_LENGTH = 15;
    final int MIN_NOME_LENGTH = 1;
	final int MAX_COGNOME_LENGTH = 15;
    final int MIN_COGNOME_LENGTH = 1;
	final int MAX_TELEFONO_LENGTH = 15;
    final int MIN_TELEFONO_LENGTH = 1;
    final int MAX_EMAIL_LENGTH = 25;
    final int MIN_EMAIL_LENGTH = 1;
    final int MAX_TIPOLOGIA_LENGTH = 15;
    final int MIN_TIPOLOGIA_LENGTH = 1;
	 
    
    @Override
	    public void validate(Object o, Errors errors) {
	        Annuncio annuncio = (Annuncio) o;
	        String nome = annuncio.getNome().trim();
	        String cognome = annuncio.getCognome().trim();
	        String telefono = annuncio.getTelefono().trim();
	        String email = annuncio.getEmail().trim();
	        String tipologia = annuncio.getTipologia().trim();

	        if (nome.isEmpty())
	            errors.rejectValue("nome", "required");
	        else if (nome.length() < MIN_NOME_LENGTH || nome.length() > MAX_NOME_LENGTH)
	            errors.rejectValue("nome", "size");
	        
	        if (cognome.isEmpty())
	            errors.rejectValue("cognome", "required");
	        else if (cognome.length() < MIN_COGNOME_LENGTH || cognome.length() > MAX_COGNOME_LENGTH)
	            errors.rejectValue("cognome", "size");
	        
	        if (telefono.isEmpty())
	            errors.rejectValue("telefono", "required");
	        else if (telefono.length() < MIN_TELEFONO_LENGTH || telefono.length() > MAX_TELEFONO_LENGTH)
	            errors.rejectValue("telefono", "size");
	        
	        if (email.isEmpty())
	            errors.rejectValue("email", "required");
	        else if (email.length() < MIN_EMAIL_LENGTH || email.length() > MAX_EMAIL_LENGTH)
	            errors.rejectValue("email", "size");
	        
	        if (tipologia.isEmpty())
	            errors.rejectValue("tipologia", "required");
	        else if (tipologia.length() < MIN_TIPOLOGIA_LENGTH || tipologia.length() > MAX_TIPOLOGIA_LENGTH)
	            errors.rejectValue("tipologia", "size");
	    }


	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
