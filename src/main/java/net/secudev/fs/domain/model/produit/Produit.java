package net.secudev.fs.domain.model.produit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import net.secudev.fs.domain.model.categorie.Categorie;

@Entity
public class Produit {	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min=2, max=30)
	private String libelle;
	
	@Min(0)
	@Max(50)
    private float prix;
    
	@JsonIgnore
	@ManyToOne
	private Categorie categorie;
	
	
	public Produit(@NotNull @Size(min = 2, max = 30) String libelle, @Min(0) @Max(50) float prix, Categorie categorie) {
		this.libelle = libelle;
		this.prix = prix;
		this.categorie = categorie;
	}
	
	protected Produit() {}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public long getId() {
		return id;
	}

}
