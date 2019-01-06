package net.secudev.fs;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import net.secudev.fs.application.IFrontOfficeService;
import net.secudev.fs.domain.model.categorie.Categorie;
import net.secudev.fs.domain.model.commande.Commande;
import net.secudev.fs.domain.model.commande.DetailCommande;
import net.secudev.fs.domain.model.produit.Produit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestFOService {
	
	@Autowired
	IFrontOfficeService frontOfficeService;
	
	@Autowired
	Populate populate;

	@Before
	public void setUp() throws Exception {
		
		populate.nettoiePuisCree();
		
	}

	@After
	public void tearDown() throws Exception {
		
		populate.nettoyage();
	}

	@Test
	public void testListerCategories() {
		assertEquals(frontOfficeService.listerCategories().size(), 5);
	}

	@Test
	public void testListerProduitsParCategorie() {
		Categorie boissons = frontOfficeService.listerCategories().stream().filter(c -> c.getLibelle().equals("Boissons")).findFirst().get();
		assertEquals(frontOfficeService.listerProduitsParCategorie(boissons).size(), 2);
	}

	@Test
	public void testValiderCommande() {
		
		Categorie boissons = frontOfficeService.listerCategories().stream().filter(c -> c.getLibelle().equals("Boissons")).findFirst().get();
		Categorie sandwiches = frontOfficeService.listerCategories().stream().filter(c -> c.getLibelle().equals("Sandwiches")).findFirst().get();
		Produit coca = frontOfficeService.listerProduitsParCategorie(boissons).stream().filter(p ->p.getLibelle().equals("Coca")).findFirst().get();
		Produit merguez = frontOfficeService.listerProduitsParCategorie(sandwiches).stream().filter(p ->p.getLibelle().equals("Sandwich Merguez")).findFirst().get();
		
		Commande cmd = frontOfficeService.nouvelleCommande();
		
		DetailCommande dc1 = new DetailCommande(coca, 1);		
		DetailCommande dc2 = new DetailCommande(merguez, 1);
		
		cmd.ajouterDetail(dc1);
		cmd.ajouterDetail(dc2);
				
		frontOfficeService.validerCommande(cmd);
		//frontOfficeService.annulerCommande(cmd);
	}

	@Test
	public void testPayerCommande() {
		fail("Not yet implemented");
	}

}
