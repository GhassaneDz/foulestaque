package net.secudev.fs.domain.model.produit;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.secudev.fs.domain.model.categorie.Categorie;

public interface IProduitRepository extends JpaRepository<Produit, Long>{
	
	List<Produit> findByCategorie(Categorie categorie);	
	List<Produit> findByLibelleContaining(String like);

}
