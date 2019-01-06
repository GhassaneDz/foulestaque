package net.secudev.fs.application.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.secudev.fs.application.IFrontOfficeService;
import net.secudev.fs.domain.model.categorie.Categorie;
import net.secudev.fs.domain.model.categorie.ICategorieRepository;
import net.secudev.fs.domain.model.commande.Commande;
import net.secudev.fs.domain.model.commande.DetailCommande;
import net.secudev.fs.domain.model.commande.ICommandeRepository;
import net.secudev.fs.domain.model.commande.IDetailCommandeRepository;
import net.secudev.fs.domain.model.produit.IProduitRepository;
import net.secudev.fs.domain.model.produit.Produit;

@Service
public class FrontOfficeService implements IFrontOfficeService {

	@Autowired
	ICategorieRepository categories;

	@Autowired
	IProduitRepository produits;

	@Autowired
	ICommandeRepository commandes;

	@Autowired
	IDetailCommandeRepository detailsCommande;

	@Override
	public List<Categorie> listerCategories() {

		return categories.findAll();
	}

	@Override
	public List<Produit> listerProduitsParCategorie(Categorie categorie) {
		return produits.findByCategorie(categorie);
	}

	@Override
	public List<Produit> listerProduitsParCategorie(long categorieId) {
		List<Produit> result = null;
		Optional<Categorie> categorie = categories.findById(categorieId);
		if (categorie.isPresent()) {
			result = produits.findByCategorie(categorie.get());
		}

		return result;
	}

	@Override
	public Produit listerProduitsParId(long id) {
		Produit result = null;
		Optional<Produit> produit = produits.findById(id);
		if (produit.isPresent()) {
			result = produit.get();
		}
		return result;
	}

	@Override
	public Commande nouvelleCommande() {

		return commandes.save(new Commande());
	}

	@Override
	public Commande validerCommande(Commande commande) {

		commande.setEnTraitement(true);
		for (DetailCommande dc : commande.getDetail()) {
			detailsCommande.save(dc);
		}
		return commandes.save(commande);
	}

	@Override
	public Commande payerCommande(Commande commande) {
		commande.setPayee(true);
		return commandes.save(commande);
	}

	@Override
	public void annulerCommande(Commande commande) {

//		for(DetailCommande dc : commande.getDetail()){		
//			detailsCommande.delete(dc);			
//		}
//		
//		commande.viderDetails();
//		commandes.save(commande);

		commandes.delete(commande);

	}

}
