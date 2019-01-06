package net.secudev.fs;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.secudev.fs.domain.model.categorie.Categorie;
import net.secudev.fs.domain.model.categorie.ICategorieRepository;
import net.secudev.fs.domain.model.commande.ICommandeRepository;
import net.secudev.fs.domain.model.commande.IDetailCommandeRepository;
import net.secudev.fs.domain.model.produit.IProduitRepository;
import net.secudev.fs.domain.model.produit.Produit;

@Component
public class Populate {
	
	@Autowired
	ICategorieRepository categories;
	
	@Autowired
	IProduitRepository produits;
	
	@Autowired
	ICommandeRepository commandes;
	
	@Autowired
	IDetailCommandeRepository detailCommandes;
	
	
	@Transactional
	public void nettoyage()
	{
		detailCommandes.deleteAll();
		commandes.deleteAll();
		produits.deleteAll();
		categories.deleteAll();
	}
	
	public boolean hasNoData()
	{		
		return (categories.count()==0 && produits.count()==0);
	}
	public void nettoiePuisCree()
	{
		nettoyage();
		creerJeuDessai();
	}
	
	public void creerJeuDessai()
	{
		Categorie boissons = new Categorie("Boissons");
		Categorie sandwiches = new Categorie("Sandwiches");
		Categorie burgers = new Categorie("Burgers");
		Categorie pizzas = new Categorie("Pizzas");
		Categorie desserts = new Categorie("Desserts");
		
		categories.save(boissons);
		categories.save(sandwiches);
		categories.save(burgers);
		categories.save(pizzas);
		categories.save(desserts);
		
		Produit sprite = new Produit("Sprite", 1.3f, boissons);
		produits.save(sprite);		
		Produit coca = new Produit("Coca", 1.5f, boissons);
		produits.save(coca);		
		Produit fanta = new Produit("Fanta", 1.6f, boissons);
		produits.save(fanta);
		
		
		
		Produit parisien = new Produit("Sandwich Parisien", 2.8f, sandwiches);
		produits.save(parisien);		
		Produit merguez = new Produit("Sandwich Merguez", 3.5f, sandwiches);
		produits.save(merguez);		
		Produit bagnat = new Produit("Pain Bagnat", 3.8f, sandwiches);
		produits.save(bagnat);
		
		
		
		Produit cheeseBurger = new Produit("Cheese Burger", 4.5f, burgers);
		produits.save(cheeseBurger);
		Produit bacon = new Produit("Bacon Burger", 5f, burgers);
		produits.save(bacon);
		Produit royal = new Produit("Royal Burger", 6f, burgers);
		produits.save(royal);
		
		Produit fromages = new Produit("4 Fromages", 7f, pizzas);
		produits.save(fromages);
		Produit saisons = new Produit("4 Saisons", 8f, pizzas);
		produits.save(saisons);
		
		
		Produit brownie = new Produit("Brownie", 2f, desserts);
		produits.save(brownie);
		Produit tiramisu = new Produit("Tiramisu", 2.5f, desserts);
		produits.save(tiramisu);
		Produit coockie = new Produit("Cookie", 2f, desserts);
		produits.save(coockie);
		
		
		
	}

}
