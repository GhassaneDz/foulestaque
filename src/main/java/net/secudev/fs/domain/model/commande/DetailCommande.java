package net.secudev.fs.domain.model.commande;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import net.secudev.fs.domain.model.produit.Produit;

@Entity
public class DetailCommande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@OneToOne
	private Produit produit;

	@Min(1)
	private int quantite;
	private float sousTotal;

	protected DetailCommande() {
	}

	public DetailCommande(@NotNull Produit produit, @Min(1) int quantite) {
		this.produit = produit;
		this.quantite = quantite;
		calculSousTotal();
	}

	private void calculSousTotal() {
		sousTotal = 0;
		sousTotal = produit.getPrix() * quantite;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
		calculSousTotal();
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
		calculSousTotal();
	}

	public long getId() {
		return id;
	}

	public float getSousTotal() {
		return sousTotal;
	}

}
