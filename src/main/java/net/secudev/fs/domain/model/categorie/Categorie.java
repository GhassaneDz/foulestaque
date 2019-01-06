package net.secudev.fs.domain.model.categorie;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Categorie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
    @Size(min=2, max=30)
	private String libelle;
	
	
	//Un constructeur sans params est nécessaire pour JPA
	protected Categorie()
	{}


	public Categorie(@NotNull @Size(min = 2, max = 30) String libelle) {
		this.libelle = libelle;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public long getId() {
		return id;
	}

}
