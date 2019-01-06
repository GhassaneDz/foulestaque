package net.secudev.fs.application;

import java.util.List;

import net.secudev.fs.domain.model.categorie.Categorie;
import net.secudev.fs.domain.model.commande.Commande;
import net.secudev.fs.domain.model.produit.Produit;

public interface IFrontOfficeService {
	
	List<Categorie> listerCategories();
	List<Produit> listerProduitsParCategorie(Categorie categorie);
	List<Produit> listerProduitsParCategorie(long categorieId);
	
	Commande nouvelleCommande();
	void annulerCommande(Commande commande);
	Commande validerCommande(Commande commande);
	Commande payerCommande(Commande commande);
	Produit listerProduitsParId(long id);

}
