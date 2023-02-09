package it.uniroma3.SW.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;

@Entity
public @Data class Annuncio {

	public static final String ANNUNCIO_lAVORO= "LAVORO";
	public static final String ANNUNCIO_DIPENDENTE = "DIPENDENTE";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String classificazione;
	
	@Column(nullable = false)
	private String nome;
		
	@Column(nullable = false)
	private String cognome;
	
	@Column(nullable = false)
	private String telefono;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String tipologia;
	
	@Column(nullable = false)
	private String testo;
	
	@ManyToOne
	private Credentials credentials;
}
