package net.secudev.fs;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.TransactionSystemException;

import net.secudev.fs.domain.model.categorie.Categorie;
import net.secudev.fs.domain.model.categorie.ICategorieRepository;
import net.secudev.fs.domain.model.commande.Commande;
import net.secudev.fs.domain.model.commande.DetailCommande;
import net.secudev.fs.domain.model.commande.ICommandeRepository;
import net.secudev.fs.domain.model.commande.IDetailCommandeRepository;
import net.secudev.fs.domain.model.produit.IProduitRepository;
import net.secudev.fs.domain.model.produit.Produit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FoulestaqueApplicationTests {

	@Autowired
	ICategorieRepository categories;
	
	@Autowired
	IProduitRepository produits;
	
	@Autowired
	ICommandeRepository commandes;
	
	@Autowired
	IDetailCommandeRepository detailCommandes;
	

	@Autowired
	Populate populate;

	@Before
	public void setUp() throws Exception {
		
		populate.nettoiePuisCree();
		
	}

	@After
	public void tearDown() throws Exception {
		
		//populate.nettoyage();
	}
	
	
	@Test
	public void testCommande()
	{
		Produit coca = produits.findByLibelleContaining("coca").get(0);
		Produit merguez = produits.findByLibelleContaining("guez").get(0);
		Commande cmd = new Commande();
		commandes.save(cmd);
		
		DetailCommande dc1 = new DetailCommande(coca, 1);
		detailCommandes.save(dc1);
		DetailCommande dc2 = new DetailCommande(merguez, 1);
		detailCommandes.save(dc2);
		
		cmd.ajouterDetail(dc1);
		cmd.ajouterDetail(dc2);
		commandes.save(cmd);
		
	}


	
	@Test(expected = TransactionSystemException.class)
	public void testCategoriesGrandNom() throws Exception {
		
		Categorie boissons = new Categorie("Boissonstttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt");
		categories.save(boissons);	
		
	}

	
	@Test
	public void trouverProduitsParCategorie()
	{
		Categorie burgers = categories.findByLibelleIgnoreCase("burgers").get(0);
		System.out.println(produits.findByCategorie(burgers).get(0).getLibelle());
	}
	
	@Test
	public void testService()
	{
		
	}
}
