package net.secudev.fs.interfaces.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.secudev.fs.application.IFrontOfficeService;
import net.secudev.fs.domain.model.categorie.Categorie;
import net.secudev.fs.domain.model.produit.Produit;

@RestController
@RequestMapping("/fo")
public class FrontOfficeController {
	
	@Autowired
	IFrontOfficeService foService;
	
	@GetMapping("/categories")
	@ResponseBody
	public List<Categorie> toutesLesCategories()
	{
		return foService.listerCategories();
	}
	
	@GetMapping("/produits/{categorieId}")
	@ResponseBody
	public List<Produit> produitParCategorie(@PathVariable("categorieId") long categorieId)
	{
		return foService.listerProduitsParCategorie(categorieId);
	}
	
	@GetMapping("/produit/{id}")
	@ResponseBody
	public Produit produitParId(@PathVariable("id") long id)
	{
		return foService.listerProduitsParId(id);
	}


}
