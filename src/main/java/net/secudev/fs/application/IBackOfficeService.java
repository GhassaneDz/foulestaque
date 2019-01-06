package net.secudev.fs.application;

import java.util.List;

import net.secudev.fs.domain.model.categorie.Categorie;
import net.secudev.fs.domain.model.commande.Commande;
import net.secudev.fs.domain.model.produit.Produit;

public interface IBackOfficeService {
	
	Categorie creerCategorie(Categorie categorie);
	Produit ajouterProduit(Produit produit);
	void desactiverProduit(Produit produit);
	
	
	Commande traiterCommande(Commande commande);
	void supprimerCommande(Commande commande);
	
	List<String> historiqueCommandes();
	//whatever....

}
